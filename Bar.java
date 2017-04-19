package itemclasses;

import CS2114.Shape;

/**
 * 
 * @author Adam Tapp adamt
 * @version 04/17/17
 */
public class Bar extends Shape {

    /**
     * The width of every bar will be the same
     */
    private static final int BAR_HEIGHT = 10;


    /**
     * Bar constructor
     * @param width width of this bar
     */
    public Bar(int width) {
        super(0, 0, width, BAR_HEIGHT);
    }
}
