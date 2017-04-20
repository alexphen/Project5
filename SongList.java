/**
 * 
 */
package prj5;

/**
 * @author aphen
 * @version <4/12/17>
 */
public class SongList extends DLList<Song> {
    /**
     * Constructor for SongList
     */
    public SongList() {
        super();
    }


    /**
     * Iterator for SongList
     * 
     * @return SongListIterator is the iterator for this song list
     */
    public SongListIterator iterator() {
        return new SongListIterator();
    }


    /**
     * Prints a string of the the contents of the songList
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
     * 
     * @author Adam Tapp adamt
     * @version 04/19/2017
     */
    private class SongListIterator extends DLListIterator<Song> {
        /**
         * SongListIterator constructor
         */
        public SongListIterator() {
            super();
        }


        /**
         * Determines if the list has another entry
         * 
         * @return boolean {@code true} if there is another entry in the list
         *         {@code false} otherwise
         */
        public boolean hasNext() {
            return super.hasNext();
        }


        /**
         * Returns the next song in the list
         * 
         * @return Song the next song in the list
         */
        public Song next() {
            return super.next();
        }
    }
}
