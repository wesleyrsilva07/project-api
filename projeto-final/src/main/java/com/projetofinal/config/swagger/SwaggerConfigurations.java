package com.projetofinal.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {

	@Bean
	public Docket forumApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.projetofinal")).paths(PathSelectors.ant("/**")).build()
				.directModelSubstitute(Pageable.class, SwaggerPageable.class).apiInfo(apiInfo());
	}
	
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title ("Product - API Documentation")
                .version("1.0.0")
                .contact(new Contact("Wesley Ribeiro da Silva", "https://github.com/wesleyrsilva07/project-api.git", "wesley.silva.pb@compasso.com.br"))
                .build();
        return apiInfo;
    }
	

}
