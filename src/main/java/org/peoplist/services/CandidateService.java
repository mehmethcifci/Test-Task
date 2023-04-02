package org.peoplist.services;

import lombok.RequiredArgsConstructor;
import org.peoplist.dto.request.CandidateRequestDto;
import org.peoplist.dto.request.UpdateCandidateRequesDto;
import org.peoplist.dto.response.CandidateResponseDto;
import org.peoplist.dto.response.InteractionResponseDto;
import org.peoplist.entity.Candidate;
import org.peoplist.exception.custom.CandidateNotFoundException;
import org.peoplist.repositories.CandidateRepository;
import org.peoplist.repositories.InteractionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;
    private final InteractionRepository interactionRepository;

    public Boolean save(CandidateRequestDto candidateRequestDto) {
        Candidate candidate = Candidate.builder()
                .name(candidateRequestDto.getName())
                .surname(candidateRequestDto.getSurname())
                .phone(candidateRequestDto.getPhone())
                .mail(candidateRequestDto.getMail())
                .status(candidateRequestDto.getStatus())
                .build();
        try {
            candidateRepository.save(candidate);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<CandidateResponseDto> findAll() {
        List<Candidate> candidateList = candidateRepository.findAll();
        if (candidateList.isEmpty()){
            throw new CandidateNotFoundException("Candidates are not found");
        }
        return candidateList.stream().map(candidate -> CandidateResponseDto.builder()
                .oid(candidate.getOid())
                .name(candidate.getName())
                .surname(candidate.getSurname())
                .phone(candidate.getPhone())
                .mail(candidate.getMail())
                .status(candidate.getStatus().toString())
                .interactionDtoList(interactionRepository.findByCandidateOid(candidate.getOid()).stream()
                        .map(interaction -> InteractionResponseDto.builder()
                                        .content(interaction.getContent())
                                        .interactionType(interaction.getInteractionType())
                                        .date(interaction.getDate())
                                        .candidateResponded(interaction.getCandidateResponded())
                                        .build()).collect(Collectors.toList()))
                .build()).collect(Collectors.toList());
    }

    public Boolean deleteCandidate(Long oid) {
        Optional<Candidate> optionalCandidate = candidateRepository.findById(oid);

        if (optionalCandidate.isEmpty()){
            throw new CandidateNotFoundException("Candidate is not found");
        }
        candidateRepository.delete(optionalCandidate.get());
        return true;

    }

    public void update(UpdateCandidateRequesDto updateCandidateRequesDto) {

        if (candidateRepository.findById(updateCandidateRequesDto.getOid()).isEmpty()){
            throw new CandidateNotFoundException("Candidate is not found");
        }
        candidateRepository.save(Candidate.builder()
                        .oid(updateCandidateRequesDto.getOid())
                        .mail(updateCandidateRequesDto.getMail())
                        .name(updateCandidateRequesDto.getName())
                        .phone(updateCandidateRequesDto.getPhone())
                        .surname(updateCandidateRequesDto.getSurname())
                        .status(updateCandidateRequesDto.getStatus())
                .build());

    }
}
