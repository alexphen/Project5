/**
 * 
 */
package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;

/**
 * @author aphen
 * @version <4/17/17>
 */
public class GUIKey extends DLList<Shape> {

    private Shape border;
    private TextShape title;
    private TextShape classification;
    private DLList<TextShape> legend;
    private TextShape heardLike;
    private Shape bar;

    private final static int HEIGHT = 200;
    private final static int WIDTH = 150;
    private final int STARTX = 1000;
    private final int STARTY = 450;


    public GUIKey(CategoryEnum cat) {
        border = new Shape(STARTX, STARTY, WIDTH, HEIGHT, Color.WHITE);
        border.setForegroundColor(Color.BLACK);
        title = new TextShape(STARTX + 5, STARTY + 5, cat + " Legend");
        title.setBackgroundColor(Color.WHITE);
        classification = new TextShape(STARTX + 40, STARTY + 105, "Song Title");
        classification.setBackgroundColor(Color.white);
        legend = setLegend(cat);
        heardLike = new TextShape(STARTX + 25, STARTY + 140, "Heard    Likes");
        heardLike.setBackgroundColor(Color.white);
        bar = new Shape(STARTX + 70, STARTY + 125, 10, 50, Color.BLACK);

        this.add(title);
        this.add(classification);
        for (int i = 0; i < 4; i++) {
            this.add(legend.get(i));
        }
        this.add(bar);
        this.add(heardLike);
        this.add(border);
    }


    private DLList<TextShape> setLegend(CategoryEnum cat) {
        TextShape pink = new TextShape(STARTX + 10, STARTY + 25, "", Color.PINK);
        pink.setBackgroundColor(Color.WHITE);
        TextShape blue = new TextShape(STARTX + 10, STARTY + 45, "", Color.BLUE);
        blue.setBackgroundColor(Color.white);
        TextShape orange = new TextShape(STARTX + 10, STARTY + 65, "",
            Color.orange);
        orange.setBackgroundColor(Color.white);
        TextShape green = new TextShape(STARTX + 10, STARTY + 85, "",
            Color.green);
        green.setBackgroundColor(Color.white);

        switch (cat) {
            case Hobby:
                pink.setText("Read");
                blue.setText("Art");
                orange.setText("Sports");
                green.setText("Music");
                break;
            case Major:
                pink.setText("Comp Sci");
                blue.setText("Other Eng");
                orange.setText("Math/CMDA");
                green.setText("Other");
                break;
            case Region:
                pink.setText("Northeast US");
                blue.setText("SouthEast US");
                orange.setText("Other US");
                green.setText("Outside US");
                break;
        }
        DLList<TextShape> textList = new DLList<TextShape>();
        textList.add(pink);
        textList.add(blue);
        textList.add(orange);
        textList.add(green);

        return textList;
    }
}
