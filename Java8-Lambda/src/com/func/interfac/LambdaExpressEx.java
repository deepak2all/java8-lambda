package com.func.interfac;

public class LambdaExpressEx {
	// https://www.java2novice.com/java-8/
	public static void main(String args[]){
        
        int i = 10;
        int j = 5;
         
        //passArgsToCalc(i, j);
        //System.out.println(calculate(i, j, (Integer a, Integer b) -> a+b));
        System.out.println(calculate(i, j, (a, b) -> a+b));
        System.out.println(calculate(i, j, (a, b) -> a-b));
        System.out.println(calculate(i, j, (a, b) -> a*b));
        System.out.println(calculate(i, j, (a, b) -> a/b));
    }
     
	/*
    private static int passArgsToCalc(int i, int j) {
		int add = calculate(i, j, new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer i, Integer j) {
				return i+j;
			}
		});
		int add = calculate(i, j, (Integer a, Integer b) -> a+b);
		System.out.println(add);
		
		int sub = calculate(i, j, new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer i, Integer j) {
				return i-j;
			}
		});
		
		int mul = calculate(i, j, new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer i, Integer j) {
				return i-j;
			}
		});
		
		int div = calculate(i, j, new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer i, Integer j) {
				return i-j;
			}
		});
		return add;
	}*/

	public static int calculate(int i, int j, BinaryOperator<Integer> bo){
        return bo.apply(i, j);
    }
    
}
