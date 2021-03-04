
import java.util.Scanner;
import java.io.*;
public class Tester{

public static void main(String [] args) throws IOException{

    try{
    Scanner scan= new Scanner(new File("challenge.html"));
    String line="";
    String newWord="";
    FileWriter w = new FileWriter("test.txt");
    LinkedQueue queue= new LinkedQueue();


    while (scan.hasNextLine())
    {
      line=scan.nextLine();
      String [] split= line.split(" ");
      int splitLength=split.length;
      int splitIndex=0;
      boolean tag=false;
       while(splitIndex<splitLength){
        String splitWord="";
        int index=0;
        int wordLength=split[splitIndex].length();
          while(index<=wordLength-1){
          char letter=split[splitIndex].charAt(index);
            if(letter == '<'){
            tag=true;
          }
          else if(letter=='>'){
            tag=false;
            }
          else if(!tag){
            splitWord+= letter;
          }
          index++;
        }//while3
        if( splitWord != "")
          queue.enqueue(splitWord);
        splitIndex++;
      }//while2
    }//while1
      w.write(queue+ "\n");
      w.close();
      System.out.println(queue);
  }//try block
    catch(FileNotFoundException e){
      System.out.println("File does not exist");
    }
  }
}
