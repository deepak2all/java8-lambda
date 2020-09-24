package com.functionaProgramming;

import static com.functionaProgramming.TraditionalUsage.Gender.FEMALE;
import static com.functionaProgramming.TraditionalUsage.Gender.MALE;

import java.util.ArrayList;
import java.util.List;


public class TraditionalUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people = new ArrayList<>(
				List.of(
						new Person("Deepak","343433433", 37, MALE), 
						new Person("Malini","343435433", 33, FEMALE), 
						new Person("Aishu","343483433", 24, FEMALE), 
						new Person("Anup","3434334338", 30, MALE), 
						new Person("Aadhi","342433433", 6, MALE), 
						new Person("Hasu","343431433", 6, FEMALE)
				));
		
		System.out.println("IMPERATIVE APPROACH");
		System.out.println("1# Predicate corresonds to creating a method with one argumemt"
				+ "and returning a boolean");
		for(Person p : people) {
			if(genderPredicate(p)) {
				System.out.println(p);
			}
		}
		
		System.out.println("SIMILARLY");
		System.out.println("2# Function corresonds to creating a method with one argumemt"
				+ "and returning one primitive / object");
		System.out.println("3# Consumer corresonds to creating a method with one argumemt"
				+ "and returning nothing");
		System.out.println("4# Suppier corresonds to creating a method with NO argumemt"
				+ "and returning one primitive / object");
	}
	
	public static boolean genderPredicate(Person person) {
		if(FEMALE.equals(person.gender)) {
			return true;
		}
		return false;
	}
	
	static class Person{
		private String name;
		private String phoneNum;
		private int age;
		private Gender gender;
		
		public Person(String name, String phoneNum, int age, Gender gender) {
			super();
			this.name = name;
			this.phoneNum = phoneNum;
			this.age = age;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", phoneNum=" + phoneNum + ", age=" + age + ", gender=" + gender + "]";
		}
		
	}

	static enum Gender {
		MALE,
		FEMALE
	}
}
