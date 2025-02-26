package com.learn_everyday.mockito.mockito_demo.business;

public class BusinessImpl {
	
	private DataService dataService;
		
	public BusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findtheGreatestValue() {
		int[] data = dataService.retrieveAllData();
		int greatestValue = Integer.MIN_VALUE;
		for(int value : data) {
			if(value > greatestValue) {
				greatestValue = value;
			}
		}
		return greatestValue;
	}
}


interface DataService {
	int[] retrieveAllData();
}