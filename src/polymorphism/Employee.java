package polymorphism;

public class Employee extends Person {

	private String company;
	private Position position;
	
	/* getter and setters */
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
	public Employee(String company, Position position){
		super();
		this.company = company;
		this.position = position;
	}	
	public Employee(String forename, String surname, int age, String street, String number, String city, String zip, String company, Position pos){
		super(forename, surname, age, street, number, city, zip);
		this.company = company;
		this.position = pos;
	}
	
	/**
	 * polymorphic method
	 */	
	@Override
	public String convertToString() {
		StringBuffer strbuffer = new StringBuffer();
		strbuffer.append(super.convertToString());
		strbuffer.append("Company: " + company + "\n");
		strbuffer.append("Position: " + position + "\n");
		return strbuffer.toString();
	}	
}
