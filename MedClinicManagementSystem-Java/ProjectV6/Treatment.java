package ProjectV6;

import java.time.LocalDate;
import java.time.LocalTime;

public class Treatment {

    private Patient patients;
    private Doctor doctor;
    private Specialist specialist;

    private GeneralPractitioner gp;
    private Appointment appointments;
    private long treatmentID;

    private String treatment;
    // private String Department;
    // private String DiagnosticTest;
    // private String Receptionist;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Treatment() {

    }

    public Treatment(long aTreatmentID, String aTreatment, Doctor aDoctor, Patient aPatient) {
        // this.Department = Depart;
        // this.DiagnosticTest = DiagnosT;
        // this.Receptionist = Reception;
        // this.specialist = aSpecialist;
        this.doctor = aDoctor;
        this.patients = aPatient;
        this.treatment = aTreatment;
        this.treatmentID = aTreatmentID;

    }

    public Patient getPatients() {
        return patients;
    }

    public void setPatients(Patient patients) {
        this.patients = patients;
    }

    public String getTreatment() {
        return treatment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Appointment getAppointments() {
        return appointments;
    }

    public long getTreatmentID() {
        return treatmentID;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public GeneralPractitioner getGp() {
        return gp;
    }

    public void setGp(GeneralPractitioner gp) {
        this.gp = gp;
    }

    public void setTreatmentID(long treatmentID) {
        this.treatmentID = treatmentID;
    }

    public void setAppointments(Appointment appointments) {
        this.appointments = appointments;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setTreatmentDuration(LocalTime aStartTime, LocalTime anEndTime) {
        Dateset timedif = new Dateset();
        timedif.Duration(aStartTime, anEndTime);
        // Duration.between(aStartTime,anEndTime);

    }

    @Override
    public String toString() {
        return String.format(
                "Treatment ID: %d Treatments: %s Patient Name: %s Doctor Name: %s\n",
                getTreatmentID(), getTreatment(), getPatients().getName(), getDoctor().getName());
        // return String.format(
        // "Treatment %s Patient Name: %s Address %s Phone: %d Birthdate: %s Employer:%s
        // Insurance company: %s",
        // getTreatment(), getPatients().getName(), getPatients().getAddress(),
        // getPatients().getPhone(), getPatients().getBirtDate(),
        // getPatients().getEmployer(),
        // getPatients().getInsuranceCo());

    }
}
