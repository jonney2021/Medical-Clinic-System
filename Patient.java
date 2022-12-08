package project;

import java.util.ArrayList;
import java.util.Iterator;

// Patient.java

/**
 * @author Yeming Hu
 * @version 1.0
 * @since December 5, 2022
 */

// class declaration
public class Patient extends Person {
    // data members
    private String insuranceCompany;
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static ArrayList<Treatment> treatments = new ArrayList<>();
    static Patient patient1;

    // constructor with parameters
    public Patient(String name, Date dateOfBirth, String insuranceCompany) {
        super(name, dateOfBirth);
        this.insuranceCompany = insuranceCompany;
    }// end constructor with parameters

    // method to setInsuranceCompany
    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }// end method setInsuranceCompany

    // method to return the insurance company
    public String getInsuranceCompany() {
        return insuranceCompany;
    }// end method getInsuranceCompany

    // method to create a new patient
    public static void createPatient() {
        System.out.println("\n============= Add a patient ===============\n");
        System.out.print("Please enter the new patient's name: ");
        String name = Utility.readString(16);
        System.out.print("Please enter the month for the new patient's date of birth: ");
        int month = Utility.readInt();
        System.out.print("Please enter the day for the new patient's date of birth: ");
        int day = Utility.readInt();
        System.out.print("Please enter the year for the new patient's date of birth: ");
        int year = Utility.readInt();

        Date dateOfBirth = new Date(month, day, year);
        System.out.print("Please enter the new patient's insurance company: ");
        String insuranceCompany = Utility.readString(16);
        patient1 = new Patient(name, dateOfBirth, insuranceCompany);
        // iterate over the elements in the patient list
        for (Patient patient : patients) {
            if (patient.getName().equals(patient1.getName()) && patient.getInsuranceCompany().equals(patient1.getInsuranceCompany()) ) {
                System.out.println("\nAdd failed. This patient already exists.\n");
                return;
            }
        }
        // add the patient1 to the list
        patients.add(patient1);
        System.out.println("\n=========== Successfully added patient ================\n");
        System.out.println(patient1);

        // output the patient information to a text file.
        Utility.outputFile(patient1, "C://JAVA_2_2022//project//data//patient.txt");

    }// end method create

    // method to return the patients list
    public static void listPatient() {
        System.out.println("\n=========== Patients list =============");
        // iterate over the elements in the patient list
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }// end method list

    // method to makeAppointment
    public static void makeAppointment() {
        System.out.println("\n============= Make a appointment ===============\n");
        // Prompt the user to input information
        System.out.print("Please enter a appointment's id: ");
        int id = Utility.readInt();
        System.out.print("Please enter the month for the appointmentDate: ");
        int month = Utility.readInt();
        System.out.print("Please enter the day for the appointmentDate: ");
        int day = Utility.readInt();
        System.out.print("Please enter the year for the appointmentDate: ");
        int year = Utility.readInt();
        Date appointmenDate = new Date(month, day, year);

        System.out.print("Please enter the patient's name: ");
        String patientName = Utility.readString(16);
        // iterate over the elements in the patient list
        for (Patient patient : patients) {
            if (!((patient.getName()).equals(patientName))) {            
                System.out.println(patientName + " is not in the patient list. Please add the patient information into system first.");
                return;
            }
        }

        System.out.print("Please enter the doctor's name: ");
        String doctorName = Utility.readString(16);
        // iterate over the elements in the doctor list
        for (Doctor doctor : doctors) {
            if (!((doctor.getName()).equals(doctorName))) {
                throw new IllegalArgumentException(doctorName + " is not in the doctor list. Please add the patient information into system first.");
            }
        }
        Appointment appointment = new Appointment(id, appointmenDate, patientName, doctorName);
        appointments.add(appointment);
        System.out.println("\n===========Successfully made an appointment================\n");
        System.out.println(appointment);

        // output the appointment information to a text file.
        Utility.outputFile(appointment, "C://JAVA_2_2022//project//data//appointment.txt");
    }// end method makeAppointment

    // method to return the appointment list
    public static void listAppointment() {
        System.out.println("\n=========== Appointment list: ============");
        // iterate over the elements in the appointment list
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }// end method list

    // mathod to cancel an appointment
    public static void cancelAppointment() {
        System.out.println("\n================== Cancel Appointment ============");
        System.out.print("Please enter the appointment id(-1 exit): ");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("============= Abandon cancel appointment information =========");
            return;
        }
        char choice = Utility.readConfirmSelection(); // Note this method already has a loop
        if (choice == 'Y') {// confirm deletion
            Iterator<Appointment> iterator = appointments.iterator();
            while (iterator.hasNext()) {
                Appointment appointment = iterator.next();
                if (appointment.getAppointmentId() == delId) {
                    iterator.remove();
                    System.out.println("============ Cancelling appointment information successfully ==========");
                }else{
                    System.out.println("The appointment id you entered does not exist, please check the information.");
                }
            }
            // System.out.println("============ Cancelling appointment information successfully ==========");
        } else {
            System.out.println("=============Abandon cancelling appointment information=========");
        }
    }// end method cancelAppointment

    // override toString
    @Override
    public String toString() {
        return "Patient: \n" + super.toString() + ", insuranceCompany: " + getInsuranceCompany() + "\n";
    }// end method toString

}// end class Patient
