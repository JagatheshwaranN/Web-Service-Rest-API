package com.learn_everyday.spring_basics.basic;

import org.springframework.stereotype.Component;

@Component
//@Primary
public class BubbleSortAlgoImpl  implements SortingAlgo {
	
	public int[] sortArray(int[] arr) {
		System.out.println("Sorting using BubbleSort");
		return arr;
	}
}
