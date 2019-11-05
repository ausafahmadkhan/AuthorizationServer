package com.example.OAuthServer.Persistence.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MyClientDetails extends ClientDAO implements ClientDetails
{

    public MyClientDetails(ClientDAO clientDAO)
    {
        this.setClientId(clientDAO.getClientId());
        this.setClientSecret(clientDAO.getClientSecret());
        this.setAuthorizedGrantType(clientDAO.getAuthorizedGrantType());
        this.setClientScope(clientDAO.getClientScope());
        this.setAutoApprove(clientDAO.isAutoApprove());
        this.setRedirectUris(clientDAO.getRedirectUris());
    }


    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return this.getClientScope();
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return this.getAuthorizedGrantType();
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return this.getRedirectUris();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.getScope().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return 1800;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return 3600;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return this.isAutoApprove();
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
