package ie.lyit.bank;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class AccountHandler extends JointAccount implements Serializable {
	
	private ArrayList<JointAccount> joint;
	private static String FILENAME = "joint.bin";
	private ArrayList<JointAccount> jointaccount;
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
	public AccountHandler(){
		jointaccount = new ArrayList<JointAccount>();
	}
	
	public void writeToFile(){
		try{
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			
			os.writeObject(jointaccount);
			os.writeInt(accountNo);
			os.close();
		
		} 
			catch(FileNotFoundException FNFE){
				System.out.println("FILE COULD NOT BE FOUND");
		}
			catch(Exception e){
				System.out.println(e.getMessage());
			
		}
	}
	
	public void readFile(){
		try{
			FileInputStream fis = new FileInputStream(FILENAME);
			 
			 ObjectInputStream is = new ObjectInputStream(fis);
			 
			 jointaccount = (ArrayList<JointAccount>)is.readObject();

			 is.close();
			}
			catch(FileNotFoundException FNFE){
				System.out.println("FILE COULD NOT BE FOUND");
			}
			
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	
	public void add(){
		JointAccount account = new JointAccount();
	    account.read();
		jointaccount.add(account);

		System.out.println("System updated " + "@ " + timeStamp);
		
		
		
	}
	
	public void list(){
		for(JointAccount tmpaccount: jointaccount){
			System.out.println(tmpaccount);
		}
	}

	public JointAccount view(){
		Scanner keyIn = new Scanner(System.in);
		
		System.out.println("Enter the Account Number: ");
		
		int input = keyIn.nextInt();
		
		for(JointAccount tmpaccount: jointaccount){
			if(tmpaccount.getAccountNo() == input);
				System.out.println(tmpaccount);
				return tmpaccount;
		}
		
		return null;
	}
	
	
	public void delete(){
				JointAccount tempaccount = view();
			    if(tempaccount != null)
			       jointaccount.remove(tempaccount);
			    System.out.println("ACCOUNT DELETED");
	}
	
	
	public void edit(){
		JointAccount tempaccount = (JointAccount) view();
		
		if(tempaccount != null){
			int index=jointaccount.indexOf(tempaccount);
			tempaccount.read();
			
			jointaccount.set(index, (JointAccount) tempaccount);
		}
	}
	
}
