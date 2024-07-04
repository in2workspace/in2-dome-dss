package es.in2.remotesignature.dtos.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Schema(description = "Generic response when an unexpected error occurs")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class GenericResponseError {
    @Schema(
            example = "2023-05-04T17:17:25.265Z",
            description = "The timestamp when the error occurred."
    )
    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    @Schema(
            example = "500",
            description = "The HTTP status code indicating the error."
    )
    @JsonProperty("status")
    private int status;

    @Schema(
            example = "null_pointer",
            description = "A unique identifier for the type of error."
    )
    @JsonProperty("error")
    private String error;

    @Schema(
            example = "The variable 'result' was unexpectedly null.",
            description = "A detailed error message describing the issue."
    )
    @JsonProperty("message")
    private String message;

    @Schema(
            example = "/credential/id3214",
            description = "The API endpoint or path where the error occurred."
    )
    @JsonProperty("path")
    private String path;

}