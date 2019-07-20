package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

	@Bean
	public FortuneService wonderfulFortuneService() {
		return new WonderfulFortuneService();
	}

	@Bean
	public PingpongCoach pingpongCoach() {
		return new PingpongCoach(wonderfulFortuneService());
	}

}
