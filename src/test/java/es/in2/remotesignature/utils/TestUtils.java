package es.in2.remotesignature.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

public class TestUtils {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = JsonMapper.builder().build();
        objectMapper.registerModule(new JavaTimeModule());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        objectMapper.setDateFormat(formatter);
    }

    public static String toJson(Object object) throws  JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static <T> T fromJson(String json, Class<T> clazz) throws Exception {
        return objectMapper.readValue(json, clazz);
    }
}