package polymorphism;

public class Person {
	private String forename;
	private String surname;
	private int age;
	private String street;
	private String number;
	private String city;
	private String zip;
	
	/* getter and setter */
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setZip(String zip){
		this.zip = zip;
	}
	public String getZip(){
		return zip;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}	

	/* constructors */
	public Person() {
//		super(); // TODO: Do we need this?
		this.forename = "";
		this.surname = "";
		this.age = 0;
		this.street = "";
		this.number = "";
		this.city = "";
		this.zip = "";
	}
	public Person(String forename, String surname, int age, String street, String number, String city, String zip) {
//		super(); // TODO: Do we need this?
		this.forename = forename;
		this.surname = surname;
		this.age = age;
		this.street = street;
		this.number = number;
		this.city = city;
		this.zip = zip;
	}

	/* overwriting toString() */
	public String toString(){
		StringBuffer strbuffer = new StringBuffer();
		strbuffer.append("Forename: " + forename + "\n");
		strbuffer.append("Surname: " + surname + "\n");
		strbuffer.append("Age: " + Integer.toString(age) + "\n");
		strbuffer.append("Street: " + street + "\n");
		strbuffer.append("number: " + number + "\n");
		strbuffer.append("ZIP code: " + zip + "\n");
		strbuffer.append("City: " + city + "\n");
		return strbuffer.toString();
	}
}


