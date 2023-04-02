package com.mirae.warmup.warmUp.config.oauth;

import com.mirae.warmup.warmUp.config.auth.PrincipalDetails;
import com.mirae.warmup.warmUp.config.oauth.provider.FacebookUserInfo;
import com.mirae.warmup.warmUp.config.oauth.provider.GoogleUserInfo;
import com.mirae.warmup.warmUp.config.oauth.provider.NaverUserInfo;
import com.mirae.warmup.warmUp.config.oauth.provider.OAuth2UserInfo;
import com.mirae.warmup.warmUp.dto.UserDto;
import com.mirae.warmup.warmUp.entity.User;
import com.mirae.warmup.warmUp.repository.UserRepository;
import com.mirae.warmup.warmUp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("getClientRegistration : " + userRequest.getClientRegistration());
        System.out.println("getAccessToken : " + userRequest.getAccessToken().getTokenValue());

        OAuth2User oAuth2User = super.loadUser(userRequest);

        System.out.println("getAttributes: " + oAuth2User.getAttributes());

        OAuth2UserInfo oAuth2UserInfo = null;

        if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
            System.out.println("구글 로그인 요청");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        }
        else if(userRequest.getClientRegistration().getRegistrationId().equals("facebook")){
            System.out.println("페이스북 로그인 요청");
            oAuth2UserInfo = new FacebookUserInfo(oAuth2User.getAttributes());
        }
        else if(userRequest.getClientRegistration().getRegistrationId().equals("naver")){
            System.out.println("네이버 로그인 요청");
            oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
        }
        else{
            System.out.println("구글 페이스북 네이버만 지원합니다.");
        }

        String provider = oAuth2UserInfo.getProvider();
        String providerId = oAuth2UserInfo.getProviderId();
        String username = provider + providerId;
        String password = bCryptPasswordEncoder.encode("미래씨");
        String email = oAuth2UserInfo.getEmail();
        String role = "ROLE_USER";

        User userEntity = userService.getUserEntity(username);

        if(userEntity == null){
            System.out.println("OAuth 로그인이 최초입니다.");
            userEntity = User.builder()
                    .username(username)
                    .password(password)
                    .role(role)
                    .email(email)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userService.saveUserEntity(userEntity);
        }
        else{
            System.out.println("이미 아이디가 있습니다.");
        }

        return new PrincipalDetails(userEntity, oAuth2UserInfo.getAttributes());
    }
}
