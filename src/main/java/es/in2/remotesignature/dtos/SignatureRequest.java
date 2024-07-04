package es.in2.remotesignature.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class SignatureRequest {
    @NotBlank
    private SignatureConfiguration configuration;

    @Schema(example = "{\"username\":\"alfresco123\", \"age\": 25}")
    @NotBlank
    private String data;
}
