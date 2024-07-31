package com.websocket.voteApp.Vote.Repository;

import com.websocket.voteApp.Vote.Models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
