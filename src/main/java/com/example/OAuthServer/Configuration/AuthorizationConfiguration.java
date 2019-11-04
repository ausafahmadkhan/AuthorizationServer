package com.example.OAuthServer.Configuration;

import com.example.OAuthServer.Service.MyClientDetailsService;
import com.example.OAuthServer.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
public class AuthorizationConfiguration extends AuthorizationServerConfigurerAdapter
{
    @Autowired
    private MyClientDetailsService clientDetailsService;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception
    {
        clients
                .withClientDetails(clientDetailsService);
//        clients
//                .inMemory()
//                .withClient("ClientA")
//                .secret("secret")
//                .authorizedGrantTypes("password")
//                .scopes("READ")
//                .autoApprove(true)
//                .accessTokenValiditySeconds(1800)
//                .refreshTokenValiditySeconds(3600);

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception
    {
        endpoints
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .setClientDetailsService(clientDetailsService);
    }
}
