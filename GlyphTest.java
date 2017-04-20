package prj5;

import java.util.NoSuchElementException;
import CS2114.Shape;

/**
 * 
 * @author Adam Tapp adamt
 * @version 04/18/2017
 */
public class GlyphTest extends student.TestCase {
    /**
     * Glyph for testing
     */
    private Glyph glyph;

    /**
     * Song for Testing
     */
    private Song song;


    /**
     * Sets up the initial conditions for testing
     */
    public void setUp() {
        song = new Song();
        glyph = new Glyph(song, 1, 1);
    }


    /**
     * Tests get song, which gets the song associated with this glyph
     */
    public void testGetSong() {
        Song song1 = glyph.getSong();
        assertEquals("Don't Stop Believing,Billy Joel,1925,HipHop", song1
            .toString());
        glyph.setSort("A");
        assertEquals("by Billy Joel", glyph.getSort());
        glyph.setSort("Y");
        assertEquals("Released: 1925", glyph.getSort());
        glyph.setSort("G");
        assertEquals("Genre: HipHop", glyph.getSort());
        
        glyph.setSort("B");
        assertEquals("Genre: HipHop", glyph.getSort());
        
        
        
        assertEquals("Don't Stop Believing Glyph", glyph.toString());
    }


    /**
     * Tests update, which changes the booleans, array of listen and like values
     * and updates the bar sizes
     */
    public void testUpdateBools() {
        // Adds fake values to the arrays of the song
        song.getHobbies()[0] = 100;
        song.getHobbies()[1] = 83;
        song.getHobbies()[2] = 38;
        song.getHobbies()[3] = 23;
        song.getHobbies()[4] = 92;
        song.getHobbies()[5] = 23;
        song.getHobbies()[6] = 45;
        song.getHobbies()[7] = 34;

        song.getMajor()[0] = 55;
        song.getMajor()[1] = 21;
        song.getMajor()[2] = 70;
        song.getMajor()[3] = 52;
        song.getMajor()[4] = 91;
        song.getMajor()[5] = 32;
        song.getMajor()[6] = 70;
        song.getMajor()[7] = 21;

        song.getState()[0] = 68;
        song.getState()[1] = 12;
        song.getState()[2] = 32;
        song.getState()[3] = 12;
        song.getState()[4] = 65;
        song.getState()[5] = 7;
        song.getState()[6] = 97;
        song.getState()[7] = 54;

        // Case 1: When the number isn't 1-3
        try {
            glyph.update(4);
        }
        catch (NoSuchElementException e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }
        assertFalse(glyph.getHobby());
        assertFalse(glyph.getMajor());
        assertFalse(glyph.getState());

        glyph.update(1);
        assertTrue(glyph.getHobby());
        assertFalse(glyph.getMajor());
        assertFalse(glyph.getState());

        glyph.update(2);
        assertFalse(glyph.getHobby());
        assertTrue(glyph.getMajor());
        assertFalse(glyph.getState());

        glyph.update(3);
        assertFalse(glyph.getHobby());
        assertFalse(glyph.getMajor());
        assertTrue(glyph.getState());
    }


    /**
     * Tests update, which changes the booleans, array of listen and like values
     * and updates the bar sizes
     */
    public void testUpdateListenLike() {
        // Adds fake values to the arrays of the song
        song.getHobbies()[0] = 100;
        song.getHobbies()[1] = 83;
        song.getHobbies()[2] = 38;
        song.getHobbies()[3] = 23;
        song.getHobbies()[4] = 92;
        song.getHobbies()[5] = 23;
        song.getHobbies()[6] = 45;
        song.getHobbies()[7] = 34;

        song.getMajor()[0] = 55;
        song.getMajor()[1] = 21;
        song.getMajor()[2] = 70;
        song.getMajor()[3] = 52;
        song.getMajor()[4] = 91;
        song.getMajor()[5] = 32;
        song.getMajor()[6] = 70;
        song.getMajor()[7] = 21;

        song.getState()[0] = 68;
        song.getState()[1] = 12;
        song.getState()[2] = 32;
        song.getState()[3] = 12;
        song.getState()[4] = 65;
        song.getState()[5] = 7;
        song.getState()[6] = 97;
        song.getState()[7] = 54;

        int[] hobby = song.getHobbies();
        int[] major = song.getMajor();
        int[] state = song.getState();

        // Ensures the correct array is accessed based on which boolean is true
        glyph.update(1);
        assertTrue(glyph.getListenLike().equals(hobby));

        glyph.update(2);
        assertTrue(glyph.getListenLike().equals(major));

        glyph.update(3);
        assertTrue(glyph.getListenLike().equals(state));

        try {
            glyph.update(4);
        }
        catch (NoSuchElementException e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }
        assertNull(glyph.getListenLike());

    }


    /**
     * Tests update, which changes the booleans, array of listen and like values
     * and updates the bar sizes
     */
    public void testUpdateBars1() {
        // Adds fake values to the arrays of the song
        song.getHobbies()[0] = 100;
        song.getHobbies()[1] = 83;
        song.getHobbies()[2] = 38;
        song.getHobbies()[3] = 23;
        song.getHobbies()[4] = 92;
        song.getHobbies()[5] = 23;
        song.getHobbies()[6] = 45;
        song.getHobbies()[7] = 34;
        glyph.update(1);
        DLList<Shape> list = glyph.getGlyphShapes();

        assertEquals(100, list.get(0).getWidth());
        assertEquals(83, list.get(1).getWidth());
        assertEquals(38, list.get(2).getWidth());
        assertEquals(23, list.get(3).getWidth());
        assertEquals(92, list.get(4).getWidth());
        assertEquals(23, list.get(5).getWidth());
        assertEquals(45, list.get(6).getWidth());
        assertEquals(34, list.get(7).getWidth());

    }


    /**
     * Tests update, which changes the booleans, array of listen and like values
     * and updates the bar sizes
     */
    public void testUpdateBars2() {
        song.getMajor()[0] = 55;
        song.getMajor()[1] = 21;
        song.getMajor()[2] = 70;
        song.getMajor()[3] = 52;
        song.getMajor()[4] = 91;
        song.getMajor()[5] = 32;
        song.getMajor()[6] = 70;
        song.getMajor()[7] = 21;

        glyph.update(2);
        DLList<Shape> list = glyph.getGlyphShapes();

        assertEquals(55, list.get(0).getWidth());
        assertEquals(21, list.get(1).getWidth());
        assertEquals(70, list.get(2).getWidth());
        assertEquals(52, list.get(3).getWidth());
        assertEquals(91, list.get(4).getWidth());
        assertEquals(32, list.get(5).getWidth());
        assertEquals(70, list.get(6).getWidth());
        assertEquals(21, list.get(7).getWidth());
    }


    /**
     * Tests update, which changes the booleans, array of listen and like values
     * and updates the bar sizes
     */
    public void testUpdateBars3() {
        song.getState()[0] = 68;
        song.getState()[1] = 12;
        song.getState()[2] = 32;
        song.getState()[3] = 12;
        song.getState()[4] = 65;
        song.getState()[5] = 7;
        song.getState()[6] = 97;
        song.getState()[7] = 54;

        glyph.update(3);
        DLList<Shape> list = glyph.getGlyphShapes();

        assertEquals(68, list.get(0).getWidth());
        assertEquals(12, list.get(1).getWidth());
        assertEquals(32, list.get(2).getWidth());
        assertEquals(12, list.get(3).getWidth());
        assertEquals(65, list.get(4).getWidth());
        assertEquals(7, list.get(5).getWidth());
        assertEquals(97, list.get(6).getWidth());
        assertEquals(54, list.get(7).getWidth());
    }

}
