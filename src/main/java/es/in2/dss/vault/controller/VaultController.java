package es.in2.dss.vault.controller;

import es.in2.dss.vault.model.Credentials;
import es.in2.dss.vault.service.CredentialsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dss/v1/vault")
@RequiredArgsConstructor
@Slf4j
public class VaultController {

    private final CredentialsService credentialsService;

    @PostMapping
    public void createSecret(@RequestBody Credentials credentials) {
        log.info("VaultController -- createSecret -- key: {}, secret: {}", credentials.key(), credentials.secret());
        credentialsService.secureCredentials(credentials);
    }

}
