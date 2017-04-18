/**
 * 
 */
package musicpreference;

import CS2114.TextShape;
import java.awt.Color;
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

    private static int STARTX = 50;
    private static int STARTY = 50;
    private static int increment = 50;
    private static final Glyph DEFAULT = new Glyph(STARTX, STARTY, 100,
        GlyphList.defaultSong);
    private static final Glyph DEFAULT1 = new Glyph(STARTX, STARTY, 100,
        GlyphList.defaultSong);
    private static final Glyph DEFAULT2 = new Glyph(STARTX, STARTY, 100,
        GlyphList.defaultSong);
    private static GlyphList DEFAULT_GLYPHS;


    public GUIDisplayWindow() {
        this(GlyphList.defaultGlyphList());
    }


    private static GlyphList setDefaultGlyphs() {
        DEFAULT_GLYPHS = new GlyphList();
        DEFAULT_GLYPHS.add(DEFAULT);
        DEFAULT_GLYPHS.add(DEFAULT1);
        DEFAULT_GLYPHS.add(DEFAULT2);
        return DEFAULT_GLYPHS;
    }


    public GUIDisplayWindow(GlyphList glyphs) {
        page = 0;
        this.glyphs = glyphs;
        if (page == glyphs.size() / 9) {
            for (int i = page * 9; i < glyphs.size() % 9; i++) {
                window.addShape(glyphs.get(i));
            }
        }
        for (int i = 0; i < 9; i++) {
            window.addShape(glyphs.get(i));
        }

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


    private void updateGlyphs() {
        if (page == glyphs.size() / 9) {
            for (int i = page * 9; i < glyphs.size() % 9; i++) {
                glyphs.get(i).moveTo(STARTX + increment * (i % 3), STARTY
                    + increment * (i / 3));
                window.addShape(glyphs.get(i));
            }
        }
        else {
            for (int i = page * 9; i < 9; i++) {
                window.addShape(glyphs.get(i));
            }
        }
    }


    public void clickedPrev(Button button) {
        page--;
        updateGlyphs();
    }


    public void clickedNext(Button button) {
        page++;
        updateGlyphs();
    }


    public void clickedArtistName(Button button) {
        glyphs.sortArtist();
        page = 0;
        updateGlyphs();
    }


    public void clickedSongTitle(Button button) {
        glyphs.sortTitle();
        page = 0;
        updateGlyphs();
    }


    public void clickedReleaseYear(Button button) {
        glyphs.sortYear();
        page = 0;
        updateGlyphs();
    }


    public void clickedGenre(Button button) {
        glyphs.sortGenre();
        page = 0;
        updateGlyphs();
    }


    public void clickedHobby(Button button) {
        window.removeAllShapes();
        updateGlyphs();
        key = new GUIKey(Category.Hobby);
        for (int i = 0; i < key.size(); i++) {
            window.addShape(key.get(i));
        }
    }


    public void clickedMajor(Button button) {
        window.removeAllShapes();
        updateGlyphs();
        key = new GUIKey(Category.Major);
        for (int i = 0; i < key.size(); i++) {
            window.addShape(key.get(i));
        }
    }


    public void clickedRegion(Button button) {
        window.removeAllShapes();
        updateGlyphs();
        key = new GUIKey(Category.Region);
        for (int i = 0; i < key.size(); i++) {
            window.addShape(key.get(i));
        }
    }


    public void clickedQuit(Button button) {
        System.exit(0);
    }


    public static void main(String[] args) {
        GUIDisplayWindow gui = new GUIDisplayWindow();
    }
}
