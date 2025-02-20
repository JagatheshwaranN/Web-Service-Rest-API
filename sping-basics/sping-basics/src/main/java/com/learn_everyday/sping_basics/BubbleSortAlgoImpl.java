package com.learn_everyday.sping_basics;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BubbleSortAlgoImpl  implements SortingAlgo {
	
	public int[] sortArray(int[] arr) {
		System.out.println("Sorting using BubbleSort");
		return arr;
	}
}
