package com.tuempresa.keycloak;

import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.models.AuthenticationExecutionModel;

import java.util.List;
import org.keycloak.models.AuthenticationExecutionModel;

public class SecretWordAuthenticatorFactory implements AuthenticatorFactory {
    public static final String PROVIDER_ID = "secret-word-authenticator";

    @Override
    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        return new AuthenticationExecutionModel.Requirement[] {
            AuthenticationExecutionModel.Requirement.REQUIRED,
            AuthenticationExecutionModel.Requirement.ALTERNATIVE,
            AuthenticationExecutionModel.Requirement.DISABLED
        };
    }
    
    @Override
    public String getDisplayType() { return "Secret Word Check"; }
    @Override
    public String getReferenceCategory() { return "custom-auth"; }
    @Override
    public boolean isConfigurable() { return false; }
    @Override
    public boolean isUserSetupAllowed() { return false; }
    @Override
    public String getHelpText() { return "Pide una palabra mágica para entrar."; }
    @Override
    public List<ProviderConfigProperty> getConfigProperties() { return null; }
    
    @Override
    public Authenticator create(KeycloakSession session) { return new SecretWordAuthenticator(); }
    @Override
    public void init(Config.Scope config) {}
    @Override
    public void postInit(KeycloakSessionFactory factory) {}
    @Override
    public void close() {}
    @Override
    public String getId() { return PROVIDER_ID; }
    
}