package algorithms;

import java.io.*;
import java.util.*;

public class Sorting {

	/**
	 * Swap applied on int array.
	 * 
	 * @param array
	 * @param a_Idx
	 * @param b_Idx
	 */
	public static void swap (int [] array, int a_Idx, int b_Idx){
		int tmp = array[a_Idx];
		array[a_Idx] = array[b_Idx];
		array[b_Idx] = tmp;
	}
	
	/**
	 * Swap applied on List<Integer>.
	 * 
	 * @param array
	 * @param a_Idx
	 * @param b_Idx
	 */
	public static void swap (List <Integer> array, int a_Idx, int b_Idx){
		int tmp = array.get(a_Idx);
		array.set(a_Idx, array.get(b_Idx));
		array.set(b_Idx, tmp);
	}
	
	/**
	 * Print an int array on System.out.
	 * 
	 * @param array
	 */
	public static void printArray (int array[]){
		System.out.print("created array with " + array.length + " elements:");
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != (array.length - 1)) System.out.print(",");
		}
		System.out.print("]");
		System.out.println("");		
	}

	/** 
	 * Quick sort algorithm applied on type List<Integer>.
	 * This quick sort takes a key-comparison-value from the middle of the list.
	 * This is a recursive method which calls itself again if there is a partial list to sort.
	 * 
	 * @param beginIdx begin index
	 * @param endIdx end index
	 */
	public static void quick_sort(List<Integer> list, int beginIdx, int endIdx){
		int left = beginIdx;
		int right = endIdx;

		if (left >= right) return;

			int middleIdx = (((left+1) + (right+1)) / 2) - 1;
			int key = list.get(middleIdx);
			
			while (left <= right) {
				while (list.get(left) < key) left++;
				while (list.get(right) > key) right--;
				if (left <= right){
					swap(list, left, right);
					left++;
					right--;
				}
			}
			
			quick_sort(list, beginIdx, right);
			quick_sort(list, left, endIdx);
	}
	
	/** 
	 * Sorted 2 already sorted arrays to one resulting sorted array.
	 * 
	 * @param a sorted array a
	 * @param b sorted array b
	 * @return resulting sorted array
	 */
	public static int [] sort (int a [], int b []){
		int	result [] = new int [a.length + b.length];
		int i = 0; // index for array a
		int j = 0; // index for array b
		int k = 0; // index for array result
		while (i < a.length || j < b.length){
			// case if array a is empty or we are already at its end
			if (i == a.length) {
				while (k < result.length && j < b.length){
					result[k] = b[j];
					j++; k++;
				}
				break;
			} 
			// case if array b is empty or we are already at its end
			else if (j == b.length){
				while (k < result.length && i < a.length){
					result[k] = a[i];
					i++; k++;
				}
				break;
			}
			// case if we are not at the end of array a or b, so we can compare their values
			else if (a[i] < b[j]){
				result[k] = a[i];
				i++;
			} // a_[i] >= b_[j]
			else {
				result[k] = b[j];
				j++;
			}
			k++;
		}
		return result; 
	}
	
	/** 
	 * Sorted 2 already sorted array list of type integer to one sorted array list.
	 * 
	 * @param a sorted array list a
	 * @param b sorted array list b
	 * @return sorted array list
	 */
	public static List<Integer> sort (List<Integer> a , List <Integer> b){
		List<Integer> result = Arrays.asList(new Integer [a.size() + b.size()]);
		int i = 0; // index for array a
		int j = 0; // index for array b
		int k = 0; // index for array result
		while (i < a.size() || j < b.size()){
			// case if array a is empty or we are already at its end
			if (i == a.size()) {
				while (k < result.size() && j < b.size()){
					result.set(k, b.get(j));
					j++; k++;
				}
				break;
			} 
			// case if array b is empty or we are already at its end
			else if (j == b.size()){
				while (k < result.size() && i < a.size()){
					result.set(k, a.get(i));
					i++; k++;
				}
				break;
			}
			// case if we are not at the end of array a or b, so we can compare their values
			else if (a.get(i) < b.get(j)){
				result.set(k, a.get(i));
				i++;
			} // a_[i] >= b_[j]
			else {
				result.set(k, b.get(j));
				j++;
			}
			k++;
		}
		return result; 
	}
	
	public static void main(String[] args) {
		StringBuffer outputStr = new StringBuffer();
		outputStr.append("APPlICATION - Sorting of unsorted integer array lists\n");
//		System.out.println("press CTRL + C to exit");
		outputStr.append("(n)umber of integer array lists you want to sort\n");
		outputStr.append("(q)uit to exit\n");
		
		String inputStr = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		int numberOfarrayLists = 0;

		/* A dynamic ArrayList which contains fixed sized Integer lists.
		 * With a dynamic ArrayList we are able to this list during runtime.
		 * Each fixed sized Integer list has to be fixed to be able apply sort algorithms
		 * on their data using their index.	*/
		ArrayList<List<Integer>> arrayLists = null;

		List<Integer> arrayListResult = Arrays.asList(new Integer[0]);
		
//		SignalHandler oldSigTERM = Signal.handle(
//								   new Signal("SIGTERM"),
//								   new SignalHandler() {
//									   public void handle(Signal signal) {
//										   System.err.println("Quit using SIGTERM hook");
//										   notificationHandler.prepareToQuit();
//										   if (oldSigTERM != null) {
//											   oldSigTERM.handle(signal);
//										   }
//									   }
//								   });

//		Runtime.getRuntime().addShutdownHook(new Thread() {
//	        public void run() {
//	            try {
//	            	Thread.sleep(1);
//	                System.out.println("Shutting down ...");
//	                //some cleaning up code...
//
//	            } catch (InterruptedException e) {
//	                // TODO Auto-generated catch block
//	                e.printStackTrace();
//	            }
//	        }
//	    });		

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
				System.out.println("...application terminated");
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
					e.printStackTrace();
					System.out.println("Incorrect number format, try it again!");
					System.out.print(outputStr.toString());
					continue;
				}
				if (numberOfarrayLists <= 0){
					System.out.println("please enter a number >= 0");
					System.out.print(outputStr.toString());
					continue;
				}
				else{
					arrayLists = new ArrayList<List<Integer>>(numberOfarrayLists);	
					for (int i = 0; i < numberOfarrayLists; i++){
						System.out.print("enter number of elements of array list " + i + ":");
						try {
							inputStr = br.readLine();
							arrayLists.add(Arrays.asList(new Integer [Integer.parseInt(inputStr)]));
						}
						catch (IOException e){
							e.printStackTrace();
							System.out.println("Could not read data from console, try it again!");
							System.out.print(outputStr.toString());
							arrayLists.clear();
							continue;
						}
						catch (NumberFormatException e){
							e.printStackTrace();
							System.out.println("Incorrect number format, try it again!");
							System.out.print(outputStr.toString());
							arrayLists.clear();
							continue;
						}
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
								continue;
							}
							catch (NumberFormatException e){
								e.printStackTrace();
								System.out.println("Incorrect number format, try it again!");
								System.out.print(outputStr.toString());
								arrayLists.clear();
								continue;
							}
						}
						System.out.print("created array list with " + arrayLists.get(i).size() + " elements:");
						System.out.print(arrayLists.get(i));
						System.out.println();
					}					
					System.out.println();
					System.out.println("1. starting sorting on each array list...");
					System.out.println();
					for (int i = 0; i < arrayLists.size(); i++){
						quick_sort(arrayLists.get(i), 0, arrayLists.get(i).size()-1);
						System.out.print("array list " + i + " sorted:");
						System.out.print(arrayLists.get(i));
						System.out.println();
					}		
			
					if (arrayLists.size() > 1)
						System.out.println();
						System.out.println("2. starting sorting each array list with each other...");
						System.out.println();
						for (int i = 0; i < arrayLists.size(); i++){
							arrayListResult = Sorting.sort(arrayListResult, arrayLists.get(i));
						}
					}
				
					System.out.println("resulting sorted array list: ");
					System.out.println(arrayListResult);
					System.out.println();
					System.out.print(outputStr.toString());
					arrayLists.clear();
				}
				else {
					System.out.println("Wrong input!");
					System.out.print(outputStr.toString());
				}
			}
		try {
			br.close();
		}
		catch (IOException e){
			e.printStackTrace();
			System.out.println("Could not close buffered reader!");
		}
    }
};
