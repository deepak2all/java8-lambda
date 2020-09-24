package com.ex1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class U1SolJ7Refactored {
	
	/*
	 * In the last soln --> Unit1SolnJava7, we see that everytime the condition
	 * changes, you need to write a new method
	 * Eg. if tomo you have to print all names Beginning with "D"
	 * So we are taking that condition out of the body
	 * and passing that as argument instead 
	 */

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickends", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);

		//Step 1: Sort the list by last name
		Collections.sort(people, new Comparator<Person>(){
			
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
			
		});
		
		//Step 2: Create a method that prints all the elements in the list
		System.out.println("*** prints all people sorted by last name ***");
		printRecords(people);
		
		//Step 3: Create a method that prints all people with last name beginning with "C"
		System.out.println("*** prints all people with last name beginning with C ***");
		printRecordsConditionally(people, new Condition(){

			@Override
			public boolean checkCondition(Person p) {
				return p.getLastName().startsWith("C");
			}
			
		});
		
		//Step 4: Create a method that prints all people with last name beginning with "D"
		//Note::: We are using the very same method but changing the condition
		System.out.println("*** prints all people with last name beginning with D ***");
		printRecordsConditionally(people, new Condition(){

			@Override
			public boolean checkCondition(Person p) {
				return p.getLastName().startsWith("D");
			}
			
		});
		
		
		//Step 4: Create a method that prints all people with first name beginning with "C"
		//Note::: We are using the very same method but changing the condition
		System.out.println("*** prints all people with last name beginning with C ***");
		printRecordsConditionally(people, new Condition(){

			@Override
			public boolean checkCondition(Person p) {
				return p.getFirstName().startsWith("C");
			}
			
		});

	}
	
	

	private static void printRecordsConditionally(List<Person> people, Condition condition) {
		for(Person p : people){
			if(condition.checkCondition(p))
				System.out.println(p);
		}
		
	}

	private static void printRecords(List<Person> people) {
		for(Person p : people){
			System.out.println(p);
		}
		
	}
}

@FunctionalInterface
interface Condition{
	//Checks if that person needs to be included or not based on the condition
	boolean checkCondition(Person p);
}
