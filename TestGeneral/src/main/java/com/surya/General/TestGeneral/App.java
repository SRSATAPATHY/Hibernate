package com.surya.General.TestGeneral;

import com.surya.General.service.TestService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        TestService service=new TestService();
       System.out.println( System.getProperty("eka.connectionprovider"));
        	service.run();
    }
}
