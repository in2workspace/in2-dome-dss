package es.in2.dss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.Map;

/**
 * The object sent to the Hashicorp API v2 needs to be a JSON object with the key "data"
 * and the value being a map of key-value pairs.
 * Further information: <a href="https://developer.hashicorp.com/vault/api-docs/secret/kv/kv-v2">...</a>
 *
 * @param dataMap - The key-value pairs to be stored in the Hashicorp Vault
 */
@Builder
public record HashiCorpVaultRequest(@JsonProperty("data") @NotNull Map<String, String> dataMap) {
}
