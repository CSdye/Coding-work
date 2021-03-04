package program3;  
import java.util.Scanner;
/*
 * Callen Dye
 * Task: Scan a binary number and using an XOR function, establish if the number inputed is true or false.
 */
public class BitReader {
public static void main(String []args) 
{
	// Set variables and parameters
	int c = -1;
	Scanner scan = new Scanner(System.in);
	System.out.println("Please input your binary seqeunce:");
	String input = scan.nextLine();
	char text = input.charAt(0);
	//construct loop 
	for(int i = 1; i<((input.length())); i++)
	{
	//scan for true or false
	if (input.charAt(i) == text)
	{
	text = '0';
	}
	else
	{ 
		text ='1';
	}
	}
	System.out.println((text == '1'));
}
}
