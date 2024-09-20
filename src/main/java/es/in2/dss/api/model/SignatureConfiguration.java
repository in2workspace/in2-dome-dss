package es.in2.dss.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Map;

@Builder
public record SignatureConfiguration(
    @Schema(example = "JADES") SignatureType type,
    @Schema(example = "{\"key1\":\"value1\",\"key2\":\"value2\"}") Map<String, String> parameters
) {
}
