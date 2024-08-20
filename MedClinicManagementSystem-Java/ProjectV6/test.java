package ProjectV6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class test {
    public static void main(String[] args) {
        Search sr = new Search();
        Scanner input = new Scanner(System.in);
        Reception rc3 = new Reception();
        int yeartest, monthtest, daytest;
        ArrayList<Specialist> Reptionsp = new ArrayList<>();
        LocalDate bdate1 = LocalDate.of(1990, 01, 2);
        Specialist dr1 = new Specialist(1, "alan smith", "123west", bdate1, "123456", bdate1, "derm");
        Specialist dr2 = new Specialist(2, "jane smith", "123west", bdate1, "123456", bdate1, "derm");
        Specialist dr3 = new Specialist(3, "john smith", "123werst", bdate1, "123456", bdate1, "physiologist");

        GeneralPractitioner gp1 = new GeneralPractitioner(4, "john smith", "east west ", bdate1, "22222", bdate1,
                true);
        Patient p1 = new Patient(5, "Susan hughes", "central avenue", "111222", bdate1, "EASOFT", "BlueCross");
        Patient p2 = new Patient(6, "Norah Jones", "west bridge", "4444", bdate1, "Xerox", "IA");
        ArrayList<Treatment> treatments = new ArrayList<Treatment>();

        rc3.addDoctorSpecialist(dr1);
        rc3.addDoctorSpecialist(dr2);
        rc3.addDoctorSpecialist(dr3);
        rc3.addDoctorGp(gp1);
        rc3.addPatient(p1);
        rc3.addPatient(p2);

        System.out.println("test year");
        while (true) {
            System.out.println(" Enter BirthYear");
            yeartest = input.nextInt();
            input.nextLine();
            if (Validation.validateYear(yeartest)) {
                break;
            }
            System.out.println("\nInvalid Birth Year!\n");

        }
        System.out.println(yeartest);
        while (true) {
            System.out.println(" Enter Birth Month");
            monthtest = input.nextInt();
            input.nextLine();
            if (Validation.validateMonth(monthtest)) {
                break;
            }
            System.out.println("\nInvalid Birth month!\n");

        }
        System.out.println(monthtest);

        while (true) {
            System.out.println(" Enter Birth Day");
            daytest = input.nextInt();
            input.nextLine();
            if (Validation.validateDay(daytest)) {
                break;
            }
            System.out.println("\nInvalid Birth month!\n");

        }
        System.out.println(daytest);
        // Reptionsp.add(dr3);
        // Reptionsp.add(dr1);
        // Reptionsp.add(dr2);

        // System.out.println("enter dr speciality to search ");
        // String str = input.nextLine();
        // System.out.println("Doctors with" + str + "Speciality" +
        // sr.findDoctorBySpeciality(str, rc3));
        // System.out.println(rc3.viewPatients());

        // System.out.println("enter a name");
        // String strname = input.nextLine();

        // rc3.removePatientBySearch(strname);
        try {
            rc3.PatientReadFromFile();
            rc3.DoctorReadFromFile();

        } catch (Exception e) {
            System.out.println("Errpr" + e);
        }
        String appPatientName = "Marco";
        String appDrName = "Pan Fryer";
        Dateset dd = new Dateset();

        LocalDate appd = dd.dateSet(2024, 1, 2);
        LocalTime start = LocalTime.of(12, 15, 0);
        LocalTime End = LocalTime.of(12, 30, 0);

        Patient appP = sr.appAssignPatientByName(appPatientName, rc3);
        Specialist appSp = sr.appAssignDoctorByName(appDrName, rc3);
        Appointment app2 = new Appointment(appd, End, start);
        System.out.println("viewalldoctors" + rc3.viewAllDoctors());
        System.out.println("====================================");
        System.out.println("drviewall" + rc3.drviewall());
        System.out.println("====================================");

        System.out.println("Doctors to string" + rc3.viewDoctorsString());
        System.out.println("====================================");

        app2.addDoctor(appSp);
        app2.addPatient(appP);
        rc3.addAppointmentDrPatient(app2, appSp, appP);
        System.out.println(rc3.viewAppointments(app2, appSp, appP));

        System.out.println();
        System.out.println(rc3.viewPatients());
        System.out.println();
        System.out.println(rc3.viewDoctorsSpecialists());

        System.out.println("add a new doctor");
        System.out.println("Enter ID:");
        int drID = input.nextInt();
        input.nextLine();
        System.out.println(" Enter Doctor`s name");
        String drName = input.nextLine();
        drName = rc3.capitalizer(drName);
        System.out.println(" Enter Doctor`s address");
        String drAdd = input.nextLine();
        System.out.println(" Enter Doctor`s phone");
        String phone = input.nextLine();
        System.out.println("Enter Doctor`s BirthDate");
        System.out.println();
        System.out.println("Enter Birth Year:");
        int year = input.nextInt();
        System.out.println("Enter Birth Month");
        int month = input.nextInt();
        System.out.println("Dnter Birth Day");
        int day = input.nextInt();
        Dateset drDateSet = new Dateset();
        LocalDate drBDate = drDateSet.dateSet(year, month, day);

        System.out.println("Enter Employement Date:");
        System.out.println();
        System.out.println("Enter Employement Year:");
        int yearEm = input.nextInt();
        System.out.println("Enter Employement Month");
        int monthEm = input.nextInt();
        System.out.println("Enter Employement Day");
        int dayEm = input.nextInt();
        Dateset drEmDateSet = new Dateset();
        LocalDate drEmDate = drEmDateSet.dateSet(yearEm, monthEm, dayEm);
        input.nextLine();
        System.out.println(" Enter Doctor`s Speciality");
        String speciality = input.nextLine();
        Specialist sp = new Specialist(drID, drName, drAdd, drBDate, phone, drEmDate, speciality);
        rc3.addDoctorSpecialist(sp);

        // System.out.println("enter dr name to update birthdate");
        // String drname = input.nextLine();
        // System.out.println("enter new date year");
        // int y = input.nextInt();
        // System.out.println("new month");
        // int m = input.nextInt();
        // System.out.println("day");
        // int d = input.nextInt();
        // LocalDate newbday = LocalDate.of(y, m, d);
        // rc3.updateBirthdateDr(newbday, drname);

        System.out.println(rc3.viewDoctorsString());
        input.nextLine();
        for (int i = 0; i <= 2; i++) {
            System.out.println("Enter treatment Id");
            long trId = input.nextLong();
            input.nextLine();
            System.out.println("enter treatment");
            String tr = input.nextLine();
            System.out.println("Enter assigned patient name");
            String patient = input.nextLine();
            System.out.println("enter assigned doctor");
            String assigneddr = input.nextLine();
            rc3.addTreatment(trId, tr, assigneddr, patient);
        }
        System.out.println(rc3.getTreatment());
        System.out.println("remove by id enter id");
        long id = input.nextInt();
        input.nextLine();
        rc3.removeTreatmentByID(id);
        System.out.println(rc3.getTreatment());

        System.out.println("enter patientname to remove its treatments");
        String assignedpt = input.nextLine();
        System.out.println(rc3.getTreatmentsForPatient(assignedpt));
        rc3.removeTreatmentByPatient(assignedpt);
        System.out.println(rc3.getTreatment());

        System.out.println("view treatment for specific dr, enter doctors name");
        String drview = input.nextLine();
        System.out.println(rc3.getTreatmentForDr(drview));
        System.out.println(rc3.getTreatment());

        /******* corret */
        // ArrayList<Specialist> sp = new ArrayList<Specialist>();
        // for (int i = 1; i < Reptionsp.size(); i++) {
        // if (Reptionsp.get(i).getName().contains(strname)) {
        // Reptionsp.remove(Reptionsp.get(i));
        // }

        // }
        // System.out.println(Reptionsp);

        // }
        /****** correct */

    }
}