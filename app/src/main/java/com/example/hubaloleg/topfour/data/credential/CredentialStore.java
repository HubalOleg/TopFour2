package com.example.hubaloleg.topfour.data.credential;

/**
 * Created by kostya on 10.07.17.
 */

public interface CredentialStore {
    void saveToken(String token);

    String loadToken();
}
