package program3; 
import java.io.*;  
import java.text.DecimalFormat;
import java.util.Scanner;
/* Callen Dye
 * Task: Calculate the data from a scanned text file then output the correctly calculated distance the ball(s) traveled.
 */ 
public class BounceReader {
	public static void main(String[]args) throws IOException
	{
		File file= new File("bouncedata.txt");
		Scanner scan = new Scanner(file);
		DecimalFormat format = new DecimalFormat("0.00");
		while(scan.hasNext())
		{ 
			//Declare values
			double distance = 0;
			double originalDropHeight = scan.nextInt();
			double dropHeight = originalDropHeight;
			double originalBounceHeight = scan.nextInt();  
			double bounceHeight = originalBounceHeight;
			double originalBounce = scan.nextInt(); 
			double Bounce = originalBounce;
			double bounceIndex = bounceHeight / dropHeight;
			double actualBounces = 0;
			//Set loop
			while ((Bounce > 0 && (bounceHeight > .001))) {
				distance = dropHeight + bounceHeight;
				dropHeight = bounceHeight;
				bounceHeight = dropHeight * bounceIndex;
				Bounce--;
				actualBounces++;
			}
			//Print the calculations
			System.out.println("The intial dropHeight in feet is " + originalDropHeight);
			System.out.println("The first bounce height in feet is " + originalBounceHeight);
			System.out.println("The calculated bounciness index is " + bounceIndex);
			System.out.println("The number of bounces was " + originalBounce);
			System.out.println("The actaul number of bounces was " + actualBounces);
			System.out.println("The distance traveled was " + format.format(distance));
			System.out.println("");
		}
	}
}