//package es.in2.remotesignature.services.impl;
//
//import com.azure.data.appconfiguration.ConfigurationClient;
//import es.in2.remotesignature.config.azure.AzureAppConfigProperties;
//import es.in2.remotesignature.services.AppConfigService;
//import es.in2.remotesignature.util.Utils;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.MDC;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;
//import reactor.core.publisher.Mono;
//
//@Service
//@RequiredArgsConstructor
//@Profile("!local")
//@Slf4j
//public class AzureConfigServiceImpl implements AppConfigService {
//
//    private final ConfigurationClient azureConfigurationClient;
//    private final AzureAppConfigProperties azureAppConfigProperties;
//
//    @Override
//    public Mono<String> getConfiguration(String key) {
//        String processId = MDC.get(Utils.PROCESS_ID);
//        return Mono.fromCallable(() -> {
//                    try {
//                        return azureConfigurationClient
//                                .getConfigurationSetting(key, azureAppConfigProperties.azureConfigLabel)
//                                .getValue();
//                    } catch (Exception e) {
//                        return "Communication with AppConfiguration failed. Prefix or label not available" + e;
//                    }
//                })
//                .doOnSuccess(voidValue -> log.info("ProcessID: {} - Secret retrieved successfully", processId))
//                .onErrorResume(Exception.class, Mono::error);
//    }
//}
