//Callen Dye
// Program 4 starter code
// Starter Code By: James Cain (jcain@sbuniv.edu)

public class buffer{

public static void main(String[]args){
  char [] first = {'h','e','l','l','o'};
  char [] second = {'w','o','r','l','d'};
  strcat(first,second);
}
public static char [] strcat (char [] destination, char [] source) {
// This method concatenates the null-character terminated
// characters within the destination character array with the
// characters from the null-character terminated characters in
// the source character array and returns the destination
// character array. The behavior is exactly like the behavior of
// the C-language function "strcat". By correcting this code,
// the student should gain an understanding of exactly what
// C-language does wrong in the function "strcat" and similar
// functions in the string.h and stdio.h libraries.
// Find the integer value i such that the i-th character
// of the destination array is the first null character
int i = 0;
int total = (destination.length + source.length);
char [] array = new char[total];
for(i = 0; i < destination.length; i++) {
  array[i] = destination[i];
}
// Copy the source array into the destination array,
// overwriting the existing characters beginning at the
// first null character within the destination array
  for(int j = 0; j < source.length; j++){
  int k = j+i;
  array[k] = source[j];
  }
// Null-terminate the destination array after the last
// character concatenated into it from the source array
// Return the destination array
for(i=0;i<total;i++){
  System.out.print(array[i]);
  }
System.out.println("");
System.out.println("This is the index of the first null character: " + total);
return array;
  } // public char [] strcat (char [] destination,
} // public class cis2953sp10p4 {...


