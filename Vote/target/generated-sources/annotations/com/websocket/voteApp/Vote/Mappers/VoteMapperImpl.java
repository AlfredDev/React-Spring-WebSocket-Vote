package com.websocket.voteApp.Vote.Mappers;

import com.websocket.voteApp.Vote.DTO.VoteResponse;
import com.websocket.voteApp.Vote.Models.Candidate;
import com.websocket.voteApp.Vote.Models.Poll;
import com.websocket.voteApp.Vote.Models.Vote;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T16:01:53-0600",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class VoteMapperImpl implements VoteMapper {

    @Override
    public Vote toVote(VoteResponse voteResponse) {
        if ( voteResponse == null ) {
            return null;
        }

        Vote.VoteBuilder vote = Vote.builder();

        vote.id( voteResponse.getId() );
        vote.timestamp( voteResponse.getTimestamp() );

        return vote.build();
    }

    @Override
    public VoteResponse toVoteResponse(Vote vote) {
        if ( vote == null ) {
            return null;
        }

        VoteResponse.VoteResponseBuilder voteResponse = VoteResponse.builder();

        voteResponse.pollName( votePollName( vote ) );
        voteResponse.candidateName( voteCandidateName( vote ) );
        voteResponse.candidatePartyName( voteCandidatePartyName( vote ) );
        voteResponse.id( vote.getId() );
        voteResponse.timestamp( vote.getTimestamp() );

        return voteResponse.build();
    }

    private String votePollName(Vote vote) {
        if ( vote == null ) {
            return null;
        }
        Poll poll = vote.getPoll();
        if ( poll == null ) {
            return null;
        }
        String name = poll.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String voteCandidateName(Vote vote) {
        if ( vote == null ) {
            return null;
        }
        Candidate candidate = vote.getCandidate();
        if ( candidate == null ) {
            return null;
        }
        String name = candidate.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String voteCandidatePartyName(Vote vote) {
        if ( vote == null ) {
            return null;
        }
        Candidate candidate = vote.getCandidate();
        if ( candidate == null ) {
            return null;
        }
        String partyName = candidate.getPartyName();
        if ( partyName == null ) {
            return null;
        }
        return partyName;
    }
}
