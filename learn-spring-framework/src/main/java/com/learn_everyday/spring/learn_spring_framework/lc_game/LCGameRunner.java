package com.learn_everyday.spring.learn_spring_framework.lc_game;

public class LCGameRunner {

//	private MarioGame game;
	private GameConsole game;
	
	public LCGameRunner(GameConsole game) {
		this.game = game;
	}

	public void run() {
		game.up();
		game.down();
		game.left();
		game.right();
	}
	
	

}
