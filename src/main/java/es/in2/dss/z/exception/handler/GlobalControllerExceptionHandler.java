package es.in2.dss.z.exception.handler;

import es.in2.dss.z.model.GenericResponseError;
import es.in2.dss.z.util.SignatureErrorCodes;
import es.in2.dss.z.model.SignatureResponseError;
import es.in2.dss.z.exception.AzureConfigurationSettingException;
import es.in2.dss.z.exception.SignatureTypeNotSupportedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    public static final String DEFAULT_ERROR_MESSAGE = "An error occurred";

    @ExceptionHandler(AzureConfigurationSettingException.class)
    public Mono<ResponseEntity<Void>> handleAzureConfigurationSettingError(AzureConfigurationSettingException e) {
        log.error(e.getMessage());
        return Mono.just(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(SignatureTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<SignatureResponseError> handleValidateDocumentExceptionException(Exception e) {
        log.error(e.getMessage(), e);
        SignatureResponseError errorResponse = SignatureResponseError.builder()
                .error(SignatureErrorCodes.SIGNATURE_TYPE_NOT_SUPPORTED)
                .description(getDescription(e))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponseError> handleException(Exception e, WebRequest request) {
        log.error(e.getMessage(), e);

        GenericResponseError customErrorResponse = new GenericResponseError(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                e.getMessage() != null ? e.getMessage() : DEFAULT_ERROR_MESSAGE,
                request.getDescription(false)
        );

        return new ResponseEntity<>(customErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getDescription(Exception e) {
        return e.getMessage() != null ? e.getMessage() : DEFAULT_ERROR_MESSAGE;
    }

}
