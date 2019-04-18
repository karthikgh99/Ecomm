
public class Person {
String name;
int age;
double height;
public void display()
{
	System.out.println(name);
	System.out.println(age);
	System.out.println(height);	
}

public static void main(String[] a)
{
  Person P=new Person();
P.name="karthik";
P.age=21;
P.height=5.7;
P.display();

}
}
