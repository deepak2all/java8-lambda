package com.func.interfac.function;
import java.util.function.*;

public class FunctionExample2 {

	public static void main(String[] args){
		Function<Student,String> f = s->{
			int marks = s.marks;
			String grade = "";
			if(marks>=80) grade="A[Distinction]";
			else if(marks>=60) grade="B[First Class]";
			else if(marks>=50) grade="C[Second Class]";
			else if(marks>=35) grade="D[Third Class]";
			else grade="E[Failed]";
			return grade;
		};
		
		Predicate<Student> p = s->s.marks>=60;
		Student[] s = { new Student("Durga", 100),
						new Student("Sunny", 65),
						new Student("Bunny", 55),
						new Student("Chinny", 45),
						new Student("Vinny", 25),
		};
		
		for(Student s1:s){
			if(p.test(s1)){
				System.out.println("Student Name: "+ s1.name);
				System.out.println("Student Marks: "+ s1.marks);
				System.out.println("Student Grade: "+ f.apply(s1));
				System.out.println();
			}
		}
	}
}
