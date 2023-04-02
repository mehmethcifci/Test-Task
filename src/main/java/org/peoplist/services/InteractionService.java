package org.peoplist.services;

import lombok.RequiredArgsConstructor;
import org.peoplist.dto.request.InteractionDto;
import org.peoplist.dto.request.UpdateInteractionDto;
import org.peoplist.dto.response.CandidateResponseDto;
import org.peoplist.dto.response.InteractionResponseDto;
import org.peoplist.entity.Candidate;
import org.peoplist.entity.Interaction;
import org.peoplist.exception.custom.CandidateNotFoundException;
import org.peoplist.exception.custom.InteractionNotFoundException;
import org.peoplist.repositories.CandidateRepository;
import org.peoplist.repositories.InteractionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InteractionService {
    private final InteractionRepository interactionRepository;
    private final CandidateRepository candidateRepository;
    public Boolean save(InteractionDto interactionDto) {

        Optional<Candidate> candidate = candidateRepository.findById(interactionDto.getCandidateOid());

        if (candidate.isEmpty()){
            throw new CandidateNotFoundException("Candidate is not found");
        }
        Interaction interaction = Interaction.builder()
                .candidate(candidate.get())
                .interactionType(interactionDto.getInteractionType())
                .content(interactionDto.getContent())
                .date(new Date())
                .candidateResponded(interactionDto.getCandidateResponded())
                .build();
        try {
            interactionRepository.save(interaction);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public InteractionResponseDto update(UpdateInteractionDto updateInteractionDto) {
        Optional<Interaction> interaction = interactionRepository.findById(updateInteractionDto.getOid());
        if (interaction.isEmpty()){
            throw new InteractionNotFoundException("Interaction is not found");
        }
        interaction.get().setOid(interaction.get().getOid());
        interaction.get().setCandidate(candidateRepository.findById(updateInteractionDto.getCandidateOid()).orElseThrow(
                ()-> new CandidateNotFoundException("Candidate is not found")));
        interaction.get().setInteractionType(updateInteractionDto.getInteractionType());
        interaction.get().setContent(updateInteractionDto.getContent());
        interaction.get().setDate(new Date());
        interaction.get().setCandidateResponded(updateInteractionDto.getCandidateResponded());
        interactionRepository.save(interaction.get());
        return InteractionResponseDto.builder()
                .content(interaction.get().getContent())
                .candidateResponded(interaction.get().getCandidateResponded())
                .interactionType(interaction.get().getInteractionType())
                .build();
    }

    public Boolean deleteCandidate(Long oid) {
        Optional<Interaction> previousInteraction = interactionRepository.findById(oid);
        if (previousInteraction.isEmpty()){
            throw new InteractionNotFoundException("Previous interaction is not found");
        }
        try {
            interactionRepository.delete(previousInteraction.get());
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
