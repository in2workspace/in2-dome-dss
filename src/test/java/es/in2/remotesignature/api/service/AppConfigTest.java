package es.in2.remotesignature.api.service;

import es.in2.remotesignature.api.config.AppConfig;
import es.in2.remotesignature.api.config.properties.*;
import es.in2.remotesignature.configuration.service.GenericConfigAdapter;
import es.in2.remotesignature.configuration.util.ConfigAdapterFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppConfigTest {

    @Mock
    private ConfigAdapterFactory configAdapterFactory;

    @Mock
    private GenericConfigAdapter genericConfigAdapter;

    @Mock
    private AppProperties appProperties;

    @Mock
    private OpenApiProperties openApiProperties;

    @Mock
    private OpenApiServerProperties openApiServerProperties;

    @Mock
    private OpenApiInfoProperties openApiInfoProperties;

    @Mock
    private OpenApiInfoContactProperties openApiInfoContactProperties;

    @Mock
    private OpenApiInfoLicenseProperties openApiInfoLicenseProperties;

    @Mock
    private AuthorizationServerProperties authorizationServerProperties;

    @Mock
    private CertificateProperties certificateProperties;

    private AppConfig appConfig;

    @BeforeEach
    public void setUp() {
        when(configAdapterFactory.getAdapter()).thenReturn(genericConfigAdapter);
        appConfig = new AppConfig(configAdapterFactory, appProperties);
    }

    @Test
    void whenGetOpenApiServerUrl_thenReturnOpenApiServerUrl() {
        String expectedServerUrl = "http://localhost:8080";

        when(appProperties.openApi()).thenReturn(openApiProperties);
        when(appProperties.openApi().server()).thenReturn(openApiServerProperties);
        when(appProperties.openApi().server().url()).thenReturn(expectedServerUrl);

        when(genericConfigAdapter.getConfiguration(appProperties.openApi().server().url())).thenReturn(expectedServerUrl);

        String serverUrl = appConfig.getOpenApiServerUrl();

        assertEquals(expectedServerUrl, serverUrl);
    }

    @Test
    void whenGetContactEmail_thenReturnContactEmail() {
        String expectedEmail = "contactEmail";

        when(appProperties.openApi()).thenReturn(openApiProperties);
        when(appProperties.openApi().info()).thenReturn(openApiInfoProperties);
        when(appProperties.openApi().info().contact()).thenReturn(openApiInfoContactProperties);
        when(appProperties.openApi().info().contact().email()).thenReturn(expectedEmail);

        String email = appConfig.getContactEmail();

        assertEquals(expectedEmail, email);
    }

    @Test
    void whenGetContactName_thenReturnContactName() {
        String expectedName = "contactName";

        when(appProperties.openApi()).thenReturn(openApiProperties);
        when(appProperties.openApi().info()).thenReturn(openApiInfoProperties);
        when(appProperties.openApi().info().contact()).thenReturn(openApiInfoContactProperties);
        when(appProperties.openApi().info().contact().name()).thenReturn(expectedName);

        String name = appConfig.getContactName();

        assertEquals(expectedName, name);
    }

    @Test
    void whenGetContactUrl_thenReturnContactUrl() {
        String expectedUrl = "contactUrl";

        when(appProperties.openApi()).thenReturn(openApiProperties);
        when(appProperties.openApi().info()).thenReturn(openApiInfoProperties);
        when(appProperties.openApi().info().contact()).thenReturn(openApiInfoContactProperties);
        when(appProperties.openApi().info().contact().url()).thenReturn(expectedUrl);

        String url = appConfig.getContactUrl();

        assertEquals(expectedUrl, url);
    }

    @Test
    void whenGetLicenseUrl_thenReturnLicenseUrl() {
        String expectedUrl = "licenseUrl";

        when(appProperties.openApi()).thenReturn(openApiProperties);
        when(appProperties.openApi().info()).thenReturn(openApiInfoProperties);
        when(appProperties.openApi().info().license()).thenReturn(openApiInfoLicenseProperties);
        when(appProperties.openApi().info().license().url()).thenReturn(expectedUrl);

        String url = appConfig.getLicenseUrl();

        assertEquals(expectedUrl, url);
    }

    @Test
    void whenGetServerDescription_thenReturnServerDescription() {
        String expectedDescription = "serverDescription";

        when(appProperties.openApi()).thenReturn(openApiProperties);
        when(appProperties.openApi().server()).thenReturn(openApiServerProperties);
        when(appProperties.openApi().server().description()).thenReturn(expectedDescription);

        String description = appConfig.getServerDescription();

        assertEquals(expectedDescription, description);
    }

    @Test
    void whenGetLicenseName_thenReturnLicenseName() {
        String expectedName = "licenseName";

        when(appProperties.openApi()).thenReturn(openApiProperties);
        when(appProperties.openApi().info()).thenReturn(openApiInfoProperties);
        when(appProperties.openApi().info().license()).thenReturn(openApiInfoLicenseProperties);
        when(appProperties.openApi().info().license().name()).thenReturn(expectedName);

        String name = appConfig.getLicenseName();

        assertEquals(expectedName, name);
    }

    @Test
    void whenGetIssuerUri_thenReturnIssuerUri() {
        String expectedIssuerUri = "issuerUri";

        when(appProperties.authorizationServer()).thenReturn(authorizationServerProperties);
        when(appProperties.authorizationServer().issuerUri()).thenReturn(expectedIssuerUri);

        when(genericConfigAdapter.getConfiguration(appProperties.authorizationServer().issuerUri())).thenReturn(expectedIssuerUri);

        String issuerUri = appConfig.getIssuerUri();

        assertEquals(expectedIssuerUri, issuerUri);
    }

    @Test
    void whenGetPublicIssuerUri_thenReturnPublicIssuerUri() {
        String expectedPublicIssuerUri = "publicIssuerUri";

        when(appProperties.authorizationServer()).thenReturn(authorizationServerProperties);
        when(appProperties.authorizationServer().publicIssuerUri()).thenReturn(expectedPublicIssuerUri);

        when(genericConfigAdapter.getConfiguration(appProperties.authorizationServer().publicIssuerUri())).thenReturn(expectedPublicIssuerUri);

        String publicIssuerUri = appConfig.getPublicIssuerUri();

        assertEquals(expectedPublicIssuerUri, publicIssuerUri);
    }

    @Test
    void whenGetCertificateKey_thenReturnCertificateKey() {
        String expectedKey = "certificateKey";

        when(appProperties.certificate()).thenReturn(certificateProperties);
        when(appProperties.certificate().key()).thenReturn(expectedKey);

        String key = appConfig.getCertificateKey();

        assertEquals(expectedKey, key);
    }

}
