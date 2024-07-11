package es.in2.remotesignature.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Schema(description = "Generic response when an unexpected error occurs")
public record GenericResponseError(
    @Schema(example = "2023-05-04T17:17:25.265Z", description = "The timestamp when the error occurred.")
    @JsonProperty("timestamp") LocalDateTime timestamp,
    @Schema(example = "500", description = "The HTTP status code indicating the error.")
    @JsonProperty("status") int status,
    @Schema(example = "null_pointer", description = "A unique identifier for the type of error.")
    @JsonProperty("error") String error,
    @Schema(example = "The variable 'result' was unexpectedly null.", description = "A detailed error message describing the issue.")
    @JsonProperty("message") String message,
    @Schema(example = "/credential/id3214", description = "The API endpoint or path where the error occurred.")
    @JsonProperty("path") String path
) {
}
