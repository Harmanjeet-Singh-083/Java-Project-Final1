
package bankmanagment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class one {
	

		/**
		 * @param args
		 * @throws FileNotFoundException 
		 */
		public static void main(String[] args) throws FileNotFoundException {
			//create array of customer object  
		    
		    ArrayList<Customer> obj = new ArrayList<Customer>();
		    /////////////////
			JOptionPane.showMessageDialog(null, "Welcome to the Bank Account System");
			String continu=null;
			
			
			boolean bankAccountAsk; //Boolean for asking if user have  bank account 
			
			String inputbankAccountAsk; // string to hold the input 
			inputbankAccountAsk = JOptionPane.showInputDialog("Enter true if you have an account in bank or type false");

			bankAccountAsk =Boolean.parseBoolean(inputbankAccountAsk);
			// variables 
			int id1;
			double balance = 0;
			int interestRate ;
			int charges;
			String name1,InputDialogue,InputDialogue2;
			// condition loop to see details and edit already existing account
			if (bankAccountAsk) {
				 JOptionPane.showMessageDialog(null, "Welcome to the  Bank");
				 String filename;
				
				 filename = JOptionPane.showInputDialog("enter account no to see the account details ");
				 
				 //// open the file with account no
				 File firstFile = new File(filename+".txt");///showing text
					Scanner firstFileRead = new Scanner(firstFile);
					while(firstFileRead.hasNext())
					{
						String data = firstFileRead.nextLine();
						System.out.println(data);
					}
					
					//// edit data 
					
					// variables for editing the data in .txt file
					String editData;
					Boolean EditData;
					JOptionPane.showMessageDialog(null, "If you want to edit the data press true else type false");
					editData = JOptionPane.showInputDialog("If you want to edit the data press true else type false");
				 EditData= Boolean.parseBoolean(editData);
			    if (EditData) {
				String fil=filename+".txt"; 
				String oldName = JOptionPane.showInputDialog("Type previous name ");// previous name input
				
				String newName = JOptionPane.showInputDialog("Type new name ");// new name input
				
				
				 modifyFile(fil, oldName, newName);/// method calling for modify
				 
				 System.out.println("Modified Account Details are following");
				   
				 
				 // showing the edited file
				 
				 File firstFile1 = new File(filename+".txt");///showing text
					Scanner firstFileRead1 = new Scanner(firstFile1);
					while(firstFileRead1.hasNext())
					{
						String data = firstFileRead1.nextLine();
						System.out.println(data);
					}
			       
			        
			}	 
			else {
				JOptionPane.showMessageDialog(null, "Thanks ");
			}
			 }
			 else/// To create a new account 
			 {
				 JOptionPane.showMessageDialog(null, "Create a new Bank Account");
				 Random random = new Random();
				 int accountNO = random.nextInt(800000);
				 
				 
					id1=accountType(); // calling method to get the account type
					if  (id1==1) {
						interestRate= 5;  // setting interset rate and chrges for saving acc
						charges=100;
					}
					else
					{ interestRate=2;   // setting interset rate and chrges for checkin acc
					charges = 200;}
					
					
					name1=customerName(); // getting customer name by calling method
					
					balance= balanceMethod();    // 
					 obj.add(new Customer(accountNO,name1,balance,interestRate,charges));
				 
					
				 
			 }
				  // making account as object and assingning it values of obj arraylist element
			 
				    
				     for (int index = 0; index < obj.size(); index++){
				    	 Customer account = obj.get(index);
				    	 account.showData();// showdata method called from employee
				    	 account.fileCreate();// file create method call from employee
				    	 }
				     //String continu1;
				    	//continu1 = JOptionPane.showInputDialog("type exit to exit ");
				       

				    	//continu=continu1;
				       
				    	
				      // } while (continu!= "exit");
				  }
		
		// method for account type selection
		public static int accountType()
		 {
			int id1;
			String input;
			input = JOptionPane.showInputDialog("Please enter 1 for saving account 2 for checkin account");
			
			id1= Integer.parseInt(input);
			 
			return id1;
			 
		 }
		
		// method for customer name input
		public static String customerName()
		 {
			String name1;
			String input;
			input = JOptionPane.showInputDialog("Please enter Account Holder  Name then press enter");
			
			name1= input;
			 
			
			return name1;
		 }
		/// method to set the balance and perform all transactions
		public static double balanceMethod()
		{
		      String input;    // To hold user input
double balance;
		      // Create a DecimalFormat object for displaying dollars.
		      DecimalFormat dollar = new DecimalFormat("#,###.00");

		      // Get the starting balance.
		      input = JOptionPane.showInputDialog("What is your " +
		                            "account's starting balance?");

		      // Create a BankAccount object.
		      BankAccount account = new BankAccount(input);

		      // Get the amount of pay.
		      input = JOptionPane.showInputDialog("How much you " +
		                                   "you want to deposit ");

		      // Deposit the user's deposit into the account.
		      account.deposit(input);

		      // Display the new balance.
		      JOptionPane.showMessageDialog(null,
		                        "Your amount has been  deposited.\n" +
		                        "Your current balance is $ " +
		                        dollar.format(account.getBalance()));

		      // Withdraw some cash from the account.
		      input = JOptionPane.showInputDialog("How much would " +
		                                   "you like to withdraw? ");
		      
		      
		      // if loop to check the balance greater than withdraw aount
		      if (Double.parseDouble(input)<=account.getBalance()+2)
		      {
		    	  account.withdraw(input);

		      // Display the new balance
		      JOptionPane.showMessageDialog(null,
		                     "Now your balance after chrges of $2 is $" +
		                     dollar.format(account.getBalance()));
		     }
		     else JOptionPane.showMessageDialog(null,"Balance is less than withdraw amount");
		   // transfer some cash from the account.
		      input = JOptionPane.showInputDialog("How much would " +
		                                   "you like to transfer to another account ");
		      
		      
		      
		      if (Double.parseDouble(input)<=account.getBalance())// to check balance greater than transfer amount
		      {
		      
		      account.transfer(input);

		   
		      // Display the new balance
		      JOptionPane.showMessageDialog(null,
		                     "Now your balance after transfer is $" +
		                     dollar.format(account.getBalance()));
		      }
		      else JOptionPane.showMessageDialog(null,"Balance is less than transfer amount");
			   
		      
		      // pay utility bills from the account.
		      input = JOptionPane.showInputDialog("How much would " +
		                                   "you like to pay for utility bills? ");
		      if (Double.parseDouble(input)<=account.getBalance())// to check the balance greater than utility bills
		      {
		      
		      
		      account.utilityBills(input);

		      // Display the new balance
		      JOptionPane.showMessageDialog(null,
		                     "Now your balance after Bills is $" +
		                     dollar.format(account.getBalance()));
		      }
		      else
		    	  JOptionPane.showMessageDialog(null,"Balance is less than utility bills amount");
				   
		      
balance=account.getBalance();
		      
			return balance;
				
		}
		/// method for modify the account details in the  .txt file
		static void modifyFile(String filePath, String oldString, String newString)
	    {
	        File fileToBeModified = new File(filePath);
	         
	        String oldContent = "";
	         
	        BufferedReader reader = null;
	         
	        FileWriter writer = null;
	         
	        try
	        {
	            reader = new BufferedReader(new FileReader(fileToBeModified));
	             
	            //Reading all the lines of input text file into oldContent
	             
	            String line = reader.readLine();
	             
	            while (line != null) 
	            {
	                oldContent = oldContent + line + System.lineSeparator();
	                 
	                line = reader.readLine();
	            }
	             
	            //Replacing oldString with newString in the oldContent
	             
	            String newContent = oldContent.replaceAll(oldString, newString);
	             
	            //Rewriting the input text file with newContent
	             
	            writer = new FileWriter(fileToBeModified);
	             
	            writer.write(newContent);
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                //Closing the resources
	                 
	                reader.close();
	                 
	                writer.close();
	            } 
	            catch (IOException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }
		
		
		
		
		
		
		
		}
		
		
		
		
		
		
		

