package com.learn_everyday.spring.learn_spring_framework.sp_game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SPSuperContraGame implements SPGameConsole {

	public void up() {
		System.out.println("SC UP");
	}
	
	public void down() {
		System.out.println("SC DOWN");
	}
	
	public void left() {
		System.out.println("SC LEFT");
	}
	
	public void right() {
		System.out.println("SC RIGHT");
	}
}
