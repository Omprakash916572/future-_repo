package com.test.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.test.dto.Book;

public class Logicss {

	static SortingLogic SsrtingLogic = new SortingLogic();

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("ab");
		list.add("abpkokjomn");
		list.add("c");
		list.add("d");

		// filter records using lambda
		// list.stream().filter(s -> s.startsWith("s")).forEach(s ->
		
		List<Book> listOfBook = SsrtingLogic.getListOfBook();
		
		// Another way of Sorting records
		//listOfBook.stream().sorted(Comparator.comparing(Book:: getId)).forEach(System.out::println);
		
		// custom sorting using Comparator with help of Lambda function
		//Collections.sort(listOfBook , (o1,o2) -> (int) o1.getId()- o2.getId());
		
		
	}

	public static List<Book> getFilterData(String input) {
		List<Book> listOfBook = SsrtingLogic.getListOfBook();

		return (input.equalsIgnoreCase("right"))
				? listOfBook.stream().filter(emp -> emp.getId() > 0).collect(Collectors.toList())
				: listOfBook.stream().filter(emp -> emp.getId() > 2).collect(Collectors.toList());

	}

}
