package week2.day2.StringAssignments;

public class CharOccurance {

	public static void main(String[] args) {
		String str = "welcome to chennai";
		char ch = 'e';
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ch)
			{
				count++;
			}
		}
		System.out.println("Occurance of " + ch + " are " + count);		
}
}
