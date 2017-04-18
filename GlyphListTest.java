/**
 * 
 */
package musicpreference;

/**
 * @author aphen
 * @version <4/13/17>
 */
public class GlyphListTest extends student.TestCase {

    private GlyphList gl;
    private Song song1;
    private Song song2;
    private Song song3;


    public void setUp() {
        gl = new GlyphList();
        song1 = GlyphList.defaultSong;
        song2 = new Song("Upside Down", "Diana Ross", 1980, "disco");
        song3 = new Song("Uma Thurman", "Fall Out Boy", 2015, "rock");
    }


    public void testAdd() {
        gl.add(new Glyph(1, 1, 1, song1));
        assertEquals(gl.size(), 1);
        gl.add(new Glyph(1, 1, 1, song2));
        assertEquals(gl.size(), 2);
        gl.add(new Glyph(1, 1, 1, song3));
        assertEquals(gl.size(), 3);
    }


    public void testSortArtist() {
        gl.add(new Glyph(1, 1, 1, song1));
        gl.add(new Glyph(1, 1, 1, song2));
        gl.add(new Glyph(1, 1, 1, song3));

        gl.sortArtist();
        assertEquals(gl.get(0).getSong(), song2);
        assertEquals(gl.get(1).getSong(), song3);
        assertEquals(gl.get(2).getSong(), song1);
    }


    public void testSortGenre() {
        gl.add(new Glyph(1, 1, 1, song1));
        gl.add(new Glyph(1, 1, 1, song2));
        gl.add(new Glyph(1, 1, 1, song3));

        gl.sortGenre();
        assertEquals(gl.get(0).getSong(), song1);
        assertEquals(gl.get(1).getSong(), song2);
        assertEquals(gl.get(2).getSong(), song3);
    }


    public void testSortTitle() {
        gl.add(new Glyph(1, 1, 1, song1));
        gl.add(new Glyph(1, 1, 1, song2));
        gl.add(new Glyph(1, 1, 1, song3));

        gl.sortTitle();
        assertEquals(gl.get(0).getSong(), song1);
        assertEquals(gl.get(1).getSong(), song3);
        assertEquals(gl.get(2).getSong(), song2);
    }


    public void testSortYear() {
        gl.add(new Glyph(1, 1, 1, song1));
        gl.add(new Glyph(1, 1, 1, song2));
        gl.add(new Glyph(1, 1, 1, song3));

        gl.sortYear();
        assertEquals(gl.get(0).getSong(), song3);
        assertEquals(gl.get(1).getSong(), song1);
        assertEquals(gl.get(2).getSong(), song2);
    }


    public void testToArray() {
        Glyph g1 = new Glyph(1, 1, 1, song1);
        Glyph g2 = new Glyph(1, 1, 1, song2);
        Glyph g3 = new Glyph(1, 1, 1, song3);

        gl.add(g1);
        gl.add(g2);
        gl.add(g3);

        Object[] arr = gl.toArray();
        Glyph[] glyphArr = { g1, g2, g3 };
        for (int i = 0; i < 3; i++) {
            assertEquals(arr[i], glyphArr[i]);
        }
    }


    public void testToString() {
        gl.add(new Glyph(1, 1, 1, song1));
        gl.add(new Glyph(1, 1, 1, song2));
        gl.add(new Glyph(1, 1, 1, song3));

        assertEquals(gl.toString(),
            "[All These Things I've Done Glyph, Upside Down Glyph, Uma Thurman Glyph]");
    }
}
