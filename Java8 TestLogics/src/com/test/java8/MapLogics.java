package com.test.java8;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.test.dto.Book;

import java.util.Set;

public class MapLogics {

	public static void main(String[] args) {

		Set<Entry<Integer, Book>> entrySet = demoMap().entrySet();
		for (Entry<Integer, Book> entrySet1 : entrySet) {
			System.out.println(entrySet1.getKey() + " " + entrySet1.getValue());

		}

	}

	public static Map<Integer, Book> demoMap() {

		Map<Integer, Book> map = new HashMap<>();

		map.put(1, new Book(10, "Math", 200));
		map.put(2, new Book(20, "English", 300));
		map.put(3, new Book(30, "Pyhysics", 400));
		map.put(4, new Book(40, "Hindi", 600));
		map.put(5, new Book(50, "Bio", 1000));

		return map;
	}

}
