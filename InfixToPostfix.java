import java.io.*;
/**
 * Converts infix expressions to postfix and evaluates them
 * @author Andrews Samuel
 * @version 3/3/17
 */
public class InfixToPostfix{
 private StringBuilder postfix;
 private String infix;
 private String eval;
 /**
  * Constructor (default) initializing memory for postfix expression
  */
 public InfixToPostfix(){
  postfix=new StringBuilder();
 }
 /**
  * Paramaterized constructor that initializes infix expression
  * @param sets infix
  */
 public InfixToPostfix(String str){
  infix=str;
 }
 /**
  * Sets infix to arguement
  * @param sets infix
  */
 public void setIn(String line){
  infix=line;
 }
 /**
  * Assigns priority of exicution for operators
  * @param operator to be given priority
  * @return returns a higher integer for operators with higher priority
  */
 public int priority(char operator){
  switch(operator){
   case'^':return 3;
   case'*':
   case'/':return 2;
   case'+':
   case'-':return 1;
   default:return 0;
  }
 }
 /**
  * processes an infix expression and stores the postfix equivelent into post member function
  */
 public void toPost(){
  char c;
  ObjectStack stack=new ObjectStack();
  for(int i=0;i<infix.length();++i){
   c=infix.charAt(i);
   if(Character.isDigit(c))
    postfix.append(" "+c);
   else if(c=='^'||c=='*'||c=='/'||c=='+'||c=='-'){
    while(!stack.isEmpty()&&(Character)stack.top()!='('&&priority((Character)stack.top())>=priority(c))
     postfix.append(" "+(char)stack.pop());
    stack.push((Character)c);
   }
   else if(c=='(')
    stack.push((Character)c);
   else if(c==')'){
    while((Character)stack.top()!='(')
     postfix.append(" "+(char)stack.pop());
    stack.pop();
   }
  }
  while(!stack.isEmpty())
   postfix.append(" "+(char)stack.pop());
 }
 /**
  * initializes and calls function from EvalPost to evaluate a postfix expression produced from toPost()
  */
 public void evalPost(){
  EvalPost ep=new EvalPost(getPost()+"\n");
  ep.evalPost();
  eval=ep.getEval();
 }
 /**
  * returns the evaluated expression
  * @return string representation of the integer evaluated from postfix expression
  */
 public String getEval(){
  return eval;
 }
 /**
  * returns a string containing the current infix member variable
  * @return infix
  */
 public String getIn(){
  return infix;
 }
 /**
  * returns a string containing the processed postfix expression
  * @return postfix
  */
 public String getPost(){
  return postfix.toString();
 }
 /**
  * clears postfix member variable
  */
 public void clearPost(){
  postfix=new StringBuilder();
 }
}