package es.in2.remotesignature.dtos.errors;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericResponseErrorTest {

    @Test
    void testGettersAndSetters() {
        // Create an instance of GenericResponseError
        GenericResponseError error = new GenericResponseError();
        error.setTimestamp(LocalDateTime.parse("2023-05-04T17:17:25.265"));
        error.setStatus(500);
        error.setError("null_pointer");
        error.setMessage("The variable 'result' was unexpectedly null.");
        error.setPath("/credential/id3214");

        // Verify that the getters return the expected values
        assertEquals(LocalDateTime.parse("2023-05-04T17:17:25.265"), error.getTimestamp());
        assertEquals(500, error.getStatus());
        assertEquals("null_pointer", error.getError());
        assertEquals("The variable 'result' was unexpectedly null.", error.getMessage());
        assertEquals("/credential/id3214", error.getPath());
    }
}