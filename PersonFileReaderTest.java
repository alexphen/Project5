package prj5;

/**
 * 
 * @author Adam Tapp adamt
 * @version 04/20/2017
 */
import java.io.File;

public class PersonFileReaderTest extends student.TestCase {
    /**
     * PersonFileReaderTest field
     */
    private PersonFileReader pFR;

    /**
     * File field
     */
    private File file;

    /**
     * PersonList field
     */
    private PersonList personList;


    /**
     * Sets up the initial conditions for the test
     */
    public void setUp() {
        file = new File("MusicSurveyDataTest3.csv");
        pFR = new PersonFileReader(file);
        personList = new PersonList();
    }

    /**
     * Tests readPersonFile, which returns a list of people created from the given
     * file
     */
    public void testReadPersonFile() {
        personList = pFR.readPersonFile();
        assertEquals(1, personList.size());
        
        Person person = personList.get(0);
        assertEquals(MajorEnum.MATH_CMDA, person.getMajor());
        assertEquals(StateEnum.SOUTHEAST, person.getState());
        assertEquals(HobbyEnum.SPORTS, person.getHobby());
        
        File file1 = new File("ThisIsNotARealFile.csv");
        pFR = new PersonFileReader(file1);
        PersonList personList1 = new PersonList();
        assertEquals(personList1.toString(), pFR.readPersonFile().toString());
        
    }

}
