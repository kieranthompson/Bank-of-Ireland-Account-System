package ie.lyit.bank;
import java.util.Scanner;
import java.io.Serializable;

public class Name implements Serializable{

	private String title;
	private String fName;
	private String lName = "";
	
	public Name(){
		
	}
	
	public Name(String title, String fName, String lName){
		this.title = title;
		this.fName = fName;
		this.lName = lName;
		
		Scanner keyIn = new Scanner(System.in);
		System.out.println("Enter Title: ");title = keyIn.nextLine();
		System.out.println("Enter First Name: ");fName = keyIn.nextLine();
		System.out.println("Enter in Surname: ");lName = keyIn.nextLine();
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "Name [title=" + title + ", fName=" + fName + ", lName=" + lName + "]";
	}

	
	
	
	
}
