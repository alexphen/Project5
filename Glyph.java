package itemclasses;

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
     * Border of the Glyph
     */
    private Shape border;

    /**
     * Title for the glyph
     */
    private TextShape title;

    /**
     * List of shapes for this glyph
     */
    private DLList<Shape> glyphShapes;

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

    private final int WIDTH = 100;
    private final int HEIGHT = 100;


    /**
     * The constructor for the glyph class
     */
    public Glyph(Song song, int x, int y) {
        glyphShapes = new DLList<>();
        this.song = song;
        listenLike = new int[6];
        border = new Shape(x, y, WIDTH, HEIGHT, Color.WHITE);
        title = new TextShape(x + 5, y + 5, song.getSongTitle() + "\nby the"
            + song.getArtistName());
        title.setBackgroundColor(Color.WHITE);
        glyphShapes.add(border);
        glyphShapes.add(title);
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
     */
    public String getSongString() {
        return song.toString();
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
            like1 = new Bar((listenLike[1] / listenLike[0]) * 100);
            listen2 = new Bar(listenLike[2]);
            like2 = new Bar((listenLike[3] / listenLike[2]) * 100);
            listen3 = new Bar(listenLike[4]);
            like3 = new Bar((listenLike[5] / listenLike[4]) * 100);
            listen4 = new Bar(listenLike[6]);
            like4 = new Bar((listenLike[7] / listenLike[6]) * 100);

            glyphShapes.add(listen1);
            glyphShapes.add(like1);
            glyphShapes.add(listen2);
            glyphShapes.add(like2);
            glyphShapes.add(listen3);
            glyphShapes.add(like3);
            glyphShapes.add(listen4);
            glyphShapes.add(like4);
        }
        else {
            throw new NoSuchElementException();
        }
    }
}
