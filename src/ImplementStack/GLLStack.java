package ImplementStack;

/**
 *
 * @author taliayahav
 */
public class GLLStack<T> implements GLLStackInterface<T> {
    private LList<T>stack;
    public GLLStack() {
        stack = new LList();
    }


    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void push(T element) {
        stack.newHead(element);
    }

    @Override
    public T pop() {
        return stack.decapitate(true);
    }

    @Override
    public T peek() {
        return stack.showHead();
    }

}
