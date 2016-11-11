package ie.lyit.bank;

import java.io.Serializable;
import java.util.Scanner;

public class JointAccount extends Account implements Serializable {
	private String t1,fn1,sn1;
	private String t2,fn2,sn2;     
	private String address; 
	private double balance;
	private Name nameA;
	private Name nameB;
// COMPOSITION - nameB is an object of class Name

  	// Default Constructor for Joint objects
 	// - Java will automatically call Account() constructor
	public JointAccount(){
		
	}

	public JointAccount(String t1, String fN1, String sn1,  
			 String t2, String fN2, String sn2,     
			 String address, double balance, 
            int day, int month, int year){
	super(t1, fN1, sn1, address, balance, day, month, year);		
	nameB = new Name(t2,fN2,sn2);
}
	
	public void read(){
		Scanner keyIn = new Scanner(System.in);
		System.out.println("Enter title: ");t1 = keyIn.nextLine();
		System.out.println("Enter First Name: ");fn1 = keyIn.nextLine();
		System.out.println("Enter Last Name: ");sn1 = keyIn.nextLine();
		System.out.println("Enter Title: ");t2 = keyIn.nextLine();
		System.out.println("Enter First Name: ");fn2 = keyIn.nextLine();
		System.out.println("Enter Last Name: ");sn2 = keyIn.nextLine();
		System.out.println("Balance: ");balance = keyIn.nextDouble();	
		
	}
	
	
	// toString() method for displaying a Joint object
	// Display Joint object as 
	//         "ACCOUNT==>100001:Mr Joe Bloggs & Mrs Ann Bloggs,123 High Road,Letterkenny.	�100.00" 
	@Override
	public String toString(){
 		return("ACCOUNT: "+ accountNo + "\n\t " + t1 + " " + fn1 + " " + sn1 + " & "  + t1 +  " " + fn2 +  " " + sn2 + "\nBalance: " + balance + "\n");		
  	}
}