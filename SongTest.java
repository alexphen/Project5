package musicpreference;

/**
 * 
 * @author Adam Tapp adamt
 * @version 04/13/2017
 */
public class SongTest extends student.TestCase {

    /**
     * Initial Song field for testing
     */
    Song song;


    /**
     * Sets up the initial conditions for testing
     */
    public void setUp() {
        song = new Song();
    }


    /**
     * Tests the get methods
     */
    public void testGets() {
        assertEquals("Billy Joel", song.getArtistName());
        assertEquals("Don't Stop Believing", song.getSongTitle());
        assertEquals(1925, song.getYearReleased());
        assertEquals("HipHop", song.getGenre());
        assertEquals(6, song.getState().length);
        assertEquals(6, song.getHobbies().length);
        assertEquals(6, song.getMajor().length);
        assertEquals("Don't Stop Believing, Billy Joel, 1925, HipHop", song
            .toString());
    }

}
