package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author aphen
 * @version 4/12/17>
 * @param <E>
 *            Generic type
 */
public class DLList<E> implements Iterable<E> {

    private static class Node<E> {
        private Node<E> next;
        private Node<E> previous;
        private E data;


        /**
         * Constructor
         * 
         * @param d
         *            Data to but put in Node
         */
        public Node(E d) {
            data = d;
        }


        /**
         * Sets the next Node
         * 
         * @param n
         *            Next Node
         */
        public void setNext(Node<E> n) {
            next = n;
        }


        /**
         * Sets the previous Node
         * 
         * @param n
         *            Previous Node
         */
        public void setPrevious(Node<E> n) {
            previous = n;
        }


        /**
         * 
         * @return the next Node
         */
        public Node<E> next() {
            return next;
        }


        /**
         * 
         * @return the previous node
         */
        public Node<E> previous() {
            return previous;
        }


        /**
         * 
         * @return Node's data
         */
        public E getData() {
            return data;
        }


        /**
         * Sets the Node's Data
         * 
         * @param newData
         *            data
         */
        public void setData(E newData) {
            data = newData;
        }
    }

    private int size;

    private Node<E> head;

    private Node<E> tail;


    /**
     * Constructor
     */
    public DLList() {
        init();
    }


    /**
     * Initializes fields
     */
    private void init() {
        head = new DLList.Node<E>(null);
        tail = new DLList.Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * 
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 
     * @return size of the list
     */
    public int size() {
        return size;
    }


    /**
     * Clears the list
     */
    public void clear() {
        init();
    }


    /**
     * Gets data at index
     * 
     * @param index
     *            index of Node
     * @return data of Node at index
     */
    public E get(int index) {
        return getNodeAtIndex(index).getData();
    }


    /**
     * Swaps two adjacent Nodes
     * 
     * @param index
     *            index of 2nd Node
     */
    public void swapWithBefore(int index) {
        E temp = this.get(index - 1);
        E curr = this.get(index);
        this.getNodeAtIndex(index).previous.setData(curr);
        this.getNodeAtIndex(index).setData(temp);
    }


    /**
     * Adds an entry to the list
     * 
     * @param newEntry
     *            new Entry
     */
    public void add(E newEntry) {
        add(size(), newEntry);
    }


    /**
     * Adds an entry at a specified index
     * 
     * @param index
     *            index
     * @param obj
     *            object to be added
     */
    public void add(int index, E obj) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException("Cannot add null "
                + "objects to a list");
        }

        Node<E> nodeAfter;
        if (index == size) {
            nodeAfter = tail;
        }
        else {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<E> addition = new Node<E>(obj);
        addition.setPrevious(nodeAfter.previous());
        addition.setNext(nodeAfter);
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;

    }


    /**
     * Removes Node at index
     * 
     * @param index
     *            index
     * @return true if Node was removed
     */
    public boolean remove(int index) {
        Node<E> nodeToBeRemoved = getNodeAtIndex(index);
        nodeToBeRemoved.previous().setNext(nodeToBeRemoved.next());
        nodeToBeRemoved.next().setPrevious(nodeToBeRemoved.previous());
        size--;
        return true;
    }
    
    public boolean remove(E obj) {
        Node<E> current = head.next();
        while (!current.equals(tail)) {
            if (current.getData().equals(obj)) {
                current.previous().setNext(current.next());
                current.next().setPrevious(current.previous());
                size--;
                return true;
            }
            current = current.next();
        }
        return false;
    }


    /**
     * 
     * @param index
     *            index of Node
     * @return Node at index
     */
    private Node<E> getNodeAtIndex(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<E> current = head.next(); // as we have a sentinel node
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current;
    }


    /**
     * @return String representation of list
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (!isEmpty()) {
            Node<E> currNode = head.next();
            while (currNode != tail) {
                E element = currNode.getData();
                builder.append(element.toString());
                if (currNode.next != tail) {
                    builder.append(", ");
                }
                currNode = currNode.next();
            }
        }

        builder.append("]");
        return builder.toString();
    }


    /**
     * 
     * @return Array representation of the list
     */
    public Object[] toArray() {
        Object[] res = new Object[size];
        Node<E> current = head.next;
        int index = 0;
        while (current.getData() != null) {
            res[index] = current.getData();
            current = current.next;
            index++;
        }

        return res;
    }


    /**
     * 
     * @author aphen
     * @version <4/13/17>
     * @param <A>
     *            generic type
     */
    public class DLListIterator<A> implements Iterator<E> {

        private int index;
        private int removed = -1;


        /**
         * Iterator constructor
         */
        public DLListIterator() {
            index = -1;
        }


        /**
         * @return true if there is a next value in the list
         */
        @Override
        public boolean hasNext() {
            return index < size - 1;
        }


        /**
         * @return the next value in the list
         */
        @Override
        public E next() {
            if (hasNext()) {
                index++;
                return getNodeAtIndex(index).data;
            }
            else {
                throw new NoSuchElementException();
            }
        }


        /**
         * Removes the current node from the list
         */
        @Override
        public void remove() {
            if (index == -1 || index == removed) {
                throw new IllegalStateException(
                    "The element to be removed does not exist");
            }
            else {
                Node<E> removal = getNodeAtIndex(index);
                removal.previous.setNext(removal.next);
                removal.next.setPrevious(removal.previous);
                size--;
                removed = index;
            }

        }
    }


    /**
     * @return new Iterator
     */
    public Iterator<E> iterator() {
        return new DLListIterator<E>();
    }

}
