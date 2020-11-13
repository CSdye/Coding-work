// Callen Dye
// Program 3 starter code
// Starter Code By: James Cain (jcain@sbuniv.edu)
// This program is a random password generator
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
public class revise{
public static void main (String [] args) throws Exception{
Random rand = new Random();
Scanner kbd = new Scanner (System.in);
String total = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
"abcdefghijklmnopqrstuvwxyz" +
"0123456789`~!$%^&*()_+{}|:<>?/.,';][=-";
int Total = 0;
System.out.println("How many characters long would you like the password to be?");
try{
Total = Math.abs(kbd.nextInt ());
}catch(Exception e){
System.out.println("This input is not a number. Please restart the program and try again.");
System.exit(0);
}
char [] password = new char [Total];
String user = "";
int i,j,k;
char temp;
for(i=0;i<Total;i++){
password [i] = total.charAt (Math.abs(rand.nextInt(total.length())));
}
   for (i = 0; i < 1000; i ++) {
   j = Math.abs (rand.nextInt ()) % Total;
   k = Math.abs (rand.nextInt ()) % Total;
   temp = password [j];
   password [j] = password [k];
   password [k] = temp;
}
System.out.println (user + "" +
(new String (password)));
System.out.println("This is a temporary password. Highly recommended that you change to a personal password ASAP.");
}
}
