package Assignments.Week1.day1;

public class TwoWheeler {
	
	int noOfWheels = 2;
	short noOfMirrors =2;
	long chassisNumber = 567893456L;
	boolean isPunchured = true;
	String bikeName = "pulser";
	double runningKm = 570.5;
	
	
	public static void main(String[] args) {
		TwoWheeler mybike = new TwoWheeler();
		System.out.println(mybike.noOfWheels);
		System.out.println(mybike.noOfMirrors);
		System.out.println(mybike.chassisNumber);
		System.out.println(mybike.isPunchured);
		System.out.println(mybike.bikeName);
		System.out.println(mybike.runningKm);

	}


	

}
