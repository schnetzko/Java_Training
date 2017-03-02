package polymorphism;

public class Employee extends Person {

	private String company;
	private Position position;
	
	/* getter and setter */
	public String getCompany(){
		return company;
	}
	public void setComany(String company){
		this.company = company;
	}	
	public Position getPosition(){
		return position;
	}
	public void setPosition(Position position){
		this.position = position;
	}

	/* constructors */
	public Employee(){
		super();
		company = "unemployeed";
	}	
	public Employee(String company, Position pos){
		super();
		this.company = company;
		this.position = pos;
	}	
	public Employee(String forename, String surname, int age, String street, String number, String city, String zip, String company, Position pos){
		super();
		this.company = company;
		this.position = pos;
	}
	
	public String toString(){
		StringBuffer strbuffer = new StringBuffer();
		strbuffer.append("Company: " + company + "\n");
		strbuffer.append("Position: " + position + "\n");
		return strbuffer.toString();
	}
}
