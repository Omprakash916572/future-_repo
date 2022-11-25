package com.test.java8;

import java.util.Arrays;
import java.util.Optional;

import zom.test.dto.Customer;

public class Java8OptionalClass {

	public static void main(String[] args) {

		Customer customer = new Customer(1, "pmm", Arrays.asList("344", "34344", "34454"));

		// if email is not present so its give null pointer exception
		// Optional<Customer> of1 = Optional.of(customer1.getEmail());

		// if email is not present so its not give null pointer exception
		Optional<Object> emptyOptional = Optional.empty();
		System.out.println(emptyOptional);

		// Optional<String> emailOptional = Optional.of(customer.getEmail());
		// System.out.println(emailOptional);

		Optional<String> emailOptional2 = Optional.ofNullable(customer.getEmail());
		/*
		 * if(emailOptional2.isPresent()){ System.out.println(emailOptional2.get()); }
		 */
		// System.out.println(emailOptional2.orElse("default@email.com"));

		// System.out.println(emailOptional2.orElseThrow(()->new
		// IllegalArgumentException("email not present")));

		System.out.println(emailOptional2.map(String::toUpperCase).orElseGet(() -> "default email..."));

	}

}
