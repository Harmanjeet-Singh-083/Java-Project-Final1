/**
 * 
 */
package bankmanagment;


import java.util.Scanner;

import javax.swing.JOptionPane;
/**
 * @author dell1
 *
 */
public class sample1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Welcome to the Bank Account System");//Welcome Message

JOptionPane.showMessageDialog(null, "Welcome to the Bank Account System");

boolean bankAccountAsk; //Boolean for asking bank account 
String inputbankAccountAsk;
inputbankAccountAsk = JOptionPane.showInputDialog("Enter true if you have an account in bank or type false");

bankAccountAsk =Boolean.parseBoolean(inputbankAccountAsk);

 if (bankAccountAsk) {
	 JOptionPane.showMessageDialog(null, "Welcome to the  Bank");
 }
 else
 {
	 JOptionPane.showMessageDialog(null, "Create a new Bank Account");
 }
 Scanner input = new Scanner(System.in);
 System.out.print("Enter an integer: ");
 int number = input.nextInt();
 System.out.println("You entered " + number);
 System.out.print("Enter an inama: ");
 String name = input.nextLine();
 System.out.println("You entered " + number);
	}

}
 