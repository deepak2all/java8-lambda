package com.ex1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1SolnJava8 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickends", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);

		//Step 1: Sort the list by last name		
		/*Collections.sort(people, (Person o1, Person o2) ->
				 o1.getLastName().compareTo(o2.getLastName()));*/
		//Actually even the type in optional in the argument
		Collections.sort(people, (o1, o2) ->
		 o1.getLastName().compareTo(o2.getLastName()));
		
		//Step 2: Create a method that prints all the elements in the list
		System.out.println("*** prints all people sorted by last name ***");
		//printRecords(people);
		//Also we can make use of printRecordsConditionally instead of printRecords
		printRecordsConditionally(people, p -> true);
		
		//Step 3: Create a method that prints all people with last name beginning with "C"
		System.out.println("*** prints all people with last name beginning with C ***");
		/*printRecordsConditionally(people, (Person p) 
				-> p.getLastName().startsWith("C"));*/
		//Since there is only 1 arg, the braces can be ignored
		printRecordsConditionally(people, p -> p.getLastName().startsWith("C"));
		
		//Step 4: Create a method that prints all people with last name beginning with "D"
		//Note::: We are using the very same method but changing the condition
		System.out.println("*** prints all people with last name beginning with D ***");
		printRecordsConditionally(people, p -> p.getLastName().startsWith("D"));
		
		
		//Step 4: Create a method that prints all people with first name beginning with "C"
		//Note::: We are using the very same method but changing the condition
		System.out.println("*** prints all people with last name beginning with C ***");
		printRecordsConditionally(people, (Person p) -> p.getFirstName().startsWith("C"));

	}
	
	

	private static void printRecordsConditionally(List<Person> people, Condition condition) {
		for(Person p : people){
			if(condition.checkCondition(p))
				System.out.println(p);
		}
		
	}

	/*
	private static void printRecords(List<Person> people) {
		for(Person p : people){
			System.out.println(p);
		}
		
	}*/
}