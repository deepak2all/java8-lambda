package com.func.interfac.function;

import java.util.function.Function;

public class FunctionExample1 {
	/**
	 * Takes in some input
	 * Processes the input
	 * Returns some output
	 */
	public static void main(String[] args){
		Function<Integer, Integer> f1 = i -> 2*i;
		System.out.println("The square of number is " + f1.apply(4));
		Function<Integer, Integer> f2 = i -> i*i*i;
		System.out.println(f1.andThen(f2).apply(2));
		// On using "Compose", first f2 will be executed
		System.out.println(f1.compose(f2).apply(2));
		
		Function<Integer, Integer> f3 = i -> i*5;
		System.out.println(f1.andThen(f2).andThen(f3).apply(2));
	}
}
