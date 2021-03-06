//Callen Dye
//Updated version of Password v.1
package program4;
import javax.swing.*;
public class Password4 {


 // JFrames, JScrollPanes, JLabels & ImageIcons

	public static boolean tooShort (String s)
	//TASK: Return true if s is less than eight characters long; false otherwise
	{
		if (s.length() < 10)
		   return true;
		else 
		   return false;
	}//tooShort
	
	public static boolean badStart (String s)
	//TASK: Return true if s starts with ! or ?; false otherwise
	{
		if (s.charAt(0) == '!')
		   return true;
		else if (s.charAt(0) == '?')
		   return true;
		return false;
	}//badStart
	
	public static boolean noSpecialCharacter(String s)
	//TASK: Return true if s doesn't contain a special characters (!, @, $)
	{
		if (s.contains("!"))
		   return false;
		else if (s.contains ("@"))
		   return false;
		else if (s.contains ("$"))
		   return false;
		return true;
	}//noSpecialCharacter
	
	public static boolean firstOrLastThreeTheSame(String s)
	//TASK: Return true if the first three characters or last three characters are the same
	//PRECondition: Assumes there are at least three characters in String s
	{
		if ((s.charAt(0) == s.charAt(1)) && (s.charAt(1) == s.charAt(2)))
		    return true;
		else if 	(s.charAt(s.length()-1) == s.charAt(s.length()-2) && 
(s.charAt(s.length()-2) == s.charAt(s.length()-3)))
		    return true;
		else
 		    return false;
	}//firstOrLastThreeTheSame
	
	public static boolean lazyPasswordChoice(String s) {
		String [] worstList = {"123456", "123456789", "qwerty" ,"12345678" ,"111111", "1234567890", "1234567","password","123123987654321" +
				"qwertyuiop","mynoob","123321","666666","18atcskd2w","7777777","1q2w3e4r","654321\r\n" + "555555\r\n" + 
						"3rjs1la7qe\r\n" + 
						"google\r\n" + 
						"1q2w3e4r5t\r\n" + 
						"123qwe\r\n" + 
						"zxcvbnm\r\n" + 
						"1q2w3e"};
			for(int i = 0; i< worstList.length; i++)
			
				if( worstList[i].equals(s))
				{
					return true;
				}
				return false;
			
		} 
			

	public static void main(String[] args) 
 	{
		/////////////// DECLARATIONS & INITIALIZATIONS ///////////////
		final int BADTRIESLIMIT = 5;	//Constant--the number of bad tries allowed
		boolean badPassword = true; 	//Assume the password is bad until a good one is typed in
		int passwordCount = 0;	//To keep track of how many times a bad password has been typed in
		String passWord = "";	//The candidate password
		int attempt = 4;
 	
		
		while (passwordCount < BADTRIESLIMIT)
		{
			if(true) 
				passwordCount++;
				attempt--; 
			if(passwordCount == BADTRIESLIMIT)
				JOptionPane.showMessageDialog(null, "Your account has been locked");
			if(passwordCount == BADTRIESLIMIT)
				System.exit(0);	
					
			
		////////// MAIN ALGORITHM FOR TESTING THE PASSWORD //////////
		passWord = JOptionPane.showInputDialog("Please input your password. You have " + attempt + " tries remaining");
		if (lazyPasswordChoice(passWord))
			JOptionPane.showMessageDialog(null,"Your password is lazy");
		else if(tooShort(passWord))
			JOptionPane.showMessageDialog(null, "Your password is too short");
		else if (badStart(passWord))
			JOptionPane.showMessageDialog(null, "Your password starts incorrectly");
		else if (passWord.contains(" "))
			JOptionPane.showMessageDialog(null, "Your password cannot contain a space");
		else if (noSpecialCharacter(passWord))
			JOptionPane.showMessageDialog(null, "Your password must contain a special character");
		else if (firstOrLastThreeTheSame(passWord))
			JOptionPane.showMessageDialog(null, "Password cannot start/end with the same 3 letters");
		else
		{
			JOptionPane.showMessageDialog(null, "You are logged in");
			System.exit(0);
		}
		}
	}
}
