package com.websocket.voteApp.Vote.Mappers;

import com.websocket.voteApp.Vote.Models.Candidate;
import com.websocket.voteApp.Vote.Models.Poll;
import com.websocket.voteApp.Vote.Models.Vote;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-07T00:20:34-0600",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class PollMapperImpl implements PollMapper {

    @Override
    public Poll toPollResponse(Poll poll) {
        if ( poll == null ) {
            return null;
        }

        Poll.PollBuilder poll1 = Poll.builder();

        poll1.id( poll.getId() );
        poll1.name( poll.getName() );
        poll1.startDate( poll.getStartDate() );
        poll1.endDate( poll.getEndDate() );
        Set<Candidate> set = poll.getCandidates();
        if ( set != null ) {
            poll1.candidates( new LinkedHashSet<Candidate>( set ) );
        }
        Set<Vote> set1 = poll.getVotes();
        if ( set1 != null ) {
            poll1.votes( new LinkedHashSet<Vote>( set1 ) );
        }

        return poll1.build();
    }
}
