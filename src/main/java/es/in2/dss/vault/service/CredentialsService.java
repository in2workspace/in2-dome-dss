package es.in2.dss.vault.service;

import es.in2.dss.vault.model.Credentials;

public interface CredentialsService {

    void secureCredentials(Credentials credentials);

    Credentials accessCredentials(String key);

}
