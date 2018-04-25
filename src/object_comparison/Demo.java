package object_comparison;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo {

	/**
	 * Prints hash-codes to System.out from objects containing in the given arrays of the primitives data types
	 * and from objects in the given array of Person class. 
	 * 
	 * @param short_array
	 * @param long_array
	 * @param persons
	 */
	public static void print_hashCodes(short [] short_array, long [] long_array, Person persons[]){
		
		System.out.println("print_hashCodes(..)");
		/* Note:	There is no hashCode() method for primitives available,
	     * 			because primitives are not classes. Thus, they can't inherit 
	     * 			from class Object the base-implementation of hashCode() to call it.
	     * 			But to still call the base-implementation of hashCode for primitives,
	     * 			just call System.identityHashCode() as an alternative.
	     * 
	     * 			The default implementation of a hash code for a variable or object
	     * 			returns a memory address MOD by integer max value (= 2^31-1).
	     * 			That means 2 different variables or objects can have the same hash-code,
	     * 			but are not identical. And that means the hash-code is not an unique id
	     * 			(reference or memory address) for an object.
	     * 			
	     * 			If 2 different objects have the same hash code, it's just a hash-collision.
	     * 			In this case these 2 objects will by compared by equality afterwards. 
	     * 			In more detail: Each different hash-code calculated by the default
	     * 			hashCode() method points to a bucket. All objects with the same hash-code
	     * 			are stored in the same bucket. */	
		for (short element : short_array) {
			System.out.print("\tSystem.identityHashCode(" + element + "): ");
			System.out.print(System.identityHashCode(element));
			System.out.println();
		}
		System.out.println();
		
		for (long element : long_array) {
			System.out.print("\tSystem.identityHashCode(" + element + "): ");
			System.out.print(System.identityHashCode(element));
			System.out.println();
		}
		System.out.println();
		
		for (Person person : persons) {
			System.out.println("\t" + person);			
			System.out.println("\tSystem.identityHashCode(person): " + System.identityHashCode(person));
			System.out.println("\tperson.hashCode(): " + person.hashCode());
			System.out.println();
		}
	}
	
	/**
	 * Tried to implement print_hashCodes() using Java reflections (java.lang.reflect.*)
	 * to avoid duplicate code, but unfortunately the printed hash-codes are not the same like
	 * primitives_hashCode() with redundant code.
	 */	
	public static void print_hashCodes(Object obj){
		
		System.out.println("print_hashCodes(..) using Java reflection");

		// iterate over all class members
		for (Field field : obj.getClass().getDeclaredFields()) {
//			System.out.println("field is of a primitive type?: " + field.getType().isPrimitive() + "\n");
//			System.out.println("field is an array type?: " + field.getType().isArray() + "\n");
//			System.out.println("field-type: " + field.getType() + "\n");
//			System.out.println("field-name: " + field.getName() + "\n");
//			System.out.println("field-component type: " + field.getType().getComponentType() + "\n");
			if ((field.getType().getComponentType() != null) && /* check if it's an array */
				(field.getType().getComponentType().isPrimitive()) /* check if it's an array of a primitive type */ 
				||
				(field.getType().isArray()) &&
				(!field.getType().isPrimitive())) {
				Object array = null;
				try {
					array = field.get(obj); // conversion to an array with one dimension
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				if (array != null) {
					int length = Array.getLength(array);
					for (int i = 0; i < length; i++) {
						System.out.print("\tSystem.identityHashCode(" + Array.get(array, i) + "): ");
						System.out.print(System.identityHashCode(Array.get(array, i)) + "\n");
					}				
				}
			}			
			else {
				System.out.println("Data type not supported!");
			}
				
//				try {
//					out.append("field-value: " + field.get(obj) + "\n");
//				} catch (IllegalArgumentException e) {
//					e.printStackTrace();
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				}

			System.out.println();
		}
	}	

	/**
	 * Prints results about comparison between values of primitive arrays
	 * and between objects of a Person array.
	 *  
	 * @param short_array
	 * @param long_array
	 * @param persons
	 */
	public static void print_comparisons(short [] short_array, long [] long_array, Person persons[]) {
		System.out.println("print_comparisons(..)");		
		System.out.println("\tshort values comparison using == operator");
		int array_length = short_array.length;
		if (array_length > 1) {
			for (int i = 0; i < array_length; i++) {
				for (int j = i, k = i+1; k < array_length; k++) {
					System.out.print("\t" + short_array[j] + " == " + short_array[k] + ": ");
					System.out.print(short_array[j] == short_array[k]);
					System.out.println();
				}
			}
		}
		
		System.out.println();
		System.out.println("\tlong values comparison using == operator");
		array_length = long_array.length;
		if (array_length > 1) {
			for (int i = 0; i < array_length; i++) {
				for (int j = i, k = i+1; k < array_length; k++) {
					System.out.print("\t" + long_array[j] + " == " + long_array[k] + ": ");
					System.out.print(long_array[j] == long_array[k]);
					System.out.println();
				}
			}
		}
		
		System.out.println();
		System.out.println("\tPerson objects comparison using == operator (reference comparison)");
		array_length = persons.length;
		if (array_length > 1) {
			for (int i = 0; i < array_length; i++) {
				for (int j = i, k = i+1; k < array_length; k++) {
					System.out.print("\t" + persons[j] + " == " + persons[k] + ": ");
					System.out.print(persons[j] == persons[k]);
					System.out.println();
				}
			}
		}

		System.out.println();
		System.out.println("\tPerson objects comparison using equals-method (semantic comparison)");
		array_length = persons.length;

		if (array_length > 1) {
			for (int i = 0; i < array_length; i++) {
				for (int j = i, k = i+1; k < array_length; k++) {
					System.out.print("\t" + persons[j] + " equals() " + persons[k] + ": ");
					System.out.print(persons[j].equals(persons[k]));
					System.out.println();
				}
			}
		}
	}
	
	public static void main(String[] args) {

		short [] primitives_short = {55, 55, 3};
		
		long [] primitives_long = {55325, 55325, 3685854};

		Person p1 = new Person (50, "Heinz");
	    Person p2 = new Person (45, "Regina");
	    Person p3 = new Person (45, "Regina");
	    Person persons [] = {p1, p2, p3};	    
		
//	    DataTypes dataTypes = new DataTypes(primitives_short, primitives_long);
//		DataTypes dataTypes = new DataTypes(primitives_short);
//		Demo.print_hashCodes(dataTypes);
		
		Demo.print_hashCodes(primitives_short, primitives_long, persons);
		Demo.print_comparisons(primitives_short, primitives_long, persons);

		System.out.println();
		System.out.println("ArrayList (non-hash-based) calls equals() of Person class");
	    List<Person> persons_list = new ArrayList<>();
	    persons_list.add(p1);
	    persons_list.add(p2);		
	    System.out.println("persons_list.contains(p3): " + persons_list.contains(p3));
		System.out.println(" => if working with ArrayList only equals() needs to overwrite for Person class");
		
		System.out.println();
		System.out.println("HashSet calls equals() of Person class");
	    Set<Person> persons_hashSet = new HashSet<Person>();
	    persons_hashSet.add(p1);
	    persons_hashSet.add(p2);
	    System.out.println("persons_hashSet.contains(p3): " + persons_hashSet.contains(p3));
	    System.out.println(" => if working with Hash-based container equals() as well as hashCode() needs to overwrite for Person class");
	}
}
