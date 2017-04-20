package prj5;

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
     * Song list
     */
    SongList songList;


    /**
     * The constructor for SongFileReader
     * 
     * @param the
     *            file that is going to be read into the scanner
     */
    public SongFileReader(File file) {
        try {
            scan = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.getStackTrace();
        }
        songList = new SongList();

    }


    /**
     * Reads the song file, creates songs, then adds the song to a list of songs
     */
    public SongList readSongFile() {
        if (scan != null) {
            scan.nextLine();
            while (scan.hasNextLine()) {
                Scanner scan1 = new Scanner(scan.nextLine());
                scan1.useDelimiter(",");
                String songTitle = scan1.next();
                String artistName = scan1.next();
                Integer yrReleased = Integer.valueOf(scan1.next());
                String genre = scan1.next();

                Song song = new Song(songTitle, artistName, yrReleased, genre);
                songList.add(song);
            }
        }
        return songList;
    }

}
