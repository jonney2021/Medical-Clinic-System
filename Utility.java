package project;

import java.io.File;
import java.io.FileOutputStream;

// Utility.java

/**
 * @author Yeming Hu
 * @version 1.0
 * @since December 6, 2022
 */

/**
 Handle user input in various situations, 
 output the information to a text file.
 */

import java.util.*;

// class declaration
public class Utility {
    // create a scanner object
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Read a menu option entered by the keyboard, value: range from 0 to 9
     * 
     * @return 0——9
     */
    public static char readMenuSelection() {
        char c;
        for (;;) {
            String str = readKeyBoard(1, false);// a string containing one character
            c = str.charAt(0);// Convert string to char
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9' && c != '0') {
                System.out.print("Wrong selection, please re-enter:");
            } else
                break;
        }
        return c;
    }

    /**
     * Read a character by the keyboard
     * 
     * @return a char
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     * Read a character entered by the keyboard, if you press Enter directly,
     * it will return the specified default value; otherwise, it will return the
     * input character
     * 
     * @param defaultValue
     * @return Default value or entered character
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);// Either an empty string or a character
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /**
     * Read the integer entered by the keyboard,
     * the length is less than 2 digits
     * 
     * @return int value
     */
    public static int readInt() {
        int n;
        for (;;) {
            String str = readKeyBoard(10, false);
            try {
                n = Integer.parseInt(str);// convert string to integer
                break;
            } catch (NumberFormatException e) {
                System.out.print("Number input error, please re-enter:");
            }
        }
        return n;
    }

    /**
     * Read the integer or default value entered by the keyboard, if you press Enter
     * directly,
     * return the default value, otherwise return the entered integer
     * 
     * @param defaultValue
     * @return int value defaultvalue
     */
    public static int readInt(int defaultValue) {
        int n;
        for (;;) {
            String str = readKeyBoard(10, true);
            if (str.equals("")) {
                return defaultValue;
            }
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Input error, please re-enter:");
            }
        }
        return n;
    }

    /**
     * Read a string of specified length entered by the keyboard
     * 
     * @param limit
     * @return String of specified length
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * Read the string or default value of the specified length entered by the
     * keyboard,
     * if you press Enter directly, return the default value, otherwise return the
     * string
     * 
     * @param limit
     * @param defaultValue
     * @return String value
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;
    }

    /**
     * The confirmation option for reading keyboard input, Y or N
     * 
     * @return Y or N
     */
    public static char readConfirmSelection() {
        System.out.println("Please enter your choice (Y/N): ");
        char c;
        for (;;) {
            // y => Y n=>N
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("Wrong selection, please re-enter:");
            }
        }
        return c;
    }

    /**
     * read a String
     * 
     * @param limit
     * @param blankReturn If it is true, it means that the empty string can be read.
     *                    If it is false, empty strings cannot be read.
     *
     *                    If the input is empty,
     *                    or the length of the input is greater than the limit,
     *                    it will prompt to re-enter.
     * @return
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {

        // define a String
        String line = "";

        // scanner.hasNextLine() Determine whether there is a next line
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();// read this line

            // If line.length=0, the user does not enter any content, just press Enter
            if (line.length() == 0) {
                if (blankReturn)
                    return line;// if blankReturn=true,return blank line
                else
                    continue; // if blankReturn=false, empty strings are not accepted, content must be entered
            }

            // If the content entered by the user is greater than the limit,
            // it will prompt to re-enter
            // If the user enters > 0 and <= limit, accept it
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("The length can't be great than " + limit + ", Please re-enter:");
                continue;
            }
            break;
        }

        return line;
    }

    /**
     * output the information to a text file.
     * 
     * @param obj
     * @param path
     */
    public static void outputFile(Object obj, String path) {
        FileOutputStream o = null;
        byte[] buff = new byte[] {};
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            buff = obj.toString().getBytes();
            o = new FileOutputStream(file, true);
            o.write(buff);
            o.flush();
            o.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}// end class Utility
