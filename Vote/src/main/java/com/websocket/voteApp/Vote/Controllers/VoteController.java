package com.websocket.voteApp.Vote.Controllers;

import com.websocket.voteApp.Vote.DTO.Request.VoteRequest;
import com.websocket.voteApp.Vote.DTO.Response.SuccessResponse;
import com.websocket.voteApp.Vote.DTO.VoteResponse;
import com.websocket.voteApp.Vote.Service.VoteService;
import com.websocket.voteApp.Vote.Utils.Utils;
import com.websocket.voteApp.Vote.WebSocket.SocketHandler.VotingWebSocketHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Vote Controller", description = "Endpoints for managing votes")
@RestController
@RequestMapping("api/v1/vote")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;

    private final VotingWebSocketHandler voteWebSocketHandler;
    private final Utils utils;

    // =====================================================================
    //                              POST
    // =====================================================================


    @PostMapping("save")
    public ResponseEntity<SuccessResponse> saveVote(@Valid @RequestBody VoteRequest voteRequest,
                                                    HttpServletRequest httpRequest,
                                                    BindingResult bindingResult) throws BadRequestException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getFieldError().getDefaultMessage());
        }

        String token = utils.getTokenFromRequest(httpRequest);
        Long userId = utils.getCurrentUserId(token);
        System.out.println(userId);
        System.out.println(voteRequest.getPollId());
        VoteResponse voteResponse = voteService.saveVote(userId, voteRequest);
        voteWebSocketHandler.broadcastVoteUpdate();
        return new ResponseEntity<>(SuccessResponse
                .builder()
                .statusCode("201")
                .message("Vote correctly created")
                .object(voteResponse)
                .build(), HttpStatus.CREATED);
    }


    // =====================================================================
    //                              GET
    // =====================================================================
    @GetMapping("votesfrompoll/{pollId}")
    public ResponseEntity<SuccessResponse> getVotesFrompollId(@PathVariable Long pollId,
                                                              @RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<VoteResponse> votes = voteService.getVotesFromPoll(pollId, pageable);

        return new ResponseEntity<>(SuccessResponse
                .builder()
                .object(votes)
                .message("Votes from Poll Id : " + pollId + " was successfully retrieved")
                .statusCode("200").build(), HttpStatus.OK);
    }

    @GetMapping("vote/{id}")
    public ResponseEntity<SuccessResponse> getVoteById(@PathVariable Long id) {
        VoteResponse voteResponse = voteService.getVoteById(id);
        return new ResponseEntity<>(SuccessResponse
                .builder()
                .object(voteResponse)
                .message("Vote Id: " + id + " was successfully retrieved")
                .statusCode("200")
                .build(), HttpStatus.OK);
    }
}
