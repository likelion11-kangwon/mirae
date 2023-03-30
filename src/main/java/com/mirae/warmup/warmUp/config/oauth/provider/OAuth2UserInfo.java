package com.mirae.warmup.warmUp.config.oauth.provider;

public interface OAuth2UserInfo {
    public String getProviderId();

    public String getProvider();

    public String getEmail();

    public String getName();

}
