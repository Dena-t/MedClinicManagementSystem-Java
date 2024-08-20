package ProjectV6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Appointment {

    private int appointmentID;
    private List<Patient> pt = new ArrayList<Patient>();
    private List<Doctor> dr = new ArrayList<Doctor>();
    private Patient patients;

    private Doctor doctors;
    private LocalDate date;
    private LocalTime endTime;
    private LocalTime startTime;
    private LocalTime duration;

    public Appointment() {
        this.date = LocalDate.now();
        this.endTime = LocalTime.now();
        this.startTime = LocalTime.now();

    }

    public Appointment(LocalDate aDate, LocalTime anEndTime, LocalTime aStartTime) {
        setDate(aDate);
        setEndTime(anEndTime);
        setStartTime(aStartTime);
        Duration(aStartTime, anEndTime);

    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public void createAppointment(LocalDate appointmentDate, LocalTime anEndTime, LocalTime aStartTime, Doctor aDr,
            Patient aPatient) {
        this.date = appointmentDate;
        this.startTime = aStartTime;
        this.endTime = anEndTime;
        this.doctors = aDr;
        this.patients = aPatient;
    }

    public void getAppointmentsbyDrPatient(LocalDate appointmentDate, LocalTime anEndTime, List<Doctor> aDr,
            List<Patient> aPatient) {
        // aDr.get(appointmentID)

    }

    public Patient getPatients() {
        return patients;
    }

    public void setPatients(Patient patients) {
        this.patients = patients;
    }

    public void addPatient(Patient p) {
        this.pt.add(p);
        p.addAppointment(this);
    }

    public void addDoctor(Doctor d) {
        this.dr.add(d);
        d.addAppointment(this);
    }

    public List<Doctor> getallDoctors() {
        return dr;
    }

    public List<Patient> getallPatients() {
        return pt;
    }

    public Doctor getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctor doctors) {
        this.doctors = doctors;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void Duration(LocalTime start, LocalTime End) {
        this.duration = End.minusNanos(start.toNanoOfDay());
    }

    public LocalTime getDuration() {
        return this.duration;
    }

    @Override
    public String toString() {
        return String.format("Date %s  Start Time :%s End Time %s Duration %s", getDate(),
                getStartTime(), getEndTime(), getDuration());

    }

}
