package Week3Assignments;


import java.util.LinkedHashSet;
import java.util.Set;


public class RemoveDuplicateWords {

	public static void main(String[] args) {
		
		String text = "We learn java basics as part of java sessions in java week1";
		String[] split = text.split(" ");
		Set<String> emptySet=new LinkedHashSet<String>();
		for (int i = 0; i < split.length; i++) {
			emptySet.add(split[i]);			
		}
		//System.out.println(emptySet);
		//Covert set of String to Strings
		System.out.println(String.join(" ", emptySet));		
	}

}
