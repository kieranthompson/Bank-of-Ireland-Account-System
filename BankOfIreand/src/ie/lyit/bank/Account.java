
package ie.lyit.bank;

public abstract class Account{
	protected Name name;		// COMPOSITION - Account HAS-A name (object of class Name)
	protected String address;	 
	protected double balance;
	protected Date dateOpened;	// COMPOSITION - Account HAS-A dateOpened (object of class Date)
	protected int accountNo;
	
	private static int nextUniqueNumber=1000;	// Next available unique Account number	
	
	// Default Constructor - set Instance Variables to null
	public Account(){
		name = new Name();      
		address= new String();	// OR address = ""; OR address = null;
		balance = 0.0;		
		dateOpened = new Date();
		// Set accountNo to static nextUniqueNumber & increment it for next accountNo
		accountNo = nextUniqueNumber++;	
	}

	// Initialisation Constructor
	public Account(String t, String fN, String sn, String address, double balance,
			       int initDay, int initMonth, int initYear){
		this.name = new Name(t,fN,sn);
		this.address = address;
		this.balance = balance;
		this.dateOpened = new Date(initDay, initMonth, initYear);

		// Set accountNo to static nextUniqueNumber & increment it for next accountNo
	}
	
	// toString() method for displaying a Account object
	// Display Account object as 
	//         "ACCOUNT==>100001:Mr Joe Bloggs,123 High Road,Letterkenny.	�100.00" 
 	@Override
	public String toString(){
 		return("ACCOUNT:"+ accountNo + "==>" + name + "," + address + " €" + balance);
  	}	

 	
	// equals() method for comparison of two Account objects
 	@Override
 	public boolean equals(Object o){
		// First check if o is a null reference to prevent run-time exceptions
		if(o == null) 
           return false;
	
		// Next check if o references the current object, if it does it must be equal
		if (this == o)
			return true;
         
		// Next check if o is in fact an Account object
		if(!(o instanceof Account))
			return false;
		else
		{
		    // If none of the above are true, cast o to a Account object so that
            // we can compare the object's instance variables and methods
			Account other = (Account)o;
			
			return (this.accountNo == other.accountNo);
		}
	}	
	
	// get() and set() methods for each Instance Variable
	public Name getName(){
		return name;
	}
	public void setName(Name name){
		this.name=name;
	}

	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}

	public double getBalance(){
		return balance;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}

	public Date getDateOpened(){
		return dateOpened;
	}
	public void setDateOpened(Date dateOpened){
		this.dateOpened = dateOpened;
	}

	public int getAccountNo(){
		return accountNo;
	}
	// Don't provide a setAccountNo() method
	// Shouldn't be able to setAccountNo(), its set using static
}