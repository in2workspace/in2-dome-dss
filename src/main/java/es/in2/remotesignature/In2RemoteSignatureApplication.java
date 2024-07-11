package es.in2.remotesignature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class In2RemoteSignatureApplication {

	public static void main(String[] args) {
		SpringApplication.run(In2RemoteSignatureApplication.class, args);
	}

}
