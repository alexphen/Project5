package prj5;

import java.util.ArrayList;

/**
 * 
 * @author Adam Tapp adamt
 * @version 04/13/17
 */
public class PersonTest extends student.TestCase {

    /**
     * Person field for testing
     */
    Person person;


    /**
     * Sets up the initial conditions for testing
     */
    public void setUp() {
        person = new Person();
    }


    /**
     * Tests the get methods
     */
    public void testGets() {
        assertEquals(HobbyEnum.ART, person.getHobby());
        assertEquals(MajorEnum.COMPUTER_SCIENCE, person.getMajor());
        assertEquals(StateEnum.SOUTHEAST, person.getState());
        assertTrue(person.getValid());
    }


    /**
     * Makes sure that answers is filled properly
     */
    public void testAns() {
        String person1String =
            "2,04/15/17 9:54,Other Engineering,Northeast,music,Yes,No,,Yes,No,Yes";
        Person person1 = new Person(person1String);
        assertEquals(HobbyEnum.MUSIC, person1.getHobby());
        assertEquals(MajorEnum.OTHER_ENGE, person1.getMajor());
        assertEquals(StateEnum.NORTHEAST, person1.getState());
        assertTrue(person1.getValid());

        ArrayList<Integer> list = person1.getAnswers();
        assertEquals(1, list.get(0).intValue());
        assertEquals(0, list.get(1).intValue());
        assertEquals(-1, list.get(2).intValue());
        assertEquals(1, list.get(3).intValue());
        assertEquals(0, list.get(4).intValue());
        assertEquals(1, list.get(5).intValue());
        
    }


    /**
     * Tests to make sure each enum acts correctly and that a non vaild person
     * isn't constructed
     */
    public void testCons() {
        String strPerson2 =
            "2,04/15/17 9:54,Math or CMDA,United States (other than Southeast or Northwest),sports,Yes,No,,Yes,No,Yes";
        String strPerson3 = "2,04/15/17 9:54,Math or CMDA,United States (other than Southeast or Northwest),sports,Yes,No,,Yes,No,Yes";

        String strPerson4 = "11,10/14/2015 12:28,Other Engineering,Southeast,reading,Yes,Yes,Yes,Yes,No";
        String strPerson5 = "128,10/19/2015 10:56,Other,Outside of United States,music,No,No,Yes,Yes,Yes,Yes,No,No,No";
       
        Person person2 = new Person(strPerson2);
        Person person3 = new Person(strPerson3);
        Person person4 = new Person(strPerson4);
        Person person5 = new Person(strPerson5);
        
        
        assertEquals(MajorEnum.MATH_CMDA, person2.getMajor());
        assertEquals(HobbyEnum.SPORTS, person2.getHobby());
        assertEquals(StateEnum.OTHER_US, person2.getState());
       
        assertTrue(person2.getValid());
        
        assertEquals(MajorEnum.MATH_CMDA, person3.getMajor());
        assertEquals(HobbyEnum.SPORTS, person3.getHobby());
        assertEquals(StateEnum.OTHER_US, person3.getState());
        assertTrue(person3.getValid());
        
        assertEquals(MajorEnum.OTHER_ENGE, person4.getMajor());
        assertEquals(HobbyEnum.READ, person4.getHobby());
        assertEquals(StateEnum.SOUTHEAST, person4.getState());
        assertTrue(person4.getValid());
        
        assertEquals(MajorEnum.OTHER, person5.getMajor());
        assertEquals(HobbyEnum.MUSIC, person5.getHobby());
        assertEquals(StateEnum.OTHER, person5.getState());
        assertTrue(person5.getValid());
        
        
        
        
        String strPerson6 =
            "2,04/15/17 9:54,,United States (other than Southeast or Northwest),sports,Yes,No,,Yes,No,Yes";
        String strPerson7 = "2,04/15/17 9:54,Math or CMDA,,sports,Yes,No,,Yes,No,Yes";

        String strPerson8 = "11,10/14/2015 12:28,Other Engineering,Southeast,,Yes,Yes,Yes,Yes,No";
        String strPerson9 = "128,10/19/2015 10:56,,,music,No,No,Yes,Yes,Yes,Yes,No,No,No";
        
        Person person6 = new Person(strPerson6);        
        Person person7 = new Person(strPerson7);
        Person person8 = new Person(strPerson8);
        Person person9 = new Person(strPerson9);
        
        assertFalse(person6.getValid());
        assertFalse(person7.getValid());
        assertFalse(person8.getValid());
        assertFalse(person9.getValid());
        
        String strPerson10 = "";
        Person person10 = new Person(strPerson10);
        
        String strPerson11 = "11";
        Person person11 = new Person(strPerson11);
        
        String strPerson12 = "129,10/19/2015 10:56,,,music,No,No,Yes,Yes,Yes,Yes,No,No,";
        Person person12 = new Person(strPerson12);
        
        String strPerson13 = "129,10/19/2015 10:56,potato,fries,ninny,No,No,Yes,Yes,Yes,Yes,No,No,";
    }
}
