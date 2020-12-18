package bankmanagment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class fileread {
	
    public static void main(String[] args) throws FileNotFoundException
    {
    	  
    		String continu = null;
			do {	
    			String filename= JOptionPane.showInputDialog("name ");;
		String fil=filename+".txt";
		File firstFile1 = new File(filename+".txt");///showing text
		Scanner firstFileRead1 = new Scanner(firstFile1);
		while(firstFileRead1.hasNext())
		{
			String data = firstFileRead1.nextLine();
			System.out.println(data);
		}
		String oldName = JOptionPane.showInputDialog("Type previous name ");
		
		String newName = JOptionPane.showInputDialog("Type new name ");
		
		
		 one.modifyFile(fil, oldName, newName);
		 
		 System.out.println("Modified Account Details are following");
		 
		 
		 File firstFile = new File(filename+".txt");///showing text
			Scanner firstFileRead = new Scanner(firstFile);
			while(firstFileRead.hasNext())
			{
				String data = firstFileRead.nextLine();
				System.out.println(data);
			}
    	
    	System.out.println("hi");
       
    	String continu1;
    	continu1 = JOptionPane.showInputDialog("type continue ");
       
       	continu=continu1;
       
        
        
       } while (continu=="continue");
	
	System.out.println("bye");
    	
    	
	
	
    	
    }
	
	
	
	

}
