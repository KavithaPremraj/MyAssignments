package org.student;

import org.department.Department;

public class Student extends Department {
	
	public void studentName()
	{
		System.out.println("Student name: Kavitha M");
	}
	public void studentDept()
	{
		System.out.println("Dept: IT");
	}
	public void studentId()
	{
		System.out.println("Student ID: 51481450");
	}
	public static void main(String[] args) {
		
		Student stu = new Student();
		stu.deptName();
		stu.studentName();
		stu.studentDept();
		stu.studentId();
		stu.collegeName();
		stu.collegeCode();
		stu.collegeRank();
		
	}
}
