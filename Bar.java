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
    private static final int BAR_WIDTH = 10;


    /**
     * Bar constructor
     * @param length length of this bar
     */
    public Bar(int length) {
        super(0, 0, length, BAR_WIDTH);
    }
}