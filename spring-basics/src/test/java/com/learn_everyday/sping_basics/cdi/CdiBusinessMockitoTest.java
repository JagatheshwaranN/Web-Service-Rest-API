package com.learn_everyday.sping_basics.cdi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.learn_everyday.spring_basics.cdi.CdiBusiness;
import com.learn_everyday.spring_basics.cdi.CdiDao;

@RunWith(MockitoJUnitRunner.class)
public class CdiBusinessMockitoTest {

	//Create Mock
	@Mock
	CdiDao cdiDao;
	
	//Inject Mock
	@InjectMocks
	CdiBusiness cdiBusiness;
	

	@Test
	public void testBasicScenario() {
		Mockito.when(cdiDao.getData()).thenReturn(new int[] {2, 5});
		assertEquals(5, cdiBusiness.findHighestValue());
	}

}
