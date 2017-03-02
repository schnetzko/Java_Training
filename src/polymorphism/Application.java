package polymorphism;

public class Application {

	public static void main(String[] args){
		Person p1 = new Person();
		System.out.println("p1");
		System.out.println(p1);
		
		Person p2 = new Person("Max", "Mustermann", 32, "Musterstrasse", "12a", "Mustcity", "12434");
		System.out.println("p2");
		System.out.println(p2);
		
		Person p3 = new Employee();
		System.out.println("p3");
		System.out.println(p3);
		
		Person p4 = new Employee("Google", Position.software_architect);
		System.out.println("p4");
		System.out.println(p4);

		Person p5 = new Employee("Max", "Mustermann", 32, "Musterstrasse", "12a", "Mustcity", "12434","Amazon", Position.snr_software_engineer);
		System.out.println("p5");
		System.out.println(p5);
	}
}

