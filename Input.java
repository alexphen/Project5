package prj5;

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
     * Song Reader
     */
    private SongFileReader sFR;

    /**
     * Person Reader
     */
    private PersonFileReader pFR;

    int readCount = 0;
    int artCount = 0;
    int sportsCount = 0;
    int musicCount = 0;
    int readCountLike = 0;
    int artCountLike = 0;
    int sportsCountLike = 0;
    int musicCountLike = 0;


    /**
     * Input constructor
     */
    public Input(File file, File file1) {
        sFR = new SongFileReader(file);
        pFR = new PersonFileReader(file1);
        window = new GUIDisplayWindow();
        songList = readSongs();
        personList = readPeople();
        glyphList = new GlyphList();
        addSongValues();

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
        return pFR.readPersonFile();
    }


    /**
     * Adds the song values to the proper arrays for every song
     */
    private void addSongValues() {
        int size = songList.size();
        for (int i = 0; i < songList.size(); i++) {
            Song song = songList.get(i);
            readCount = 0;
            artCount = 0;
            sportsCount = 0;
            musicCount = 0;
            readCountLike = 0;
            artCountLike = 0;
            sportsCountLike = 0;
            musicCountLike = 0;
            for (int j = 0; j < personList.size(); j++) {
                Person person = personList.get(j);
                ArrayList<Integer> aInts = person.getAnswers();
                HobbyEnum hobby = person.getHobby();
                StateEnum state = person.getState();
                MajorEnum major = person.getMajor();
                int listenVal = (i * 2);
                int likeVal = (i * 2 + 1);
                switch (hobby) {
                    case READ:
                        if (aInts.get(listenVal) != -1) {
                            readCount++;
                            song.getHobbies()[0] += aInts.get(listenVal);
                        }
                        if (aInts.get(likeVal) != -1) {
                            readCountLike++;
                            song.getHobbies()[1] += aInts.get(likeVal);
                        }
                        break;
                    case ART:
                        if (aInts.get(listenVal) != -1) {
                            artCount++;
                            song.getHobbies()[2] += aInts.get(listenVal);

                        }
                        if (aInts.get(likeVal) != -1) {
                            artCountLike++;
                            song.getHobbies()[3] += aInts.get(likeVal);
                        }
                        break;
                    case SPORTS:
                        if (aInts.get(listenVal) != -1) {
                            sportsCount++;
                            song.getHobbies()[4] += aInts.get(listenVal);

                        }
                        if (aInts.get(likeVal) != -1) {
                            sportsCountLike++;
                            song.getHobbies()[5] += aInts.get(likeVal);
                        }
                        break;
                    case MUSIC:
                        if (aInts.get(listenVal) != -1) {
                            musicCount++;
                            song.getHobbies()[6] += aInts.get(listenVal);

                        }
                        if (aInts.get(likeVal) != -1) {
                            musicCountLike++;
                            song.getHobbies()[7] += aInts.get(likeVal);
                        }
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
                }// End Switch 3

            } // End person for
            Glyph glyph = new Glyph(song, 0, 0);
            glyphList.add(glyph);
            perHobbies(song.getHobbies());

            /*
             * System.out.println("song title " + song.getSongTitle()
             * + "\nsong artist " + song.getArtistName()
             * + "\nsong genre " + song.getGenre()
             * + "\nsong year " + song.getYearReleased()
             * + "\nheard\nreading" + song.getHobbies()[0]
             * + " art" + song.getHobbies()[2] +
             * " sports" + song.getHobbies()[4]+
             * " music" + song.getHobbies()[6] +
             * "\nlikes\nreading" + song.getHobbies()[1] +
             * " art" + song.getHobbies()[3] +
             * " sports" + song.getHobbies()[5] +
             * " music" + song.getHobbies()[7] + "\n");
             */

        } // End song for
        glyphList.sortGenre();
        glyphList.sortTitle();

    }


    private void perHobbies(int[] hobbies) {
        if (readCount != 0) {
            double per = ((double)hobbies[0] / readCount) * 100;
            double per1 = ((double)hobbies[1] / readCountLike) * 100;
            int x = (int)per;
            int x1 = (int)per1;
            hobbies[0] = x;
            hobbies[1] = x1;
        }

        if (artCount != 0) {
            double per = ((double)hobbies[2] / artCount) * 100;
            double per1 = ((double)hobbies[3] / artCountLike) * 100;
            int x = (int)per;
            int x1 = (int)per1;
            hobbies[2] = x;
            hobbies[3] = x1;
        }

        if (sportsCount != 0) {
            double per = ((double)hobbies[4] / sportsCount) * 100;
            double per1 = ((double)hobbies[5] / sportsCountLike) * 100;
            int x = (int)per;
            int x1 = (int)per1;
            hobbies[4] = x;
            hobbies[5] = x1;
        }
        if (musicCount != 0) {
            double per = ((double)hobbies[6] / musicCount) * 100;
            double per1 = ((double)hobbies[7] / musicCountLike) * 100;
            int x = (int)per;
            int x1 = (int)per1;
            hobbies[6] = x;
            hobbies[7] = x1;
        }

    }


    public static void main(String args0[]) {
        File personFile = new File(args0[0]);
        File songFile = new File(args0[1]);
        Input input = new Input(songFile, personFile);
    }

}
