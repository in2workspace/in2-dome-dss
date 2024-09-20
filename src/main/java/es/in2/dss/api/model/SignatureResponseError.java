package es.in2.dss.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(description = "Response object for expected signing errors. This DTO is used to provide detailed information when a known or expected error occurs during the signing process.")
public record SignatureResponseError(
        @Schema(description = "The error code", example = "signature_type_not_available")
        @JsonProperty("error") String error,
        @Schema(description = "A brief description of the error", example = "The signature type 'dummy' is not available")
        @JsonProperty("description") String description
) {
}
