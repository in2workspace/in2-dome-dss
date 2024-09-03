package es.in2.dss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DSSApplication {

	public static void main(String[] args) {
		SpringApplication.run(DSSApplication.class, args);
	}

}
