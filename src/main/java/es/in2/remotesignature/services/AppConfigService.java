package es.in2.remotesignature.services;

import reactor.core.publisher.Mono;

public interface AppConfigService {
      Mono<String> getConfiguration(String key);
}

