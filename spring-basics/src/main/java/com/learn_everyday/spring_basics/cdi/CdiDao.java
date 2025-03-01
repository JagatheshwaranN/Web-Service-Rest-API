package com.learn_everyday.spring_basics.cdi;

import javax.inject.Named;

@Named
public class CdiDao {

	
	public int[] getData() {
		return new int[] {20, 34, 87, 92};
	}
}

