/**
 * 
 */
package musicpreference;

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


    /**
     * Initializes fields
     */
    public void setUp() {
        gl = new GlyphList();
        song1 = GlyphList.defaultSong;
        song2 = GlyphList.defaultSong1;
        song3 = GlyphList.defaultSong2;
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
        gl.add(new Glyph(song1, 1, 1));
        gl.add(new Glyph(song2, 1, 1));
        gl.add(new Glyph(song3, 1, 1));

        gl.sortArtist();
        assertEquals(gl.get(0).getSong(), song2);
        assertEquals(gl.get(1).getSong(), song3);
        assertEquals(gl.get(2).getSong(), song1);
    }


    /**
     * Tests sortGenre method
     */
    public void testSortGenre() {
        gl.add(new Glyph(song1, 1, 1));
        gl.add(new Glyph(song2, 1, 1));
        gl.add(new Glyph(song3, 1, 1));

        gl.sortGenre();
        assertEquals(gl.get(0).getSong(), song1);
        assertEquals(gl.get(1).getSong(), song2);
        assertEquals(gl.get(2).getSong(), song3);
    }


    /**
     * Tests sortTitle method
     */
    public void testSortTitle() {
        gl.add(new Glyph(song1, 1, 1));
        gl.add(new Glyph(song2, 1, 1));
        gl.add(new Glyph(song3, 1, 1));

        gl.sortTitle();
        assertEquals(gl.get(0).getSong(), song1);
        assertEquals(gl.get(1).getSong(), song3);
        assertEquals(gl.get(2).getSong(), song2);
    }


    /**
     * Tests sort year method
     */
    public void testSortYear() {
        gl.add(new Glyph(song1, 1, 1));
        gl.add(new Glyph(song2, 1, 1));
        gl.add(new Glyph(song3, 1, 1));

        gl.sortYear();
        assertEquals(gl.get(0).getSong(), song3);
        assertEquals(gl.get(1).getSong(), song1);
        assertEquals(gl.get(2).getSong(), song2);
    }


    /**
     * Tests toArray method
     */
    public void testToArray() {
        Glyph g1 = new Glyph(song1, 1, 1);
        Glyph g2 = new Glyph(song2, 1, 1);
        Glyph g3 = new Glyph(song3, 1, 1);

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
        gl.add(new Glyph(song1, 1, 1));
        gl.add(new Glyph(song2, 1, 1));
        gl.add(new Glyph(song3, 1, 1));

        assertEquals(gl.toString(),
            "[All These Things I've Done Glyph, Upside Down Glyph, Uma Thurman Glyph]");
    }
}
