package com.test.java8;

import java.util.Arrays;
import java.util.List;

public class MoreLogic {

	public static void main(String[] args) {
		
      String image = "Body";
		
		byte img=(byte) Long.parseLong(image);
		byte[] byteArray = new byte[] { img};
		
		List<byte[]> asList = Arrays.asList(byteArray);
		
		if(asList.contains("png") || asList.contains("jpg")) {
			System.out.println(asList.toString());
		}
		
		
	}

}
