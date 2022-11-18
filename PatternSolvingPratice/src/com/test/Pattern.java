package com.test;

public class Pattern {

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {

			for (int j = 1; j <= i; j++) {

				if (j % 2 == 0) {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}

}
