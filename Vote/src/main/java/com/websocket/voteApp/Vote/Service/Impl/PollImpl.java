package com.websocket.voteApp.Vote.Service.Impl;

import com.websocket.voteApp.Vote.DTO.Request.PollRequest;
import com.websocket.voteApp.Vote.DTO.Response.PollResponse;
import com.websocket.voteApp.Vote.Exceptions.ResourceNotFoundException;
import com.websocket.voteApp.Vote.Mappers.PollMapper;
import com.websocket.voteApp.Vote.Models.Poll;
import com.websocket.voteApp.Vote.Repository.PollRepository;
import com.websocket.voteApp.Vote.Repository.VoteRepository;
import com.websocket.voteApp.Vote.Service.PollService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PollImpl implements PollService {
    private final PollRepository pollRepository;
    private final PollMapper pollMapper;
    private final VoteRepository voteRepository;

    @Override
    public List<PollResponse> getAllPolls() {
        List<Poll> polls = pollRepository.findAll();
        if (polls.isEmpty()) {
            //  throw new ResourceNotFoundException("No Polls found");
            return Collections.emptyList();
        }
        return polls.stream()
                .map(this::mapPollToPollResponse)
                .toList();
    }


    @Override
    public PollResponse getPollById(Long id) {
        Poll poll = pollRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No poll found with id " + id));
        return mapPollToPollResponse(poll);
    }

    @Override
    @Transactional
    public PollResponse createPoll(PollRequest request) {
        Poll poll = pollMapper.toPoll(request);
        Poll savedPoll = pollRepository.save(poll);
        return mapPollToPollResponse(savedPoll);
    }

    @Override
    @Transactional
    public PollResponse updatePoll(PollRequest request, Long pollId) {
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new ResourceNotFoundException("No poll found with id " + pollId));
        poll.setName(request.getName());
        poll.setEndDate(request.getEndDate());
        poll.setStartDate(request.getStartDate());
        Poll updatedPoll = pollRepository.save(poll);

        return mapPollToPollResponse(updatedPoll);
    }

    @Override
    public void deletePollById(Long id) {
        pollRepository.findById(id).ifPresentOrElse(
                pollRepository::delete,
                () -> {
                    throw new ResourceNotFoundException("No poll found with id " + id);
                }
        );
    }

    private PollResponse mapPollToPollResponse(Poll poll) {
        int voteCount = voteRepository.countByPollId(poll.getId());
        return pollMapper.toPollResponse(poll, voteCount);
    }

}
