package prj5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Adam Tapp adamt
 * @version 04/13/2017
 */
public class Person {
    /**
     * The hobby of this person
     */
    private HobbyEnum hobby;

    /**
     * The state this person lives in
     */
    private StateEnum state;

    /**
     * The major of this person
     */
    private MajorEnum major;

    /**
     * Determines if this person is a valid person
     */
    private Boolean valid;
    /**
     * Stores answers in an int ArrayList
     */
    private ArrayList<Integer> answers;
    /**
     * Scanner to get through the string assigned to this person
     */
    private Scanner scan;

    /**
     * Default person
     */
    private static final String ME =
        "1,04/13/17 11:37,Computer Science,Southeast,art";


    /**
     * Default Person constuctor
     */
    public Person() {
        this(ME);
    }


    /**
     * 
     * @param person
     *            the details of a person to be added into this person object
     */
    public Person(String person) {
        if (!person.isEmpty()) {
            if (person.endsWith(",")) {
                person = person + "Empty";
            }
            // person.replaceAll(",,", ",Empty,");
            answers = new ArrayList<>();
            valid = true;
            scan = new Scanner(person);
            scan.useDelimiter(",");
            convertAns();
        }

    }


    /**
     * Gets the hobby of the person
     * 
     * @return Hobby the hobby of this person
     */
    public HobbyEnum getHobby() {
        return hobby;
    }


    /**
     * Gets the state of this person
     * 
     * @return State the state of this person
     */
    public StateEnum getState() {
        return state;
    }


    /**
     * Gets the major of this person
     * 
     * @return Major the major of this person
     */
    public MajorEnum getMajor() {
        return major;
    }


    /**
     * Returns if this person is valid i.e. major, state, or hobby do not equal
     * null
     * 
     * @return Boolean {@code true} if the person has a major, state, and hobby
     *         that are not null {@code false} otherwise
     */
    public boolean getValid() {
        return valid;
    }


    /**
     * Returns the array list of answers
     * 
     * @return ArrayList<Integer> the arry of answers
     */
    public ArrayList<Integer> getAnswers() {
        return answers;
    }


    /**
     * Converts the string to set the given fields and fills the array of
     * answers
     */
    private void convertAns() {
        // Removes the data we don't need for a person
        // Survey Number and date
        for (int i = 0; i < 2; i++) {
            if (scan.hasNext()) {
                scan.next();
            }
        } // End for

        String strMajor = nextString();
        String strState = nextString();
        String strHobby = nextString();
        if (strMajor != null) {
            setMajor(strMajor);
        }
        if (strState != null) {
            setState(strState);
        }
        if (strHobby != null) {
            setHobby(strHobby);
        }
        if (valid) {
            fillAnswers();
        }

    }


    /**
     * Sets the major, if the entry is blank set the state to null
     * 
     * @param str
     *            the string that will determine the major
     */
    private void setMajor(String str) {
        if (str.equals("Computer Science")) {
            major = MajorEnum.COMPUTER_SCIENCE;
        }

        else if (str.equals("Other Engineering")) {
            major = MajorEnum.OTHER_ENGE;
        }
        else if (str.equals("Math or CMDA")) {
            major = MajorEnum.MATH_CMDA;
        }

        else if (str.equals("Other")) {
            major = MajorEnum.OTHER;
        }

        else {
            valid = false;
            major = null;
        }

    }


    /**
     * Sets the state, if the entry is blank set the state to null
     * 
     * @param str
     *            the string that will determine the state
     */
    private void setState(String str) {

        if (str.equals("Northeast")) {
            state = StateEnum.NORTHEAST;
        }

        else if (str.equals("Southeast")) {
            state = StateEnum.SOUTHEAST;
        }

        else if (str.equals(
            "United States (other than Southeast or Northwest)")) {
            state = StateEnum.OTHER_US;
        }

        else if (str.equals("Outside of United States")) {
            state = StateEnum.OTHER;
        }
        else {
            valid = false;
            state = null;
        }

    }


    /**
     * Sets the hobby, if the entry is blank set the state to null
     * 
     * @param str
     *            the string that will determine the hobby
     */
    private void setHobby(String str) {

        if (str.equals("reading")) {
            hobby = HobbyEnum.READ;
        }

        else if (str.equals("art")) {
            hobby = HobbyEnum.ART;
        }
        else if (str.equals("sports")) {
            hobby = HobbyEnum.SPORTS;
        }
        else if (str.equals("music")) {
            hobby = HobbyEnum.MUSIC;
        }
        else {
            valid = false;
            state = null;
        }
    }


    /**
     * Fills the array list
     */
    private void fillAnswers() {
        while (scan.hasNext()) {
            String str = scan.next();
            if (str.equals("Yes")) {
                answers.add(1);
            }
            else if (str.equals("No")) {
                answers.add(0);
            }
            else {
                answers.add(-1);
            }
        }

    }


    /**
     * Checks to see if the scanner has a next and if it does returns the next
     * if not return null
     * 
     * @return String the next string in the scanner
     */
    private String nextString() {
        String str = null;
        if (scan.hasNext()) {
            str = scan.next();
        }
        return str;
    }

}
