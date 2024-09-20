package es.in2.dss.api.service.impl;

import es.in2.dss.api.exception.SignatureTypeNotSupportedException;
import es.in2.dss.api.model.SignatureType;
import es.in2.dss.api.service.SignatureService;
import es.in2.dss.api.service.SignatureServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignatureServiceFactoryImpl implements SignatureServiceFactory {

    private final List<SignatureService> signatureServices;

    @Override
    public SignatureService createService(SignatureType type) {
        Optional<SignatureService> selectedService = signatureServices.stream()
                .filter(service -> service.getSignatureType() == type)
                .findFirst();
        return checkSelectedService(selectedService, type);
    }

    private SignatureService checkSelectedService(Optional<SignatureService> selectedService, SignatureType type) {
        if (selectedService.isPresent()) {
            return selectedService.get();
        } else {
            throw new SignatureTypeNotSupportedException(type.toString());
        }
    }

}
