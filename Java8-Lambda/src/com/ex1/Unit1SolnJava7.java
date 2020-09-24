package com.ex1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1SolnJava7 {

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
		printRecords(people);
		
		//Step 3: Create a method that prints all people with last name beginning with "C"
		printRecordsWithLastNameBeginningWithC(people);

	}

	private static void printRecordsWithLastNameBeginningWithC(List<Person> people) {
		System.out.println("*** prints all people with last name beginning with C ***");
		for(Person p : people){
			if(p.lastName.startsWith("C"))
				System.out.println(p);
		}
		
	}

	private static void printRecords(List<Person> people) {
		System.out.println("*** prints all people sorted by last name ***");
		for(Person p : people){
			System.out.println(p);
		}
		
	}

}
