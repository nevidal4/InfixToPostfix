import java.io.*;
/**
 * Class designed to process a postfix expression
 * @author Andrews Samuel
 * @version 3/3/17
 */
public class EvalPost{
 private ObjectStack stack;
 private String post;
 /**
  * Constructor for EvalStack (defalut) to assign memory to ObjectStack
  */
 public EvalPost(){
  stack=new ObjectStack();
  post="";
 }
 /**
  * Paramaterized constructor for EvalStack to assign a value to postfix member variable
  * @param string to initialize postfix to
  */
  public EvalPost(String str){
  stack=new ObjectStack();
  post=str;
 }
 /**
  * sets postfix expression to str
  * @param str sets postfix member variable
  */
 public void setPost(String str){
  post=str;
 }
 /**
  * gets postfix member variable
  * @return postfix expression
  */
 public String getPost(){
  return post;
 }
 /**
  * gets the evaluation of postfix expression
  * @return postfix
  */
 public String getEval(){
  return (String)stack.top();
 }
 /**
  * helper method to deturmine wither or not a substring is a number or not
  * @return true if string represents a number; false otherwise
  */
 private boolean isNum(String str){
  for(int i=0;i<str.length();++i){
   if(!Character.isDigit(str.charAt(i)))
    return false;
  }
  return true;
 }
 /**
  * processes postfix expression to determine the value of it
  */
 public void evalPost(){
  int var1,var2;
  String s;
  for(int i=0;i<post.length();++i){
   s=post.substring(i,i+1);
   if(isNum(s))
    stack.push(s);
   else if(s.equals("^")||s.equals("*")||s.equals("/")||s.equals("+")||s.equals("-")){
    var2=Integer.parseInt((String)stack.pop());
    var1=Integer.parseInt((String)stack.pop());
    switch(s.charAt(0)){
     case'^':stack.push(String.valueOf((int)Math.pow(var1,var2)));break;
     case'*':stack.push(String.valueOf(var1*var2));break;
     case'/':stack.push(String.valueOf(var1/var2));break;
     case'+':stack.push(String.valueOf(var1+var2));break;
     case'-':stack.push(String.valueOf(var1-var2));break;
    }
   }
  }
 }
}