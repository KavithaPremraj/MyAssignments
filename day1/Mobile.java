package Assignments.Week1.day1;

public class Mobile {
	
	String mobileBrandName = "Motorola";
	char mobileLogo = 'M';
	short noOfMobilePiece = 100;
	int modelNumber = 570;
	long mobilelmeiNumber = 545678952L;
	float mobilePrice = 15965;
	boolean isDamaged = false;
	
	
	
	public static void main(String[] args) {
		Mobile mymobile = new Mobile();
		System.out.println(mymobile.mobileBrandName);
		System.out.println(mymobile.mobileLogo);
		System.out.println(mymobile.noOfMobilePiece);
		System.out.println(mymobile.modelNumber);
		System.out.println(mymobile.mobilelmeiNumber);
		System.out.println(mymobile.mobilePrice);
		System.out.println(mymobile.isDamaged);
		
		

	}

}
