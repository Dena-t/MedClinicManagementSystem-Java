/***
 * makeappointment()
 * calculate last visit();
 * changestatus()- current new former
 * provide medical history
 * 
 */

package ProjectV6;

import java.util.*;
import java.time.LocalDate;

public class Patient extends Person {

    private String employer = "";
    private String insuranceCo = "";
    private List<Doctor> doctors;
    private List<Treatment> treatments;
    private List<Appointment> appointments;

    public Patient() {

    }

    public Patient(int anID, String aName, String aAddress, String aPhone, LocalDate aBirthDate, String anEmployer,
            String aInsuranceCo) {
        super(anID, aName, aAddress, aBirthDate, aPhone);
        this.employer = anEmployer;
        this.insuranceCo = aInsuranceCo;
        this.treatments = new ArrayList<Treatment>();
        this.appointments = new ArrayList<Appointment>();
        this.doctors = new ArrayList<Doctor>();
    }

    public void createPatient(int anID, String name, String add, String phone, LocalDate bdate, String employer,
            String aInsurance,
            Treatment aTreatment) {
        super.setId(anID);
        super.setName(name);
        super.setAddress(add);
        super.setBirtDate(bdate);
        super.setPhone(phone);
        setEmployer(employer);
        setInsuranceCo(aInsurance);
        addTreatments(aTreatment);

    }

    public String getEmployer() {
        return employer;
    }

    public String getInsuranceCo() {
        return insuranceCo;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setInsuranceCo(String insuranceCo) {
        this.insuranceCo = insuranceCo;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public void addTreatments(Treatment aTreatment) {
        this.treatments.add(aTreatment);
        aTreatment.setPatients(this);
    }

    public void setTreatment(List<Treatment> aTreatment) {
        this.treatments = aTreatment;
    }

    public void removeTreatments(Treatment aTreatment) {
        this.treatments.remove(aTreatment);
    }

    public void setAppointment(List<Appointment> anAppointment) {
        this.appointments = anAppointment;
    }

    public void addAppointment(Appointment anAppointment) {
        appointments.add(anAppointment);

    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void addDoctor(Doctor aDoctor) {
        doctors.add(aDoctor);
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return String.format("%s Employer: %s Insurance Company: %s\n", super.toString(), getEmployer(),
                getInsuranceCo());
    }
}
