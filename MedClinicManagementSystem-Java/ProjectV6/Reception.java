package ProjectV6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;

public class Reception implements ManagementMethods {

    public Reception() {
    }

    private List<Specialist> specialists = new ArrayList<Specialist>();
    private List<GeneralPractitioner> generalPractitioners = new ArrayList<GeneralPractitioner>();
    private List<Patient> patient = new ArrayList<Patient>();
    private List<Treatment> treatment = new ArrayList<Treatment>();
    private List<Appointment> appointment = new ArrayList<Appointment>();
    private List<Doctor> doctors = new ArrayList<Doctor>();
    private Search sr = new Search();

    public void PatientReadFromFile() throws IOException {
        int i, j, id, year, month, day;
        LocalDate dt = LocalDate.of(1999, 11, 12);
        id = 0;
        String bdate, y, m, d;
        year = 0;
        month = 0;
        day = 0;
        y = "";
        d = "";
        m = "";
        String[] result = new String[7];
        String[] str;

        File file = new File("Patients.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(",");
            for (i = 0; i < tokens.length; i++) {
                result[i] = tokens[i];
            }
            try {
                id = Integer.parseInt(result[0]);

            } catch (NumberFormatException ex) {
                System.out.println("error" + ex);
            }
            String name = result[1];
            String add = result[2];
            String phone = result[3];
            bdate = result[4];
            String employer = result[5];
            String insurance = result[6];
            String birthday = bdate;
            if (birthday != null) {
                str = birthday.split("-");

                y = str[0];
                m = str[1];
                d = str[2];

            }
            try {
                year = Integer.valueOf(y);
                month = Integer.valueOf(m);
                day = Integer.valueOf(d);
                dt = LocalDate.of(year, month, day);
            } catch (NumberFormatException ex) {
                System.out.println("error" + ex);
            }
            if (sr.pUniqueID(id, this) == 0) {
                Patient p = new Patient(id, name, add, phone, dt, employer, insurance);
                addPatient(p);
            }
        }
    }

    public void DoctorReadFromFile() throws IOException {
        int i, j, id, bYear, bMonth, bDay, empYear, empDay, empMonth;
        LocalDate drBdt = LocalDate.of(1999, 11, 12);
        LocalDate drEmpdt = LocalDate.of(1999, 11, 12);
        id = 0;
        String bdate, sBY, sBM, sBD, sEmpY, sEmpD, sEmpM, empDate, name, add, phone, speciality;
        bYear = bMonth = bDay = empYear = empMonth = empDay = 0;
        sBY = sBD = sBM = sEmpY = sEmpM = sEmpD = empDate = name = add = phone = speciality = "";
        String[] result = new String[8];
        String[] str;

        File file = new File("Doctors.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(",");
            for (i = 0; i < tokens.length; i++) {
                result[i] = tokens[i];
            }
            try {
                id = Integer.parseInt(result[0]);

            } catch (NumberFormatException ex) {
                System.out.println("error" + ex);
            }
            name = result[1];
            add = result[2];
            bdate = result[3];
            phone = result[4];
            speciality = result[5];
            String sEmpDate = result[6];
            empDate = sEmpDate;
            String birthday = bdate;
            if (birthday != null) {
                str = birthday.split("-");

                sBY = str[0];
                sBM = str[1];
                sBD = str[2];

            }
            try {
                bYear = Integer.valueOf(sBY);
                bMonth = Integer.valueOf(sBM);
                bDay = Integer.valueOf(sBD);
                drBdt = LocalDate.of(bYear, bMonth, bDay);
            } catch (NumberFormatException ex) {
                System.out.println("error" + ex);
            }
            if (empDate != null) {
                str = sEmpDate.split("-");

                sEmpY = str[0];
                sEmpM = str[1];
                sEmpD = str[2];

            }
            try {
                empYear = Integer.valueOf(sEmpY);
                empMonth = Integer.valueOf(sEmpM);
                empDay = Integer.valueOf(sEmpD);
                drEmpdt = LocalDate.of(empYear, empMonth, empDay);

            } catch (NumberFormatException ex) {
                System.out.println("error" + ex);
                ex.printStackTrace();
            }
            if (sr.drUniqueID(id, this) == 0) {

                if (speciality.equals("gp")) {
                    boolean gpbln = true;
                    GeneralPractitioner gp = new GeneralPractitioner(id, name, add, drBdt, phone, drEmpdt, gpbln);
                    addDoctorGp(gp);
                } else {
                    Specialist sp = new Specialist(id, name, add, drBdt, phone, drEmpdt, speciality);
                    addDoctorSpecialist(sp);

                }
            }
        }
        br.close();
    }

    public String fullnameCapitalizer(String name) {

        String[] words = name.split(" ");
        StringBuilder sb = new StringBuilder();
        if (words[0].length() > 0) {
            sb.append(Character.toUpperCase(words[0].charAt(0))
                    + words[0].subSequence(1, words[0].length()).toString().toLowerCase());
            for (int i = 1; i < words.length; i++) {
                sb.append(" ");
                sb.append(Character.toUpperCase(words[i].charAt(0))
                        + words[i].subSequence(1, words[i].length()).toString().toLowerCase());
            }
        }
        return sb.toString();
    }

    public final String capitalizer(String str) {
        if (str == null || str.length() == 0)
            return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    @Override
    public void addDoctorSpecialist(Specialist aDr) {
        this.specialists.add(aDr);

    }

    @Override
    public void updateBirthdateDr(LocalDate newBdate, String aName) {
        for (Specialist specialist : this.viewDoctorsSpecialists()) {
            if (specialist.getName().equalsIgnoreCase(aName)) {
                specialist.setBirtDate(newBdate);
            }
        }
        for (GeneralPractitioner generalPractitioner : this.viewDoctorGP()) {
            if (generalPractitioner.getName().equalsIgnoreCase(aName)) {
                generalPractitioner.setBirtDate(newBdate);
            }
        }

    }

    @Override
    public void updateBirthdatePatient(LocalDate newBdate, String aName) {
        for (Patient patient : this.viewPatients()) {
            if (patient.getName().equalsIgnoreCase(aName)) {
                patient.setBirtDate(newBdate);
            }
        }
    }

    @Override
    public void removeDoctorBySearch(String search) {
        // this.specialists.remove(aDr);
        for (int i = 0; i < specialists.size(); i++) {
            if (specialists.get(i).getName().equalsIgnoreCase(search)) {
                specialists.remove(specialists.get(i));
            }
        }
        for (int i = 0; i < generalPractitioners.size(); i++) {
            if (generalPractitioners.get(i).getName().equalsIgnoreCase(search)) {
                generalPractitioners.remove(generalPractitioners.get(i));
            }
        }
    }

    @Override
    public void removeTreatmentByID(long removeTreatmentId) {
        for (int i = 0; i < treatment.size(); i++) {
            if (treatment.get(i).getTreatmentID() == removeTreatmentId)
                this.treatment.remove(treatment.get(i));
        }

    }

    @Override
    public String getTreatmentsForPatient(String assignedPatient) {
        String result = "";
        for (int i = 0; i < treatment.size(); i++) {
            if (treatment.get(i).getPatients().getName().equalsIgnoreCase(assignedPatient)) {
                result = treatment.get(i).toString();
            }

        }
        return result;

    }

    @Override
    public String getTreatmentForDr(String assignedDoctor) {
        String result = "";
        for (int i = 0; i < treatment.size(); i++) {
            if (treatment.get(i).getDoctor().getName().equalsIgnoreCase(assignedDoctor)) {
                result = treatment.get(i).toString();
            }
        }
        return result;

    }

    @Override
    public void removeTreatmentByPatient(String assignedPatient) {
        for (int i = 0; i < treatment.size(); i++) {
            if (treatment.get(i).getPatients().getName().equalsIgnoreCase(assignedPatient)) {
                this.treatment.remove(treatment.get(i));
            }
        }
    }

    public List<Specialist> viewDoctorsSpecialists() {
        return this.specialists;
    }

    public String drviewall() {
        this.viewDoctorGP();
        this.viewDoctorsSpecialists();
        return this.viewDoctorsSpecialists().toString() + this.viewDoctorGP().toString();
    }

    @Override
    public List<Doctor> viewAllDoctors() {
        return this.doctors;
    }

    @Override
    public void addDoctorGp(GeneralPractitioner aDrgp) {
        this.generalPractitioners.add(aDrgp);
    }

    @Override
    public List<GeneralPractitioner> viewDoctorGP() {
        return this.generalPractitioners;
    }

    @Override
    public String viewDoctorsString() {

        return this.generalPractitioners.toString() + this.specialists.toString();
    }

    @Override
    public void addPatient(Patient aPatient) {
        this.patient.add(aPatient);
    }

    @Override
    public List<Patient> viewPatients() {
        return this.patient;
    }

    @Override
    public void removePatient(Patient aPatient) {
        this.patient.remove(aPatient);

    }

    @Override
    public void removePatientBySearch(String search) {
        int counter = 0;
        for (int i = 0; i < patient.size(); i++) {
            if (patient.get(i).getName().equalsIgnoreCase(search)) {
                patient.remove(patient.get(i));
                counter = 0;
            } else {
                counter++;
            }
        }
        if (counter > 0) {
            System.out.println("Patient not Found");
        } else {
            System.out.println("Patient removed");
        }
    }

    @Override
    public List<Treatment> getTreatment() {
        return treatment;
    }

    @Override
    public void setTreatment(List<Treatment> treatment) {
        this.treatment = treatment;
    }

    @Override
    public void addTreatment(long aTreatmentId, String aTreatment, String assignedDr, String assignedPatient) {
        Patient pt = new Patient();
        Treatment tr = new Treatment();
        for (int i = 0; i < patient.size(); i++) {
            if (patient.get(i).getName().equalsIgnoreCase(assignedPatient)) {
                pt = patient.get(i);
            }
        }
        for (int j = 0; j < specialists.size(); j++) {
            if (specialists.get(j).getName().equalsIgnoreCase(assignedDr)) {
                Specialist sp = specialists.get(j);
                tr = new Treatment(aTreatmentId, aTreatment, sp, pt);
            }
        }
        for (int k = 0; k < generalPractitioners.size(); k++) {
            if (generalPractitioners.get(k).getName().equalsIgnoreCase(assignedDr)) {
                GeneralPractitioner gp = generalPractitioners.get(k);
                tr = new Treatment(aTreatmentId, aTreatment, gp, pt);

            }
        }
        treatment.add(tr);
    }

    @Override
    public void addAppointmentDrPatient(Appointment anAppointment, Specialist aDr, Patient aPatient) {
        this.appointment.add(anAppointment);
        aPatient.addAppointment(anAppointment);
        aDr.addAppointment(anAppointment);
        // anAppointment.getDoctors().addPatient(anAppointment.getPatients());

    }

    public String viewAppointments(Appointment appointments, Specialist doctors, Patient patients) {
        return "Appointment for the Patient: " + patients.getName() + " With Doctor:"
                + doctors.getName() + " On "
                + appointments.getDate() + " At " + appointments.getStartTime() + " For " + appointments.getDuration()
                + " Minutes.";
    }

}
