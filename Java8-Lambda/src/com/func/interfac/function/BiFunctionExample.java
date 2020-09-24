package com.func.interfac.function;

import java.util.ArrayList;
import java.util.function.*;

public class BiFunctionExample {

	public static void main(String[] args){
		ArrayList<Employee> l = new ArrayList<Employee>();
		BiFunction<Integer, String, Employee> f = (eno, name) -> new Employee(eno,name);
		l.add(f.apply(100, "Durga"));
		l.add(f.apply(200, "Ravi"));
		l.add(f.apply(300, "Pavan"));
		
		for(Employee e:l){
			System.out.println("Employee Number :" + e.eno);
			System.out.println("Employee Name :" + e.name);
		}
	}	
}
