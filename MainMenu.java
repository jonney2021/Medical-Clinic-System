package project;
// MainMenu.java

/**
 * @author Yeming Hu, Mathew, Alexandra
 * @version 1.0
 * @since December 6, 2022
 */

// class declaration
public class MainMenu {

    // control the display of menu
    boolean isFlag = true;
    // Receive user selection
    int key; 
   
    // method to show main menu
    public void mainMenu() {
        do {
            System.out.println("\n=========== Medical Clinic System ==========\n");
            System.out.println("1 Add new patient");
            System.out.println("2 Add new doctor");
            System.out.println("3 Add new appointment");
            System.out.println("4 Add new treatment");    
            System.out.println("5 Show patients list");
            System.out.println("6 Show doctors list");
            System.out.println("7 Show appointment list");
            System.out.println("8 Show treatment list");
            System.out.println("9 Cancel appointment list");
            System.out.println("10 Modify appointment list");
            System.out.println("11 PayBill");
            System.out.println("0 exit\n");
            System.out.print("Please enter your choice (0-11): ");
            try{
                key = Utility.readInt();
                switch (key) {
                    case 1:
                        Patient.createPatient();
                        break;
                    case 2:
                        Doctor.createDoctor();
                        break;  
                    case 3:
                        Patient.makeAppointment();
                        break;
                    case 4:
                        Doctor.addTreatment();
                        break;
                    case 5:
                        Patient.listPatient();
                        break;
                    case 6:
                        Doctor.listDoctor();
                        break;
                    case 7:
                        Patient.listAppointment();
                        break;
                    case 8:
                        Doctor.listTreatments();
                        break;  
                    case 9:
                        Patient.cancelAppointment();
                        break;
                    case 10:
                        Patient.modifyAppointment();
                        break;
                    case 11:
                        Patient.payment();
                        break;
                    case 0:
                        exit();
                        break;
                    default:
                        throw new IllegalArgumentException("Your choice is not correct, please enter a integer number(0-11):");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }     
        } while (isFlag);

    }// end method mainMenu

    //exit confirmation
    public void exit(){
        char c = Utility.readConfirmSelection();
        if(c == 'Y'){
            isFlag = false;
        }
    }// end method exit

}// end class MeinMenu
