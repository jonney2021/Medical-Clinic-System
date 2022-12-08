package project;

// Person.java

/**
 * @author Yeming Hu
 * @version 1.0
 * @since December 5, 2022
 */

// class declaration
public abstract class Person {
    // data members
    private String name;
    private Date dateOfBirth;

    // constructor with parameters
    public Person(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }// constructor with parameters

    // method to return the name
    public String getName() {
        return name;
    }// end method getName

    // method to set the name
    public void setName(String name) {
        this.name = name;
    }// end method to setName

    // method to return the date of birth
    public Date getDateOfBirth() {
        return dateOfBirth;
    }// end method getDateOfBirth

    // method to set the date of birth
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }// end method setDateOfBirth

    // override method toString
    @Override
    public String toString() {
        return "Name: " + getName() + ", Date of Birth: " + getDateOfBirth();
    }// end method toString

}// end class Person
