package es.in2.dss.z.exception;

public class SignatureTypeNotSupportedException extends RuntimeException {

    public SignatureTypeNotSupportedException(String type) {
        super("Signature type: " + type + " is currently not supported");
    }

}
