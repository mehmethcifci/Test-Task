package org.peoplist.controller;

import static org.peoplist.constant.APIUrls.*;
import lombok.RequiredArgsConstructor;
import org.peoplist.dto.request.DeleteInteractionDto;
import org.peoplist.dto.request.InteractionDto;
import org.peoplist.dto.request.UpdateInteractionDto;
import org.peoplist.dto.response.InteractionResponseDto;
import org.peoplist.entity.Interaction;
import org.peoplist.services.InteractionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(INTERACTION)
@RequiredArgsConstructor
public class InteractionController {

    private final InteractionService interactionService;
    @CrossOrigin(originPatterns = "*")
    @PostMapping(CREATE)
    public ResponseEntity<Void> createCandidate(@RequestBody @Valid InteractionDto interactionDto){
        interactionService.save(interactionDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @CrossOrigin(originPatterns = "*")
    @PutMapping(UPDATE)
    public ResponseEntity<InteractionResponseDto> updateCandidate(@RequestBody @Valid UpdateInteractionDto updateInteractionDto){
        return ResponseEntity.ok(interactionService.update(updateInteractionDto));
    }
    @DeleteMapping(DELETE+ID)
    public ResponseEntity<Boolean> deleteCandidate(@PathVariable("id") Long id){
        return ResponseEntity.ok(interactionService.deleteCandidate(id));
    }
}
