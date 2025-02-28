package com.learn_everyday.mockito.mockito_demo.list;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ListMockTest {
	
	@SuppressWarnings("unchecked")
	List<String> list = mock(List.class);
	
	@Test
	public void simpleTest() {
		when(list.size()).thenReturn(3);
		assertEquals(3, list.size());
	}
	
	@Test
	public void specificTest() {
		when(list.get(0)).thenReturn("mockito");
		assertEquals("mockito", list.get(0));
		assertEquals(null, list.get(1));		
	}
	
	@Test
	public void genericTest() {
		when(list.get(Mockito.anyInt())).thenReturn("mockito");
		assertEquals("mockito", list.get(0));
		assertEquals("mockito", list.get(1));		
	}

}
