package com.example.pavel.twobrains;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import shared.request.RegisterRequest;
import shared.response.RegisterResponse;

public class WebClient {

    private OAuth2RestTemplate template;

    public boolean login(final String username, final String password){
        final MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

        map.add("username", username);
        map.add("password", password);
        map.add("grant_type", "password");

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Authorization","Basic dHdvYnJhaW5zOmFuZHk=");
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        OAuth2AccessToken token = restTemplate.postForObject("http://localhost:8080/oauth/token", request, OAuth2AccessToken.class);

        if(token == null){
            return false;
        } else {
            template = new OAuth2RestTemplate(new ResourceOwnerPasswordResourceDetails(), new DefaultOAuth2ClientContext(token));
            return true;
        }
    }

    public RegisterResponse register(final String firstname, final String lastname, final int age, final String email, final String password){
        final RegisterRequest request = new RegisterRequest(email, firstname, lastname, password, age);
        RestTemplate registerTemplate = new RestTemplate();
//        registerTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        registerTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        return registerTemplate.postForObject("http://localhost:8080/register", request, RegisterResponse.class);
    }

    public static void main(String[] args) {}

}
