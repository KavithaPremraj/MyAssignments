package week2.day2.StringAssignments;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String text1 = "stops";
		String text2 = "potss";
		if(text1.length() == text2.length())
		{		
			char[] ch1  = text1.toCharArray();
			char[] ch2  = text2.toCharArray();
			Arrays.sort(ch1);
			Arrays.sort(ch2);
			boolean isSuccess = Arrays.equals(ch1, ch2);
			if(isSuccess)
				{
					System.out.println(text1 + " and " + text2 + " are Anagram ");
				}
				else
					System.out.println(text1 + " and " + text2 + " are not an Anagram ");
		}	
		else
			System.out.println(text1 + " and " + text2 + " are not an Anagram ");

	}

}
