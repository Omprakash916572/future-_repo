package zom.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import zom.test.dto.Customer;

public class StremLogic {

	public static void main(String[] args) {

		List<Customer> customers = getCustomers();

		// how to get all emails from the list of customers
		List<String> emials = customers.stream().map(cust -> cust.getEmail()).collect(Collectors.toList());
		System.out.println(emials);

		// how to get list of list phone numbers ,but i want only list so we need use flat map in next line
		List<List<String>> phoneNumbers = customers.stream().map(cust -> cust.getPhoneNumber()).collect(Collectors.toList());
		System.out.println(phoneNumbers);
		
		
		//we can convert list of list object in single list using flatMap
		 List<String> listOfPhoneNumInSingleList = customers.stream().flatMap(cust -> cust.getPhoneNumber().stream()).collect(Collectors.toList());
		System.out.println(listOfPhoneNumInSingleList);
		
		

	}

	public static List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1, "pmm1@gmail.com", Arrays.asList("909090", "80880808", "707070")));
		customers.add(new Customer(2, "pmm2@gmail.com", Arrays.asList("90900", "808830808", "7057070")));
		customers.add(new Customer(3, "pm3@gmail.com", Arrays.asList("9090", "808808408", "7076070")));
		customers.add(new Customer(4, "pmm4@gmail.com", Arrays.asList("459090", "80880808", "707070")));
		customers.add(new Customer(5, "pmm5@gmail.com", Arrays.asList("679090", "80880808", "7037070")));
		customers.add(new Customer(6, "pmm6@gmail.com", Arrays.asList("90459090", "808840808", "7207070")));

		return customers;

	}

}
