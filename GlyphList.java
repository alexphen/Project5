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


    public GlyphList() {
        super();
    }


    public GlyphListIterator iterator() {
        return new GlyphListIterator();
    }


    public static GlyphList defaultGlyphList() {
        GlyphList dGL = new GlyphList();
        dGL.add(new Glyph(100, 100, 100, defaultSong));
        return dGL;
    }

    

    public void sortArtist() {
        for (int i = 1; i < this.size(); i++) {
            for (int k = i; k > 0; k--) {
                Glyph curr = this.get(k);
                Glyph before = this.get(k - 1);
                if (curr.getSong().getArtist().compareTo(before.getSong()
                    .getArtist()) < 0) {
                    swapWithBefore(k);
                }
            }
        }
    }


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


    public void sortTitle() {
        for (int i = 1; i < this.size(); i++) {
            for (int k = i; k > 0; k--) {
                Glyph curr = this.get(k);
                Glyph before = this.get(k - 1);
                if (curr.getSong().getTitle().compareTo(before.getSong()
                    .getTitle()) < 0) {
                    swapWithBefore(k);
                }
            }
        }
    }


    public void sortYear() {
        for (int i = 1; i < this.size(); i++) {
            for (int k = i; k > 0; k--) {
                Glyph curr = this.get(k);
                Glyph before = this.get(k - 1);
                if (curr.getSong().getYear() > before.getSong().getYear()) {
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
