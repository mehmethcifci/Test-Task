package org.peoplist.controller;

import static org.peoplist.constant.APIUrls.*;

import lombok.RequiredArgsConstructor;
import org.peoplist.dto.request.CandidateRequestDto;
import org.peoplist.dto.request.DeleteCandidateDto;
import org.peoplist.dto.request.UpdateCandidateRequesDto;
import org.peoplist.dto.response.CandidateResponseDto;
import org.peoplist.services.CandidateService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(CANDIDATE)
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @CrossOrigin(originPatterns = "*")
    @PostMapping(CREATE)
    public ResponseEntity<Void> createCandidate(@RequestBody @Valid CandidateRequestDto candidateRequestDto){
        candidateService.save(candidateRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @CrossOrigin(originPatterns = "*")
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<CandidateResponseDto>> findAll(){
        return ResponseEntity.ok(candidateService.findAll());
    }
    @CrossOrigin(originPatterns = "*")
    @PutMapping(UPDATE)
    public ResponseEntity<Void> updateCandidate(@RequestBody @Valid UpdateCandidateRequesDto updateCandidateRequesDto)
    {
        candidateService.update(updateCandidateRequesDto);
        return ResponseEntity.ok().build();
    }
    @CrossOrigin(originPatterns = "*")
    @DeleteMapping(DELETE+ID)
    public ResponseEntity<Void> deleteCandidate(@PathVariable("id") Long id){
        candidateService.deleteCandidate(id);
        return ResponseEntity.ok().build();
    }

}
