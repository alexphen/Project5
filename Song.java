/**
 * 
 */
package musicpreference;

/**
 * @author aphen
 *
 */
public class Song {

    private String title;
    private String artist;
    private int year;
    private String genre;
    
    public Song(String t, String a, int y, String g) {
        setTitle(t);
        setArtist(a);
        setYear(y);
        setGenre(g);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String toString() {
        return title;
    }
    
}
