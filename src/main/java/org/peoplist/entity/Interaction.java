package org.peoplist.entity;


import jakarta.persistence.*;
import lombok.*;
import org.peoplist.entity.enums.InteractionType;

import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "interaction")
public class Interaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long oid;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_oid", referencedColumnName = "oid")
    Candidate candidate;

    @Enumerated(EnumType.STRING)
    InteractionType interactionType;

    String content;

    @Temporal(TemporalType.TIMESTAMP)
    Date date;

    Boolean candidateResponded;


}
