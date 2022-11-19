package Week3.AssignmentStudent;

public class Students {
	
		public void getStudentInfo(int id)
		{
			
			System.out.println("Id is: " + id);
		}
		public void getStudentInfo(int id , String name)
		{
			
			System.out.println("ID :" + id );
			System.out.println("Name : " + name);
		}
		public void getStudentInfo(String email , String pn)
		{
			System.out.println("Email : " + email);
			System.out.println("Phone Number : " + pn);
		}
		public static void main(String[] args) {
			
			Students s = new Students();
			s.getStudentInfo(222);
			s.getStudentInfo(111, "Kavitha");
			s.getStudentInfo("kavitham@hcl.com", "9865777775");
		}

}
