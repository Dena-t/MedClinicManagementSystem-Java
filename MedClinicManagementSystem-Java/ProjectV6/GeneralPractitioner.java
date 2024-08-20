package ProjectV6;

import java.time.LocalDate;

public class GeneralPractitioner extends Doctor {

    private boolean generalPractitioner;

    public GeneralPractitioner(int anID, String theName, String theAddress, LocalDate theBirthdate, String thePhone,
            LocalDate aDateEmployed, boolean aGeneralPractitioner) {
        super(anID, theName, theAddress, theBirthdate, thePhone, aDateEmployed);
        this.generalPractitioner = aGeneralPractitioner;

    }

    public boolean isGeneralPractitioner() {
        return generalPractitioner;
    }

    public void setGeneralPractitioner(boolean generalPractitioner) {
        this.generalPractitioner = generalPractitioner;
    }

    @Override
    public String toString() {
        return String.format("%s General Practitioner\n", super.toString());
    }
}
