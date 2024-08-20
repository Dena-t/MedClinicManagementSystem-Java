package ProjectV6;

import java.time.LocalDate;

public class Specialist extends Doctor {
    private String speciality;

    public Specialist(int anID, String theName, String theAddress, LocalDate theBirthdate, String thePhone,
            LocalDate aDateEmployed, String aSpeciality) {
        super(anID, theName, theAddress, theBirthdate, thePhone, aDateEmployed);
        this.speciality = aSpeciality;

    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return String.format("%s Speciality: %s\n", super.toString(), getSpeciality());
    }

}