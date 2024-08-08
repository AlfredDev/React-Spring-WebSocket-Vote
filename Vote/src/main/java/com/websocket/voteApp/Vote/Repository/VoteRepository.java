package com.websocket.voteApp.Vote.Repository;

import com.websocket.voteApp.Vote.Models.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    @Query("SELECT COUNT(v) FROM Vote v WHERE v.poll.id = :pollId")
    int countByPollId(Long id);

    Page<Vote> getVotesByPollId(Long id, Pageable pageable);
}
