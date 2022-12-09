package project;

import java.io.*;

// Utility.java

/**
 * @author Yeming Hu, Mathew, Alexandra
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
     * Read the integer entered by the keyboard,
     * 
     * @return int value
     */
    public static int readInt() {
        int n;
        for (;;) {
            String str = readKeyBoard(4, false);
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
     * Read a string of specified length entered by the keyboard
     * 
     * @param limit
     * @return String of specified length
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
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
            // If the file does not exist, create a new one
            if (!file.exists()) {
                file.createNewFile();
            }
            buff = obj.toString().getBytes();
            // append:true start writing from the end of the file and continue after the original data of the file
            o = new FileOutputStream(file, true);
            o.write(buff);
            o.flush();
            o.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}// end class Utility
