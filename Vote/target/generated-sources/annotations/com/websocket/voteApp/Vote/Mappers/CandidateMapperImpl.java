package com.websocket.voteApp.Vote.Mappers;

import com.websocket.voteApp.Vote.DTO.Response.CandidateResponse;
import com.websocket.voteApp.Vote.Models.Candidate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-01T13:49:52-0600",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CandidateMapperImpl implements CandidateMapper {

    @Override
    public Candidate toCandidate(CandidateResponse candidateResponse) {
        if ( candidateResponse == null ) {
            return null;
        }

        Candidate.CandidateBuilder candidate = Candidate.builder();

        candidate.id( candidateResponse.getId() );
        candidate.name( candidateResponse.getName() );
        candidate.partyName( candidateResponse.getPartyName() );

        return candidate.build();
    }

    @Override
    public CandidateResponse toCandidateResponse(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }

        CandidateResponse.CandidateResponseBuilder candidateResponse = CandidateResponse.builder();

        candidateResponse.id( candidate.getId() );
        candidateResponse.name( candidate.getName() );
        candidateResponse.partyName( candidate.getPartyName() );

        return candidateResponse.build();
    }
}
