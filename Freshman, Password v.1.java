package program2;
import javax.swing.*;

// Callen Dye


public class Program2 {
	
	public static void main(String[] args) {
	
		String pswrd;
			
		pswrd = JOptionPane.showInputDialog("Please input a password\n"
		+ "password must be at least 10 characters long\n" + 
		"Your password must contain at least one character chosen from '!', '#', or '$'\n" + 
		"Password must NOT contain any spaces or begin with an exclamation (!) or a question mark\n"
		+ "The first three charcaters cannot be the same.\n" 
		+ "The last three charcaters cannot be the same.");
		boolean accepted = true;
	//length test
		if (pswrd.length() <10)
		accepted = false;	
	
	//character test
		if (!pswrd.contains("!") && !pswrd.contains("#") && !pswrd.contains("$")) 
			accepted = false;
		if(pswrd.charAt(0) == '!' || pswrd.charAt(0) == '?' )
			accepted = false;
	 
		//space test
		if (pswrd.contains(" "))
		accepted = false;
		
	//first 3 letter test
		if (pswrd.charAt(0) == pswrd.charAt(1) && pswrd.charAt(1) == pswrd.charAt(2))
		accepted = false;
		 
	//last 3 letter test
		if(pswrd.charAt(pswrd.length()-3) == pswrd.charAt(pswrd.length() -2) 
	&& pswrd.charAt(pswrd.length() -2) == pswrd.charAt(pswrd.length() -1))
		accepted = false;
		
		if (accepted) 
		{
		JOptionPane.showMessageDialog(null, "Password is Accepted");
		}
	else
	{
			JOptionPane.showMessageDialog(null, "Password strength is weak. Try again");
	}
}
}
