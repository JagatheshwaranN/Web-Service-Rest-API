package com.learn_everyday.spring.learn_spring_framework.game;

public class GameRunner {

//	private MarioGame game;
	private SuperContraGame game;
	
	public GameRunner(SuperContraGame game) {
		this.game = game;
	}

	public void run() {
		game.up();
		game.down();
		game.left();
		game.right();
	}
	
	

}
