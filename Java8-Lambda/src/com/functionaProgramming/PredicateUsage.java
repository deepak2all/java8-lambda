package com.functionaProgramming;

import static com.functionaProgramming.PredicateUsage.Gender.FEMALE;
import static com.functionaProgramming.PredicateUsage.Gender.MALE;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateUsage {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>(
				List.of(
						new Person("Deepak","343433433", 37, MALE), 
						new Person("Malini","343435433", 33, FEMALE), 
						new Person("Aishu","343483433", 24, FEMALE), 
						new Person("Anup","3434334338", 30, MALE), 
						new Person("Aadhi","342433433", 6, MALE), 
						new Person("Hasu","343431433", 6, FEMALE)
				));
		
		System.out.println("DECLARATIVE APPROACH");
		System.out.println("PREDICATES are used to categorize a list of values based on 1 particular condition");
		System.out.println("1# Using simple predicate -> To find FEMALE members");
		Predicate<Person> genderPredicate = person -> FEMALE.equals(person.gender);
		people.stream()
			.filter(genderPredicate)
			.collect(Collectors.toList())
			.forEach(person -> System.out.println(person));
		
		System.out.println("2# Using predicate -> To find FEMALE members, less than 10 yrs");
		Predicate<Person> agePredicate = person -> (person.age<10);
		Predicate<Person> agePredicateForYouths = person -> (person.age>=18 && person.age<=25);
		people.parallelStream()
			.filter(genderPredicate.and(agePredicate)) // JOIN can be with AND, OR
			.collect(Collectors.toList())
			.forEach(System.out::println); //Using method reference
		
		Predicate<Person> phoneValidationPredicate = person -> (person.phoneNum.length()==9) && person.phoneNum.contains("s");	
		System.out.println("3# Using predicate -> To find FEMALE members or members less than 10 yrs");
		people.parallelStream()
			.filter(genderPredicate.or(agePredicate)) // JOIN can be with AND, OR
			.collect(Collectors.toList())
			.forEach(System.out::println); //Using method reference
		
		System.out.println("4# Using predicate -> "
				+ "To find FEMALE members, less than 10 yrs and "
				+ "modify the object to print the name alone");
		people.parallelStream()
			.filter(genderPredicate.and(agePredicate)) // JOIN can be with AND, OR
			.map(person -> person.name)	// Map is used for transforming
			.collect(Collectors.toList())
			.forEach(person -> System.out.println(person)); // Using method reference
		
		System.out.println("5# Using predicate -> "
				+ "To find FEMALE members, less than 10 yrs and "
				+ "modify the age to 10 yrs");
		people.parallelStream()
			.filter(genderPredicate.and(agePredicate)) // JOIN can be with AND, OR
			.map(person -> person.getName() + ", " + person.getAge() + ", " + person.getPhoneNum()) //map() should return value; So can't be used with setters
			.forEach(person -> System.out.println(person)); // Using method reference
		
		System.out.println("5# Using predicate -> "
				+ "To find FEMALE members, less than 10 yrs and "
				+ "modify the age to 10 yrs");
		people.parallelStream()
			.filter(genderPredicate.and(agePredicate)) // JOIN can be with AND, OR
			.map(person -> person.name.toUpperCase()) //map() should return value; So can't be used with setters
			.forEach(person -> System.out.println(person)); // Using method reference
		
		System.out.println("5# Using predicate -> "
				+ "To find FEMALE members, less than 10 yrs and "
				+ "modify the age by adding another 5 yrs");
		people.parallelStream()
			.filter(genderPredicate.and(agePredicate)) // JOIN can be with AND, OR
			.map(person -> person.getName() + ", " +(person.getAge()+5)) //map() should return value; So can't be used with setters
			.forEach(person -> System.out.println(person)); // Using method reference
		
		
		System.out.println("5# Using predicate -> "
				+ "To find FEMALE members, less than 10 yrs and "
				+ "modify the age to 10 yrs");
		people.parallelStream()
			.filter(genderPredicate.and(agePredicate)) // JOIN can be with AND, OR
			.map(person -> person.getName() + ", " + person.getAge()) //map() should return value; So can't be used with setters
			.forEach(person -> System.out.println(person)); // Using method reference
	
		System.out.println("6# Using predicate -> "
				+ "To find FEMALE members, less than 10 yrs and "
				+ "modify the age to 10 yrs");
		people.parallelStream()
			.filter(genderPredicate.and(agePredicate)) // JOIN can be with AND, OR
			.map(person -> person.name.toUpperCase()) //map() should return value; So can't be used with setters
			.forEach(person -> System.out.println(person)); // Using method reference
		
		System.out.println("7# Using predicate -> "
				+ "To find FEMALE youths");
		people.parallelStream()
			.filter(genderPredicate.and(agePredicateForYouths)) // JOIN can be with AND with One predicate internally having another AND
			.collect(Collectors.toList())
			.forEach(System.out::println); //Using method reference
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

		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public String getPhoneNum() {
			return phoneNum;
		}



		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
		}



		public int getAge() {
			return age;
		}



		public void setAge(int age) {
			this.age = age;
		}



		public Gender getGender() {
			return gender;
		}



		public void setGender(Gender gender) {
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
