//Callen Dye
import java.util.*;
public class thread extends Thread{

  static int size = 100; // variables needed to be referenced throughout the program
  static int total = 25;
  static int []array = new int[size];
  static int val;
  static int begin;
  static int end;
  public static void main(String[]args) throws InterruptedException{
    Scanner scan = new Scanner(System.in);  //user input
    System.out.println("What is the number you would like to search for?");
    val = scan.nextInt();
    if(val > total){ //error handling
      System.out.println("The number you have chosen is too large.");
      System.exit(0);
    }
     Random rand = new Random();

    for(int j = 0; j < array.length; j++){ //fill array with random ints and print to screen
      array[j] = rand.nextInt(total);
      System.out.println(array[j]);
    }
    thread a = new thread(0,24,array);// Create 4 threads to traverse array at different indexes
    a.start();// problem in implementation of join, program currently does not use threads properly but is sequential
    a.join();
    thread b = new thread(25,49,array);
    b.start();
    b.join();
    thread c = new thread(50,74,array);
    c.start();
    c.join();
    thread d = new thread(75,99,array);
    d.start();
    d.join();
  }//main

  public thread(int first,int last,int []array){
 begin = first ;// set beginning and end values so each thread will only traverse a certain section of array
    end = last;
  }//thread

  public void run(){ //Make threads check each index and report if the target value is found
  for(int i = begin; i < end;i++){
    if(array[i] == val){
      System.out.println("The target was found at array index:" + i);
      }//if
    }//for
  }//run
}//class thread

