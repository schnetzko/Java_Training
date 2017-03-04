package polymorphism;

public class Demo {

	public static void main(String[] args){
		// p1 references to a Person object
		Person p1 = new Person();
		System.out.println("p1");
		System.out.println(p1.convertToString());
		
		// p2 references to a Person object
		Person p2 = new Person("Max", "Mustermann", 32, "Musterstrasse", "12a", "Mustcity", "12434");
		System.out.println("p2");
		System.out.println(p2.convertToString());
		
		// p3 references to an Employee object
		Person p3 = new Employee();
		System.out.println("p3");
		System.out.println(p3.convertToString());
		
		// p4 references to an Employee object
		Person p4 = new Employee("Google", Position.software_architect);
		System.out.println("p4");
		System.out.println(p4.convertToString());

		// p5 references to an Employee object
		Person p5 = new Employee("Max", "Mustermann", 32, "Musterstrasse", "12a", "Mustcity", "12434", "Amazon", Position.snr_software_engineer);
		System.out.println("p5");
		System.out.println(p5.convertToString());
	}
}

