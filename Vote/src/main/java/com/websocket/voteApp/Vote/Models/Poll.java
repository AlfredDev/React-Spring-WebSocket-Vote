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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "poll")
    private Set<Candidate> candidates;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
    private Set<Vote> votes;
}
