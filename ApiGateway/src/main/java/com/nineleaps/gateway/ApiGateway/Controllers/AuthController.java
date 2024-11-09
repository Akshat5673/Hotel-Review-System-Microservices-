//package com.nineleaps.gateway.ApiGateway.Controllers;
//
//import com.nineleaps.gateway.ApiGateway.Payloads.AuthResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
//import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.List;
//import java.util.Objects;
//
//@Slf4j
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    @GetMapping("/login")
//    public ResponseEntity<AuthResponse> login(
//            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
//            @AuthenticationPrincipal OidcUser user
//    ){
//
//        log.info("user email id: {}",user.getEmail());
//
//        AuthResponse authResponse= new AuthResponse();
//
//        authResponse.setUserId(user.getEmail());
//        authResponse.setAccessToken(client.getAccessToken().getTokenValue());
//        authResponse.setRefreshToken(Objects.requireNonNull(client.getRefreshToken()).getTokenValue());
//        authResponse.setExpiresAt(Objects.requireNonNull(client.getAccessToken().getExpiresAt()).getEpochSecond());
//
//        List<String> authorities = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
//
//        authResponse.setAuthorities(authorities);
//
//        return ResponseEntity.ok(authResponse);
//
//    }
//
//}
