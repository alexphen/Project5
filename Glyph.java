package prj5;

import java.awt.Color;
import java.util.NoSuchElementException;
import CS2114.Shape;
import CS2114.TextShape;

/**
 * 
 * @author Adam Tapp adamt
 * @version 04/18/17
 */

public class Glyph extends DLList<Shape> {

    /**
     * The list of shapes for this glyph
     */
    private DLList<Shape> glyphList;
    /**
     * String for sort
     */
    private String sort;
    /**
     * The song associated with this glyph
     */
    private Song song;

    /**
     * The array of listen and like values associated with each enum
     * depending on which boolean (hobby, major, state) is true
     */
    private int[] listenLike;

    /**
     * The boolean for when the window is sorting by hobby
     */
    private boolean hobby;

    /**
     * The boolean for when the window is sorting by major
     */
    private boolean major;

    /**
     * The boolean for when the window is sorting by state
     */
    private boolean state;

    /**
     * The listen side of the top bar
     */
    private Bar listen1;

    /**
     * The like side of the top bar
     */
    private Bar like1;

    /**
     * The listen side of bar 2
     */
    private Bar listen2;

    /**
     * The like side of bar 2
     */
    private Bar like2;

    /**
     * the listen side of bar 3
     */
    private Bar listen3;

    /**
     * The like side of bar 3
     */
    private Bar like3;

    /**
     * The listen side of bar 4
     */
    private Bar listen4;

    /**
     * The like side of bar 4
     */
    private Bar like4;

    private final int WIDTH = 200;
    private final int HEIGHT = 200;


    /**
     * The constructor for the glyph class
     * 
     * @param song
     *            is the song assiciated with this glyph
     * @param x
     *            is the x coordinate of this glyph
     * @param y
     *            is the y coordinate of this glyph
     */
    public Glyph(Song song, int x, int y) {

        this.song = song;
        listenLike = new int[8];
        glyphList = new DLList<>();
        Shape border = new Shape(x, y, WIDTH, HEIGHT, Color.WHITE);
        border.setForegroundColor(Color.BLACK);
        TextShape title = new TextShape(x, y + 10, song.getSongTitle());
        title.move((WIDTH / 2) - (title.getWidth() / 2), 0);
        title.setBackgroundColor(Color.WHITE);
        setSort("A");
        TextShape subtitle = new TextShape(x, y + 30, sort);
        subtitle.setBackgroundColor(Color.WHITE);
        subtitle.move((WIDTH / 2) - (title.getWidth() / 2), 0);

        this.add(subtitle);
        this.add(title);
        this.add(border);
    }


    /**
     * Sets the sort for this glyph
     * 
     * @param str
     *            identifies what sort
     */

    public void setSort(String str) {
        if (str.equals("A")) {
            sort = "by " + this.getSong().getArtistName();
        }
        else if (str.equals("Y")) {
            sort = "Released: " + this.getSong().getYearReleased();
        }
        else if (str.equals("G")) {
            sort = "Genre: " + this.getSong().getGenre();
        }
    }


    /**
     * Returns the song associated with this glyph object
     * 
     * @return Song the song associated with this glyph
     */
    public Song getSong() {
        return song;
    }


    /**
     * returns the song associated with this glyph
     * @return String the song associated with this glyph
     */
    public String toString() {
        return song.getSongTitle() + " Glyph";
    }


    /**
     * Get hobby, for testing purposes
     * 
     * @return boolean the value of hobby
     */
    public boolean getHobby() {
        return hobby;
    }


    /**
     * Get major, for testing purposes
     * 
     * @return boolean the value of major
     */
    public boolean getMajor() {
        return major;
    }


    /**
     * Get state, for testing purposes
     * 
     * @return boolean the value of state
     */
    public boolean getState() {
        return state;
    }


    /**
     * Gets the listenLike array, for testing purposes
     * 
     * @return int[] the ListenLike array
     */
    public int[] getListenLike() {
        return listenLike;
    }


    /**
     * Gets the listOfShapes, for testing purposes
     * 
     * @return DLList<Shape> the glyphList of shapes
     */
    public DLList<Shape> getGlyphShapes() {
        return glyphList;
    }


    /**
     * Getter for sort
     * @return String 
     *          the sort string
     */
    public String getSort() {
        return sort;
    }


    /**
     * Updates the array of listenLike
     * Updates the booleans
     * Updates the bars
     * 
     * @param num
     *            represents what bars need to be shown
     *            1 for hobby
     *            2 for major
     *            3 for state
     */
    public void update(int num) {
        updateBools(num);
        updateListenLike();
        updateBars();
    }


    /**
     * Changes the boolean variables
     * 
     * @param num
     *            determines what boolean will become true
     */
    private void updateBools(int num) {

        switch (num) {
            case 1:
                hobby = true;
                major = false;
                state = false;
                break;
            case 2:
                hobby = false;
                major = true;
                state = false;
                break;
            case 3:
                hobby = false;
                major = false;
                state = true;
                break;
            default:
                hobby = false;
                major = false;
                state = false;
                break;
        }
    }


    /**
     * Changes the values in listen and like
     */
    private void updateListenLike() {
        if (hobby) {
            listenLike = song.getHobbies();
        }
        else if (major) {
            listenLike = song.getMajor();
        }
        else if (state) {
            listenLike = song.getState();
        }
        else {
            listenLike = null;
        }
    }


    /**
     * Changes the size of the bars
     * possibly need to change the bars in
     */
    private void updateBars() {
        if (listenLike != null) {
            listen1 = new Bar(listenLike[0]);
            like1 = new Bar(listenLike[1]);
            listen2 = new Bar(listenLike[2]);
            like2 = new Bar(listenLike[3]);
            listen3 = new Bar(listenLike[4]);
            like3 = new Bar(listenLike[5]);
            listen4 = new Bar(listenLike[6]);
            like4 = new Bar(listenLike[7]);

            glyphList.add(listen1);
            glyphList.add(like1);
            glyphList.add(listen2);
            glyphList.add(like2);
            glyphList.add(listen3);
            glyphList.add(like3);
            glyphList.add(listen4);
            glyphList.add(like4);
        }
        else {
            throw new NoSuchElementException();
        }
    }
}
