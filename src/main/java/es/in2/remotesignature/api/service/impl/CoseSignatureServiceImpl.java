package es.in2.remotesignature.api.service.impl;

import COSE.*;
import es.in2.remotesignature.api.model.SignatureRequest;
import es.in2.remotesignature.api.model.SignedData;
import es.in2.remotesignature.api.model.SignatureType;
import es.in2.remotesignature.api.exception.SignedDataException;
import es.in2.remotesignature.api.service.SignatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor
public class CoseSignatureServiceImpl implements SignatureService {

    // Current Prerequisite: Data sent for Cose requests must be base64 encoded
    @Override
    public SignedData sign(SignatureRequest signatureRequest) {
        try {
            byte[] cbor = getBytesFromBase64String(signatureRequest.data());
            Sign1Message coseSign1Message;
            coseSign1Message = signCbor(cbor);
            return sign1MessageToSignedData(coseSign1Message);
        } catch (Exception e) {
            throw new SignedDataException(e);
        }
    }

    @Override
    public SignatureType getSignatureType() {
        return SignatureType.COSE;
    }

    private byte[] getBytesFromBase64String(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }

    private Sign1Message signCbor(byte[] cbor) throws CoseException {
        OneKey oneKey = OneKey.generateKey(AlgorithmID.ECDSA_256);
        OneKey publicKey = oneKey.PublicKey();
        Sign1Message msg = new Sign1Message();
        msg.addAttribute(HeaderKeys.Algorithm, oneKey.get(KeyKeys.Algorithm), Attribute.PROTECTED);
        msg.addAttribute(HeaderKeys.KID, publicKey.AsCBOR(), Attribute.UNPROTECTED);
        msg.SetContent(cbor);
        msg.sign(oneKey);
        return msg;
    }

    private SignedData sign1MessageToSignedData(Sign1Message sign1Message) throws CoseException {
        return new SignedData(SignatureType.COSE, Base64.getEncoder().encodeToString(sign1Message.EncodeToBytes()));
    }

}
