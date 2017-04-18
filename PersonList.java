package musicpreference;


/**
 * 
 * @author aphen
 * @version <4/12/17>
 * @param <E>
 */
public class PersonList extends DLList<Person> {
    
    public PersonList() {
        super();
    }
    
    public PersonListIterator iterator() {
        return new PersonListIterator();
    }
    
    private class PersonListIterator extends DLListIterator<Person> {

        public PersonListIterator() {
            super();
        }
        
        public boolean hasNext() {
            return super.hasNext();
        }
        
        public Person next() {
            return super.next();
        }
    }
}
