package com.myspringproject.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()// .apis(getApis())//
																// basePackage("com.cplo.mobile.controller"))
				.paths(PathSelectors.any()).build().apiInfo(metaData());
	}

	private Predicate<RequestHandler> getApis() {
		List<Predicate<RequestHandler>> list = new ArrayList<>();
		list.add(RequestHandlerSelectors.withClassAnnotation(CrossOrigin.class));
		// list.add(transform(PathSelectors.ant(properties.getActuatorBaseURI()+"/**")));
		list.add(transform(PathSelectors.ant("/logout")));
		return Predicates.or(list);
	}

	private Predicate<RequestHandler> transform(final Predicate<String> pathSelector) {
		return new Predicate<RequestHandler>() {
			@Override
			public boolean apply(RequestHandler input) {
				return Iterables.any(input.getPatternsCondition().getPatterns(), pathSelector);
			}
		};
	}

	private Parameter getParameter() {
		return new ParameterBuilder().name("token").description("JWT").modelRef(new ModelRef("string"))
				.parameterType("query").required(false).build();
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("My Spring Boot")
				.description("JavaInUse API reference for developers")
				.termsOfServiceUrl("http://javainuse.com")
				.contact(new Contact("Vinay Agarwala","","vinayagarwala@gmail.com")).license("JavaInUse License")
				.licenseUrl("javainuse@gmail.com").version("1.0").build();
	}
}
