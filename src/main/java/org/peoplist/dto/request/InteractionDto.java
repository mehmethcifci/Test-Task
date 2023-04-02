package org.peoplist.dto.request;

import lombok.*;
import org.peoplist.entity.enums.InteractionType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InteractionDto {

    Long candidateOid;
    InteractionType interactionType;
    String content;
    Boolean candidateResponded;
}
