package com.websocket.voteApp.Vote.Repository;

import com.websocket.voteApp.Vote.Models.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
}
