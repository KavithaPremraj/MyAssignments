package week2.day2.StringAssignments;

public class Palindrome {

	public static void main(String[] args) {
		String str = "madam";
		String revstr = "";
		int size = str.length();
		for( int i = (size - 1); i >=0; --i)
		{
			revstr += str.charAt(i);
		}
	if(str.toLowerCase().equals(revstr.toLowerCase()))
	{
		System.out.println(str + " is a palindrome");
	}

	}
}
