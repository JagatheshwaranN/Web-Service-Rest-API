package com.learn_everyday.spring.learn_spring_framework.sp_game;

import org.springframework.stereotype.Component;

@Component
public class SPMarioGame implements SPGameConsole {

	public void up() {
		System.out.println("UP");
	}
	
	public void down() {
		System.out.println("DOWN");
	}
	
	public void left() {
		System.out.println("LEFT");
	}
	
	public void right() {
		System.out.println("RIGHT");
	}
}
