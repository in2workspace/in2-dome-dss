package es.in2.remotesignature.dtos.errors;

public class SignatureErrorCodes
{
    private SignatureErrorCodes() {
        throw new IllegalStateException("Utility class");
    }
    public static final String SIGNATURE_TYPE_NOT_SUPPORTED = "signature_type_not_supported";
}

