package prj5;

import java.awt.Color;
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
    private static final int BAR_HEIGHT = 25;


    /**
     * Bar constructor
     * @param width width of this bar
     */
    public Bar(int width, Color c) {
        super(0, 0, width, BAR_HEIGHT, c);
    }
}
