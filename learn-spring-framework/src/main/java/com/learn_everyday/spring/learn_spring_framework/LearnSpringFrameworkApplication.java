package com.learn_everyday.spring.learn_spring_framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.learn_everyday.spring.learn_spring_framework.enterprise.web.WebController;
import com.learn_everyday.spring.learn_spring_framework.sp_game.SPGameRunner;

@SpringBootApplication
//@ComponentScan
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		
		// Tight Coupling
		// MarioGame game = new MarioGame();
//		SuperContraGame game = new SuperContraGame();
//		GameRunner runner = new GameRunner(game);
//		runner.run();
		
		// Loose Coupling with Interface
		// LCMarioGame lcGame = new LCMarioGame();
//		LCSuperContraGame lcGame = new LCSuperContraGame();
//		LCGameRunner lcRunner = new LCGameRunner(lcGame);
//		lcRunner.run();
		
		// Loose Coupling Using Spring
		SPGameRunner runner = context.getBean(SPGameRunner.class);
		runner.run();
		
		WebController controller = context.getBean(WebController.class);
		System.out.println(controller.returnValueFromBusinessService());
	}

}
