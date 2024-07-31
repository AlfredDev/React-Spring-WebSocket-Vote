package com.websocket.voteApp.Vote.Repository;

import com.websocket.voteApp.Vote.Models.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long> {
}
