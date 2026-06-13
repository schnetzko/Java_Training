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
		outputStr.append("type (s)orting of integer lists\n");
		outputStr.append("type (e)xit to exit\n");
		
		String inputStr = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
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
			// (e)xit
			if (inputStr.equals("e")){
				break;
			}
			// (n)umber of arrays handling
			else if(inputStr.equals("s")){
				handleLists(br, outputStr);
			}
			else {
				System.out.println("Wrong input.");
				System.out.print(outputStr.toString());
			}
		}
		try {
			br.close();
		}
		catch (IOException e){
			e.printStackTrace();
			System.out.println("Could not close buffered reader.");
		}
		finally {
			System.out.println("exit app...");
		}
    }

	private static void handleLists(BufferedReader br, StringBuffer outputStr) {
		System.out.print("number of lists: ");

		String inputStr = null;
		int numberOfarrayLists = 0;
		List<Integer> arrayListResult = null;

		// number of lists validation
		try {
			inputStr = br.readLine();
			numberOfarrayLists = Integer.parseInt(inputStr);
		}
		catch (IOException e){
			System.out.println("Could not read data from command line, try it again.");
			System.out.print(outputStr.toString());
			return;
		}
		catch (NumberFormatException e){
			System.out.println("Incorrect number format, try it again.");
			System.out.print(outputStr.toString());
			return;
		}
		if (numberOfarrayLists <= 0){
			System.out.println("please enter a number > 0");
			System.out.print(outputStr.toString());
			return;
		}
		else {
			ArrayList<List<Integer>> arrayLists = new ArrayList<List<Integer>>(numberOfarrayLists);
			int numberOfelements = 0;

			for (int i = 0; i < numberOfarrayLists; i++){
				System.out.print("enter number of elements for list " + i + ":");
				// number of list validation
				try {
					inputStr = br.readLine();
					numberOfelements = Integer.parseInt(inputStr);
				}
				catch (IOException e){
					System.out.println("Could not read data from command line, try it again.");
					System.out.print(outputStr.toString()); 
					return;
				}
				catch (NumberFormatException e){
					System.out.println("Incorrect number format, try it again.");
					System.out.print(outputStr.toString()); 
					return;
				}
				if (numberOfelements <= 0){
					System.out.println("please enter a number > 0");
					System.out.print(outputStr.toString());
					return;
				}
				// empty array list created
				arrayLists.add(Arrays.asList(new Integer [Integer.parseInt(inputStr)]));

				for (int j = 0; j < arrayLists.get(i).size(); j++) {
					System.out.println("enter integer on index [" + j + "]: ");
					// validation of each element of list
					try {
						inputStr = br.readLine();
						arrayLists.get(i).set(j, Integer.parseInt(inputStr));
					}
					catch (IOException e){
						System.out.println("Could not read data from command line, try it again.");
						System.out.print(outputStr.toString());
						return;
					}
					catch (NumberFormatException e){
						System.out.println("Incorrect number format, try it again.");
						System.out.print(outputStr.toString());
						return;
					}
				}
				System.out.print("created list with " + arrayLists.get(i).size() + " elements:");
				System.out.print(arrayLists.get(i));
				System.out.println();
			}	
			// apply sorting algorithms on the lists and print the result
			System.out.println();
			System.out.println("1. start sorting each list...");
			System.out.println();
			for (int i = 0; i < arrayLists.size(); i++){
				//	Sorting.quick_sort(arrayLists.get(i), 0, arrayLists.get(i).size()-1);
				Sorting.insertion_sort(arrayLists.get(i));
				System.out.print("list " + i + " sorted:");
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
		}
	}
}
