package es.in2.remotesignature.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record SignatureRequest(
        @NotBlank SignatureConfiguration configuration,
        @Schema(example = "{\"username\":\"alfresco123\", \"age\": 25}") @NotBlank String data
) {
}
