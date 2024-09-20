package es.in2.remotesignature.api.model.errors;

import es.in2.remotesignature.api.model.GenericResponseError;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericResponseErrorTest {

    @Test
    void testGettersAndSetters() {
        // Create an instance of GenericResponseError
        GenericResponseError error = GenericResponseError.builder()
                .error("null_pointer")
                .message("The variable 'result' was unexpectedly null.")
                .path("/credential/id3214")
                .status(500)
                .timestamp(LocalDateTime.parse("2023-05-04T17:17:25.265"))
                .build();
        // Verify that the getters return the expected values
        assertEquals(LocalDateTime.parse("2023-05-04T17:17:25.265"), error.timestamp());
        assertEquals(500, error.status());
        assertEquals("null_pointer", error.error());
        assertEquals("The variable 'result' was unexpectedly null.", error.message());
        assertEquals("/credential/id3214", error.path());
    }

}
