package org.peoplist.exception;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Component
public class ExceptionResponse {
    private int exceptionCode;
    private String customMessage;
    private String exceptionMessage;
    private int httpStatus;
}
