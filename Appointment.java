package project;
// Appointment.java

import java.time.LocalDate;

/**
 * @author Yeming Hu, Mathew, Alexandra
 * @version 1.0
 * @since December 7, 2022
 */

// class declaration
public class Appointment {
    // data memebers
    private int appointmentId;
    private LocalDate appointmentDate;
    private String patientName;
    private String doctorName;

    // public Appointment() {
    // }

    // constructor with paramters
    public Appointment(int appointmentId, LocalDate appointmentDate, String patientName, String doctorName) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.patientName = patientName;
        this.doctorName = doctorName;
    }// end constructor with parameters

    // method to return appointmentId
    public int getAppointmentId() {
        return appointmentId;
    }// end method getAppointmentId

    // method to set the appointmentId
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }// end method setAppointmentId

    // method to return the appointmentDate
    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }// end method getAppointmentDate

    // method to set the appointmentDate
    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }// end method setAppointmentDate

    // method to return patient
    public String getPatientName() {
        return patientName;
    }// end method getPatient

    // method to setPatient
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }// end method setPatient

    // method to return doctor
    public String getDoctorName() {
        return doctorName;
    }// end method getDoctor

    // method to set doctor
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }// end method setDoctor

    

    // override method toString
    @Override
    public String toString() {
        return "Appointment:\nPatient " + getPatientName() + " made an appointment for " + getAppointmentDate() + " with Doctor "
                + getDoctorName() + ", the appointment id: " + appointmentId + "\n";
    }// end method to String

}// end class Appointment
