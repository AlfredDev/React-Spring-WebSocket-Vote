package com.websocket.voteApp.Vote.Mappers;

import com.websocket.voteApp.Vote.DTO.VoteResponse;
import com.websocket.voteApp.Vote.Models.Vote;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T14:47:34-0600",
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
    public VoteResponse toVoteResponse(Vote response) {
        if ( response == null ) {
            return null;
        }

        VoteResponse.VoteResponseBuilder voteResponse = VoteResponse.builder();

        voteResponse.id( response.getId() );
        voteResponse.timestamp( response.getTimestamp() );

        return voteResponse.build();
    }
}
