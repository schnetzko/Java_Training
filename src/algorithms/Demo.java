package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		StringBuffer outputStr = new StringBuffer();
		outputStr.append("Sorting of unsorted integer lists\n");
		outputStr.append("---------------------------------\n");
		outputStr.append("Input: multiple lists of unsorted integers\n");
		outputStr.append("Output: one sorted integer list\n");
		outputStr.append("\n");
		outputStr.append("(n)umber of integer array lists you want to sort\n");
		outputStr.append("(q)uit to exit\n");
		
		String inputStr = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		int numberOfarrayLists = 0;
		int numberOfelements = 0;

		/* arrayList represents contains all values of all integer lists.
		 * While using a dynamic ArrayList we are able to handle this list during runtime
		 * similar to a stack. Each integer list must be fixed sized, otherwise
		 * the sorting algorithms will not work. */
		ArrayList<List<Integer>> arrayLists = null;

		List<Integer> arrayListResult = null;
		
		System.out.print(outputStr.toString());

		while (true){
			try {
				inputStr = br.readLine();
			}
			catch (IOException e){
				e.printStackTrace();
				System.out.println("Could not read data from command line, try it again.");
				System.out.print(outputStr.toString());
				continue;
			}
			// (q)uit - handling
			if (inputStr.equals("q")){
				System.out.println("...App exited");
				System.out.println();
				break;
			}
			// (n)umber of arrays handling
			else if(inputStr.equals("n")){
				System.out.print("number of array lists: ");
				try {
					inputStr = br.readLine();
					numberOfarrayLists = Integer.parseInt(inputStr);
				}
				catch (IOException e){
					System.out.println("Could not read data from command line, try it again.");
					System.out.print(outputStr.toString());
					continue;
				}
				catch (NumberFormatException e){
					System.out.println("Incorrect number format, try it again.");
					System.out.print(outputStr.toString());
					continue;
				}
				if (numberOfarrayLists <= 0){
					System.out.println("please enter a number > 0");
					System.out.print(outputStr.toString());
					continue;
				}
				// numberOfarrayLists is known, start requesting values for each arrayList 
				else {
					arrayLists = new ArrayList<List<Integer>>(numberOfarrayLists);
					boolean restart = false;	// flag that triggers going back to entry point 
												// (jump to the beginning of the outer loop)
					// check each arrayList creation 
					// the "restart" variable in this loop handles the case of exception happening in the inner-loop
					// a "restart" set to true in this loop leads to a suppression of printing an result (see case below "if (!restart){..}")
					for (int i = 0; i < numberOfarrayLists && !restart; i++){
						System.out.print("enter number of elements of array list " + i + ":");
						try {
							inputStr = br.readLine();
							numberOfelements = Integer.parseInt(inputStr);
						}
						catch (IOException e){
							System.out.println("Could not read data from command line, try it again.");
							System.out.print(outputStr.toString()); 
							arrayLists.clear();
							restart = true;
							break;
						}
						catch (NumberFormatException e){
							System.out.println("Incorrect number format, try it again!");
							System.out.print(outputStr.toString()); 
							arrayLists.clear();
							restart = true;
							break;
						}
						if (numberOfelements <= 0){
							System.out.println("please enter a number > 0");
							System.out.print(outputStr.toString());
							arrayLists.clear();
							restart = true;
							break;
						}
						arrayLists.add(Arrays.asList(new Integer [Integer.parseInt(inputStr)]));
						for (int j = 0; j < arrayLists.get(i).size(); j++) {
							System.out.println("enter integer on index [" + j + "]: ");
							try {
								inputStr = br.readLine();
								arrayLists.get(i).set(j, Integer.parseInt(inputStr));
							}
							catch (IOException e){
								System.out.println("Could not read data from command line, try it again.");
								System.out.print(outputStr.toString());
								arrayLists.clear();
								restart = true;
								break;
							}
							catch (NumberFormatException e){
								System.out.println("Incorrect number format, try it again.");
								System.out.print(outputStr.toString());
								arrayLists.clear();
								restart = true;
								break;
							}
						}
						if (!restart){
							System.out.print("created list with " + arrayLists.get(i).size() + " elements:");
							System.out.print(arrayLists.get(i));
							System.out.println();
						}
					}	
					if (!restart){
						System.out.println();
						System.out.println("1. start sorting each array list...");
						System.out.println();
						for (int i = 0; i < arrayLists.size(); i++){
	//						Sorting.quick_sort(arrayLists.get(i), 0, arrayLists.get(i).size()-1);
							Sorting.insertion_sort(arrayLists.get(i));
							System.out.print("array list " + i + " sorted:");
							System.out.print(arrayLists.get(i));
							System.out.println();
						}		
				
						arrayListResult = arrayLists.get(0);
						
						if (arrayLists.size() > 1){
							System.out.println();
							System.out.println("2. start sorting each list with each other...");
							System.out.println();
							for (int i = 1; i < arrayLists.size(); i++){
								arrayListResult = Sorting.sort(arrayListResult, arrayLists.get(i));
							}
							System.out.println("resulting sorted list: ");
							System.out.println(arrayListResult);
							System.out.println();
							System.out.print(outputStr.toString());
						}
						else{
							System.out.println();
							System.out.println("there is only 1 list which is already sorted...");
							System.out.println();	
						}	
						arrayLists.clear();
					}
				}
			} // end of case "n"
			else {
				System.out.println("Wrong input!");
				System.out.print(outputStr.toString());
			}
		} // end of while loop
		try {
			br.close();
		}
		catch (IOException e){
			e.printStackTrace();
			System.out.println("Could not close buffered reader.");
		}
		finally {
			System.out.println("App exited...");
		}
    }
}
