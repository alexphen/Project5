/**
 * 
 */
package musicpreference;

/**
 * @author aphen
 * @version <4/12/17>
 */
public class GlyphList extends DLList<Glyph> {
    public static Song defaultSong = new Song("All These Things I've Done",
        "The Killers", 2005, "Alternative");
    public static Song defaultSong1 = new Song("Upside Down", "Diana Ross",
        1980, "disco");
    public static Song defaultSong2 = new Song("Uma Thurman", "Fall Out Boy",
        2015, "rock");
    private static final int START = 50;


    public GlyphList() {
        super();
    }
    
    public void setSorts(String str) {
        for (int i = 0; i < size(); i++) {
            this.get(i).setSort(str);
        }
    }


    public GlyphListIterator iterator() {
        return new GlyphListIterator();
    }


    public static GlyphList defaultGlyphList() {
        GlyphList dGL = new GlyphList();
        defaultSong.setDefaultArr();
        defaultSong1.setDefaultArr();
        defaultSong2.setDefaultArr();
        dGL.add(new Glyph(defaultSong, START, START));
        dGL.add(new Glyph(defaultSong1, START, START));
        dGL.add(new Glyph(defaultSong2, START, START));
        dGL.add(new Glyph(defaultSong, START, START));
        dGL.add(new Glyph(defaultSong1, START, START));
        dGL.add(new Glyph(defaultSong2, START, START));
        dGL.add(new Glyph(defaultSong2, START, START));
        /*dGL.add(new Glyph(defaultSong2, START, START));
        dGL.add(new Glyph(defaultSong2, START, START));
        dGL.add(new Glyph(defaultSong2, START, START));
        dGL.add(new Glyph(defaultSong2, START, START));
        dGL.add(new Glyph(defaultSong2, START, START));*/
        return dGL;
    }


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


    private class GlyphListIterator extends DLListIterator<Glyph> {

        public GlyphListIterator() {
            super();
        }


        public boolean hasNext() {
            return super.hasNext();
        }


        public Glyph next() {
            return super.next();
        }
    }

}
