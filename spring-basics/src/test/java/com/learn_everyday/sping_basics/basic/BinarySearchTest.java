package com.learn_everyday.sping_basics.basic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn_everyday.spring_basics.SpingExternalPropertyApplication;
import com.learn_everyday.spring_basics.basic.BinarySearchImpl;

// Load the context
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpingExternalPropertyApplication.class)
public class BinarySearchTest {

	// Get the BEAN from the context
	@Autowired
	BinarySearchImpl binarySearchImpl;

	@Test
	public void testBasicScenario() {
		// Call a method on Binary Search
		int result = binarySearchImpl.binarySearch(new int[] {}, 5);
		// Check the value is correct
		assertEquals(3, result);
	}

}
