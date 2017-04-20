/**
 * 
 */
package musicpreference;

/**
 * @author aphen
 * @version <4/12/17>
 */
public class SongList extends DLList<Song> {

    /**
     * Constructor, calls DLList constructor
     */
    public SongList() {
        super();
    }


    /**
     * @return SongListIterator
     */
    public SongListIterator iterator() {
        return new SongListIterator();
    }


    /**
     * @return String representation of list
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (!isEmpty()) {

            for (int i = 0; i < this.size(); i++) {
                builder.append(this.get(i).toString());
                if (i != size() - 1) {
                    builder.append("; ");
                }
            }
        }
        builder.append("]");
        return builder.toString();
    }

    /**
     * Song list iterator inner class
     * @author aphen
     * @version <4/17/17
     */
    private class SongListIterator extends DLListIterator<Song> {

        /**
         * Constructor
         */
        public SongListIterator() {
            super();
        }

        /**
         * @return True if there exists a next value
         */
        public boolean hasNext() {
            return super.hasNext();
        }

        /**
         * @return the next song in the list
         */
        public Song next() {
            return super.next();
        }
    }
}
