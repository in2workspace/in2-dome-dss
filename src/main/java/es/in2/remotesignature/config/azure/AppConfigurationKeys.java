package es.in2.remotesignature.config.azure;

public final class AppConfigurationKeys {

    private AppConfigurationKeys() {
        throw new IllegalStateException("Utility class");
    }

    public static final String REMOTE_SIGNATURE_BASE_URL_KEY = "aca-cross-rmt-sign-ms-uri";
    public static final String KEYCLOAK_URI_KEY = "aca-cross-keycloak-ms-uri";

}

