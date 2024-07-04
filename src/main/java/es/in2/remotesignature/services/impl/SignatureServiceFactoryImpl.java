package es.in2.remotesignature.services.impl;

import es.in2.remotesignature.enums.SignatureType;
import es.in2.remotesignature.exceptions.SignatureTypeNotSupportedException;
import es.in2.remotesignature.services.SignatureService;
import es.in2.remotesignature.services.SignatureServiceFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class SignatureServiceFactoryImpl implements SignatureServiceFactory {
    private final List<SignatureService> signatureServices;

    @Override
    public SignatureService createService(SignatureType type) {
        Optional<SignatureService> selectedService = signatureServices.stream()
                .filter(service -> service.getSignatureType() == type)
                .findFirst();

        if (!selectedService.isPresent()) {
            throw new SignatureTypeNotSupportedException(type.toString());
        }

        return selectedService.get();
    }

}
