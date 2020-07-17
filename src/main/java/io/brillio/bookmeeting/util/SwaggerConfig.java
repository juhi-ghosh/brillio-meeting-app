/**
 * 
 */
package io.brillio.bookmeeting.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jghosh
 * Class to configure Swagger Documentation
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket CollabModuleAPI() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("io.brillio.bookmeeting")).build().apiInfo(metadata());
	}

	private ApiInfo metadata() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("Brillio Book Meeting REST APIs", "Listing of all the Modules of Book Meeting App", "1.0", "Terms Of Service", null, null, null);
		return apiInfo;
	}
}
