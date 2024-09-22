package com.petmeet.api.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Collections;

@Profile("!prod")
@OpenAPIDefinition(
        info = @Info(
                title = "PetMeet API DOCS",
                description = "펫밋 서버 API 명세서입니다.",
                version = "v1")
)
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER).name("Authorization");
        SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerAuth");

        return new OpenAPI()
                .components(new Components().addSecuritySchemes("bearerAuth", securityScheme))
                .security(Collections.singletonList(securityRequirement))
                .paths(configureOAuth2LoginPaths());
    }

    // OAuth2 로그인 Path
    private Paths configureOAuth2LoginPaths() {
        // 경로 변수 파라미터
        Parameter param = new Parameter()
                .in("path")
                .name("registrationId")
                .description("소셜 제공자 (kakao, apple)")
                .required(true)
                .schema(new Schema<String>().type("string"));

        Operation operation = new Operation()
                .summary("OAuth2 로그인 경로 요청")
                .description("OAuth2 로그인 경로 요청 엔드포인트입니다." +
                        " 성공 시 /login/oauth2/code/{registrationId} 경로로 리다이렉트 됩니다.")
                .addTagsItem("oauth2")
                .addParametersItem(param);

        return new Paths()
                .addPathItem("/oauth2/authorization/{registrationId}", new PathItem().get(operation));
    }
}
