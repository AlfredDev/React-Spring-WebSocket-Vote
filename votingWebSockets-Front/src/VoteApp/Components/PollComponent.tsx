import React, { useEffect, useState } from 'react';
import { PollResponse, VoteCountResponse } from '../Types/types';
import { getPollData, subscribeToVoteUpdates, voteForCandidate } from '../Service/api';

interface PollComponentProps {
    pollId: number;
}

const PollComponent: React.FC<PollComponentProps> = ({ pollId }) => {
    const [poll, setPoll] = useState<PollResponse | null>(null);
    const [voteCounts, setVoteCounts] = useState<Map<number, number>>(new Map());

    useEffect(() => {
        const fetchData = async () => {
            const data = await getPollData(pollId);
            setPoll(data);
            const initialVoteCounts = new Map<number, number>();
            data.candidates.forEach(candidate => {
                initialVoteCounts.set(candidate.id, candidate.voteCount); 
            });
            setVoteCounts(initialVoteCounts);
        };

        fetchData();

        const unsubscribe = subscribeToVoteUpdates((vote: VoteCountResponse) => {
            setVoteCounts(prevVoteCounts => {
                const newVoteCounts = new Map(prevVoteCounts);
                newVoteCounts.set(vote.candidateId, vote.voteCount);
                return newVoteCounts;
            });
        });

        return () => {
            unsubscribe();
        };
    }, [pollId]);

    // Function to handle voting for a candidate
    const handleVote = async (candidateId: number) => {
        try {
            await voteForCandidate(pollId, candidateId);
            console.log('Vote successfully submitted!');
        } catch (error) {
            console.error('Error submitting vote:', error);
        }
    };

    return (
        <div className="p-6 max-w-lg mx-auto bg-white rounded-xl shadow-md space-y-4">
            {poll ? (
                <>
                    <h2 className="text-xl font-bold">{poll.name}</h2>
                    <p className="text-gray-500">Start Date: {poll.startDate.toString()}</p>
                    <p className="text-gray-500">End Date: {poll.endDate.toString()}</p>
                    <p className="text-gray-500">Total Votes: {poll.voteCountPoll}</p>
                    <div className="space-y-2">
                        {poll.candidates.map(candidate => (
                            <div key={candidate.id} className="flex justify-between items-center">
                                <span>{candidate.name} ({candidate.partyName})</span>
                                <span className="font-bold">{voteCounts.get(candidate.id) || 0} votes</span>
                                <button
                                    onClick={() => handleVote(candidate.id)}
                                    className="px-4 py-2 bg-blue-500 text-white rounded"
                                >
                                    Vote
                                </button>
                            </div>
                        ))}
                    </div>
                </>
            ) : (
                <p>Loading poll data...</p>
            )}
        </div>
    );
};

export default PollComponent;
