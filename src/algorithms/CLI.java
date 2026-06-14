package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CLI {
	public static void main(String[] args) {
		StringBuffer outputStr = new StringBuffer();
		outputStr.append("\nSorting of unsorted integer lists\n");
		outputStr.append("---------------------------------\n");
		outputStr.append("Input: multiple lists of unsorted integers\n");
		outputStr.append("Output: a sorted integer list\n");
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
			// (s)sorting
			else if(inputStr.equals("s")){
				try {
				    ArrayList<List<Integer>> integerLists = createLists(br, outputStr);
					applySort(outputStr, integerLists);
				}
				catch (AlgorithmsCliException e){
					System.out.print(e.getMessage());
					continue;
				}
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

	private static ArrayList<List<Integer>> createLists(BufferedReader br, StringBuffer outputStr) throws AlgorithmsCliException {
		System.out.print("number of lists: ");

		String inputStr = null;
		int numberOfarrayLists = 0;

		// validate "number of lists"
		try {
			inputStr = br.readLine();
			numberOfarrayLists = Integer.parseInt(inputStr);
		}
		catch (IOException e){
			throw new AlgorithmsCliException("Could not read data from command line, try it again.\n" + outputStr.toString());
		}
		catch (NumberFormatException e){
			throw new AlgorithmsCliException("Incorrect number format, try it again.\n" + outputStr.toString());
		}
		if (numberOfarrayLists <= 0){
			throw new AlgorithmsCliException("please enter a number > 0\n" + outputStr.toString());
		}
		else {
			ArrayList<List<Integer>> arrayLists = new ArrayList<List<Integer>>(numberOfarrayLists);

			for (int i = 0; i < numberOfarrayLists; i++) {
				try {
					List<Integer> list = createList(br, outputStr, i);
					arrayLists.add(list);
				}
				catch (AlgorithmsCliException e) {
					throw e;
				}
			}	
			return arrayLists;
		}
	}

	private static void applySort(StringBuffer outputStr, ArrayList<List<Integer>> arrayLists) {
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
		
		if (arrayLists.size() > 1){
			System.out.println();
			System.out.println("2. start sorting each list with each other...");
			System.out.println();
			
			List<Integer> arrayListResult = arrayLists.get(0);
			for (int i = 1; i < arrayLists.size(); i++){
				arrayListResult = Sorting.sort(arrayListResult, arrayLists.get(i));
			}
			
			System.out.println("sorted list: ");
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

	private static List<Integer> createList(BufferedReader br, StringBuffer outputStr, int i) throws AlgorithmsCliException {
		String inputStr = null;
		int numberOfelements = 0;

		System.out.print("enter number of elements for list " + i + ": ");
		// number of list validation
		try {
			inputStr = br.readLine();
			numberOfelements = Integer.parseInt(inputStr);
		}
		catch (IOException e){
			throw new AlgorithmsCliException("Could not read data from command line, try it again.\n" + outputStr.toString());
		}
		catch (NumberFormatException e){
			throw new AlgorithmsCliException("Incorrect number format, try it again.\n" + outputStr.toString());
		}
		if (numberOfelements <= 0){
			throw new AlgorithmsCliException("please enter a number > 0\n" + outputStr.toString());
		}
		// empty array list created
		List<Integer> list = Arrays.asList(new Integer [Integer.parseInt(inputStr)]);
		for (int j = 0; j < list.size(); j++) {
			System.out.print("enter integer on index [" + j + "]: ");
			// validation of each element of list
			try {
				inputStr = br.readLine();
				list.set(j, Integer.parseInt(inputStr));
			}
			catch (IOException e){
				throw new AlgorithmsCliException("Could not read data from command line, try it again.\n" + outputStr.toString());
			}
			catch (NumberFormatException e){
				throw new AlgorithmsCliException("Incorrect number format, try it again.\n" + outputStr.toString());
			}
		}
		System.out.print("created list with " + list.size() + " elements:");
		System.out.print(list);
		System.out.println();

		return list;
	}
}
