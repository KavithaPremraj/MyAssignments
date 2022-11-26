package Week3Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {
	
	// Generic function to convert set to list
    public static <T> List<T> convertSetToList(Set<T> set)
    {
        // create an empty list
        List<T> list = new ArrayList<T>();
  
        // push each element in the set into the list
        for (T t : set)
            list.add(t);
  
        // return the list
        return list;
    }

	public static void main(String[] args) {
		// Here is the input
				int[] data = {3,2,11,4,6,7,2,3,3,6,7};
				Set<Integer> emptySet = new TreeSet<Integer>();
				for (int i = 0; i < data.length; i++) {
					emptySet.add(data[i]);
					
				}System.out.println("The Set Contains: " + emptySet); 
				 // construct a new List from Set
		        List<Integer> list = convertSetToList(emptySet);
		        System.out.println("The List Contains: " + emptySet);
				
				System.out.println("The Second Largest Num is : " + list.get(list.size()-2));
					
					
					
					
				

	}

}
