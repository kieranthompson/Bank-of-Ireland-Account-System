package ie.lyit.bank;

import javax.swing.JFrame;

import java.util.InputMismatchException;

import javax.swing.*;
import javax.swing.border.*;

public class accountTester extends JFrame{
	
	public static void main(String [] args){
		
		AccountHandler kieran = new AccountHandler();
		kieran.readFile();
		
		Menu menu = new Menu();
		
		do{	
			try{
				menu.display();

				menu.readOption();
				
				switch(menu.getOption()){
				   case 1:kieran.add();
				   kieran.writeToFile();
				   break;
				   
				   case 2:kieran.list();
				   break;
				   case 3:kieran.view();
				   break;
				   case 4:kieran.edit();
				   kieran.writeToFile();
				   break;
				   case 5:kieran.delete();
				   kieran.writeToFile();
				   break;
				   case 6:
					   break;				
				   default:System.out.println("INVALID OPTION...");
				}
				}catch(InputMismatchException IMe){
					System.out.println("Enter a number between 1 and 6");
				}
			}while(menu.getOption() != 6);
		
		
		
		
	}
}
