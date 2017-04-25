
package prj5;

import java.awt.Color;
import java.awt.Window;
import CS2114.Shape;
import CS2114.TextShape;

/**
 * 
 * @author Adam Tapp adamt
 * @version 04/18/17
 */

public class Glyph extends DLList<Shape> {

    /**
     * Int used for updating glyphs
     */
    public static int rep;

    /**
     * The shapes associated with this glyph
     */
    private Shape border;
    private Shape divider;
    private TextShape title;
    private TextShape subtitle;
    private static String sort;
    private DLList<Shape> glyph;

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
    private boolean region;

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


    /**
     * The constructor for the glyph class
     */
    public Glyph(Song song, int x, int y) {
        this.song = song;
        listenLike = new int[8];
        border = new Shape(x, y, 0, 0);

        title = new TextShape(0, 0, song.getSongTitle());
        title.setBackgroundColor(Color.WHITE);
        subtitle = new TextShape(0, 0, sort);
        setSort("A");
        subtitle.setBackgroundColor(Color.WHITE);
        this.setLocs();
        this.update();

        this.add(border);
        this.add(subtitle);
        this.add(title);
        this.add(divider);
    }


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
        subtitle.setText(sort);
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
     * Returns border of Glyph
     */
    public Shape getBorder() {
        return border;
    }


    /**
     * Get hobby, for testing purposes
     * 
     * @return boolean the value of hobby
     *         Returns border of Glyph
     */
    public boolean getHobby() {
        return hobby;
    }


    /**
     * Get major, for testing purposes
     * 
     * @return boolean the value of major
     *         returns the song associated with this glyph
     */
    public boolean getMajor() {
        return major;
    }


    /**
     * Get region for testing purposes
     * 
     * @return boolean the value of region
     *         returns the song associated with this glyph
     */
    public boolean getRegion() {
        return region;
    }


    /**
     * returns the song associated with this glyph
     */
    public String toString() {
        return song.getSongTitle() + " Glyph";
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
    public void update() {
        updateBools(rep);
        updateListenLike();
        updateBars();

    }


    /**
     * @return Sort
     */
    public String getSort() {
        return sort;
    }


    /**
     * Sets the locations of the shapes in the Glyph
     */
    public void setLocs() {
        divider = new Shape(border.getX() + (WIDTH / 2) - 5, border.getY() + 60,
            10, 100, Color.BLACK);
        title.moveTo(border.getX() + (WIDTH / 2) - (title.getWidth() / 2),
            border.getY() + 10);
        subtitle.moveTo(border.getX() + (WIDTH / 2) - (subtitle.getWidth() / 2),
            border.getY() + 30);
    }


    /**
     * Sets the starting location f the Glyph
     */
    public void setStart(int x, int y) {
        border.setX(x);
        border.setY(y);
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
                region = false;
                break;
            case 2:
                hobby = false;
                major = true;
                region = false;
                break;
            case 3:
                hobby = false;
                major = false;
                region = true;
                break;
            default:
                hobby = false;
                major = false;
                region = false;
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
        else {
            listenLike = song.getState();
        }
    }


    /**
     * Changes the size of the bars
     * possibly need to change the bars in
     */
    private void updateBars() {
        listen1 = new Bar(listenLike[0], Color.pink);
        listen1.moveTo(divider.getX() - listen1.getWidth(), border.getY() + 60);
        like1 = new Bar(listenLike[1], Color.pink);
        like1.moveTo(divider.getX() + divider.getWidth(), border.getY() + 60);
        listen2 = new Bar(listenLike[2], Color.blue);
        listen2.moveTo(divider.getX() - listen2.getWidth(), border.getY() + 85);
        like2 = new Bar(listenLike[3], Color.blue);
        like2.moveTo(divider.getX() + divider.getWidth(), border.getY() + 85);
        listen3 = new Bar(listenLike[4], Color.orange);
        listen3.moveTo(divider.getX() - listen3.getWidth(), border.getY()
            + 110);
        like3 = new Bar(listenLike[5], Color.orange);
        like3.moveTo(divider.getX() + divider.getWidth(), border.getY() + 110);
        listen4 = new Bar(listenLike[6], Color.green);
        listen4.moveTo(divider.getX() - listen4.getWidth(), border.getY()
            + 135);
        like4 = new Bar(listenLike[7], Color.green);
        like4.moveTo(divider.getX() + divider.getWidth(), border.getY() + 135);

        this.add(listen1);
        this.add(like1);
        this.add(listen2);
        this.add(like2);
        this.add(listen3);
        this.add(like3);
        this.add(listen4);
        this.add(like4);
    }
}
