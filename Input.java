package musicpreference;

import java.io.File;
import java.util.ArrayList;

/**
 * 
 * @author Adam Tapp
 * @version 04/19/2017
 */
public class Input {

    /**
     * Window GUI
     */
    private GUIDisplayWindow window;

    /**
     * List of songs
     */
    private SongList songList;

    /**
     * List of people
     */
    private PersonList personList;

    /**
     * List of Glyphs
     */
    private GlyphList glyphList;

    /**
     * File for people
     */
    private File personFile;

    /**
     * File for songs
     */
    private File songFile;

    /**
     * Song Reader
     */
    private SongFileReader sFR;

    /**
     * Person Reader
     */
    private PersonFileReader pFR;


    /**
     * Keeps track of what
     */
    /**
     * Input constructor
     */
    public Input() {
        // Files can change
        // personFile = new File('MusicSurveyData');
        // songFile = new File('SongList');
        sFR = new SongFileReader(songFile);
        pFR = new PersonFileReader(personFile);
        window = new GUIDisplayWindow();
        songList = readSongs();
        personList = readPeople();
        glyphList = new GlyphList();

    }


    /**
     * Reads the song file and returns the list
     * 
     * @return SongList is the list of songs for the given file
     */
    private SongList readSongs() {
        return sFR.readSongFile();
    }


    /**
     * Reads the person file and returns the list
     * 
     * @return PersonList is the list of people for the given file
     */
    private PersonList readPeople() {
        return pFR.readSongFile();
    }


    /**
     * Adds the song values to the proper arrays for every song
     */
    private void addSongValues() {
        // Keeps track of where the values need to be added
        for (int i = 0; i < songList.size(); i++) {
            Song song = songList.get(i);
            for (int j = 0; j < personList.size(); j++) {
                Person person = personList.get(j);
                ArrayList<Integer> aInts = person.getAnswers();
                Hobby hobby = person.getHobby();
                State state = person.getState();
                Major major = person.getMajor();
                int listenVal = aInts.get(i * 2 - 1);
                int likeVal = aInts.get(i * 2);
                switch (hobby) {
                    case READ:
                        song.getHobbies()[0] += aInts.get(listenVal);
                        song.getHobbies()[1] += aInts.get(likeVal);
                        break;
                    case ART:
                        song.getHobbies()[2] += aInts.get(listenVal);
                        song.getHobbies()[3] += aInts.get(likeVal);
                        break;
                    case SPORTS:
                        song.getHobbies()[4] += aInts.get(listenVal);
                        song.getHobbies()[5] += aInts.get(likeVal);
                        break;
                    case MUSIC:
                        song.getHobbies()[6] += aInts.get(listenVal);
                        song.getHobbies()[7] += aInts.get(likeVal);
                        break;
                    default:
                        break;
                }// End Switch 1

                switch (major) {
                    case COMPUTER_SCIENCE:
                        song.getMajor()[0] += aInts.get(listenVal);
                        song.getMajor()[1] += aInts.get(likeVal);
                        break;
                    case OTHER_ENGE:
                        song.getMajor()[2] += aInts.get(listenVal);
                        song.getMajor()[3] += aInts.get(likeVal);
                        break;
                    case MATH_CMDA:
                        song.getMajor()[4] += aInts.get(listenVal);
                        song.getMajor()[5] += aInts.get(likeVal);
                        break;
                    case OTHER:
                        song.getMajor()[6] += aInts.get(listenVal);
                        song.getMajor()[7] += aInts.get(likeVal);
                        break;
                    default:
                        break;
                }// End Switch 2

                switch (state) {
                    case NORTHEAST:
                        song.getState()[0] = aInts.get(listenVal);
                        song.getState()[1] = aInts.get(likeVal);
                        break;
                    case SOUTHEAST:
                        song.getState()[2] = aInts.get(listenVal);
                        song.getState()[3] = aInts.get(likeVal);
                        break;
                    case OTHER_US:
                        song.getState()[4] = aInts.get(listenVal);
                        song.getState()[5] = aInts.get(likeVal);
                        break;
                    case OTHER:
                        song.getState()[6] = aInts.get(listenVal);
                        song.getState()[7] = aInts.get(likeVal);
                        break;
                }
            }
        }
    }

    /**
     * Adds the values to hobby song list
     * 
     * @param hobby
     *            the hobby of a person
     */
    /*
     * private void addHobbyVal(Hobby hobby) {
     * switch (hobby) {
     * case READ:
     * }
     * }
     */

}
