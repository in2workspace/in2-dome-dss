package es.in2.dss.z.service.impl;

import es.in2.dss.z.config.CertificateConfig;
import es.in2.dss.z.exception.SignedDataException;
import es.in2.dss.z.model.SignatureRequest;
import es.in2.dss.z.model.SignatureType;
import es.in2.dss.z.model.SignedData;
import es.in2.dss.z.service.SignatureService;
import eu.europa.esig.dss.enumerations.*;
import eu.europa.esig.dss.jades.JAdESSignatureParameters;
import eu.europa.esig.dss.jades.signature.JAdESService;
import eu.europa.esig.dss.model.DSSDocument;
import eu.europa.esig.dss.model.InMemoryDocument;
import eu.europa.esig.dss.model.SignatureValue;
import eu.europa.esig.dss.model.ToBeSigned;
import eu.europa.esig.dss.token.DSSPrivateKeyEntry;
import eu.europa.esig.dss.token.Pkcs12SignatureToken;
import eu.europa.esig.dss.validation.CommonCertificateVerifier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class JAdESSignatureServiceImpl implements SignatureService {

    private final CertificateConfig certificateConfig;

    @Override
    public SignedData sign(SignatureRequest signatureRequest) {
        Pkcs12SignatureToken token = certificateConfig.loadKeyStore();
        //In our use of case, there's always one and only one key in the token
        //If there are more than one, we should implement a way to select the right one by alias
        DSSPrivateKeyEntry privateKey = token.getKeys().get(0);
        JAdESSignatureParameters parameters = getjAdESSignatureParameters(privateKey);
        String data = signatureRequest.data();
        return signData(data, parameters, token, privateKey);
    }

    @Override
    public SignatureType getSignatureType() {
        return SignatureType.JADES;
    }

    private JAdESSignatureParameters getjAdESSignatureParameters(DSSPrivateKeyEntry privateKey) {
        JAdESSignatureParameters parameters = new JAdESSignatureParameters();
        parameters.setSignatureLevel(SignatureLevel.JAdES_BASELINE_B);
        parameters.setSignaturePackaging(SignaturePackaging.ENVELOPING);
        parameters.setJwsSerializationType(JWSSerializationType.COMPACT_SERIALIZATION);
        parameters.setDigestAlgorithm(DigestAlgorithm.SHA256);
        parameters.setSigningCertificate(privateKey.getCertificate());
        parameters.setCertificateChain(privateKey.getCertificateChain());
        return parameters;
    }

    private SignedData signData(String data, JAdESSignatureParameters parameters, Pkcs12SignatureToken token, DSSPrivateKeyEntry privateKey) {
        DSSDocument toSignDocument = new InMemoryDocument(data.getBytes(StandardCharsets.UTF_8));
        toSignDocument.setMimeType(MimeTypeEnum.JSON);
        CommonCertificateVerifier commonCertificateVerifier = new CommonCertificateVerifier();
        JAdESService service = new JAdESService(commonCertificateVerifier);
        ToBeSigned dataToSign = service.getDataToSign(toSignDocument, parameters);
        DigestAlgorithm digestAlgorithm = parameters.getDigestAlgorithm();
        SignatureValue signatureValue = token.sign(dataToSign, digestAlgorithm, privateKey);
        DSSDocument signedDocument = service.signDocument(toSignDocument, parameters, signatureValue);
        return signedDocumentContentToString(signedDocument);
    }

    private SignedData signedDocumentContentToString(DSSDocument signedDocument) {
        ByteArrayOutputStream outputStream =  new ByteArrayOutputStream();
        try {
            signedDocument.writeTo(outputStream);
        } catch (IOException e) {
            throw new SignedDataException(e);
        }
        return new SignedData(SignatureType.JADES, outputStream.toString(StandardCharsets.UTF_8));
    }

}
