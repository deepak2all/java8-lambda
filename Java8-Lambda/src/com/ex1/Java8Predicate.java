package com.ex1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Java8Predicate {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickends", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);

		//Step 1: Sort the list by last name		
		Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
		
		//Step 2: Create a method that prints all the elements in the list
		System.out.println("*** prints all people sorted by last name ***");
		printRecordsConditionally(people, p -> true);
		
		//Step 3: Create a method that prints all people with last name beginning with "C"
		System.out.println("*** prints all people with last name beginning with C ***");
		printRecordsConditionally(people, p -> p.getLastName().startsWith("C"));
		
		//Step 4: Create a method that prints all people with last name beginning with "D"
		System.out.println("*** prints all people with last name beginning with D ***");
		printRecordsConditionally(people, p -> p.getLastName().startsWith("D"));
		
		
		//Step 5: Create a method that prints all people with first name beginning with "C"
		System.out.println("*** prints all people with last name beginning with C ***");
		printRecordsConditionally(people, (Person p) -> p.getFirstName().startsWith("C"));

	}
	
	
	private static void printRecordsConditionally(List<Person> people, Predicate<Person> condition) {
		for(Person p : people){
			if(condition.test(p))
				System.out.println(p);
		}
		
	}

}
