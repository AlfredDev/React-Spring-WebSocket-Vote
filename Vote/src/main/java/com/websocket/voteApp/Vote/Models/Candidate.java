package com.websocket.voteApp.Vote.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "Candidates")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String partyName;
    private int voteCount;
    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Vote> votes;


}
