package es.in2.dss.controller;

import es.in2.dss.z.model.SignatureRequest;
import es.in2.dss.z.model.SignedData;
import es.in2.dss.z.model.GenericResponseError;
import es.in2.dss.z.model.SignatureResponseError;
import es.in2.dss.z.service.SignatureServiceFactory;
import es.in2.dss.z.model.SignatureType;
import es.in2.dss.z.service.SignatureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
//@RestController
//@RequestMapping("/api/v1/signature")
//@RequiredArgsConstructor

@RestController
@RequestMapping("/dss/v1/signatures")
@RequiredArgsConstructor
public class SignaturesController {

    // todo: Create the required endpoints for the Remote Signature Service API: signatures/signHash, signatures/signDoc
    //  and signatures/timestamp.

//    private final SignatureServiceFactory signatureServiceFactory;
//
//    @Operation(
//            summary = "Signs the given data according to the given paramaters",
//            description = "This endpoint allows you to sign data based on the provided request parameters. " +
//                    "The data is signed according to the specified signature type and configuration."
//    )
//    @ApiResponses(value = {
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "The signing process was completed successfully and the given data is returned",
//                    content = @Content(
//                            mediaType = MediaType.APPLICATION_JSON_VALUE,
//                            schema = @Schema(implementation = SignedData.class)
//                    )
//            ),
//            @ApiResponse(
//                    responseCode = "400",
//                    description = "Bad request",
//                    content = @Content(
//                            mediaType = MediaType.APPLICATION_JSON_VALUE,
//                            schema = @Schema(implementation = SignatureResponseError.class)
//                    )
//            ),
//            @ApiResponse(
//                    responseCode = "500",
//                    description = "This response is returned when an unexpected server error occurs. It includes an error message if one is available.",
//                    content = @Content(
//                            mediaType = MediaType.APPLICATION_JSON_VALUE,
//                            schema = @Schema(implementation = GenericResponseError.class)
//                    )
//            )
//    })
//    @PostMapping(value= "sign", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<SignedData> sign(@RequestBody SignatureRequest signatureRequest) {
//        log.info("SignController - sign() invoked");
//        SignatureType type = signatureRequest.configuration().type();
//        log.info("Signature type requested: " + type);
//        SignatureService signatureService = signatureServiceFactory.createService(type);
//        SignedData signedData = signatureService.sign(signatureRequest);
//        return ResponseEntity.ok(signedData);
//    }

}
