package ImplementStack;
/**
 * Interface for GLLStack Class *
 * @author Katz9
 */
public interface GLLStackInterface<T>
{
    /**
     * isEmpty
     * @return boolean true if the stack is empty
     */
    public boolean isEmpty();

    /**
     * push element onto the stack
     * @param element - generic type T :  element to push
     */
    public void push(T element);

    /**
     * pop element off the stack and return it
     * @return element of generic type T
     */
    public T pop();

    /**
     * peek at the top element of the stack
     * @return element of generic type T
     */
    public T peek();
}