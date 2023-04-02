package org.peoplist.dto.request;

import lombok.*;
import org.peoplist.entity.enums.CandidateStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateCandidateRequesDto {
    Long oid;
    String name;
    String surname;
    String mail;
    String phone;
    CandidateStatus status;
}
