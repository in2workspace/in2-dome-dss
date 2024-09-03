package es.in2.dss.z.service.impl;

import es.in2.dss.z.exception.SignatureTypeNotSupportedException;
import es.in2.dss.z.model.SignatureType;
import es.in2.dss.z.service.SignatureService;
import es.in2.dss.z.service.SignatureServiceFactory;
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
