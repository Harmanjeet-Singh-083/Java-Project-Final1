package bankmanagment;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class cc {
	
	public static void main(String[] args) throws FileNotFoundException
    {
	
	String continu = null;
	int a=0;
	do {
		
		String continu1;
    	continu1 = JOptionPane.showInputDialog("type continue ");
       

    	continu=continu1;
       
    	System.out.println(continu);
       System.out.println("enter no");
      	Scanner scan = new Scanner(System.in);
       int num1 = scan.nextInt();
       
       a=num1;
       } while (continu!= "end");
	
	System.out.println("bye");
	}



}
