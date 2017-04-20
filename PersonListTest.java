/**
 * 
 */
package musicpreference;

/**
 * @author aphen
 * @version <4/13/17>
 */
public class PersonListTest extends student.TestCase {
    
    /**
     * Field
     */
    private PersonList pl;
    
    /**
     * Initializes fields
     */
    public void setUp() {
        pl = new PersonList();
    }
    
    /**
     * Tests add method
     */
    public void testAdd() {
        pl.add(new Person());
        assertEquals(pl.size(), 1);
        pl.add(new Person());
        assertEquals(pl.size(), 2);
    }
}
