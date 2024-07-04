package es.in2.remotesignature.dtos;

import es.in2.remotesignature.enums.SignatureType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class SignatureConfiguration {
    @Schema(example = "JADES")
    private SignatureType type;

    @Schema(example = "{\"key1\":\"value1\",\"key2\":\"value2\"}")
    private Map<String, String> parameters;
}
