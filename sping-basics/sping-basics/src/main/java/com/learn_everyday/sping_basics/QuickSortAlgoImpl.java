package com.learn_everyday.sping_basics;

import org.springframework.stereotype.Component;

@Component
public class QuickSortAlgoImpl implements SortingAlgo {
	
	public int[] sortArray(int[] arr) {
		System.out.println("Sorting using QuickSort");
		return arr;
	}
}
