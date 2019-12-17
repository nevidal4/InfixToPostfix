/**
 * interface for ObjectStack
 */
public interface ObjectStackInterface{
 public boolean isEmpty();
 public boolean isFull();
 public void clear();
 public void push(Object owie);
 public Object pop();
 public Object top();
}