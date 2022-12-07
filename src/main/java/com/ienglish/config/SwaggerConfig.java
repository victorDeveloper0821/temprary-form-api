package com.ienglish.config;

import com.google.common.base.Predicates;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
/**
 * Swagger2 設定檔
 */
public class SwaggerConfig {
    @Autowired
    private MaintainerInfo info;
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * 設定 Swagger Document Maintainer 資訊
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                info.getTitle(),
                info.getDescription(),
                info.getVersion(),
                "",
                new Contact(info.getName(), "",
                        info.getEmail()),
                "", "", Collections.emptyList());
    }
}
