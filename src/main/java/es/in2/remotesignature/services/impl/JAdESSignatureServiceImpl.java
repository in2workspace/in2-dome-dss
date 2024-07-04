package es.in2.remotesignature.services.impl;

import es.in2.remotesignature.config.properties.certificate.CertificateConfig;
import es.in2.remotesignature.dtos.SignatureRequest;
import es.in2.remotesignature.dtos.SignedData;
import es.in2.remotesignature.enums.SignatureType;
import es.in2.remotesignature.exceptions.SignedDataException;
import es.in2.remotesignature.services.SignatureService;
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
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class JAdESSignatureServiceImpl implements SignatureService {

    private final CertificateConfig certificateConfig;

    @Override
    public SignedData sign(SignatureRequest signatureRequest) {
        //Obtain private token and privateKey
        Pkcs12SignatureToken token = certificateConfig.loadKeyStore();
        DSSPrivateKeyEntry privateKey = token.getKey(certificateConfig.getCertAlias());

        //Load Signature parameters
        JAdESSignatureParameters parameters = getjAdESSignatureParameters(privateKey);

        //Obtain signed data
        String data = signatureRequest.getData();
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
        parameters.setIncludeSignatureType(false);
        parameters.setSigningCertificate(privateKey.getCertificate());
        parameters.setCertificateChain(Arrays.asList(privateKey.getCertificate()));

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
        OutputStream os =  new ByteArrayOutputStream();
        try {
            signedDocument.writeTo(os);
        } catch (IOException e) {
            throw new SignedDataException(e);
        }
        byte[] signedDocumentByteArray = ((ByteArrayOutputStream) os).toByteArray();
        return new SignedData(SignatureType.JADES, new String(signedDocumentByteArray, StandardCharsets.UTF_8));
    }
}
