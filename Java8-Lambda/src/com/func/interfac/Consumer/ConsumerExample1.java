package com.func.interfac.Consumer;
import java.util.function.*;

public class ConsumerExample1 {

	public static void main(String[] args) {
		Consumer<String> c = s -> System.out.println(s);
		c.accept("durga");
		c.accept("durgaSoftware");
	}

}
