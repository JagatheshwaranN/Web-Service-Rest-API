package com.learn_everyday.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BusinessImplTest {

	@Test
	void findtheGreatestValueTest() {
		DataService dataServiceStub = new DataServiceStub();		
		BusinessImpl businessImpl = new BusinessImpl(dataServiceStub);
		int result = businessImpl.findtheGreatestValue();
		assertEquals(17, result);
	}

	class DataServiceStub implements DataService {
		@Override
		public int[] retrieveAllData() {
			return new int[] {5, 7, 17, 4, 2};
		}		
	}
}
