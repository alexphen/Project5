/**
 * 
 */
package musicpreference;

/**
 * @author aphen
 * @version <4/13/17>
 */
public class PersonListTest extends student.TestCase {
    
    private PersonList pl;
    
    public void setUp() {
        pl = new PersonList();
    }
    
    public void testAdd() {
        pl.add(new Person());
        assertEquals(pl.size(), 1);
        pl.add(new Person());
        assertEquals(pl.size(), 2);
    }
}
