package com.websocket.voteApp.Vote.Models;

import com.websocket.voteApp.Vote.Models.User.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "Votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    private LocalDateTime timestamp;

}
