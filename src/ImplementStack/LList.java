package ImplementStack;
import java.util.*;

/**
 *
 * @author MCON 264
 */
public class LList<T> implements Iterable
{

    //<editor-fold defaultstate="collapsed" desc="class LLNode">
    /**
     * LLNode - generic node T is "any type" we hide the implementation of the
     * nodes comprising the list
     *
     * @param <T>
     */
    private class LLNode<T>
    {

        private T info;
        private LLNode<T> next;

        public LLNode(T info)
        {
            this.info = info;
            next = null;
        }
    }
//</editor-fold>

    /**
     * private LLNode head points (it is a reference type, after all) <br>
     * to the start of the list. It is null for empty lists.
     */
    private LLNode<T> head;

    //<editor-fold defaultstate="collapsed" desc="constructors">
    /**
     * Constructors: no-args, and single node to contain info of generic type T.
     */
    public LList()
    {
        head = null;
    }

    public LList(T value)
    {
        head = new LLNode<T>(value);
    }
    //</editor-fold>

    /**
     * add a node (to the end of the list)
     *
     * @param value of type T to be encapsulated in LLNode and added to the list
     */
    public void add(T value)
    {
        LLNode<T> node = new LLNode<T>(value);
        if (head == null)
        {
            head = node;
        }
        else
        {
            LLNode curr = head;
            while (curr.next != null)
            {
                curr = curr.next;
            }
            curr.next = node;
        }
    }

    /**
     * override toString
     *
     * @return string representing the list, e.g., "|2|
     * -{@literal >} |5| -{@literal >}"
     */
    public String toString()
    {
        String strList = head == null
                ? "list == null"
                : "";

        LLNode<T> curr = head;
        while (curr != null)
        {
            strList += ("|" + curr.info.toString() + "| -> ");
            curr = curr.next;
        }
        return strList;
    }

    /**
     * remove a node from the list with the specified value
     *
     * @param value node with info containing T value is to be removed
     * @return boolean - success or failure (if no such value in the list)
     */
    public boolean remove(T value)
    {
        boolean found = false;
        if (head != null)
        {
            if (head.info.equals(value))
            {
                found = true;
                head = head.next;
            }
            else
            {
                LLNode<T> curr = head;
                while (curr.next != null)
                {
                    if (curr.next.info.equals(value))
                    {
                        found = true;
                        curr.next = curr.next.next;
                        break;
                    }
                    curr = curr.next;
                }
            }
        }
        return found;
    }

    /**
     * isEmpty check
     *
     * @return boolean confirmation of the list being empty
     */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * decapitate:  remove the first element of the list
     * @return - boolean true if success, false if the list is empty
     */
    public boolean decapitate()
    {
        boolean retVal = false;
        if (head != null)
        {
            head = head.next;
            retVal = true;
        }
        return retVal;
    }

    /**
     * decapitate - remove the first element of the list and return its info
     * @param boolean returnHead :  has to be true for the info to be returned
     * @return T info part of the removed (head) node
     */
    public T decapitate(boolean returnHead)
    {
        T headInfo = null;
        if (returnHead && head != null)
        {
            headInfo = head.info;
        }
        this.decapitate();
        return headInfo;
    }

    /**
     * secondectomy - remove the second element of the list
     * this, arguably useless, method was part of a homework assignment
     * @return boolean success or failure (list shorter than 2 elements)
     */
    public boolean secondectomy()
    {
        boolean retVal = false;
        if (head != null && head.next != null)
        {
            head.next = head.next.next;
            retVal = true;
        }
        return retVal;
    }

    /**
     * swap12 - swap the first two elements
     * another, arguably useless, method assigned as homework
     * @return boolean success or failure (list shorter than 2 elements)
     */
    public boolean swap12()
    {
        boolean retVal = false;
        if (head != null && head.next != null)
        {
            T tmp = head.info;
            head.info = head.next.info;
            head.next.info = tmp;
            retVal = true;
        }
        return retVal;
    }

    /**
     * newHead - insert new node as the head of the list
     * @param T value info part of the node
     */
    public void newHead(T value)
    {
        LLNode<T> node = new LLNode(value);
        node.next = head;
        head = node;
    }

    /**
     * caudectomy - remove the last element of the list and return its info
     * @return T info of the just removed last element of the list
     */
    public T caudectomy()
    {
        T retVal = null;
        if (head != null)
        {
            LLNode curr = head;
            if (curr.next == null)
            {
                retVal = head.info;
                head = null;
            }
            else
            {
                while (curr.next.next != null)
                {
                    curr = curr.next;
                }
                retVal = (T)curr.next.info;
                curr.next = null;
            }
        }
        return retVal;
    }

    /**
     * showhead - (peek at the head) return the info part of the head node
     * @return T info part of the head node of the list
     */
    public T showHead()
    {
        T element = null;
        if (head != null)
        {
            element = head.info;
        }
        return element;
    }

    //<editor-fold defaultstate="collapsed" desc="iterator">
    public Iterator<T> iterator()
    {
        return new LocalIterator(this);
    }

    private class LocalIterator<T> implements Iterator<T>
    {

        private LList<T> localList;
        private LLNode curr; // = head;

        public LocalIterator(LList<T> list)
        {
            localList = list;
            curr = localList.head;
        }

        public boolean hasNext()
        {
            return curr != null;
        }

        public T next()
        {
            T retVal = (T) curr.info;
            curr = curr.next;
            return retVal;
        }

    }
    //</editor-fold>
}
