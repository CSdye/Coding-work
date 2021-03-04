// Callen Dye
// Implementation of using a stack to change infix math to postfix
import java.util.Scanner;
public class Program1{

  public static boolean isOperand(char c){
    if((c>='a' && c<='z') ||
      (c>='A' && c<='Z') ||
      (c>='0' && c<='9')){
        return true;
      }else{
        return false;
      }
  }

  public static boolean isOperator(char d){
    return d =='+' || d =='-' || d =='*' || d =='/';
  }
  public static int precedenceOrder(char e){
    if(e == '*' || e == '/' ){
      return 2;
    }else {
      return 1;
    }
  }

 public static void main(String[]args){
    CharStack opstack = new CharStack();
    Scanner scan = new Scanner(System.in);

    System.out.println("Please input your problem: ");
    String str = scan.nextLine();

    for(int i=0;i<str.length();i++){
      char current = str.charAt(i);
       if(isOperand(current)){
        System.out.print(current);
      }else if (current == '('){
        opstack.push(current);
      }else if (current == ')'){
        while(!opstack.isEmpty() && opstack.peek()!= '('){
          System.out.print(opstack.pop());
        }
        opstack.pop();
      }else {
        while (!opstack.isEmpty() && opstack.peek()!= '(' &&  precedenceOrder(opstack.peek()) >= precedenceOrder(current))
            {
            System.out.print(opstack.pop());
          }
          opstack.push(current);
        }
      }

      while(!opstack.isEmpty()){
        System.out.print(opstack.pop());
    }
  }
}
