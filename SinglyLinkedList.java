package prj5;

public class SinglyLinkedList<E> {

    public static class Node<D> {

        // The data element stored in the node.
        private D data;

        // The next node in the sequence.
        private Node<D> next;


        public Node(D d) {
            data = d;
        }


        public void setNext(Node<D> n) {
            next = n;
        }


        public Node<D> next() {
            return next;
        }


        public D getData() {
            return data;
        }
    }

    private Node<E> head;

    // the size of the linked list
    private int size;


    public SinglyLinkedList() {
        head = null;
        size = 0;

    }


    public int size() {
        return size;
    }


    public void add(int index, E obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        // check if the index is out of bounds
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<E> current = head;

        // empty stack case
        if (isEmpty()) {
            head = new Node<E>(obj);
        }

        // all other cases
        else {
            int currentIndex = 0;
            while (current != null) {
                if ((currentIndex + 1) == index) {
                    Node<E> nextNext = current.next;
                    Node<E> newNode = new Node<E>(obj);
                    current.setNext(newNode);
                    newNode.setNext(nextNext);

                }
                current = current.next();
                currentIndex++;
            }
        }
        size++;
    }


    public void add(E obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<E> current = head;

        // empty stack case
        if (isEmpty()) {
            head = new Node<E>(obj);
        }

        // other cases
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<E>(obj));
        }
        size++;
    }


    public boolean isEmpty() {
        return (size == 0);
    }


    public boolean remove(E obj) {
        Node<E> current = head;

        // account for matching head
        if ((null != head) && (obj.equals(current.data))) {
            head = head.next;
            size--;
            return true;
        }

        // account for 2+ size
        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                if (current.next.next != null) {
                    current.setNext(current.next.next);
                }
                size--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }


    public boolean remove(int index) {
        // // if the index is invalid
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {

            Node<E> current = head;
            int currentIndex = 0;

            // account for 1 size
            if ((index == 0)) {
                head = head.next;
                size--;
                return true;
            }

            // account for 2+ size
            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    Node<E> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
            }

            // if the element was never found, this also handles empty case
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    public E get(int index) {
        Node<E> current = head;
        int currentIndex = 0;
        E data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    public boolean contains(E obj) {
        Node<E> current = head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    public void clear() {
        // make sure we don't call clear on an empty list
        if (head != null) {
            head.setNext(null);
            head = null;
        }

    }


    public int lastIndexOf(E obj) {
        int lastIndex = -1;
        Node<E> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    @Override
    public String toString() {
        String result = "{";

        Node<E> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    public Object[] toArray() {

        Object[] array = new Object[this.size()];

        Node<E> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            SinglyLinkedList<E> other = ((SinglyLinkedList<E>)obj);
            if (other.size() == this.size()) {
                Node<E> current = head;
                Node<E> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }

}
