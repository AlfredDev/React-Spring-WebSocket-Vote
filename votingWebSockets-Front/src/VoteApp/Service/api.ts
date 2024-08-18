import { axiosInstance } from '../../AxiosConector/ConnectionAxios';
import { PollResponse, VoteCountResponse } from '../Types/types';

export const getPollData = async (pollId: number): Promise<PollResponse> => {
    try {
        const response = await axiosInstance.get(`/api/v1/poll/${pollId}`);
        console.log(response);
        return response.data.object;
    } catch (error) {
        console.error('Error fetching poll data:', error);
        throw error;
    }
};

export const voteForCandidate = async (pollId: number, candidateId: number): Promise<void> => {
    const voteRequest = {
        idCandidate: candidateId,
        pollId: pollId
    };
    console.log(voteRequest)
    try {
        await axiosInstance.post('/api/v1/vote/save', voteRequest);
    } catch (error) {
        console.error('Error submitting vote:', error);
        throw error; 
    }
};

export const subscribeToVoteUpdates = (
    onVoteUpdate: (vote: VoteCountResponse) => void
) => {

    const socket = new WebSocket('wss://backend-wspq.onrender.com/ws/voting');

    socket.onopen = () => {
        console.log('WebSocket connection established');
    };

    // Handle incoming messages
    socket.onmessage = (event) => {
        try {
            const voteUpdate: VoteCountResponse = JSON.parse(event.data);
            console.log(voteUpdate);
            onVoteUpdate(voteUpdate); 
        } catch (error) {
            console.error('Error processing WebSocket message:', error);
        }
    };

    // Handle WebSocket errors
    socket.onerror = (error) => {
        console.error('WebSocket error:', error);
    };

    socket.onclose = (event) => {
        if (event.wasClean) {
            console.log(`WebSocket connection closed cleanly, code=${event.code}, reason=${event.reason}`);
        } else {
            console.error('WebSocket connection closed unexpectedly');
        }
    };

    return () => {
        socket.close();
    };
};
