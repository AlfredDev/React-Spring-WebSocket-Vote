package com.websocket.voteApp.Vote.Controllers;

import com.websocket.voteApp.Vote.DTO.Request.CandidateRequest;
import com.websocket.voteApp.Vote.DTO.Response.CandidateResponse;
import com.websocket.voteApp.Vote.DTO.Response.SuccessResponse;
import com.websocket.voteApp.Vote.Models.Candidate;
import com.websocket.voteApp.Vote.Service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/candidate")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping("/save")
    public ResponseEntity<SuccessResponse> createCandidate(@RequestBody @Valid CandidateRequest candidateRequest) {
        CandidateResponse candidate = candidateService.saveCandidate(candidateRequest);
        return new ResponseEntity<>(SuccessResponse.builder()
                .object(candidate)
                .statusCode("201")
                .message("Candidate created successfully")
                .build(), HttpStatus.CREATED);
    }

    @GetMapping("findAll")
    public ResponseEntity<SuccessResponse> findAllcandidates() {
        List<CandidateResponse> candidates = candidateService.getCandidates();
        return new ResponseEntity<>(SuccessResponse.builder()
                .object(candidates)
                .message("Candidates was retrieved successfully")
                .statusCode("200")
                .build(), HttpStatus.OK);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<SuccessResponse> findCandidateById(@PathVariable Long id) {
        CandidateResponse candidate = candidateService.getCandidateById(id);
        return new ResponseEntity<>(SuccessResponse.builder()
                .object(candidate)
                .message("Candidate id was retrieved successfully")
                .statusCode("200")
                .build(), HttpStatus.OK);
    }


    @GetMapping("delete/{id}")
    public ResponseEntity<String> deleteCandidateById(@PathVariable Long id) {
        candidateService.deleteCandidateById(id);
        return ResponseEntity.ok().body("Candidate id was deleted successfully");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
