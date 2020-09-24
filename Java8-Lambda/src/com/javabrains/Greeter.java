package com.javabrains;

public class Greeter {
	
	public void greet (Greeting greeting){
		greeting.perform();
	}

	public static void main(String[] args){
		Greeter greeter = new Greeter();
		
		Greeting lambdaGreeting = () -> System.out.println("Lambda :: Hello World");
		Greeting innerClassGreeting = new Greeting(){
			public void perform() {
				System.out.println("Inner Class :: Hello World");
			}
		};
		
		greeter.greet(lambdaGreeting);
		greeter.greet(innerClassGreeting);
	}
}
