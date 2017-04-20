/**
 * 
 */
package prj5;

import java.util.Iterator;

/**
 * @author aphen
 * @version <4/13/17>
 */
public class SongListTest extends student.TestCase {

    private SongList sl;
    private Song song1;
    private Song song2;
    private Song song3;
    private Iterator<Song> iter;


    /**
     * Initializes fields
     */
    public void setUp() {
        sl = new SongList();
        song1 = GlyphList.defaultSong;
        song2 = new Song("Upside Down", "Diana Ross", 1980, "Disco");
        song3 = new Song("Uma Thurman", "Fall Out Boy", 2015, "Rock");
        iter = sl.iterator();
    }


    /**
     * Tests add method
     */
    public void testAdd() {
        sl.add(song1);
        assertEquals(sl.size(), 1);
        sl.add(song2);
        assertEquals(sl.size(), 2);
        sl.add(song3);
        assertEquals(sl.size(), 3);
    }


    /**
     * Tests toString method
     */
    public void testToString() {
        sl.add(song1);
        sl.add(song2);
        sl.add(song3);

        assertEquals(sl.toString(),
            "[All These Things I've Done,The Killers,2005,Alternative; "
            + "Upside Down,Diana Ross,1980,Disco; "
            + "Uma Thurman,Fall Out Boy,2015,Rock]");
    }

    /**
     * Tests toArray method
     */
    public void testToArray() {
        sl.add(song1);
        sl.add(song2);
        sl.add(song3);

        Object[] arr = sl.toArray();
        Song[] songArr = { song1, song2, song3 };
        for (int i = 0; i < 3; i++) {
            assertEquals(arr[i], songArr[i]);
        }
    }
    
    /**
     * Tests use of iterator
     */
    public void testIter() {
        sl.add(song1);
        sl.add(song2);
        sl.add(song3);

        assertTrue(iter.hasNext());
        assertEquals(iter.next(), song1);
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), song2);
        assertTrue(iter.hasNext());
        assertEquals(iter.next(), song3);
        assertFalse(iter.hasNext());
    }

}
