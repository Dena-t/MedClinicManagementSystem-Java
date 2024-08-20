package ProjectV6;

import java.time.LocalDate;
import java.util.*;

public class Search {
    public String findDoctorByID(int id, Reception rc3) {
        List<Specialist> resultSP = new ArrayList<>();
        for (Specialist drtest : rc3.viewDoctorsSpecialists()) {
            if (drtest.getId() == id) {
                resultSP.add(drtest);
            }
        }
        List<GeneralPractitioner> resultGP = new ArrayList<>();
        for (GeneralPractitioner gpTest : rc3.viewDoctorGP()) {
            if (gpTest.getId() == id) {
                resultGP.add(gpTest);
            }
        }
        return resultSP.toString() + resultGP.toString();

    }

    public String findPatientByID(int id, Reception rc3) {
        List<Patient> resultP = new ArrayList<>();
        for (Patient ptest : rc3.viewPatients()) {
            if (ptest.getId() == id) {
                resultP.add(ptest);
            }
        }
        return resultP.toString();

    }

    public int pUniqueID(int id, Reception rc3) {
        int count = 0;
        for (Patient ptest : rc3.viewPatients()) {
            if (ptest.getId() == id) {
                count++;
            }
        }
        return count;

    }

    public int drUniqueID(int id, Reception rc3) {
        int count = 0;
        for (Specialist drtest : rc3.viewDoctorsSpecialists()) {
            if (drtest.getId() == id) {
                count++;
            }

        }
        for (GeneralPractitioner gpTest : rc3.viewDoctorGP()) {
            if (gpTest.getId() == id) {
                count++;
            }
        }
        return count;
    }

    public String findDoctorByName(String strname, Reception rc3) {
        List<Specialist> result = new ArrayList<>();
        for (Specialist sptest : rc3.viewDoctorsSpecialists()) {
            if (sptest.getName().toUpperCase().contains(strname.toUpperCase())) {
                result.add(sptest);
            }
        }
        List<GeneralPractitioner> resultgp = new ArrayList<>();
        for (GeneralPractitioner gpSearch : rc3.viewDoctorGP()) {
            if (gpSearch.getName().equalsIgnoreCase(strname)) {
                resultgp.add(gpSearch);
            }
        }

        return result.toString() + resultgp.toString();

    }

    public List<Specialist> findDoctorBySpeciality(String str, Reception rc3) {
        List<Specialist> result = new ArrayList<>();
        for (Specialist dtest : rc3.viewDoctorsSpecialists()) {
            if (dtest.getSpeciality().equalsIgnoreCase(str)) {
                result.add(dtest);
            }
        }
        return result;

    }

    public String findDoctorByDateOfBirth(LocalDate aDateofBirth, Reception rc3) {
        List<Specialist> resultSP = new ArrayList<>();
        for (Specialist drtest : rc3.viewDoctorsSpecialists()) {
            if (drtest.getBirtDate().equals(aDateofBirth)) {
                resultSP.add(drtest);
            }
        }
        List<GeneralPractitioner> resultGP = new ArrayList<>();
        for (GeneralPractitioner gpTest : rc3.viewDoctorGP()) {
            if (gpTest.getBirtDate().equals(aDateofBirth)) {
                resultGP.add(gpTest);
            }
        }
        return resultSP.toString() + resultGP.toString();

    }

    public String findDoctorByDateOfEmployement(LocalDate aDateofEmp, Reception rc3) {
        List<Specialist> resultSP = new ArrayList<>();
        for (Specialist drtest : rc3.viewDoctorsSpecialists()) {
            if (drtest.getDateEmployed().equals(aDateofEmp)) {
                resultSP.add(drtest);
            }
        }
        List<GeneralPractitioner> resultGP = new ArrayList<>();
        for (GeneralPractitioner gpTest : rc3.viewDoctorGP()) {
            if (gpTest.getDateEmployed().equals(aDateofEmp)) {
                resultGP.add(gpTest);
            }
        }
        return resultSP.toString() + resultGP.toString();

    }

    public List<Patient> findPatientByName(String strname, Reception rc3) {
        List<Patient> result = new ArrayList<>();
        for (Patient ptTest : rc3.viewPatients()) {
            if (ptTest.getName().equalsIgnoreCase(strname)) {
                result.add(ptTest);
            }
        }
        return result;

    }

    public Patient appAssignPatientByName(String strname, Reception rc3) {
        Patient p = new Patient();
        for (Patient ptTest : rc3.viewPatients()) {
            if (ptTest.getName().equalsIgnoreCase(strname)) {
                p = ptTest;
            }
        }
        return p;

    }

    public Specialist appAssignDoctorByName(String strname, Reception rc3) {
        Specialist sp = new Specialist(0, strname, strname, null, strname, null, strname);
        for (Specialist sptest : rc3.viewDoctorsSpecialists()) {
            if (sptest.getName().equalsIgnoreCase(strname)) {
                sp = sptest;
            }
        }

        return sp;

    }

    public List<Patient> findPatientByDateOfBirth(LocalDate aDateofBirth, Reception rc3) {
        List<Patient> result = new ArrayList<>();
        for (Patient ptTst : rc3.viewPatients()) {
            if (ptTst.getBirtDate().equals(aDateofBirth)) {
                result.add(ptTst);
            }
        }
        return result;

    }

    public List<Patient> findPatientByEmployer(String strEmployer, Reception rc3) {
        List<Patient> result = new ArrayList<>();
        for (Patient ptTest : rc3.viewPatients()) {
            if (ptTest.getEmployer().equalsIgnoreCase(strEmployer)) {
                result.add(ptTest);
            }
        }
        return result;

    }

    public List<Patient> findPatientByInsuranceCo(String strInsurance, Reception rc3) {
        List<Patient> result = new ArrayList<>();
        for (Patient ptTest : rc3.viewPatients()) {
            if (ptTest.getInsuranceCo().equalsIgnoreCase(strInsurance)) {
                result.add(ptTest);
            }
        }
        return result;

    }

    /****** test */

    @Override
    public String toString() {
        return String.format("%s ");

    }

}
