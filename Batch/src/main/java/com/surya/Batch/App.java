package com.surya.Batch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Entity.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("/Resources/hibernate-cfg.xml");
    	SessionFactory sf=cfg.buildSessionFactory();
    	Session s1=sf.openSession();
    	int batch=5;
    	Transaction beginTransaction = s1.beginTransaction();
    
    	for(int i=0;i<100;i++) {
    		Person p=new Person();
    		p.setFirstName("Rama"+i);
    		p.setLastName("lochan"+i);
    		s1.save(p);
    		if(i>0&&i%batch==0) {
    			s1.flush();
    			s1.clear();
    			break;
    		}
    	}
    	beginTransaction.commit();
    }
}
