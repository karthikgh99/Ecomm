package com.niit.ecomm.test;



import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralDBConfigTest 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		
		context.refresh();
		
		SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");

	}
}
