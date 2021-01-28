package com.klu.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.klu.connections.DBUtil;
import com.klu.bean.salesBean;

public class salesInsertion {
	public int SaleInsert(salesBean sale)throws ClassNotFoundException, SQLException
	   {
		   Connection con=DBUtil.DBConnection();
		   PreparedStatement ps=con.prepareStatement("insert into saledetails values(?,?,?)"); 
		   ps.setInt(1,sale.getItemid());
		   ps.setString(2,sale.getName());
		   ps.setInt(3,sale.getCost());
		   int i = ps.executeUpdate();
		   return i;
	   }
	public void SaleDisplay(salesBean sale)throws ClassNotFoundException, SQLException
	   {
		   Connection con=DBUtil.DBConnection();
		   PreparedStatement stmt=con.prepareStatement("select * from saledetails");  
		   ResultSet rs=stmt.executeQuery();  
		   while(rs.next()){  
		   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));  
		   }  
		   
	   }
	public void displayCost(salesBean sale)throws ClassNotFoundException, SQLException
	{
		int sum=0;
		Connection con=DBUtil.DBConnection();
		Statement st = con.createStatement();
	    ResultSet res = st.executeQuery("SELECT SUM(cost) FROM saledetails");
	    while (res.next()) {
	      int c = res.getInt(1);
	      sum = sum + c;
	    }
	    System.out.println("total cost  = " + sum); 
	}
}
