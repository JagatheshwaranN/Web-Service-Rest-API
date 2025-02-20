package com.learn_everyday.sping_basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	@Autowired
	SortingAlgo sortingAlgo;

	public int binarySearch(int[] array, int searchFor) {

//		bubbleSortAlgoImpl.sortArray(array);
		this.sortingAlgo.sortArray(array);

		// Logic for sorting the array
		return 3;
	}

}
