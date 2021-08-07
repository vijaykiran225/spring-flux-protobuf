package com.vijay.app.springboot.springbootserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@SpringBootApplication
@ComponentScan(basePackages = {"com.vijay.app.springboot.springbootserver"})
public class SpringbootServerApplication {

	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootServerApplication.class, args);
	}

}
