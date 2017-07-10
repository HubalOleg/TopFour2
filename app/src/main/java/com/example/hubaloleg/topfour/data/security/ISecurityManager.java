package com.example.hubaloleg.topfour.data.security;

/**
 * Created by hubaloleg on 10.07.17.
 */

public interface ISecurityManager {

    String loadUserToken();

    void storeUserToken(String token);

    boolean isUserLoggedIn();

}
