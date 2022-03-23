package com.automation_page_concept;
import java.io.ObjectInputStream.GetField;
import java.util.jar.Attributes.Name;

public class Pojo_B {
	public static void main(String[] args) {
		Pojo_A a=new Pojo_A();
		String name = a.getName();
		System.out.println("GET NAME  :"+name);
		a.setName("BALAJI");
		String name2 = a.getName();
		System.out.println("SET NAME  :"+name2);
	}

}
