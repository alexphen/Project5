package prj5;

/**
 * 
 * @author Adam Tapp adamt
 * @version 04/13/2017
 *
 */
public class Song {

    /**
     * Array that contains listens and likes for hobbies
     * (even indexes are listens; odd indexes are likes)
     */
    private int[] hobbies;

    /**
     * Array that contains listens and likes for majors
     * (even indexes are listens; odd indexes are likes)
     */
    private int[] major;

    /**
     * Array that contains listens and likes for state
     * (even indexes are listens; odd indexes are likes)
     */
    private int[] state;

    /**
     * The name of the artist that wrote this song
     */
    private String artistName;

    /**
     * The title of this song
     */
    private String songTitle;

    /**
     * The year this song was released
     */
    private int yearReleased;

    /**
     * The genre of this song
     */
    private String genre;


    /**
     * The defualt constructor for this class
     */
    public Song() {
        this("Don't Stop Believing", "Billy Joel", 1925, "HipHop");
    }


    /**
     * Custom Constructor
     * 
     * @param artistName
     *            the name of the artist who wrote this song
     * @param songTitle
     *            the title of this song
     * @param yearReleased
     *            the year this song was released
     * @param genre
     *            the genre of this song
     */
    public Song(
        String songTitle,
        String artistName,
        int yearReleased,
        String genre) {

        this.songTitle = songTitle;
        this.artistName = artistName;
        this.yearReleased = yearReleased;
        this.genre = genre;

        hobbies = new int[8];
        major = new int[8];
        state = new int[8];
    }


    /**
     * Returns the artistName
     * 
     * @return String
     *         the artistName
     */
    public String getArtistName() {
        return artistName;
    }


    /**
     * Returns the songTitle
     * 
     * @return String the songTitle
     */
    public String getSongTitle() {
        return songTitle;
    }


    /**
     * Return the yearReleased
     * 
     * @return int the year this song was released
     */
    public int getYearReleased() {
        return yearReleased;
    }


    /**
     * Return the genre
     * 
     * @return String the genre of this song
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Return the array of hobby listens and likes
     * 
     * @return int[] that holds listens and likes for hobby
     */
    public int[] getHobbies() {
        return hobbies;
    }


    /**
     * Return the array of major listens and likes
     * 
     * @return int[] that holds listens and likes for majors
     */
    public int[] getMajor() {
        return major;
    }


    /**
     * Return the array of state listens and likes
     * 
     * @return int[] that holds listens and likes for state
     */
    public int[] getState() {
        return state;
    }


    /**
     * Returns a readable string representation of this song
     * 
     * @return String a readable string of this song
     */
    public String toString() {
        String strSong = songTitle + "," + artistName + "," + yearReleased + ","
            + genre;
        return strSong;
    }

}
