package org.peoplist.dto.response;

import lombok.*;
import org.peoplist.entity.enums.CandidateStatus;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CandidateResponseDto {
    Long oid;
    String name;
    String surname;
    String mail;
    String phone;
    String status;
    List<InteractionResponseDto> interactionDtoList;
}
