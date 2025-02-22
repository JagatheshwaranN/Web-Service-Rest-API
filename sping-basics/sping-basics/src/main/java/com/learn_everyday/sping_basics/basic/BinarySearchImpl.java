package com.learn_everyday.sping_basics.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
// @Scope("prototype") Not Recommended Type of Writing // It is used to generate the different instance of this class when requested from AC.
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BinarySearchImpl {

	private static Logger logger = LoggerFactory.getLogger(BinarySearchImpl.class);

	// Here, we will have issue as we have 2 sorting algorithms defined.
	// To fix the same, we have used @Primary annotation, so @Primary injected
	// algorithm will be considered.
//	@Autowired
//	SortingAlgo sortingAlgo;

	// Alternate Way 1
	// The other way to fix the same is by using the explicit instance variable name
	// of the algorithm.
	// Note: We need to provide the exact name otherwise it will not work.
	// NOTE: Here, we can remove the @Primary annotation.
//	@Autowired
//	SortingAlgo bubbleSortAlgoImpl;

	// Alternate Way 2
	// The second approach is to use the @Qualifier annotation.
	// We have to add the annotation in the Bean class and also have to mention the
	// same
	// before Autowired reference.
	@Autowired
	@Qualifier("quick")
	SortingAlgo sortingAlgo;

	public int binarySearch(int[] array, int searchFor) {

//		bubbleSortAlgoImpl.sortArray(array);
		this.sortingAlgo.sortArray(array);

		// Logic for sorting the array
		return 3;
	}

	@PostConstruct
	public void postConstruct() {
		logger.info("Method - Post Construct");
	}

	@PreDestroy
	public void preDestroy() {
		logger.info("Method - Pre Destroy");
	}
	
}
