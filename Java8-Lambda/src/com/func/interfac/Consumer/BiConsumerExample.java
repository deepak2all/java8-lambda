package com.func.interfac.Consumer;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import com.func.interfac.Consumer.Employee;

public class BiConsumerExample {

	public static void main(String[] args){
		ArrayList<Employee> l = new ArrayList<Employee>();
		BiFunction<Integer, String, Employee> f = (eno, salary) -> new Employee(eno,salary);
		l.add(f.apply(1000, "Durga"));
		l.add(f.apply(2000, "Ravi"));
		l.add(f.apply(3000, "Pavan"));
		
		for(Employee e:l){
			System.out.println("Employee Name :" + e.name);
			System.out.println("Employee Salary :" + e.salary);
		}
		
		/*
		 * BiConsumer
		 * takes in 2 inputs, using accept method
		 * Does computation
		 * But doesn't return any output
		 */
		BiConsumer<Employee,Double> c = (e,d)->e.salary=e.salary+d;
		for(Employee e:l){
			c.accept(e, 500.00);
		}
		
		for(Employee e:l){
			System.out.println("Employee Name :" + e.name);
			System.out.println("Employee Salary :" + e.salary);
		}
	}
}
