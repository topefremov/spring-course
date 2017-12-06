package org.efremov.didemo;

import org.efremov.didemo.controllers.ConstructorInjectedController;
import org.efremov.didemo.controllers.PropertyInjectedController;
import org.efremov.didemo.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
		PropertyInjectedController propertyInjectedController = ctx.getBean("propertyInjectedController", PropertyInjectedController.class);
		SetterInjectedController setterInjectedController = ctx.getBean("setterInjectedController", SetterInjectedController.class);
		ConstructorInjectedController constructorInjectedController = ctx.getBean("constructorInjectedController", ConstructorInjectedController.class);
		
		System.out.println(propertyInjectedController.sayHello());
		System.out.println(setterInjectedController.sayHello());
		System.out.println(constructorInjectedController.sayHello());
	}
}
