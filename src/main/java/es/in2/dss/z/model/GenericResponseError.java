package es.in2.dss.z.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Builder
public record GenericResponseError(
    @JsonProperty("timestamp") LocalDateTime timestamp,
    @JsonProperty("status") int status,
    @JsonProperty("error") String error,
    @JsonProperty("message") String message,
    @JsonProperty("path") String path
) {
}
