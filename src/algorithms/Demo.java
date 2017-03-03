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
		outputStr.append("DEMO - Sorting of unsorted integer array lists\n");
		outputStr.append("(n)umber of integer array lists you want to sort\n");
		outputStr.append("(q)uit to exit\n");
		
		String inputStr = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		int numberOfarrayLists = 0;
		int numberOfelements = 0;

		/* A dynamic ArrayList which contains fixed sized integer lists.
		 * While using a dynamic ArrayList we are able to handle this list during runtime
		 * similar to a stack. Each integer list has to be fixed-sized, because otherwise
		 * the sorting algorithms provided here will not work. */
		ArrayList<List<Integer>> arrayLists = null;

		List<Integer> arrayListResult = null;
		
		System.out.print(outputStr.toString());

		while (true){
			try {
				inputStr = br.readLine();
			}
			catch (IOException e){
				e.printStackTrace();
				System.out.println("Could not read data from console, try it again!");
				System.out.print(outputStr.toString());
				continue;
			}
			if (inputStr.equals("q")){
				System.out.println("...demo terminated");
				System.out.println();
				break;
			}
			else if(inputStr.equals("n")){
				System.out.print("number of array lists: ");
				try {
					inputStr = br.readLine();
					numberOfarrayLists = Integer.parseInt(inputStr);
				}
				catch (IOException e){
					e.printStackTrace();
					System.out.println("Could not read data from console, try it again!");
					System.out.print(outputStr.toString());
					continue;
				}
				catch (NumberFormatException e){
					System.out.println("Incorrect number format, try it again!");
					System.out.print(outputStr.toString());
					continue;
				}
				if (numberOfarrayLists <= 0){
					System.out.println("please enter a number > 0");
					System.out.print(outputStr.toString());
					continue;
				}
				else{
					arrayLists = new ArrayList<List<Integer>>(numberOfarrayLists);
					boolean restart = false; 
					for (int i = 0; i < numberOfarrayLists && !restart; i++){
						System.out.print("enter number of elements of array list " + i + ":");
						try {
							inputStr = br.readLine();
							numberOfelements = Integer.parseInt(inputStr);
						}
						catch (IOException e){
							e.printStackTrace();
							System.out.println("Could not read data from console, try it again!");
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
						for (int j = 0; j < arrayLists.get(i).size(); j++){
							System.out.println("enter integer on index [" + j + "]: ");
							try {
								inputStr = br.readLine();
								arrayLists.get(i).set(j, Integer.parseInt(inputStr));
							}
							catch (IOException e){
								e.printStackTrace();
								System.out.println("Could not read data from console, try it again!");
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
						}
						if (!restart){
							System.out.print("created array list with " + arrayLists.get(i).size() + " elements:");
							System.out.print(arrayLists.get(i));
							System.out.println();
						}
					}	
					if (!restart){
						System.out.println();
						System.out.println("1. starting sorting each array list...");
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
							System.out.println("2. starting sorting each array list with each other...");
							System.out.println();
							for (int i = 1; i < arrayLists.size(); i++){
								arrayListResult = Sorting.sort(arrayListResult, arrayLists.get(i));
							}
							System.out.println("resulting sorted array list: ");
							System.out.println(arrayListResult);
							System.out.println();
							System.out.print(outputStr.toString());
						}
						else{
							System.out.println();
							System.out.println("there is only 1 array list which is already sorted...");
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
			System.out.println("Could not close buffered reader!");
		}
    }
}
