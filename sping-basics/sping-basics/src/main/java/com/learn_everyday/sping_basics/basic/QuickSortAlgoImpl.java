package com.learn_everyday.sping_basics.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("quick")
public class QuickSortAlgoImpl implements SortingAlgo {
	
	public int[] sortArray(int[] arr) {
		System.out.println("Sorting using QuickSort");
		return arr;
	}
}
