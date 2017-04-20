/**
 * 
 */
package musicpreference;

import CS2114.Window;
import CS2114.Button;
import CS2114.Shape;
import CS2114.WindowSide;

/**
 * @author aphen
 * @version <4/17/17>
 */
public class GUIDisplayWindow {

    private Window window;
    private Button next;
    private Button prev;
    private Button artistName;
    private Button songTitle;
    private Button releaseYear;
    private Button genre;
    private Button hobby;
    private Button major;
    private Button region;
    private Button quit;
    private DLList<Shape> key;
    private GlyphList glyphs;
    private int page;
    private boolean started = false;
    private int rep;

    private static int STARTX = 50;
    private static int STARTY = 50;
    private static int xIncrement = 350;
    private static int yIncrement = 200;


    public GUIDisplayWindow() {
        this(GlyphList.defaultGlyphList());
    }


    public GUIDisplayWindow(GlyphList glyphs) {
        page = 0;
        this.glyphs = glyphs;

        window = new Window("Project 5");
        window.setSize(1200, 800);

        prev = new Button("< Prev");
        window.addButton(prev, WindowSide.NORTH);
        prev.disable();
        prev.onClick(this, "clickedPrev");

        artistName = new Button("Sort By Artist Name");
        window.addButton(artistName, WindowSide.NORTH);
        artistName.onClick(this, "clickedArtistName");

        songTitle = new Button("Sort By Song Title");
        window.addButton(songTitle, WindowSide.NORTH);
        songTitle.onClick(this, "clickedSongTitle");

        releaseYear = new Button("Sort By Release Year");
        window.addButton(releaseYear, WindowSide.NORTH);
        releaseYear.onClick(this, "clickedReleaseYear");

        genre = new Button("Sort By Genre");
        window.addButton(genre, WindowSide.NORTH);
        genre.onClick(this, "clickedGenre");

        next = new Button("Next >");
        window.addButton(next, WindowSide.NORTH);
        next.onClick(this, "clickedNext");
        if (glyphs.size() < 10) {
            next.disable();
        }

        hobby = new Button("Represent Hobby");
        window.addButton(hobby, WindowSide.SOUTH);
        hobby.onClick(this, "clickedHobby");

        major = new Button("Represent Major");
        window.addButton(major, WindowSide.SOUTH);
        major.onClick(this, "clickedMajor");

        region = new Button("Represent Region");
        window.addButton(region, WindowSide.SOUTH);
        region.onClick(this, "clickedRegion");

        quit = new Button("Quit");
        window.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this, "clickedQuit");

    }


    private void addShapeList(DLList<Shape> list) {
        for (int k = 0; k < list.size(); k++) {
            window.addShape(list.get(k));
        }
    }


    private void placeGlyphs() {
        if (page == glyphs.size() / 9) {
            for (int i = page * 9; i < glyphs.size() % 9; i++) {
                Glyph curr = glyphs.get(i);
                for (int k = 0; k < curr.size(); k++) {
                    curr.get(k).move(xIncrement * (i % 3), yIncrement * (i
                        / 3));
                    addShapeList(curr);
                }
            }
        }
        else {
            for (int i = page * 9; i < 9; i++) {
                Glyph curr = glyphs.get(i);
                for (int k = 0; k < curr.size(); k++) {
                    curr.get(k).move(xIncrement * (i % 3), yIncrement * (i
                        / 3));
                    addShapeList(curr);
                }
            }
        }
    }


    private void updateGlyphs(int rep) {
        if (page == glyphs.size() / 9) {
            for (int i = page * 9; i < glyphs.size() % 9; i++) {
                Glyph curr = glyphs.get(i);
                curr.update(rep);
                curr.setStart(STARTX + xIncrement * (i % 3), STARTY
                    + yIncrement * (i / 3));
                addShapeList(curr);
            }
        }
        else {
            for (int i = page * 9; i < 9; i++) {
                Glyph curr = glyphs.get(i);
                curr.getBorder().moveTo(STARTX + xIncrement * (i % 3), STARTY
                    + yIncrement * (i / 3));
                curr.update(rep);
                addShapeList(curr);
            }
        }
    }


    public void clickedPrev(Button button) {
        page--;
        updateGlyphs(rep);
        if (page == 0) {
            prev.disable();
        }
    }


    public void clickedNext(Button button) {
        page++;
        updateGlyphs(rep);
        prev.enable();
        if (page == glyphs.size() / 9) {
            next.disable();
        }
    }


    public void clickedArtistName(Button button) {
        glyphs.sortArtist();
        page = 0;
        glyphs.setSorts("A");
        if (started) {
            updateGlyphs(rep);
        }

    }


    public void clickedSongTitle(Button button) {
        glyphs.sortTitle();
        page = 0;
        glyphs.setSorts("A");
        if (started) {
            updateGlyphs(rep);
        }
    }


    public void clickedReleaseYear(Button button) {
        glyphs.sortYear();
        page = 0;
        glyphs.setSorts("Y");
        if (started) {
            updateGlyphs(rep);
        }
    }


    public void clickedGenre(Button button) {
        glyphs.sortGenre();
        page = 0;
        glyphs.setSorts("G");
        if (started) {
            updateGlyphs(rep);
        }
    }


    public void clickedHobby(Button button) {
        window.removeAllShapes();
        rep = 1;
        if (started) {
            updateGlyphs(rep);
        }
        else {
            placeGlyphs();
        }
        key = new GUIKey(Category.Hobby);
        addShapeList(key);
        started = true;
    }


    public void clickedMajor(Button button) {
        window.removeAllShapes();
        rep = 2;
        if (started) {
            updateGlyphs(rep);
        }
        else {
            placeGlyphs();
        }
        key = new GUIKey(Category.Major);
        addShapeList(key);
        started = true;
    }


    public void clickedRegion(Button button) {
        window.removeAllShapes();
        rep = 3;
        if (started) {
            updateGlyphs(rep);
        }
        else {
            placeGlyphs();
        }
        key = new GUIKey(Category.Region);
        addShapeList(key);
        started = true;
    }


    public void clickedQuit(Button button) {
        System.exit(0);
    }


    public static void main(String[] args) {
        GUIDisplayWindow gui = new GUIDisplayWindow();
    }
}
