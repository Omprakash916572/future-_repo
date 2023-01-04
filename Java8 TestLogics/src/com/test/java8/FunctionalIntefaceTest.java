package com.test.java8;

@FunctionalInterface
public interface FunctionalIntefaceTest {

	public int m1(int a , int b);

	default int sum(int a , int b) {
		return a+b;
		
	}

	static int subtract(int a , int b) {
		return a-b;
	}

}
