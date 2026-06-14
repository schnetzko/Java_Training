package algorithms;

import java.util.*;

/** 
 * class Sorting which provides a sorting API.
 */
public class Sorting {

	/**
	 * Swap applied on int array.
	 * 
	 * @param array the array where swap will be applied on
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
	 * @param list the list where swap will be applied on
	 * @param a_Idx
	 * @param b_Idx
	 */
	public static void swap (List <Integer> list, int a_Idx, int b_Idx){
		int tmp = list.get(a_Idx);
		list.set(a_Idx, list.get(b_Idx));
		list.set(b_Idx, tmp);
	}
	
	/**
	 * Print an int array on System.out.
	 * 
	 * @param array the array to be printed
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
	 * Insertion sort algorithm applied on type List<Integer>.
	 * 
	 * @param list the list to be sorted
	 */
	public static void insertion_sort (List<Integer> list){
		/* iterate (and sort) from left to right in an ascending order */
		for (int i = 1; i < list.size(); i++){
			int tmp = list.get(i);
			int j = i - 1;
			/* Sort a subset of complete list and start with 2 values. 
			 * Continue with one more value and sort it with
			 * the already sorted subset list while iterating from right to left. */ 
			while ((j >= 0) && (list.get(j) >  tmp)){
				list.set(j+1, list.get(j));
				j--;
			}
			list.set(j+1, tmp);
		}
	}
	
	/** 
	 * Quick sort algorithm applied on type List<Integer>.
	 * This quick sort takes a key-comparison-value from the middle of the list.
	 * This is a recursive method.
	 * 
	 * @param list the list to be sorted
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
		int idx_a = 0;
		int idx_b = 0;
		int idx_result = 0;
		while (idx_a < a.size() || idx_b < b.size()){
			// case if array a is empty or we are already at the end
			if (idx_a == a.size()) {
				while (idx_result < result.size() && idx_b < b.size()){
					result.set(idx_result, b.get(idx_b));
					idx_b++; idx_result++;
				}
				break;
			} 
			// case if array b is empty or we are already at the end
			else if (idx_b == b.size()){
				while (idx_result < result.size() && idx_a < a.size()){
					result.set(idx_result, a.get(idx_a));
					idx_a++; idx_result++;
				}
				break;
			}
			// case if we are not at the end of array a or b, so we can compare their values
			else if (a.get(idx_a) < b.get(idx_b)){
				result.set(idx_result, a.get(idx_a));
				idx_a++;
			} // a_[i] >= b_[j]
			else {
				result.set(idx_result, b.get(idx_b));
				idx_b++;
			}
			idx_result++;
		}
		return result; 
	}
};
