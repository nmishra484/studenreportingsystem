package studentreportsystem;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) throws IOException{
		int num1,num2,num3,res;
		String url = "jdbc:mysql://localhost:3306/student";
		String username="root";
		String password="1234";
	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the Option: \n1.Add Student Details\n2. Avg of student\n3. Top scorer\n4.All Students");
		int ch= sc.nextInt();
		switch (ch) {
		case 1: System.out.println("Enter Student Details");
				System.out.println("Enter your id: ");
				int id = sc.nextInt();
				System.out.println("Enter your name: ");
				String name = sc.next();
				
				
				System.out.println("Enter your grade: ");
				String grade = sc.next();
		
				System.out.println("Enter Marks in English");
				int emarks = sc.nextInt();
				
				System.out.println("Enter Marks in Maths");
				int mmarks = sc.nextInt();
				
				System.out.println("Enter Marks in Science");
				int smarks = sc.nextInt();
			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection connection = DriverManager.getConnection(url,username,password);
					
					Statement statement = connection.createStatement();
					
					ResultSet resultSet = statement.executeQuery("select * from student where id = 1");
					while(resultSet.next()) {
						num1=resultSet.getInt(4);
						 num2=resultSet.getInt(5);
						 num3=resultSet.getInt(6);
						 res = (num1+num2+num3)/3;
						 }
					
					String sql= "insert into student values("+id+",'"+name+"',"+grade+","+emarks+","+mmarks+","+smarks+")";
					
					statement.executeUpdate(sql);
					
					connection.close();
				}
				
				catch(Exception e) {
					System.out.println(e);
					
				}
		break;
		
		case 2: System.out.println("avg of student");
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from student where id = 1");
			while(resultSet.next()) {
				int num01=resultSet.getInt(4);
				int num02=resultSet.getInt(5);
				int num03=resultSet.getInt(6);
				int res1 = (num01+num02+num03)/3;
				System.out.println(res1);
			}
			connection.close();
			}
			catch (Exception e) {
					System.out.println(e);

			}
		break;
		
		case 3: System.out.println("Top 2 student");
		break;
		
		case 4: System.out.println("\nAll students.\n");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url,username,password);
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from student");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getInt(4)+" "+resultSet.getInt(5)+" "+resultSet.getInt(6));
			}
			connection.close();
			}
			catch (Exception e) {
					System.out.println(e);
				
			}
		
		break;
		}
		
		
		
	}
	public static void printReport(String name,String age,String grade, int numSubjects,String subject[])
	{
		System.out.println("\nSTUDNET REPORT");
		System.out.println("Student Name:"+name);
		System.out.println("Student Grade:"+grade);
		System.out.println("Student Number of Subjects:"+numSubjects);
		for(int i=0;i<numSubjects;i++)
		{
		System.out.println("\nStudent Subject: "+subject[i]);
		}
		System.out.println("\nEnd of the report");
	
		}
}
