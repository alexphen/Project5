/*
 * 
 */
package musicpreference;

import CS2114.Shape;

/**
 * @author aphen
 *
 */
public class Glyph extends Shape {
    private Song song;

    public Glyph(int x, int y, int size, Song sng) {
        super(x, y, size);
        song = sng;
    }
    
    public Song getSong() {
        return song;
    }
    
    public String toString() {
        return getSong().toString() + " Glyph";
    }

}
