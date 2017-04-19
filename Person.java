package itemclasses;

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
        answers = new ArrayList<>();
        valid = true;
        scan = new Scanner(person);
        scan.useDelimiter(",");
        convertAns();

    }


    /**
     * Gets the hobby of the person
     * 
     * @return Hobby the hobby of this person
     */
    public Hobby getHobby() {
        return hobby;
    }


    /**
     * Gets the state of this person
     * 
     * @return State the state of this person
     */
    public State getState() {
        return state;
    }


    /**
     * Gets the major of this person
     * 
     * @return Major the major of this person
     */
    public Major getMajor() {
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
     * @return ArrayList<Integer> the arry of answers
     */
    public ArrayList<Integer> getAnswers() {
        return answers;
    }
    
    /**
     * Returns an array of answers
     * @return Object[] the answers in an array of objects
     */
    public Object[] toArray() {
        return answers.toArray();
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

        setMajor(strMajor);
        setState(strState);
        setHobby(strHobby);

        fillAnswers();
  

    }


    /**
     * Sets the major, if the entry is blank set the state to null
     * 
     * @param str
     *            the string that will determine the major
     */
    private void setMajor(String str) {

        switch (str) {
            case "Computer Science":
                major = Major.COMPUTER_SCIENCE;
                break;

            case "Other Engineering":
                major = Major.OTHER_ENGE;
                break;

            case "Math or CMDA":
                major = Major.MATH_CMDA;
                break;

            case "Other":
                major = Major.OTHER;
                break;
                
            default:
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

        switch (str) {
            case "Northeast":
                state = State.NORTHEAST;
                break;

            case "Southeast":
                state = State.SOUTHEAST;
                break;

            case "United States (other than Southeast or Northwest)":
                state = State.OTHER_US;
                break;

            case "Outside of United States":
                state = State.OTHER;
                break;
                
            default:
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

        switch (str) {
            case "reading":
                hobby = Hobby.READ;
                break;

            case "art":
                hobby = Hobby.ART;
                break;
                
            case "sports":
                hobby = Hobby.SPORTS;
                break;

            case "music":
                hobby = Hobby.MUSIC;
                break;
                
            default:
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
            switch (str) {
                case "Yes":
                    answers.add(1);
                    break;

                default:
                    answers.add(0);
                    break;
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
