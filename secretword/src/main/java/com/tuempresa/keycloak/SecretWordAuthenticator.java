package com.tuempresa.keycloak;

import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.Authenticator;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

import jakarta.ws.rs.core.Response;

public class SecretWordAuthenticator implements Authenticator {

    // 1. Se ejecuta cuando el flujo llega a este paso
    @Override
    public void authenticate(AuthenticationFlowContext context) {
        // Mostramos un formulario HTML personalizado (lo crearemos luego)
        Response challenge = context.form()
                .createForm("secret-word-form.ftl");
        context.challenge(challenge);
    }

    // 2. Se ejecuta cuando el usuario envía el formulario
    @Override
    public void action(AuthenticationFlowContext context) {
        String secretInput = context.getHttpRequest().getDecodedFormParameters().getFirst("secret_word");
        String magicWord = "PROYECTO2026"; // Esto podría venir de un config

        if (magicWord.equals(secretInput)) {
            context.success(); // ¡Pasa!
        } else {
            // Falla y vuelve a mostrar el formulario con un error
            Response challenge = context.form()
                    .setError("Palabra secreta incorrecta")
                    .createForm("secret-word-form.ftl");
            context.failureChallenge(org.keycloak.authentication.AuthenticationFlowError.INVALID_CREDENTIALS, challenge);
        }
    }

    @Override public boolean requiresUser() { return true; }
    @Override public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) { return true; }
    @Override public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {}
    @Override public void close() {}
    
 
}
