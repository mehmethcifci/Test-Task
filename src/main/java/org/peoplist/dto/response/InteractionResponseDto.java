package org.peoplist.dto.response;

import lombok.*;
import org.peoplist.entity.enums.InteractionType;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InteractionResponseDto {


    InteractionType interactionType;
    String content;
    Boolean candidateResponded;
    Date date;

}
