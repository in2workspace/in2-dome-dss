package es.in2.dss.vault.controller;

import es.in2.dss.vault.model.Credentials;
import es.in2.dss.vault.service.CredentialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dss/v1/vault")
@RequiredArgsConstructor
public class VaultController {

    private final CredentialsService credentialsService;

    @PostMapping
    public void createSecret(Credentials credentials) {
        credentialsService.secureCredentials(credentials);
    }

}
