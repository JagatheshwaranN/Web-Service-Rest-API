package com.learn_everyday.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BusinessImplSimplifiedMockTest {
	
	@Mock
	private DataService dataService;
	
	@InjectMocks
	private BusinessImpl businessImpl;

	@Test
	void findtheGreatestValueTest() {
		when(dataService.retrieveAllData()).thenReturn(new int[] {4, 7, 9, 2, 3});
		int result = businessImpl.findtheGreatestValue();
		System.out.println(result);
		assertEquals(9, result);
	}
	
	@Test
	void findtheGreatestValueOneTest() {
		when(dataService.retrieveAllData()).thenReturn(new int[] {4});
		int result = businessImpl.findtheGreatestValue();
		System.out.println(result);
		assertEquals(4, result);
	}

}
