package Assignments.Week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		int range = 8;
		int firstnum = 0;
		int secnum = 1;
		System.out.print(firstnum + "," + secnum + ",");
		int sum;
		for (int i = 0; i < range; i++) 
		{
			sum=firstnum+secnum;
			firstnum=secnum;
			secnum=sum;
			System.out.print(sum + ",");
			
		}
		
	}

}
