package com.learn_everyday.spring.learn_spring_framework.sp_game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SPGameRunner {

	@Autowired
	private SPGameConsole game;
	
	public SPGameRunner(SPGameConsole game) {
		this.game = game;
	}

	public void run() {
		game.up();
		game.down();
		game.left();
		game.right();
	}
	
	

}
