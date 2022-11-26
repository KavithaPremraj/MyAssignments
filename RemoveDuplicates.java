package Week3Assignments;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		/*
		 * Pseudo code 
		 
		 * a) Use the declared String text as input
			String text = "We learn java basics as part of java sessions in java week1";		
		 * b) Initialize an integer variable as count	  
		 * c) Split the String into array and iterate over it 
		 * d) Initialize another loop to check whether the word is there in the array
		 * e) if it is available then increase and count by 1. 
		 * f) if the count > 1 then replace the word as "" 
		 
		 * g) Displaying the String without duplicate words	
		 */
		//a) input
		String text = "We learn java basics as part of java sessions in java week1";
		//b) Initialize an integer variable as count
		int count;
		// c) Split the String into array and iterate over it 
		String[] split = text.split(" ");
		System.out.println("The given String is : " + text);
		for (int i = 0; i < split.length; i++) {
			count = 0;
			for (int j = i+1; j < split.length; j++) {
				//String string = split[j];
				if(split[j].equals(split[i]))
				{
					count++;
					split[j] = " ";
				}
			}
			if(count >1){
				
				String removeduplicate = text.replace(split[i], "");
				System.out.println("After Duplicate Words removed : " + removeduplicate);
				}
			}
		}
	}

	


