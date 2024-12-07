package com.klef.jfsd.exam;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

public class ClientDemo 
{
	public static void main(String[] args) 
	{
		ClientDemo cd=new ClientDemo();
		cd.updatepositional();
	}
	
	public void updatepositional()
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		int id=1;
		String name="Rama Krishna";
		String location="Vjz";
		
		
		String query = "update Department set name=?1, location=?2 where id=?3";

		MutationQuery qry= session.createMutationQuery(query);
		qry.setParameter(1, name);
		qry.setParameter(2, location);
		qry.setParameter(3, id);
		
		int n=qry.executeUpdate();
		
		if(n>0)
		{
			System.out.println("Updated");
		}
		else
		{
			System.out.println("not found");
		}
		transaction.commit();
		
		session.close();
		sf.close();
	}
	
}