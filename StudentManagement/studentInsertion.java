package com.klu.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.klu.Connections.DBUtil;
import com.klu.StudentBean.StudentBean;
public class StudentInsertion {
	Scanner s = new Scanner(System.in);
   public int StudentInsert(StudentBean student)throws ClassNotFoundException, SQLException
   {
	   Connection con=DBUtil.DBConnection();
	   PreparedStatement ps=con.prepareStatement("insert into StudentDetails values(?,?,?)"); 
	   ps.setInt(1,student.getRegno());
	   ps.setString(2,student.getName());
	   ps.setString(3,student.getEmail());
	   int i = ps.executeUpdate();
	   return i;
   }
   public int StudentDelete(StudentBean student)throws ClassNotFoundException, SQLException
   {
	   Connection con=DBUtil.DBConnection();
	   System.out.println("enter the id of student id to be deleted:");
	   int id=s.nextInt();
	   PreparedStatement stmt=con.prepareStatement("delete from StudentDetails where id=?");  
	   stmt.setInt(1,id);  
	   int i=stmt.executeUpdate();  
	   return i;
   }
   public int StudentUpdate(StudentBean student)throws ClassNotFoundException, SQLException
   {
	   Connection con=DBUtil.DBConnection();
	   System.out.println("enter the id of student id whose name to be updated:");
	   int id=s.nextInt();
	   System.out.println("enter the name to which it has to be updated:");
	   String name=s.next();
	   PreparedStatement stmt=con.prepareStatement("update StudentDetails set name=? where id=?");  
	   stmt.setString(1,name);//1 specifies the first parameter in the query i.e. name  
	   stmt.setInt(2,id);  
	     
	   int i=stmt.executeUpdate();  
	   return i;
   }
   public void StudentDisplay(StudentBean student)throws ClassNotFoundException, SQLException
   {
	   Connection con=DBUtil.DBConnection();
	   PreparedStatement stmt=con.prepareStatement("select * from StudentDetails");  
	   ResultSet rs=stmt.executeQuery();  
	   while(rs.next()){  
	   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));  
	   }  
	   
   }
   
   
   
}
