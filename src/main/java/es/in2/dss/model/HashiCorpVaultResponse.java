package es.in2.dss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.Map;

/**
 * The object returned by the Hashicorp API v2 is a JSON object with the keys "data" and "metadata".
 *
 * @param dataMap     - The key-value pairs stored in the Hashicorp Vault
 * @param metadataMap - The metadata of the key-value pairs stored in the Hashicorp Vault
 */
@Builder
public record HashiCorpVaultResponse(
        @JsonProperty("data") @NotNull Map<String, String> dataMap,
        @JsonProperty("metadata") @NotNull Map<String, String> metadataMap) {
}
