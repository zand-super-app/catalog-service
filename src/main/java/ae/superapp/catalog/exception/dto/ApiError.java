package ae.superapp.catalog.exception.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Slf4j
public class ApiError {
    public static final String TIMESTAMP_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";

    private HttpStatus status;
    private int statusCode;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = TIMESTAMP_PATTERN)
    private LocalDateTime timestamp = LocalDateTime.now();
    private String debugMessage;
    private List<Error> errors;


}

