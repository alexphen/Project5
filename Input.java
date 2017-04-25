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

    /**
     * Counters for Hobby likes and listens
     */
    private int readCount = 0;
    private int artCount = 0;
    private int sportsCount = 0;
    private int musicCount = 0;
    private int readCountLike = 0;
    private int artCountLike = 0;
    private int sportsCountLike = 0;
    private int musicCountLike = 0;

    /**
     * Counters for Major likes and listens
     */
    private int compSciCount = 0;
    private int otherENGECount = 0;
    private int mathCMDACount = 0;
    private int otherCount = 0;
    private int compSciCountLike = 0;
    private int otherENGECountLike = 0;
    private int mathCMDACountLike = 0;
    private int otherCountLike = 0;
    /**
     * Counters for state likes and listens
     */
    private int northEastCount = 0;
    private int southEastCount = 0;
    private int otherUsCount = 0;
    private int outsideUsCount = 0;
    private int northEastCountLike = 0;
    private int southEastCountLike = 0;
    private int otherUsCountLike = 0;
    private int outsideUsCountLike = 0;


    /**
     * Input constructor
     */
    public Input(File file, File file1) {
        sFR = new SongFileReader(file);
        pFR = new PersonFileReader(file1);
        songList = readSongs();
        personList = readPeople();
        glyphList = new GlyphList();
        window = new GUIDisplayWindow(glyphList);
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
            perMajors(song.getMajor());
            perRegion(song.getState());

        } // End song for
        glyphList.sortGenre();
        glyphList.sortTitle();

    }


    /**
     * Creates the proper sized bars for hobby
     * 
     * @param hobbies
     *            the int array that contains the values for hobby
     */
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


    /**
     * Creates the proper sized bars for hobby
     * 
     * @param hobbies
     *            the int array that contains the values for hobby
     */
    private void perMajors(int[] majors) {
        if (compSciCount != 0) {
            double per = ((double)majors[0] / compSciCount) * 100;
            double per1 = ((double)majors[1] / compSciCountLike) * 100;
            int x = (int)per;
            int x1 = (int)per1;
            majors[0] = x;
            majors[1] = x1;
        }

        if (otherENGECount != 0) {
            double per = ((double)majors[2] / otherENGECount) * 100;
            double per1 = ((double)majors[3] / otherENGECountLike) * 100;
            int x = (int)per;
            int x1 = (int)per1;
            majors[2] = x;
            majors[3] = x1;
        }

        if (mathCMDACount != 0) {
            double per = ((double)majors[4] / mathCMDACount) * 100;
            double per1 = ((double)majors[5] / mathCMDACountLike) * 100;
            int x = (int)per;
            int x1 = (int)per1;
            majors[4] = x;
            majors[5] = x1;
        }
        if (otherCount != 0) {
            double per = ((double)majors[6] / otherCount) * 100;
            double per1 = ((double)majors[7] / otherCountLike) * 100;
            int x = (int)per;
            int x1 = (int)per1;
            majors[6] = x;
            majors[7] = x1;
        }

    }


    /**
     * Creates the proper sized bars for region
     * 
     * @param region
     *            the int array that contains the values for region
     */
    private void perRegion(int[] region) {
        if (readCount != 0) {
            double per = ((double)region[0] / northEastCount) * 100;
            double per1 = ((double)region[1] / northEastCountLike) * 100;
            int x = (int)per;
            int x1 = (int)per1;
            region[0] = x;
            region[1] = x1;
        }

        if (artCount != 0) {
            double per = ((double)region[2] / southEastCount) * 100;
            double per1 = ((double)region[3] / southEastCountLike) * 100;
            int x = (int)per;
            int x1 = (int)per1;
            region[2] = x;
            region[3] = x1;
        }

        if (sportsCount != 0) {
            double per = ((double)region[4] / otherUsCount) * 100;
            double per1 = ((double)region[5] / otherUsCountLike) * 100;
            int x = (int)per;
            int x1 = (int)per1;
            region[4] = x;
            region[5] = x1;
        }
        if (musicCount != 0) {
            double per = ((double)region[6] / outsideUsCount) * 100;
            double per1 = ((double)region[7] / outsideUsCountLike) * 100;
            int x = (int)per;
            int x1 = (int)per1;
            region[6] = x;
            region[7] = x1;
        }

    }


    /**
     * Main method that runs the program
     * 
     * @param args0
     *            the array that contains the files needed for running
     */

    @SuppressWarnings("unused")
    public static void main(String args0[]) {
        File personFile = new File(args0[0]);
        File songFile = new File(args0[1]);
        Input input = new Input(songFile, personFile);
    }

}
