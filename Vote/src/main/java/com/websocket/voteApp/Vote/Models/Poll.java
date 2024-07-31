package com.websocket.voteApp.Vote.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Polls")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToMany(mappedBy = "polls")
    private Set<Candidate> candidates;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
    private Set<Vote> votes;
}
