package prj5;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 * @author Adam Tapp adamt
 * @version 04/20/2017
 */

public class SongFileReaderTest extends student.TestCase {
    /**
     * SongFileReader field
     */
    SongFileReader sFR;

    /**
     * The file being read to the file reader
     */
    File file;

    /**
     * SongList field
     */
    SongList songList;


    public void setUp() {
        file = new File("SongListTest2.csv");
        sFR = new SongFileReader(file);
        songList = new SongList();
    }


    /**
     * Tests readSongFile, which returns a list of songs created from the given
     * file
     */
    public void testReadSongFile() {
        songList = sFR.readSongFile();
        assertEquals("All These Things I've Done,The Killers,2005,alternative",
            songList.get(0).toString());
        
        // Tests that the scanner throws a file not found exception
        File file1 = new File("NotAFile.cvs");
        sFR = new SongFileReader(file1);
        SongList songList1 = new SongList();
        assertEquals(songList1.toString(), sFR.readSongFile().toString());
    }

}
