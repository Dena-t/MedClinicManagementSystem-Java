package ProjectV6;

import java.util.*;
import java.time.LocalDate;

public abstract class Doctor extends Person {

    private LocalDate dateEmployed;
    private List<Treatment> treatments;
    private List<Appointment> appointments;
    private List<Patient> patients;

    public Doctor(int anID, String theName, String theAddress, LocalDate theBirthdate, String thePhone,
            LocalDate aDateEmployed) {
        super(anID, theName, theAddress, theBirthdate, thePhone);
        this.dateEmployed = aDateEmployed;
        this.treatments = new ArrayList<Treatment>();
        this.appointments = new ArrayList<Appointment>();
        this.patients = new ArrayList<Patient>();

    }

    public void createDoctor(int anID, String theName, String theAddress, LocalDate theBirthdate, String thePhone,
            LocalDate theDateEmployed) {
        super.setId(anID);
        super.setName(theName);
        super.setAddress(theAddress);
        super.setBirtDate(theBirthdate);
        super.setPhone(thePhone);
        setDateEmployed(theDateEmployed);

    }

    public LocalDate getDateEmployed() {
        return dateEmployed;
    }

    public void setDateEmployed(LocalDate dateEmployed) {
        this.dateEmployed = dateEmployed;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatment(List<Treatment> aTreatment) {
        this.treatments = aTreatment;
    }

    public void addTreatments(Treatment aTreatment) {
        this.treatments.add(aTreatment);
        aTreatment.setDoctor(this);
    }

    public void removeTreatments(Treatment aTreatment) {
        this.treatments.remove(aTreatment);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void addAppointment(Appointment anAppointment) {
        this.appointments.add(anAppointment);
        anAppointment.setDoctors(this);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient aPatient) {
        patients.add(aPatient);
    }

    @Override
    public void updateBirthDate(LocalDate newBdate) {
        setBirtDate(newBdate);
    }

    @Override
    public String toString() {
        return String.format("%s Date Employed: %s", super.toString(),
                getDateEmployed().toString());
    }
}
