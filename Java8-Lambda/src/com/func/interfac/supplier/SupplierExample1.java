package com.func.interfac.supplier;
import java.util.Date;
import java.util.function.*;

public class SupplierExample1 {

	public static void main(String[] args) {
		Supplier<Date> s = ()->new Date();
		System.out.println(s.get());
		System.out.println(s.get().toGMTString());
		System.out.println(s.get().toInstant());
	}

}
