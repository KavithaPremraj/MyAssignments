package week2.day2.StringAssignments;

public class ReverseEven {

	public static void main(String[] args) {
		
		String test = "I am a software tester";
		String[] str = test.split(" ");
		for (int i = 0; i < str.length; i++) {
			if(i % 2 == 1)
			{
				char[] charArray = str[i].toCharArray();
				//Reverse for loop
				for (int j = charArray.length-1; j >= 0 ; j--) {
					
					System.out.print(charArray[j]);			
			}				
			}
			else
			{
				System.out.print(" ");
				System.out.print(str[i] + " ");
			}
			
		}

	}

}
