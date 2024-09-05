//package es.in2.dss.z.config;
//
//import es.in2.dss.z.config.properties.AppProperties;
//import es.in2.dss.configuration.service.GenericConfigAdapter;
//import es.in2.dss.configuration.util.ConfigAdapterFactory;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Configuration
//public class AppConfig {
//
//   private final GenericConfigAdapter genericConfigAdapter;
//   private final AppProperties appProperties;
//
//    public AppConfig(ConfigAdapterFactory configAdapterFactory, AppProperties appProperties) {
//       this.genericConfigAdapter = configAdapterFactory.getAdapter();
//       this.appProperties = appProperties;
//   }
//
//    public String getOpenApiServerUrl() {
//        return genericConfigAdapter.getConfiguration(appProperties.openApi().server().url());
//    }
//
//    public String getContactEmail() {
//        return appProperties.openApi().info().contact().email();
//    }
//
//    public String getContactName() {
//        return appProperties.openApi().info().contact().name();
//    }
//
//    public String getContactUrl() {
//        return appProperties.openApi().info().contact().url();
//    }
//
//    public String getLicenseUrl() {
//        return appProperties.openApi().info().license().url();
//    }
//
//    public String getServerDescription() {
//        return appProperties.openApi().server().description();
//    }
//
//    public String getLicenseName() {
//        return appProperties.openApi().info().license().name();
//    }
//
//    public String getIssuerUri() {
//        return genericConfigAdapter.getConfiguration(appProperties.authorizationServer().issuerUri());
//    }
//
//    public String getPublicIssuerUri() {
//        return genericConfigAdapter.getConfiguration(appProperties.authorizationServer().publicIssuerUri());
//    }
//
//    public String getCertificateKey() {
//        return appProperties.certificate().key();
//    }
//
//}
