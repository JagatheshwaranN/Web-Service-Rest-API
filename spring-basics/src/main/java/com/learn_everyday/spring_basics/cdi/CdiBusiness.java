package com.learn_everyday.spring_basics.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CdiBusiness {

	@Inject
	private CdiDao cdiDao;

	public CdiDao getCdiDao() {
		return cdiDao;
	}

	public void setCdiDao(CdiDao cdiDao) {
		this.cdiDao = cdiDao;
	}
	
	public int findHighestValue() {
		int[] data = cdiDao.getData();
		int highestValue = Integer.MIN_VALUE;
		for(int value : data) {
			if(value > highestValue) {
				highestValue = value;
			}
		}
		return highestValue;
	}
	
}
