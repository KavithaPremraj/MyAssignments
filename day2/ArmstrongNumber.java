package Assignments.Week1.day2;;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int input = 154;
		int calculated = 0;
		int remainder;
		int original;
		original = input;
		while(original>0)
		{
			remainder = original % 10;
			calculated += Math.pow(remainder, 3);
			original = original / 10;
		}
		if(calculated==input)
		{
			System.out.println(input + " The given number is Armstrong");
		}
		else
		{
			System.out.println(input + " The given number is not an Armstrong");
		}
	}

}
