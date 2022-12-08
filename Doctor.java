package project;
// Doctor.java

import java.io.*;
import java.util.ArrayList;

// import java.util.Date;

/**
 * @author Yeming Hu
 * @version 1.0
 * @since December 5, 2022
 */

// class declaration
public class Doctor extends Person {
    // data members
    private int id;
    private String specialty;

    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Treatment> treatments = new ArrayList<>();
    static Treatment treatment;

    // constructor with parameters
    public Doctor(String name, Date dateOfBirth, int id, String specialty) {
        super(name, dateOfBirth);
        this.id = id;
        this.specialty = specialty;
    }// constructor with parameters

    // method to return the id
    public int getId() {
        return id;
    }// end method getId

    // method to set the id
    public void setId(int id) {
        this.id = id;
    }// method to set the id

    // method to set the specialty
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }// end method setSpecialty

    // method to return the specialty
    public String getSpecialty() {
        return specialty;
    }// end method getSpecialty

    // method to addTreatment
    public static void addTreatment() {
        System.out.println("\n============= Add a treatment ===============\n");
        System.out.print("Please enter the treatment's name: ");
        String name = Utility.readString(12);
        System.out.print("Please enter the month of the treatment date: ");
        int month = Utility.readInt();
        System.out.print("Please enter the day of the treatment date: ");
        int day = Utility.readInt();
        System.out.print("Please enter the year of the treatment date: ");
        int year = Utility.readInt();
        Date treatmentDate = new Date(month, day, year);
        System.out.print("Please enter the patient's name: ");
        String patientName = Utility.readString(16);
        System.out.print("Please enter the doctor's name: ");
        String doctorName = Utility.readString(16);
        treatment= new Treatment(name, treatmentDate, patientName, doctorName);
        treatments.add(treatment);
        System.out.println("\n=========== Successfully added treatment ================\n");
        System.out.println(treatment);

        // output the treatment information to a text file.
        FileOutputStream o = null;
        byte[] buff = new byte[] {};
        try {
            File file = new File("C://JAVA_2_2022//project//data//treatment.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            buff = treatment.toString().getBytes();
            o = new FileOutputStream(file, true);
            o.write(buff);
            o.flush();
            o.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }// end method addTreatment

    // method to return treatments
    public static void listTreatments() {
        System.out.println("\n=========== Treatments list ========== ");
        for (Treatment treatment : treatments) {
            System.out.println(treatment);
        }
    } // end method listTreatments

    // method to create a new doctor
    public static void createDoctor() {
        System.out.println("\n============= Add a doctor ===============\n");
        System.out.print("Please enter the new doctor's name: ");
        String name = Utility.readString(12);
        System.out.print("Please enter the month for the new doctor's date of birth: ");
        int month = Utility.readInt();
        System.out.print("Please enter the day for the new doctor's date of birth: ");
        int day = Utility.readInt();
        System.out.print("Please enter the year for the new doctor's date of birth: ");
        int year = Utility.readInt();
        Date dateOfBirth = new Date(month, day, year);
        System.out.print("Please enter the new doctor's id: ");
        int id = Utility.readInt();
        System.out.print("Please enter the new doctor's specialty: ");
        String specialty = Utility.readString(16);
        Doctor doctor1 = new Doctor(name, dateOfBirth, id, specialty);
        doctors.add(doctor1);
        System.out.println("\n===========Successfully added doctor================\n");
        System.out.println(doctor1);

        // output the patient information to a text file.
        FileOutputStream o = null;
        byte[] buff = new byte[] {};
        try {
            File file = new File("C://JAVA_2_2022//project//data//doctor.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            buff = doctor1.toString().getBytes();
            o = new FileOutputStream(file, true);
            o.write(buff);
            o.flush();
            o.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }// end method createDoctor

    // method to return the doctors list
    public static void listDoctor() {
        System.out.println("\n=========== Doctor list ========== ");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }// end method list

    // override method toString
    @Override
    public String toString() {
        return "Doctor: \n" + super.toString() + ", id: " + getId() + ", specialty: " + getSpecialty();
    }// end method toString

}// end class Doctor
