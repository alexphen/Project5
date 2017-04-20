package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLList<E> implements Iterable<E> {

    private static class Node<E> {
        private Node<E> next;
        private Node<E> previous;
        private E data;


        public Node(E d) {
            data = d;
        }


        public void setNext(Node<E> n) {
            next = n;
        }


        public void setPrevious(Node<E> n) {
            previous = n;
        }


        public Node<E> next() {
            return next;
        }


        public Node<E> previous() {
            return previous;
        }


        public E getData() {
            return data;
        }
        
        public void setData(E newData) {
            data = newData;
        }
    }

    private int size;

    private Node<E> head;

    private Node<E> tail;


    public DLList() {
        init();
    }


    private void init() {
        head = new DLList.Node<E>(null);
        tail = new DLList.Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public void clear() {
        init();
    }


    public boolean contains(E obj) {
        return lastIndexOf(obj) != -1;
    }


    public E get(int index) {
        return getNodeAtIndex(index).getData();
    }
    
    public void swapWithBefore(int index) {
        E temp = this.get(index - 1);
        E curr = this.get(index);
        this.getNodeAtIndex(index).previous.setData(curr);
        this.getNodeAtIndex(index).setData(temp);
    }
    
    public void add(E newEntry) {
        add(size(), newEntry);
    }


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


    public int lastIndexOf(E obj) {
        /*
         * We should go from the end of the list as then we an stop once we find
         * the first one
         */
        Node<E> current = tail.previous();
        for (int i = size() - 1; i >= 0; i--) {
            if (current.getData().equals(obj)) {
                return i;
            }
            current = current.previous();
        }
        return -1; // if we do not find it
    }


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


    public class DLListIterator<A> implements Iterator<E> {

        private int index;
        private int removed = -1;


        public DLListIterator() {
            index = -1;
        }


        @Override
        public boolean hasNext() {
            return index < size - 1;
        }


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


    public Iterator<E> iterator() {
        return new DLListIterator<E>();
    }

}
