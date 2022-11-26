package Week3Assignments;

import java.util.LinkedHashSet;
import java.util.Set;

public class Paypal {

	public static void main(String[] args) {

		String text= "Paypal India";
		String text1= text.replaceAll("\\s", "");
		char[] charArray= text1.toCharArray();
		Set<Character> charSet= new LinkedHashSet<Character>();
		Set<Character> dupCharSet= new LinkedHashSet<Character>();
		for(int i=0; i< charArray.length;i++)
		{
			boolean add =charSet.add(charArray[i]);
			if (!add)
			{
				charSet.contains(charArray[i]);
				dupCharSet.add(charArray[i]);
			}
			
		}
		System.out.println("The Duplicate Set is : " + dupCharSet);
		charSet.removeAll(dupCharSet);
		System.out.println("The Unique Char Set is : " + charSet);
	}
}
		
		
		

