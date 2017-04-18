/**
 * 
 */
package musicpreference;


/**
 * @author aphen
 * @version <4/12/17>
 */
public class SongList extends DLList<Song> {
    public SongList() {
        super();
    }
    
    public SongListIterator iterator() {
        return new SongListIterator();
    }
    
    private class SongListIterator extends DLListIterator<Song> {

        public SongListIterator() {
            super();
        }
        
        public boolean hasNext() {
            return super.hasNext();
        }
        
        public Song next() {
            return super.next();
        }
    }
}
