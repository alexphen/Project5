/**
 * 
 */
package prj5;

import java.util.Iterator;

/**
 * @author aphen
 * @version <4/13/17>
 */
public class GlyphListTest extends student.TestCase {

    /**
     * Fields
     */
    private GlyphList gl;
    private Song song1;
    private Song song2;
    private Song song3;
    private Iterator<Glyph> iter;
    private Glyph g1;
    private Glyph g2;
    private Glyph g3;

    /**
     * Initiializes fields
     */
    public void setUp() {
        gl = new GlyphList();
        song1 = GlyphList.defaultSong;
        song2 = GlyphList.defaultSong1;
        song3 = GlyphList.defaultSong2;
        iter = gl.iterator();
        g1 = new Glyph(song1, 1, 1);
        g2 = new Glyph(song2, 1, 1);
        g3 = new Glyph(song3, 1, 1);
    }
    
    /**
     * Tests default glyph list
     */
    public void testDefaultGlyphList() {
        gl.add(g1);
        gl.add(g2);
        gl.add(g3);
        GlyphList defGL = GlyphList.defaultGlyphList();
        
        for (int i = 0; i < 3; i++) {
            assertEquals(defGL.get(i).getSong(), gl.get(i).getSong());
        }
    }

    /**
     * Tests add method
     */
    public void testAdd() {
        gl.add(new Glyph(song1, 1, 1));
        assertEquals(gl.size(), 1);
        gl.add(new Glyph(song2, 1, 1));
        assertEquals(gl.size(), 2);
        gl.add(new Glyph(song3, 1, 1));
        assertEquals(gl.size(), 3);
    }

    /**
     * Tests sortArtist method
     */
    public void testSortArtist() {
        gl.add(g1);
        gl.add(g2);
        gl.add(g3);

        gl.sortArtist();
        gl.setSorts("A");
        assertEquals(gl.get(0).getSong(), song2);
        assertEquals(gl.get(1).getSong(), song3);
        assertEquals(gl.get(2).getSong(), song1);
    }


    /**
     * Tests sortGenre method
     */
    public void testSortGenre() {
        gl.add(g1);
        gl.add(g2);
        gl.add(g3);

        gl.sortGenre();
        gl.setSorts("G");
        assertEquals(gl.get(0).getSong(), song1);
        assertEquals(gl.get(1).getSong(), song2);
        assertEquals(gl.get(2).getSong(), song3);
    }


    /**
     * Tests sortTitle method
     */
    public void testSortTitle() {
        gl.add(g1);
        gl.add(g2);
        gl.add(g3);

        gl.sortTitle();
        gl.setSorts("A");
        assertEquals(gl.get(0).getSong(), song1);
        assertEquals(gl.get(1).getSong(), song3);
        assertEquals(gl.get(2).getSong(), song2);
    }


    /**
     * Tests sortYear method
     */
    public void testSortYear() {
        gl.add(g1);
        gl.add(g2);
        gl.add(g3);

        gl.sortYear();
        gl.setSorts("Y");
        assertEquals(gl.get(0).getSong(), song3);
        assertEquals(gl.get(1).getSong(), song1);
        assertEquals(gl.get(2).getSong(), song2);
    }


    /**
     * Tests toArray method
     */
    public void testToArray() {
        gl.add(g1);
        gl.add(g2);
        gl.add(g3);

        Object[] arr = gl.toArray();
        Glyph[] glyphArr = { g1, g2, g3 };
        for (int i = 0; i < 3; i++) {
            assertEquals(arr[i], glyphArr[i]);
        }
    }


    /**
     * Tests toString method
     */
    public void testToString() {
        gl.add(g1);
        gl.add(g2);
        gl.add(g3);

        assertEquals(gl.toString(),
            "[All These Things I've Done Glyph, Upside Down Glyph, Uma Thurman Glyph]");
    }
    
    /**
     * Tests iterator
     */
    public void testIter() {
        gl.add(g1);
        gl.add(g2);
        gl.add(g3);
        
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), g1);
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), g2);
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), g3);
        assertFalse(iter.hasNext());
    }
}
