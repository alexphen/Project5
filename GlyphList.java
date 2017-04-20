/**
 * 
 */
package musicpreference;

/**
 * @author aphen
 * @version <4/12/17>
 */
public class GlyphList extends DLList<Glyph> {
    /**
     * Default song 1
     */
    public static Song defaultSong = new Song("All These Things I've Done",
        "The Killers", 2005, "Alternative");
    /**
     * Default song 2
     */
    public static Song defaultSong1 = new Song("Upside Down", "Diana Ross",
        1980, "disco");
    /**
     * Default song 3
     */
    public static Song defaultSong2 = new Song("Uma Thurman", "Fall Out Boy",
        2015, "rock");
    /**
     * Start position of Glyphs
     */
    private static final int START = 50;


    /**
     * Constructor, calls DLList constructor
     */
    public GlyphList() {
        super();
    }


    /**
     * Sets the sort method for the glyphs
     * 
     * @param str
     *            sort method, A = Artist and Title, G = Genre, Y = Year
     */
    public void setSorts(String str) {
        for (int i = 0; i < size(); i++) {
            this.get(i).setSort(str);
        }
    }


    /**
     * Creates new GlyphListIterator
     */
    public GlyphListIterator iterator() {
        return new GlyphListIterator();
    }


    /**
     * Default Glyphlist
     * 
     * @return the default glyphlist
     */
    public static GlyphList defaultGlyphList() {
        GlyphList dGL = new GlyphList();
        defaultSong.setDefaultArr();
        defaultSong1.setDefaultArr();
        defaultSong2.setDefaultArr();
        dGL.add(new Glyph(defaultSong, START, START));
        dGL.add(new Glyph(defaultSong1, START, START));
        dGL.add(new Glyph(defaultSong2, START, START));
        return dGL;
    }


    /**
     * Sort the list by artist
     */
    public void sortArtist() {
        for (int i = 1; i < this.size(); i++) {
            for (int k = i; k > 0; k--) {
                Glyph curr = this.get(k);
                curr.setSort("A");
                Glyph before = this.get(k - 1);
                if (curr.getSong().getArtistName().compareTo(before.getSong()
                    .getArtistName()) < 0) {
                    swapWithBefore(k);
                }
            }
        }
    }


    /**
     * Sort the list by Genre
     */
    public void sortGenre() {
        for (int i = 1; i < this.size(); i++) {
            for (int k = i; k > 0; k--) {
                Glyph curr = this.get(k);
                curr.setSort("G");
                Glyph before = this.get(k - 1);
                if (curr.getSong().getGenre().compareTo(before.getSong()
                    .getGenre()) < 0) {
                    swapWithBefore(k);
                }
            }
        }
    }


    /**
     * Sort the list by Title
     */
    public void sortTitle() {
        for (int i = 1; i < this.size(); i++) {
            for (int k = i; k > 0; k--) {
                Glyph curr = this.get(k);
                curr.setSort("A");
                Glyph before = this.get(k - 1);
                if (curr.getSong().getSongTitle().compareTo(before.getSong()
                    .getSongTitle()) < 0) {
                    swapWithBefore(k);
                }
            }
        }
    }


    /**
     * Sort the list by Year
     */
    public void sortYear() {
        for (int i = 1; i < this.size(); i++) {
            for (int k = i; k > 0; k--) {
                Glyph curr = this.get(k);
                curr.setSort("Y");
                Glyph before = this.get(k - 1);
                if (curr.getSong().getYearReleased() > before.getSong()
                    .getYearReleased()) {
                    swapWithBefore(k);
                }
            }
        }
    }


    /**
     * Glyph list iterator inner class
     * 
     * @author aphen
     * @version <4/17/17>
     */
    private class GlyphListIterator extends DLListIterator<Glyph> {

        /**
         * Iterator constructor
         */
        public GlyphListIterator() {
            super();
        }


        /**
         * True is there exists a next value
         */
        public boolean hasNext() {
            return super.hasNext();
        }


        /**
         * Returns the next value in the list
         */
        public Glyph next() {
            return super.next();
        }
    }

}
