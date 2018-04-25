package object_comparison;

public class DataTypes {

	public short [] primitive_short;	

	public long [] primitive_long;
	
	private Person [] persons;
	
	public DataTypes (short [] primitive_short, long [] primitive_long, Person [] persons) {
		this.primitive_short = primitive_short;
		this.primitive_long = primitive_long;
		this.persons = persons;
	}
	
	public DataTypes (short [] primitive_short) {
		this.primitive_short = primitive_short;
	}
}
