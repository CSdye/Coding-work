// Callen Dye
// XOR Cipher
// This program takes in a key, in this instance 'world', and encrypts the data until it is decrypted by the same key
import java.lang.String;
import java.lang.Integer;
import java.util.Arrays;
public class xor{
public static void main(String[]args){
  String total = new String(Crypt("Hello", "World")); //first encrypt the input String.
  String last = new String(Crypt(total, "World")); //use the same codebook to decode encrypted String.
  System.out.println(last); //Print final result to console. Should be the same value as original "msg" String.
}

public static String Crypt(String msg, String code){ // Method to encrypt a string "msg" using the codebook "code".
	if(msg.length() != code.length()){ //Error handling to prevent crashing of program.
 	 System.out.println("Error. The input strings are not the same length.");
 	 return "-1";
 	 }
byte[] ByteArr = msg.getBytes(); //convert strings to bytes to data.
byte[] CodeArr = code.getBytes();
byte[] Result = new byte[ByteArr.length]; //result array to store the XOR'd data.
int lcv = 0;
for(lcv = 0; lcv < msg.length();lcv++){ // loop to XOR the two byte arrays and store them in Result array.
  Result[lcv] = (byte)(ByteArr[lcv] ^ CodeArr[lcv]);
  }
  String res = new String(Result); // Convert Result byte array to String.
  return res;
  }
}



