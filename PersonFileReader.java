package itemclasses;

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
    //private File file;
    
    /**
     * Song list 
     */
    PersonList<Person> personList;
    
    /**
     * The constructor for SongFileReader
     * @param the file that is going to be read into the scanner
     */
    public PersonFileReader(File file) {
        //this.file = file;
        try {
            scan = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.getStackTrace();
        }
        personList = new PersonList<>();
        
    }
    
    /**
     * Reads the song file, creates songs, then adds the song to a list of songs
     */
    public PersonList<Song> readSongFile() {
        while(scan.hasNextLine()) {          
            Person person = new Person(scan.nextLine());
            personList.add(person);
        }
        return personList;
    }
}
