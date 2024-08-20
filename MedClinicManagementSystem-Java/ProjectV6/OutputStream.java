package ProjectV6;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;

public class OutputStream {
    PrintWriter output;

    public void outputDoctor(int anID, String theName, String theAddress, LocalDate theBirthdate, String thePhone,
            String theSpeciality, LocalDate theDateEmployed) throws FileNotFoundException {

        try {
            output = new PrintWriter(new FileWriter("Doctors.txt", true));
        } catch (Exception e) {
            System.out.println("Error");
        }

        output.printf("\n%d%s%s%s%s%s%s%s%s%s%s%s%s", anID, ",", theName, ",", theAddress, ",",
                theBirthdate.toString(), ",", thePhone, ",", theSpeciality, ",", theDateEmployed.toString());
        output.flush();
        output.close();

    }

    public void outputGP(int anID, String theName, String theAddress, LocalDate theBirthdate, String thePhone,
            Boolean gp, LocalDate theDateEmployed) throws FileNotFoundException {

        try {
            output = new PrintWriter(new FileWriter("Doctors.txt", true));
        } catch (Exception e) {
            System.out.println("Error");
        }

        output.printf("\n%d%s%s%s%s%s%s%s%s%s%s%s%s", anID, ",", theName, ",", theAddress, ",",
                theBirthdate.toString(), ",", thePhone, ",", "gp", ",", theDateEmployed.toString());
        output.flush();
        output.close();

    }

    public void outputPatient(int anID, String theName, String theAddress, LocalDate theBirthdate, String thePhone,
            String anEmployer, String aInsuranceCo) throws FileNotFoundException {

        try {
            output = new PrintWriter(new FileWriter("Patients.txt", true));
        } catch (Exception e) {
            System.out.println("Error");
        }

        output.printf("%d%s%s%s%s%s%s%s%s%s%s%s%s\n", anID, ",", theName, ",", theAddress, ",",
                thePhone, ",", theBirthdate.toString(), ",", anEmployer, ",", aInsuranceCo);
        output.flush();
        output.close();

    }
}
