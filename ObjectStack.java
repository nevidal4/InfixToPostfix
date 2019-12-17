/**
 * Class for a stack of objects
 * @author Andrews Samuel
 * @version 3/3/17
 */
public class ObjectStack implements ObjectStackInterface{
 private int top;
 private Object item[];
 /**
  * toString represntation of stack
  * @return contents of stack with top on left
  */
 public String toString(){
  StringBuilder buildie=new StringBuilder();
  for(int i=0;i<=top;++i)
   buildie.append(item[i]+" ");
  return buildie.toString();
 }
 /**
  * Default constructor for ObjectStack
  */
 public ObjectStack(){
  top=-1;
  item=new Object[100];
 }
 /**
  * determines wither or not the stack is empty
  * @return true if stack is empty, false if otherwise
  */
 public boolean isEmpty(){
  return top==-1;
 }
 /**
  * determines wither or not the stack is full
  * @return true is stack is full, false otherwise
  */
 public boolean isFull(){
  return top==item.length-1;
 }
 /**
 * clears contents of stack by instantiating a new location in memory for a new stack
 */
 public void clear(){
  top=-1;
  item=new Object[2];
 }
 /**
  * places an object onto the top of stack
  * @param object to be placed
  */
 public void push(Object obie){
  item[++top]=obie;
  //System.out.print(toString()+"\n");
  if(isFull())
   resize(item.length*2);
 }
 /**
  * removes and returns the top object from the stack
  * @return top object from stack
  */
 public Object pop(){
  if(isEmpty()){
   System.out.print("Underflow\n");
   System.exit(1);
  }
  if(top==item.length/4)
   resize(item.length/2);
  //System.out.print(toString()+"\n");
  return item[top--];
 }
 /**
  * helper method to resize the array holding the values of the stack when it becomes too full or too empty
  */
 private void resize(int size){
  if(size<1)
   size=1;
  Object temp[]=new Object[size];
  for(int i=0;i<=top;++i)
   temp[i]=item[i];
  item=temp;
 }
 /**
  * returns the top item from the stack without removing it
  * @return item on top of stack
  */
 public Object top(){
  if(isEmpty()){
   System.out.print("Underflow\n");
   System.exit(1);
  }
  return item[top];
 }
}