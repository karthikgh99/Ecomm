
public class Student {
int id;
String name;
public void display()
{
	System.out.println(id);
	System.out.println(name);
}
public static void main(String[] a)
{
	Student s=new Student();
	s.id=1;
	s.name="karthik";
	s.display();
	Student s1=new Student();
	s1.display();
}
}
