package com.threads;

public class RunnableExample {

	public static void main(String[] args) {
		Thread myThread = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("Run method of myThread");
				
			}
			
		});
		myThread.run();
		
		/* Since Runnable is an interface with exactly one abstract method
		 * it becomes a perfect candidate for using lambda
		 * These interfaces are called FUNCTIONAL INTERFACES
		 */
		Thread myLamdaThread = new Thread(() -> System.out.println("Run method of myLamdaThread"));
		myLamdaThread.run();
	}

}
