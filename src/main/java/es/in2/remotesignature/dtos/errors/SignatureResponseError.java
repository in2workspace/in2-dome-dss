package es.in2.remotesignature.dtos.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "Response object for expected signing errors. This DTO is used to provide detailed information when a known or expected error occurs during the signing process.")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class SignatureResponseError {
    @Schema(
            description = "The error code",
            example = "signature_type_not_available"
    )
    @JsonProperty("error")
    private String error;

    @Schema(
            description = "A brief description of the error",
            example = "The signature type 'dummy' is not available"
    )
    @JsonProperty("description")
    private String description;
}
