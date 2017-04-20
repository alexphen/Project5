/**
 * 
 */
package prj5;

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
     * Glyph List Constructor
     */
    public GlyphList() {
        super();
    }


    /**
     * Sets sort method of list
     * 
     * @param str
     */
    public void setSorts(String str) {
        for (int i = 0; i < size(); i++) {
            this.get(i).setSort(str);
        }
    }


    /**
     * @return new iterator
     */
    public GlyphListIterator iterator() {
        return new GlyphListIterator();
    }


    /**
     * 
     * @return default GlyphList
     */
    public static GlyphList defaultGlyphList() {
        GlyphList dGL = new GlyphList();
        dGL.add(new Glyph(defaultSong, 100, 100));
        dGL.add(new Glyph(defaultSong1, 100, 100));
        dGL.add(new Glyph(defaultSong2, 100, 100));
        return dGL;
    }


    /**
     * Sort by artist
     */
    public void sortArtist() {
        for (int i = 1; i < this.size(); i++) {
            for (int k = i; k > 0; k--) {
                Glyph curr = this.get(k);
                Glyph before = this.get(k - 1);
                if (curr.getSong().getArtistName().compareTo(before.getSong()
                    .getArtistName()) < 0) {
                    swapWithBefore(k);
                }
            }
        }
    }


    /**
     * Sort by genre
     */
    public void sortGenre() {
        for (int i = 1; i < this.size(); i++) {
            for (int k = i; k > 0; k--) {
                Glyph curr = this.get(k);
                Glyph before = this.get(k - 1);
                if (curr.getSong().getGenre().compareTo(before.getSong()
                    .getGenre()) < 0) {
                    swapWithBefore(k);
                }
            }
        }
    }


    /**
     * Sort by title
     */
    public void sortTitle() {
        for (int i = 1; i < this.size(); i++) {
            for (int k = i; k > 0; k--) {
                Glyph curr = this.get(k);
                Glyph before = this.get(k - 1);
                if (curr.getSong().getSongTitle().compareTo(before.getSong()
                    .getSongTitle()) < 0) {
                    swapWithBefore(k);
                }
            }
        }
    }


    /**
     * Sort by year
     */
    public void sortYear() {
        for (int i = 1; i < this.size(); i++) {
            for (int k = i; k > 0; k--) {
                Glyph curr = this.get(k);
                Glyph before = this.get(k - 1);
                if (curr.getSong().getYearReleased() > before.getSong()
                    .getYearReleased()) {
                    swapWithBefore(k);
                }
            }
        }
    }


    /**
     * 
     * @author aphen
     * @version <4/16/17>
     */
    private class GlyphListIterator extends DLListIterator<Glyph> {

        /**
         * Iterator constructor
         */
        public GlyphListIterator() {
            super();
        }


        /**
         * @return true if there is a next value
         */
        public boolean hasNext() {
            return super.hasNext();
        }


        /**
         * @return next Glyph
         */
        public Glyph next() {
            return super.next();
        }
    }

}
