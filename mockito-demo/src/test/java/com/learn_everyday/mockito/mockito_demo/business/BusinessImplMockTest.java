package com.learn_everyday.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class BusinessImplMockTest {

	@Test
	void findtheGreatestValueTest() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {4, 7, 9, 2, 3});
		BusinessImpl businessImpl = new BusinessImpl(dataServiceMock);
		int result = businessImpl.findtheGreatestValue();
		System.out.println(result);
		assertEquals(9, result);
	}
	
	@Test
	void findtheGreatestValueOneTest() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {4});
		BusinessImpl businessImpl = new BusinessImpl(dataServiceMock);
		int result = businessImpl.findtheGreatestValue();
		System.out.println(result);
		assertEquals(4, result);
	}

}
