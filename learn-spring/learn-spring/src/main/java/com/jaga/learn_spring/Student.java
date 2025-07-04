package com.jaga.learn_spring;

public class Student {

	private Writer writer;

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public void writeExam() {
		writer.write();
	}

}
