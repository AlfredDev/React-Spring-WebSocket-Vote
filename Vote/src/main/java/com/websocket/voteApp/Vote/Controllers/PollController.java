package com.websocket.voteApp.Vote.Controllers;

import com.websocket.voteApp.Vote.DTO.Request.PollRequest;
import com.websocket.voteApp.Vote.DTO.Response.PollResponse;
import com.websocket.voteApp.Vote.DTO.Response.SuccessResponse;
import com.websocket.voteApp.Vote.Service.PollService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/poll")
@RequiredArgsConstructor
public class PollController {
    private final PollService pollService;

    // =====================================================================
    //                              POST
    // =====================================================================
    @PostMapping("save")
    public ResponseEntity<SuccessResponse> createPoll(@Valid @RequestBody PollRequest pollRequest,
                                                      BindingResult bindingResult) throws BadRequestException {
        handleValidationErrors(bindingResult);
        PollResponse pollResponse = pollService.createPoll(pollRequest);

        return new ResponseEntity<>(SuccessResponse.builder()
                .message("Poll was successfully created")
                .object(pollResponse)
                .statusCode("201")
                .build(), HttpStatus.CREATED);

    }

    // =====================================================================
    //                              PUT
    // =====================================================================
    @PutMapping("update/{id}")
    public ResponseEntity<SuccessResponse> updatePoll(@Valid @RequestBody PollRequest pollRequest,
                                                      BindingResult bindingResult, @PathVariable Long id) throws BadRequestException {
        handleValidationErrors(bindingResult);

        PollResponse pollResponse = pollService.updatePoll(pollRequest, id);

        return new ResponseEntity<>(SuccessResponse.builder()
                .message("Poll was successfully updated")
                .object(pollResponse)
                .statusCode("201")
                .build(), HttpStatus.OK);
    }


    // =====================================================================
    //                              GET
    // =====================================================================
    @GetMapping("{id}")
    public ResponseEntity<SuccessResponse> getPoolById(@PathVariable Long id) {
        PollResponse pollResponse = pollService.getPollById(id);
        return new ResponseEntity<>(SuccessResponse.builder()
                .statusCode("200")
                .message("Poll with id : " + id + " was successfully returned")
                .object(pollResponse)
                .build(), HttpStatus.OK);
    }


    @GetMapping("polls")
    public ResponseEntity<SuccessResponse> getAllPolls() {
        List<PollResponse> poll = pollService.getAllPolls();

        return new ResponseEntity<>(SuccessResponse.builder()
                .object(poll)
                .message("Polls was succesfully retrieved")
                .statusCode("201")
                .build(), HttpStatus.OK);
    }

    // =====================================================================
    //                              DELETE
    // =====================================================================
    @DeleteMapping("delete/{pollId}")
    public ResponseEntity<SuccessResponse> deletePollById(@PathVariable Long pollId) {
        PollResponse response = pollService.getPollById(pollId);
        pollService.deletePollById(pollId);
        return new ResponseEntity<>(SuccessResponse
                .builder()
                .statusCode("200")
                .message("Poll was successfully removed")
                .object(response)
                .build(), HttpStatus.ACCEPTED);
    }

    private void handleValidationErrors(BindingResult bindingResult) throws BadRequestException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getFieldError().getDefaultMessage());
        }
    }

}
