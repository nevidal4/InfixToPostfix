import java.io.*;
import java.util.Scanner;
/**
 * Driver for infixToPostfix
 * @author Andrews Samuel
 * @version 3/3/17
 */
public class Driver{
 /**
  * Main method
  */
 public static void main(String[] args) throws IOException{
  //Andrews Samuel
  //008559913
  Scanner in=new Scanner(new File("infix.txt"));
  PrintWriter pw=new PrintWriter(new FileWriter("csis.txt"));
  InfixToPostfix itp=new InfixToPostfix();
  for(int i=1;in.hasNext();++i){
   itp.setIn(in.nextLine());
   itp.toPost();
   itp.evalPost();
   pw.print(i+":\nInfix: "+itp.getIn()+"\nPostfix:"+itp.getPost()+"\nEvaluation: "+itp.getEval()+"\n");
   System.out.print(i+":\nInfix: "+itp.getIn()+"\nPostfix:"+itp.getPost()+"\nEvaluation: "+itp.getEval()+"\n");
   itp.clearPost();
  }
  in.close();
  pw.close();
 }
}