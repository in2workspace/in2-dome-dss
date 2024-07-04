package es.in2.remotesignature.services.impl;

import COSE.*;
import es.in2.remotesignature.dtos.SignatureRequest;
import es.in2.remotesignature.dtos.SignedData;
import es.in2.remotesignature.enums.SignatureType;
import es.in2.remotesignature.exceptions.SignedDataException;
import es.in2.remotesignature.services.SignatureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
@AllArgsConstructor
public class CoseSignatureServiceImpl implements SignatureService {

    // Current Prerequisite: Data sent for Cose requests must be base64 encoded
    @Override
    public SignedData sign(SignatureRequest signatureRequest) {
        try {
            byte[] cbor = getBytesFromBase64String(signatureRequest.getData());

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
