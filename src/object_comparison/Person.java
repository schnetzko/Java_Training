package object_comparison;

public class Person {
	
	private int age;
	private String forename;
	
	public Person(int age, String forename) {
		this.age = age;
		this.forename = forename;
	}

	/**
	 *	overwriting equals() by applying 
	 *	"=="-operator on member variable which is of a primitive data type and
	 *	equals()-method on member String object */
	public boolean equals(Object o) {
		if (o instanceof Person) {
			Person person = (Person)o;
			return ((this.age == person.age) && (this.forename.equals(person.forename)));
		}
		return false;
	}
	
	public String toString() {
		return ("Person object (age: " + age + "," + " forename: " + forename + ")");
	}

	/**  
	 * Using Hash-based containers (HashMap, HashSet), the first step is to identify
	 * an object by its hash-code using hashCode(). Each hash code points to a bucket.
	 * Within a bucket all objects with the same hash-code are stored and will
	 * by identified by using equals() as the second step. 
	 * That's why hashCode() as well as equals() has to overwrite to implement this behavior
	 * for hash based containers.
	 * 
	 * The default implementation of hash-code returns the current memory-address of an object,
	 * but this memory address is converted to int (32 Bit).
	 * If the object is located out of 32 Bit range, it can't be identified, because another
	 * object could have the same hash-code.
	 * 
	 * @see java.lang.Object#hashCode()	 */
	public int hashCode() {
	    return forename.hashCode();	// If using System.identityHashCode(age) it could lead to have 
	    							// a different hash-code for the same value as you can see in the output
	    							// of print_hashCodes(..) for data type long. But we need a hash code which
	    							// is identical based on the value. That's why the String implementation
	    							// of hash-code is perfect.
	}
}

