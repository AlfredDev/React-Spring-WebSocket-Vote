package com.websocket.voteApp.Vote.Controllers;

import com.websocket.voteApp.Vote.Service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/poll")
@RequiredArgsConstructor
public class PollController {
    private final PollService pollService;

    public String getName() {
        return "Holla";
    }
}
