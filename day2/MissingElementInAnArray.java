package Assignments.Week1.day2;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		int[] arr = {2,5,7,9,1,4};
		Arrays.sort(arr);
		int min = arr[0];
		int max = arr[arr.length-1];
		String missing = "";
		for (int i = min; i < max; i++)
		{
				for (int j = 0; j < arr.length; j++)
				{
				if(arr[j]==i)
				{
					missing = "";
					break;
				}else
				{
					missing = "Missing value is" + i;
				}				
			}			
			if(missing!="")
			{
				System.out.println("The Misisng Values are " + i);
			}			
		}
	}
}
