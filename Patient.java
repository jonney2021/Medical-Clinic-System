package project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

// Patient.java

/**
 * @author Yeming Hu, Mathew, Alexandra
 * @version 1.0
 * @since December 5, 2022
 */

// class declaration
public class Patient extends Person {
    // data members
    private String insuranceCompany;
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static ArrayList<Treatment> treatments = new ArrayList<>();
    static Patient patient1;

    // constructor with parameters
    public Patient(String name, LocalDate dateOfBirth, String insuranceCompany) {
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
        try{
            int month = Utility.readInt();
            System.out.print("Please enter the day for the new patient's date of birth: ");
            int day = Utility.readInt();
            System.out.print("Please enter the year for the new patient's date of birth: ");
            int year = Utility.readInt();

            LocalDate dateOfBirth = LocalDate.of(year, month, day);

            System.out.print("Please enter the new patient's insurance company: ");
            String insuranceCompany = Utility.readString(16);
            patient1 = new Patient(name, dateOfBirth, insuranceCompany);
            // iterate over the elements in the patient list
            for (Patient patient : patients) {
                if (patient.getName().equals(patient1.getName())
                        && patient.getInsuranceCompany().equals(patient1.getInsuranceCompany())) {
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
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

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
        try{
            int month = Utility.readInt();
            System.out.print("Please enter the day for the appointmentDate: ");
            int day = Utility.readInt();
            System.out.print("Please enter the year for the appointmentDate: ");
            int year = Utility.readInt();
            LocalDate appointmenDate = LocalDate.of(year, month, day);

            // appointment date must be after today
            if (appointmenDate.isBefore(LocalDate.now())) {
                System.out.println("There is an error in your entry. Your appointment date must be after today");
                return;
            }

            System.out.print("Please enter the patient's name: ");
            String patientName = Utility.readString(16);

            // After Java8, we can use stream noneMatch() method, it is a short-circuiting
            // terminal operation.
            // noneMatch(): According to the judgment condition, if all elements do not
            // match, show this patient is not in the list
            if (patients.stream().noneMatch(o -> o.getName().equals(patientName))) {
                System.out.println(
                        patientName + " is not in the patient list. Please add the patient information into system first.");
                return;
            }

            System.out.print("Please enter the doctor's name: ");
            String doctorName = Utility.readString(16);

            // noneMatch(): According to the judgment condition, if all elements do not
            // match, show this patient is not in the list
            if (Doctor.doctors.stream().noneMatch(o -> o.getName().equals(doctorName))) {
                System.out.println(
                        doctorName + " is not in the doctor list. Please add the doctor information into system first.");
                return;
            }

            Appointment appointment = new Appointment(id, appointmenDate, patientName, doctorName);
            appointments.add(appointment);
            System.out.println("\n===========Successfully made an appointment================\n");
            System.out.println(appointment);

            // output the appointment information to a text file.
            Utility.outputFile(appointment, "C://JAVA_2_2022//project//data//appointment.txt");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }// end method makeAppointment

    // method to return the appointment list
    public static void listAppointment() {
        System.out.println("\n=========== Appointment list: ============");
        // iterate over the elements in the appointment list
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }// end method list

    // method to modify the appointment
    public static void modifyAppointment() {
        // Set a variable index to record whether an appointment was found
        int index = -1;
        System.out.println("\n=============Modify Appointment================");
        System.out.println("Please select the appointment number to be modified (-1 to exit):");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("==========Abandon modify appointment information=============");
        }

        // iterate over the elements in the appointment list
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == updateId) {
                // If the appointment number is matched, add 1 to this variable
                index++;
                System.out.print("month(" + appointment.getAppointmentDate() + "):");
                int month = Utility.readInt();
                System.out.print("day(" + appointment.getAppointmentDate() + "):");
                int day = Utility.readInt();
                System.out.print("year(" + appointment.getAppointmentDate() + "):");
                int year = Utility.readInt();
                LocalDate appointmentDate = LocalDate.of(year, month, day);
                // appointment date must be after today
                if (appointmentDate.isBefore(LocalDate.now())) {
                    System.out.println("There is an error in your entry. Your appointment date must be after today");
                    return;
                }
                appointment.setAppointmentDate(appointmentDate);

                System.out.println("patientName(" + appointment.getPatientName() + "):");
                // if the user presses Enter directly, it means that the information will not be
                // modified, and the default is ""
                String patientName = Utility.readString(16);
                if (!"".equals(patientName)) {// modify
                    appointment.setPatientName(patientName);
                }

                // noneMatch(): According to the judgment condition, if all elements do not
                // match, show this patient is not in the list
                if (patients.stream().noneMatch(o -> o.getName().equals(patientName))) {
                    System.out.println(patientName
                            + " is not in the patient list. Please add the patient information into system first.");
                    return;
                }

                System.out.print("doctorName(" + appointment.getDoctorName() + "):");
                String doctorName = Utility.readString(16);
                if (!"".equals(doctorName)) {// modify
                    appointment.setDoctorName(doctorName);
                }

                // noneMatch(): According to the judgment condition, if all elements do not
                // match, show this patient is not in the list
                if (Doctor.doctors.stream().noneMatch(o -> o.getName().equals(doctorName))) {
                    System.out.println(doctorName
                            + " is not in the doctor list. Please add the doctor information into system first.");
                    return;
                }

                System.out.println("\n===========Successfully modify an appointment================\n");
                System.out.println(appointment);
            }
        }
        // if index==-1, no matching record is found, output the information
        if (index == -1) {
            System.out.println("==========Modify appointment number does not exist==========");
            return;
        }
    }

    // mathod to cancel an appointment
    public static void cancelAppointment() {
        int index = -1;
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
                    index++;
                    iterator.remove();
                    System.out.println("============ Cancelling appointment information successfully ==========");
                }
            }
        } else {
            System.out.println("=============Abandon cancelling appointment information=========");
        }
        if (index == -1) {
            System.out.println("The appointment id you entered does not exist, please check the information.");

        }
    }// end method cancelAppointment

    // method for payments
    public static void payment() {

        System.out.println("Choose a payment method");
        System.out.println("1. Cash");
        System.out.println("2. Credit");
        System.out.println("3. Debit");
        int answer = Utility.readInt();

        switch (answer) {
            case 1:
                System.out.println("***********************");
                System.out.println("Bill will be paid in cash.\nThank you!");
                System.out.println("***********************");
                break;
            case 2:
                System.out.println("\nPlease enter your credit card number.");
                String cc = Utility.readString(16);
                System.out.println("Please enter the name of the credit card owner.");
                String name = Utility.readString(16);
                System.out.println("Enter the 3 digit verification code.");
                int code = Utility.readInt();
                if (code < 100 || code > 999) {
                    System.out.println("The verification code should be 3 digit");
                    break;
                }
                System.out.println("\n***********************");
                System.out.println("Bill will be paid by credit.\nCustomer name: " + name + "\nCredit Card #: " + cc
                        + "\nVerification code: " + code + ".\nThank you.");
                System.out.println("***********************");
                break;
            case 3:
                System.out.println("\n***********************");
                System.out.println("Bill will be paid by debit.\nThank you!");
                System.out.println("***********************");
                break;
            default:
                System.out.println("\nYou must input the integer number(1-3)");
        }
    }

    // override toString
    @Override
    public String toString() {
        return "Patient: \n" + super.toString() + ", insuranceCompany: " + getInsuranceCompany() + "\n";
    }// end method toString

}// end class Patient
