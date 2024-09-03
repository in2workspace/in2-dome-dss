package es.in2.dss.z.exception;

public class SignedDataException extends RuntimeException {
    public static final String DEFAULT_EXCEPTION_MESSAGE = "Error signing data ";

    public SignedDataException(Exception e) {
        super(DEFAULT_EXCEPTION_MESSAGE, e);
    }

}
