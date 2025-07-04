package com.jaga.learn_spring_boot_basics;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Pencil implements Writer {

	public Pencil() {
		System.out.println("Pencil Created");
	}

	@Override
	public void write() {
		System.out.println("Write using Pencil..");
	}

}
