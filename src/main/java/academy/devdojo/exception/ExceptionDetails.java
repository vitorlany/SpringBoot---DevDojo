package academy.devdojo.exception;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails {
    String title;
    int status;
    String details;
    String developerMessage;
    LocalDateTime timestamp;
}
