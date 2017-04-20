package musicpreference;

/**
 * 
 * @author aphen
 * @version <4/12/17>
 * @param <E>
 */
public class PersonList extends DLList<Person> {

    /**
     * Constructor, calls DLLidt Constructor
     */
    public PersonList() {
        super();
    }


    /**
     * @return PersonListIterator
     */
    public PersonListIterator iterator() {
        return new PersonListIterator();
    }


    /**
     * PersonListIterator inner class
     * 
     * @author aphen
     * @version <4/17/17>
     */
    private class PersonListIterator extends DLListIterator<Person> {

        /**
         * Iterator constructor
         */
        public PersonListIterator() {
            super();
        }


        /**
         * @return true if there is a next value
         */
        public boolean hasNext() {
            return super.hasNext();
        }


        /**
         * @return the next Person in the list
         */
        public Person next() {
            return super.next();
        }
    }
}
