package project;
//ClinicApp.java
/**
 * @author Yeming Hu
 * @version 1.0
 * @since December 6, 2022
 */
// class declaration
public class ClinicApp {
    public static void main(String[] args) {
        // Create a Mainmenu object and display the main menu, 
        // which is the entrance of the entire program
        
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu();
        System.out.println("You are logged out of the medical clinic system.");  

    }// end method main
    
}// end class ClinicApp
