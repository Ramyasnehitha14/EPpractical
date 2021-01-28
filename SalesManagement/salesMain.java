package com.klu.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.klu.bean.salesBean;
import com.klu.insert.salesInsertion;

public class salesMain {
public static void main(String args[])throws ClassNotFoundException,SQLException
{
	Scanner s=new Scanner(System.in);
	salesBean sb = new salesBean();
	salesInsertion si = new salesInsertion();
	
	while(true) {
		System.out.println("\n1.insert into table sale \n2.display the details \n3.display total cost");
		int ch = s.nextInt();
	switch(ch) {
	case 1:
		System.out.println("enter itemid,name,cost");
		int id=s.nextInt();
		String name=s.next();
		int cost=s.nextInt();
		
		sb.setItemid(id);
		sb.setName(name);
		sb.setCost(cost);
		
		int i=si.SaleInsert(sb);
		if(i>0)
			System.out.println("Insertion successfull");
		else
			System.out.println("Fail");
		break;
		
	case 2:
		si.SaleDisplay(sb);
		break;
	
	case 3:
		si.displayCost(sb);
		break;
	}
	
}
}
}
