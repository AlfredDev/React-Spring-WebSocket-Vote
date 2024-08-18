package com.websocket.voteApp.Vote.Mappers;

import com.websocket.voteApp.Vote.DTO.Request.PollRequest;
import com.websocket.voteApp.Vote.DTO.Response.CandidateResponse;
import com.websocket.voteApp.Vote.DTO.Response.PollResponse;
import com.websocket.voteApp.Vote.Models.Candidate;
import com.websocket.voteApp.Vote.Models.Poll;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-18T14:47:34-0600",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class PollMapperImpl implements PollMapper {

    @Override
    public PollResponse toPollResponse(Poll poll, int voteCount) {
        if ( poll == null ) {
            return null;
        }

        PollResponse.PollResponseBuilder pollResponse = PollResponse.builder();

        if ( poll != null ) {
            pollResponse.id( poll.getId() );
            pollResponse.name( poll.getName() );
            pollResponse.startDate( poll.getStartDate() );
            pollResponse.endDate( poll.getEndDate() );
            pollResponse.candidates( candidateSetToCandidateResponseSet( poll.getCandidates() ) );
        }
        pollResponse.voteCountPoll( voteCount );

        return pollResponse.build();
    }

    @Override
    public Poll toPoll(PollRequest pollRequest) {
        if ( pollRequest == null ) {
            return null;
        }

        Poll.PollBuilder poll = Poll.builder();

        poll.name( pollRequest.getName() );
        poll.startDate( pollRequest.getStartDate() );
        poll.endDate( pollRequest.getEndDate() );

        return poll.build();
    }

    protected CandidateResponse candidateToCandidateResponse(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }

        CandidateResponse.CandidateResponseBuilder candidateResponse = CandidateResponse.builder();

        candidateResponse.id( candidate.getId() );
        candidateResponse.name( candidate.getName() );
        candidateResponse.partyName( candidate.getPartyName() );

        return candidateResponse.build();
    }

    protected Set<CandidateResponse> candidateSetToCandidateResponseSet(Set<Candidate> set) {
        if ( set == null ) {
            return null;
        }

        Set<CandidateResponse> set1 = new LinkedHashSet<CandidateResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Candidate candidate : set ) {
            set1.add( candidateToCandidateResponse( candidate ) );
        }

        return set1;
    }
}
