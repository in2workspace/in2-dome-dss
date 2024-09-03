package es.in2.dss.model;

import lombok.Builder;

@Builder
public record VaultSecret(
        // fixme: define field type. Object is not recommended.
        Object value) {
}