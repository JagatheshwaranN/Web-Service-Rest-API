package com.learn_everyday.sping_basics.cdi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn_everyday.spring_basics.SpringCdiApplication;
import com.learn_everyday.spring_basics.cdi.CdiBusiness;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringCdiApplication.class)
public class CdiBusinessTest {

	
	@Autowired
	CdiBusiness cdiBusiness;
	
	@Test
	public void testBasicScenario() {
		int result = cdiBusiness.findHighestValue();
		assertEquals(92, result);
	}

}
