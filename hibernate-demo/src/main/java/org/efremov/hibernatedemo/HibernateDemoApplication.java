package org.efremov.hibernatedemo;

import java.util.Arrays;
import java.util.List;

import org.efremov.hibernatedemo.config.AppConfig;
import org.efremov.hibernatedemo.dao.SingerDao;
import org.efremov.hibernatedemo.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateDemoApplication {
	
	private static Logger logger = LoggerFactory.getLogger(AppConfig.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(HibernateDemoApplication.class, args);

		SingerDao singerDao = ctx.getBean(SingerDao.class);
		listSingers(singerDao.findAll());
	}

	private static void listSingers(List<Singer> singers) {
		logger.info(" ---- Listing singers:");
		for (Singer singer : singers) {
			logger.info(singer.toString());
		}
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}
}
