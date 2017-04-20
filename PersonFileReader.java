package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PersonFileReader {

    /**
     * Scanner to read the file
     */
    private Scanner scan;

    /**
     * File with song information inside
     */
    // private File file;

    /**
     * Song list
     */
    PersonList personList;


    /**
     * The constructor for SongFileReader
     * 
     * @param the
     *            file that is going to be read into the scanner
     */
    public PersonFileReader(File file) {
        // this.file = file;
        try {
            scan = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.getStackTrace();
        }
        personList = new PersonList();

    }


    /**
     * Reads the Person file, creates people, then adds the song to a list of people
     */
    public PersonList readPersonFile() {
        if (scan != null) {
            //Removes the first line
            scan.nextLine();
            while (scan.hasNextLine()) {
                
                Person person = new Person(scan.nextLine());
                if (person.getValid()) {
                    personList.add(person);
                }
            }
        }
        return personList;
    }

}
