package org.peoplist.entity;



import jakarta.persistence.*;
import lombok.*;
import org.peoplist.entity.enums.CandidateStatus;


import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "candidate")
public class Candidate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long oid;
    //name-surname
    String name;
    String surname;
    //Contact Information
    String mail;
    String phone;

    //Previous interaction

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Interaction> interactionList;

    @Enumerated(EnumType.STRING)
    CandidateStatus status;
}
