package org.smart.micro.config.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @ClassName OAuth2AuthorizationServer
 * @Description 认证授权服务器
 * @Author jiangsida
 * @VERSION 1.0
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() // 使用in-memory存储
                .withClient("user")  //security5.0 以后{bycryt}+加密后的密码
                .secret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"))
                .redirectUris("http://localhost:9001/callback")
                // 授权码模式
                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
                .scopes("read_userinfo", "read_contacts");
    }



}
