package com.petmeet.api.api.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Set;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final Set<String> PERMIT_URLS = Set.of(
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resource/**"
    );

    private static final Set<HttpMethod> ALLOWED_HTTP_METHOD = Set.of(
            HttpMethod.GET,
            HttpMethod.POST,
            HttpMethod.PUT,
            HttpMethod.PATCH,
            HttpMethod.DELETE,
            HttpMethod.OPTIONS
    );

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // CSRF 비활성화
                .csrf(AbstractHttpConfigurer::disable)
                // Http Basic 비활성화
                .httpBasic(AbstractHttpConfigurer::disable)
                // 기본 로그아웃 비활성화
                .logout(AbstractHttpConfigurer::disable)
                // cors 설정
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                // 경로별 인가 작업
                .authorizeHttpRequests(authorize -> {
                    // 접근 허용
                    PERMIT_URLS.forEach(url -> authorize.requestMatchers(url).permitAll());
                })
                // JWT 인증 필터 추가 (로그인 필터 수행 전 동작)

                // JWT 예외 필터 추가 (JWT 인증 필터 수행 전 동작)

                // OAuth2 로그인 설정

                // form 로그인 비활성화
                .formLogin(AbstractHttpConfigurer::disable)
                // 세션 미사용 설정
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }

    // cors 설정
    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);   // 자격 증명 허용
        config.addAllowedOriginPattern("*");    // 모든 요청 허용
        config.addAllowedHeader("*");   // 모든 헤더 허용
        ALLOWED_HTTP_METHOD.forEach(config::addAllowedMethod);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
