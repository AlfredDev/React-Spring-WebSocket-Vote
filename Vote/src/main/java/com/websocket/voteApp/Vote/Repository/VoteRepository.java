package com.websocket.voteApp.Vote.Repository;

import com.websocket.voteApp.Vote.Models.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    @Query("SELECT COUNT(v) FROM Vote v WHERE v.poll.id = :pollId")
    int countByPollId(Long pollId);


    Page<Vote> getVotesByPollId(Long pollId, Pageable pageable);

    @Query("SELECT COUNT(v) FROM Vote v WHERE v.candidate.id = :candidateId AND v.poll.id = :pollId")
    long countVotesByCandidateIdAndPollId(@Param("candidateId") Long candidateId, @Param("pollId") Long pollId);

}
