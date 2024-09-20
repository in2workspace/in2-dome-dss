package es.in2.dss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DSSApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DSSApiApplication.class, args);
	}

}
