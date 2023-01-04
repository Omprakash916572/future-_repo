package com.test.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.test.dto.Book;

public class SortingLogic {

	public static void main(String[] args) {

		getListOfBook().stream().forEach((t -> {
			System.out.println(t);
		}));

		//System.out.println(getSortedBokkObj());
		//System.out.println(getSortedBokkObjUsibgLambda());
	}

	public static List<Book> getSortedBokkObj() {
		List<Book> listOfBook = getListOfBook();
		Collections.sort(listOfBook, new SortingComparotor());
		return listOfBook;
	}

	// do same above things using lamda expresion
	public static List<Book> getSortedBokkObjUsibgLambda() {
		List<Book> listOfBook = getListOfBook();
		Collections.sort(listOfBook, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		return listOfBook;
	}

	public static List<Book> getListOfBook() {
		List<Book> list = new ArrayList<>();
		list.add(new Book(1, "prakash", 100));
		list.add(new Book(2, "ram", 100));
		list.add(new Book(3, "arif", 100));

		return list;

	}
}

class SortingComparotor implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
