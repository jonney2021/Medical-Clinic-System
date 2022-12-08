package project;

// Treatment.java

/**
 * @author Yeming Hu
 * @version 1.0
 * @since December 7, 2022
 */

// class declaration
public class Treatment {
    // data memebers
    private String treatmentName;
    private Date treatmentDate;
    private String patientName;
    private String doctorName;
   
    // constructor with parameters
    public Treatment(String treatmentName, Date treatmentDate, String patientName, String doctorName) {
        this.treatmentName = treatmentName;
        this.treatmentDate = treatmentDate;
        this.patientName = patientName;
        this.doctorName = doctorName;
    }// end constructor with parameters

    // method to return the treatmentName
    public String getTreatmentName() {
        return treatmentName;
    }// end method getTreatmentName

    // method to setTreatmentName
    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }// end method setTreatmentName  

    // method to return the patient name
    public String getPatientName() {
        return patientName;
    }// end method getPatientName

    // method to set the patient name
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }// end method to set the patient name

    // method to retutn the doctor name
    public String getDoctorName() {
        return doctorName;
    }// end method getDoctorName

    // method to set the doctor name
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }// end method setDoctorName

    // method to set the treatment date
    public void setTreatmentDate(Date treatmentDate) {
        this.treatmentDate = treatmentDate;
    }// end method setTreatmentDate

    // method to return the treatmentDate
    public Date getTreatmentDate() {
        return treatmentDate;
    }// end method getTreatmentDate


    @Override
    public String toString() {
        return "Treatment " + getTreatmentName() + " provided by the doctor  " + getDoctorName() + " will be used on "
                + getPatientName() + " on " + treatmentDate + "\n";
    }// end method to String
  
}// end class Treatment
