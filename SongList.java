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
