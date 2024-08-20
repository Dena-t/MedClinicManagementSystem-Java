package ProjectV6;

import java.time.LocalDate;
import java.util.List;

public interface ManagementMethods {
    void addDoctorSpecialist(Specialist aDr);

    void updateBirthdateDr(LocalDate newBdate, String aName);

    void updateBirthdatePatient(LocalDate newBdate, String aName);

    void removeDoctorBySearch(String search);

    void removeTreatmentByPatient(String assignedPatient);

    void removeTreatmentByID(long removeTreatmentId);

    String getTreatmentsForPatient(String assignedPatient);

    String getTreatmentForDr(String assignedDoctor);

    List<Treatment> getTreatment();

    List<Specialist> viewDoctorsSpecialists();

    List<Doctor> viewAllDoctors();

    List<GeneralPractitioner> viewDoctorGP();

    List<Patient> viewPatients();

    void addDoctorGp(GeneralPractitioner aDrgp);

    void addPatient(Patient aPatient);

    void addTreatment(long aTreatmentId, String aTreatment, String assignedDr, String assignedPatient);

    void removePatient(Patient aPatient);

    void removePatientBySearch(String search);

    void setTreatment(List<Treatment> treatment);

    String viewDoctorsString();

    void addAppointmentDrPatient(Appointment anAppointment, Specialist aDr, Patient aPatient);
}
