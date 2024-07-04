package es.in2.remotesignature.services.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"es.in2.remotesignature.config.properties.certificate"})
public class ServiceTestConfiguration {

}