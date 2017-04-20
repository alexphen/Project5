package prj5;


/**
 * 
 * @author aphen
 * @version <4/12/17>
 */
public class PersonList extends DLList<Person> {
    /**
     * PersonList constructor
     */
    public PersonList() {
        super();
    }
    /**
     * Returns a new iterator for this personList
     * @return PersonListIterator the iterator for this PersonList
     */
    public PersonListIterator iterator() {
        return new PersonListIterator();
    }
    /**
     * 
     * @author Adam Tapp adamt
     * @version 04/19/2017
     */
    private class PersonListIterator extends DLListIterator<Person> {
        /**
         * Constructor for PersonListIterator
         */
        public PersonListIterator() {
            super();
        }
        /**
         * Determines if the list has another entry
         * @return boolean {@code true} if there is another entry in the list {@code false} otherwise
         */
        public boolean hasNext() {
            return super.hasNext();
        }
        
        /**
         * Returns the next Person in the list
         * @return Person the next Person in the list
         */
        public Person next() {
            return super.next();
        }
    }
}
