package com.cloudthat.eventservice.external.interceptors;

import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

import java.util.Objects;

@Configuration
public class OAuthRequestInterceptor {

    @Autowired
    private OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;
    public void apply(RequestTemplate template){
        template.header("Authorization", "Bearer "
        + Objects.requireNonNull(oAuth2AuthorizedClientManager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("internal-client")
                        .principal("internal").build()))
                .getAccessToken().getTokenValue());

    }
}
