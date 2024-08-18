export interface CandidateResponse {
    id: number;
    name: string;
    partyName: string;
    voteCount: number;  
  }
  
  export interface PollResponse {
    id: number;
    name: string;
    startDate: Date;
    endDate: Date;
    voteCountPoll: number;
    candidates: CandidateResponse[];
  }
  
  export interface VoteCountResponse {
    candidateId: number;
    candidateName: string;
    voteCount: number;
  }
  
  export interface VoteResponse {
    id: number;
    pollName: string;
    candidateName: string;
    candidatePartyName: string;
    timestamp: Date;
  }
  