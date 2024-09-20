package es.in2.remotesignature.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class JacksonConfig {

    private static final ObjectMapper OBJECT_MAPPER = JsonMapper.builder().build();

    @Bean
    public ObjectMapper objectMapper() {
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        OBJECT_MAPPER.setDateFormat(formatter);
        return OBJECT_MAPPER;
    }

}
