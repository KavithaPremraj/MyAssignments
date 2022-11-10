package Assignments.Week1.day2;

import java.util.Arrays;

public class FindSecondLargestNumber {

	public static void main(String[] args) {
		int[] data = {3,2,11,4,6,7};
		int size=data.length;
		Arrays.sort(data);
		System.out.println("The Sorted Array is:"+ Arrays.toString(data));
		int second = data[size-2];
		System.out.println("The Second Largest number is:"+second);
		

	}

}
