package itemclasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Adam Tapp adamt
 * @version 04/18/2017
 */
public class SongFileReader {

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
    SongList<Song> songList;
    
    /**
     * The constructor for SongFileReader
     * @param the file that is going to be read into the scanner
     */
    public SongFileReader(File file) {
        //this.file = file;
        try {
            scan = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.getStackTrace();
        }
        songList = new SongList<>();
        
    }
    
    /**
     * Reads the song file, creates songs, then adds the song to a list of songs
     */
    public SongList<Song> readSongFile() {
        while(scan.hasNext()) {
            String songTitle = scan.next();
            String artistName = scan.next();
            Integer yrReleased = Integer.valueOf(scan.next());
            String genre = scan.next();
            
            Song song = new Song(songTitle, artistName, yrReleased, genre);
            songList.add(song);
        }
        return songList;
    }
    
}
