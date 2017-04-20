/**
 * 
 */
package prj5;

import java.util.Iterator;

/**
 * @author aphen
 * @version <4/13/17>
 */
public class PersonListTest extends student.TestCase {
    
    private PersonList pl;
    private Iterator iter;
    private Person p1;
    private Person p2;
    private Person p3;
    
    /**
     * Initializes Fields
     */
    public void setUp() {
        pl = new PersonList();
        iter = pl.iterator();
        p1 = new Person();
        p2 = new Person();
        p3 = new Person();
    }
    
    /**
     * Tests add method
     */
    public void testAdd() {
        pl.add(p1);
        assertEquals(pl.size(), 1);
        pl.add(p2);
        assertEquals(pl.size(), 2);
    }
    
    /**
     * Tests Iterator Method
     */
    public void testIter() {
        pl.add(p1);
        pl.add(p2);
        pl.add(p3);

        assertTrue(iter.hasNext());
        assertEquals(iter.next(), p1);
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), p2);
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), p3);
        assertFalse(iter.hasNext());
    }
}
