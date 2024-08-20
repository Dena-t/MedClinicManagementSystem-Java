package ProjectV6;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class MainMenu {
    static Scanner input = new Scanner(System.in);
    static OutputStream drtxt = new OutputStream();
    static Reception receptionist = new Reception();
    static Search sr = new Search();;
    Appointment app;
    Patient p;

    private String acc, drName, drAdd, drPhone, pName, pAddress, pPhone;
    private int year, month, day, yearEm, monthEm, dayEm, pBirthYear, pBirthMonth, pBirthDay;
    static int answer, drID, ptID;
    static String speciality;
    Specialist sp1;
    Specialist sp2;
    GeneralPractitioner gp1;
    static Patient p1;

    public static void main(String[] args) {
        MainMenu newm = new MainMenu();

        newm.mainMenu();

    }

    public MainMenu() {
    }

    public void close() {
        System.exit(1);
    }

    public void mainMenu() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("            Medical Clinic Management System             ");
        System.out.println("=========================================================");

        System.out.println(" Please Login As One Of The Followings Or Exit The Program:");
        System.out.println();
        System.out.println(" 1. Receptionist");
        System.out.println(" 2. Exit");
        System.out.println();
        System.out.println(" Enter The Number:");
        boolean notValidSelection = true;
        do {
            // System.out.println("Please Select:");
            acc = input.nextLine();
            if (acc.equals("1")) {
                System.out.println("You Logged In As Reciptionist");
                notValidSelection = false;
            } else if (acc.equals("2")) {
                notValidSelection = true;
                System.out.println("You Selected to Exit, Are you sure? Y/N");
                char answer = input.next().charAt(0);
                if (answer == 'y' || answer == 'Y') {
                    System.exit(1);

                } else {
                    mainMenu();
                }

            } else {
                System.out.println("You Entered Wrong Number Please Try Again");
                mainMenu();

            }

            if (!notValidSelection && !acc.equals("2")) {
                System.out.println("Loading");
            }
        } while (notValidSelection);
        while (Integer.parseInt(acc) > 0 && acc.equals("1")) {
            subMenu1();
        }

    }

    public void subMenu1() {
        System.out.println();
        System.out.println("=============================");
        System.out.println("    Receptionist Panel       ");
        System.out.println("=============================");
        System.out.println();
        System.out.println(" 1. Doctor");
        System.out.println(" 2. Patient");
        System.out.println(" 3. Search/View Information");
        System.out.println(" 4. Edit Information");
        System.out.println(" 5. Appointments");
        System.out.println(" 6. Treatments");
        System.out.println(" 7. Previous Menu");
        System.out.println(" 8. Exit");
        System.out.println();
        acc = input.nextLine();
        int condition = 0;
        do {
            if (acc.equals("1")) {
                doctorMenu();
            } else if (acc.equals("2")) {
                patientMenu();

            } else if (acc.equals("3")) {
                viewMenu();

            } else if (acc.equals("4")) {
                editMenu();

            } else if (acc.equals("5")) {
                appointmentMenu();

            } else if (acc.equals("6")) {
                treatmentMenu();
            } else if (acc.equals("7")) {
                mainMenu();
            } else if (acc.equals("8")) {
                System.out.println("You Selected to Exit, Are you sure? Y/N");
                char answer = input.next().charAt(0);
                if (answer == 'y' || answer == 'Y') {
                    System.exit(1);

                } else {
                    subMenu1();
                }

            } else {
                System.out.println("You Entered Wrong Number Please Try Again");
                subMenu1();
            }
        } while (condition != 8);

    }

    public void doctorMenu() {
        System.out.println("=============================");
        System.out.println("         1. Doctor            ");
        System.out.println("=============================");
        System.out.println(" 1. Load List of Existing Doctors From External File");
        System.out.println(" 2. Add a New Doctor");
        System.out.println(" 3. Receptionist Panel");
        System.out.println(" 4. Main Menu");
        System.out.println(" 5. Exit");
        int drMenuSelect = input.nextInt();
        input.nextLine();

        if (drMenuSelect == 1) {
            try {
                receptionist.DoctorReadFromFile();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
            System.out.println("List Loaded...");
        } else if (drMenuSelect == 2) {
            System.out.println(" Do you want to add a 1. Specialist or a 2. General Practitioner ? (Enter Number)");
            answer = input.nextInt();
            input.nextLine();
            System.out.println();
            while (true) {
                System.out.println(" Enter ID");
                drID = input.nextInt();
                if (sr.drUniqueID(drID, receptionist) == 0) {
                    break;
                } else if (sr.drUniqueID(drMenuSelect, receptionist) != 0) {
                    System.out.println("Duplicate id Error,another dr with this id already exists:");
                    System.out.println(sr.findDoctorByID(drID, receptionist));
                    System.out.println(" Please retry");
                }
            }
            input.nextLine();
            while (true) {
                System.out.println(" Enter Doctor`s name");
                drName = receptionist.fullnameCapitalizer(input.nextLine());
                if (Validation.validateName(drName)) {
                    break;
                }
                System.out.println(" Invalid Doctor name!\n");
            }
            while (true) {
                System.out.println(" Enter Doctor`s address");
                drAdd = input.nextLine();
                if (Validation.validatedrAdd(drAdd)) {
                    break;
                }
                System.out.println("\nInvalid Doctor address!\n");

            }
            while (true) {
                System.out.println(" Enter Doctor`s phone: (e.g.: xxx-xxx-xxxx)");
                drPhone = input.nextLine();
                if (Validation.validatePhone(drPhone)) {
                    break;
                }
                System.out.println("\nInvalid Doctor phone!\n");

            }

            System.out.println(" Enter Doctor`s BirthDate");
            System.out.println();
            System.out.println(" Enter Birth Year:");
            while (true) {
                System.out.println(" Enter Birth Year");
                year = input.nextInt();
                input.nextLine();
                if (Validation.validateYear(year)) {
                    break;
                }
                System.out.println("\nInvalid Birth Year!\n");

            }
            while (true) {
                System.out.println(" Enter Birth Month");
                month = input.nextInt();
                input.nextLine();
                if (Validation.validateMonth(month)) {
                    break;
                }
                System.out.println("\nInvalid Birth Month!\n");

            }
            while (true) {
                System.out.println(" Enter Birth Day");
                day = input.nextInt();
                input.nextLine();
                if (Validation.validateDay(day)) {
                    break;
                }
                System.out.println("\nInvalid Birth Day!\n");

            }
            Dateset drDateSet = new Dateset();
            LocalDate drBDate = drDateSet.dateSet(year, month, day);

            System.out.println("Enter Employement Date:");
            System.out.println();
            while (true) {
                System.out.println(" Enter Employement Year");
                yearEm = input.nextInt();
                input.nextLine();
                if (Validation.validateYear(yearEm)) {
                    break;
                }
                System.out.println("\nInvalid Employement Year!\n");

            }
            while (true) {
                System.out.println(" Enter Employement Month");
                monthEm = input.nextInt();
                input.nextLine();
                if (Validation.validateMonth(monthEm)) {
                    break;
                }
                System.out.println("\nInvalid Employement Month!\n");

            }
            while (true) {
                System.out.println(" Enter Employement Day");
                dayEm = input.nextInt();
                if (Validation.validateDay(dayEm)) {
                    break;
                }
                System.out.println("\nInvalid Employement Day!\n");

            }
            Dateset drEmDateSet = new Dateset();
            LocalDate drEmDate = drEmDateSet.dateSet(yearEm, monthEm, dayEm);
            input.nextLine();

            if (answer == 1) {

                System.out.println(" Enter Doctor`s Speciality");
                speciality = receptionist.capitalizer(input.nextLine());
                sp1 = new Specialist(drID, drName, drAdd, drBDate, drPhone, drEmDate, speciality);
                receptionist.addDoctorSpecialist(sp1);
                System.out.println(receptionist.viewDoctorsSpecialists());
                try {
                    drtxt.outputDoctor(drID, drName, drAdd, drBDate, drPhone, speciality, drEmDate);
                } catch (Exception e) {
                    System.out.println("Error" + e);
                }

            } else {
                Boolean gp = true;
                gp1 = new GeneralPractitioner(drID, drName, drAdd, drBDate, drPhone, drEmDate, gp);
                receptionist.addDoctorGp(gp1);
                System.out.println(receptionist.viewDoctorGP());
                try {
                    drtxt.outputGP(drID, drName, drAdd, drBDate, drPhone, gp, drEmDate);
                } catch (Exception e) {
                    System.out.println("Error" + e);
                }

            }
            System.out.println("New Doctor Added ");
        } else if (drMenuSelect == 3) {
            subMenu1();
        } else if (drMenuSelect == 4) {
            mainMenu();

        } else if (drMenuSelect == 5) {
            System.out.println("You Selected to Exit, Are you sure? Y/N");
            char answer = input.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {
                System.exit(1);

            } else {
                doctorMenu();
            }

        } else {
            System.out.println("You Entered Wrong Number Please Try Again");
            doctorMenu();

        }
    }

    public void patientMenu() {
        System.out.println("=============================");
        System.out.println("         2. Patient          ");
        System.out.println("=============================");
        System.out.println(" 1. Load List of Existing Patients From External File");
        System.out.println(" 2. Add a New Patient");
        System.out.println(" 3. Receptionist Panel");
        System.out.println(" 4. Exit");
        int ptMenuSelect = input.nextInt();
        input.nextLine();
        if (ptMenuSelect == 1) {
            try {
                receptionist.PatientReadFromFile();
            } catch (IOException e) {
                System.out.println("Error " + e);
            }

        } else if (ptMenuSelect == 2) {
            while (true) {
                System.out.println(" Enter ID");
                ptID = input.nextInt();
                if (sr.pUniqueID(ptID, receptionist) == 0) {
                    break;
                } else if (sr.pUniqueID(ptID, receptionist) != 0) {
                    System.out.println("Duplicate id Error,another patient with this id already exists:");
                    System.out.println(sr.findPatientByID(ptID, receptionist));
                    System.out.println(" Please retry");
                }
            }

            input.nextLine();
            while (true) {
                System.out.println(" Enter Patient`s name");
                pName = receptionist.fullnameCapitalizer(input.nextLine());
                if (Validation.validateName(pName)) {
                    break;
                }
                System.out.println(" Invalid Patient name!\n");
            }
            while (true) {
                System.out.println(" Enter Patient`s address");
                pAddress = input.nextLine();
                if (Validation.validatepAddress(pAddress)) {
                    break;
                }
                System.out.println("\nInvalid Patient address!\n");

            }
            while (true) {
                System.out.println(" Enter Patient`s phone: (e.g: xxx-xxx-xxxx)");
                pPhone = input.nextLine();
                if (Validation.validatePhone(pPhone)) {
                    break;
                }
                System.out.println("\nInvalid Patient phone!\n");

            }
            System.out.println(" Enter Patient`s BirthDate");
            while (true) {
                System.out.println(" Enter Birth Year");
                pBirthYear = input.nextInt();
                input.nextLine();
                if (Validation.validateYear(pBirthYear)) {
                    break;
                }
                System.out.println("\nInvalid Birth Year!\n");

            }
            while (true) {
                System.out.println(" Enter Birth Month");
                pBirthMonth = input.nextInt();
                input.nextLine();
                if (Validation.validateMonth(pBirthMonth)) {
                    break;
                }
                System.out.println("\nInvalid Birth Month!\n");

            }
            while (true) {
                System.out.println(" Enter Birth Day");
                pBirthDay = input.nextInt();
                if (Validation.validateDay(pBirthDay)) {
                    break;
                }
                System.out.println("\nInvalid Birth Day!\n");

            }
            Dateset pDateSet = new Dateset();
            LocalDate pBdate = pDateSet.dateSet(pBirthYear, pBirthMonth, pBirthDay);
            input.nextLine();
            System.out.println(" Enter Patient`s Employer Name");
            String pEmployerName = receptionist.capitalizer(input.nextLine());
            System.out.println(" Enter Patients Insurance Company");
            String pInsuranceCo = receptionist.capitalizer(input.nextLine());
            p = new Patient(ptID, pName, pAddress, pPhone, pBdate, pEmployerName, pInsuranceCo);
            receptionist.addPatient(p);
            System.out.println(" New Patient Added");
            System.out.println(receptionist.viewPatients());

            try {
                drtxt.outputPatient(ptID, pName, pAddress, pBdate, pPhone, pEmployerName, pInsuranceCo);
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
        } else if (ptMenuSelect == 2) {
            subMenu1();
        } else if (ptMenuSelect == 3) {
            subMenu1();
        } else if (ptMenuSelect == 4) {
            System.out.println("You Selected to Exit, Are you sure? Y/N");
            char answer = input.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {
                System.exit(1);
            } else {
                patientMenu();
            }
        } else {
            System.out.println("You Entered Wrong Number Please Try Again");
            patientMenu();

        }

    }

    public void viewMenu() {
        System.out.println("=============================");
        System.out.println("  3. Search/View Information ");
        System.out.println("=============================");
        System.out.println(" 1. View List of All Doctors- Specialists");
        System.out.println(" 2. View List of All Doctors- General Practitioners");
        System.out.println(" 3. View All Doctors");
        System.out.println(" 4. View List of All Patients");
        System.out.println(" 5. Search");
        System.out.println(" 6. Reception Panel");
        System.out.println(" 7. Exit");
        String ansViewMenu = input.nextLine();
        if (ansViewMenu.equals("1")) {
            System.out.println(" 3.1 List of All Doctors: Specialists");
            System.out.println(" ================================= ");
            System.out.println(receptionist.viewDoctorsSpecialists());

        } else if (ansViewMenu.equals("2")) {
            System.out.println("  3.2 List of All Doctors: General Practitioners");
            System.out.println(" ========================================== ");
            System.out.println(receptionist.viewDoctorGP());
        } else if (ansViewMenu.equals("3")) {
            System.out.println("List of All Doctors");
            System.out.println(" ========================================== ");
            System.out.println(receptionist.drviewall());

        } else if (ansViewMenu.equals("4")) {
            System.out.println(" 3.3 List of All Patients");
            System.out.println(" ====================== ");
            System.out.println(receptionist.viewPatients());

        } else if (ansViewMenu.equals("5")) {
            searchMenu();
        } else if (ansViewMenu.equals("6")) {
            subMenu1();

        } else if (ansViewMenu.equals("7")) {
            System.out.println("You Selected to Exit, Are you sure? Y/N");
            char answer = input.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {
                System.exit(1);

            } else {
                viewMenu();
            }

        } else {
            System.out.println("You Entered Wrong Number Please Try Again");
            viewMenu();

        }
    }

    public void searchMenu() {
        System.out.println("=============================");
        System.out.println("        3.4. Search           ");
        System.out.println("=============================");
        System.out.println(" 1. Search for Doctors Based On: Name ");
        System.out.println(" 2. Search for Doctors Based On: Date Of Birth ");
        System.out.println(" 3. Search for Doctors Based On: Speciality ");
        System.out.println(" 4. Search for Doctors Based On: Date Of Employement");
        System.out.println(" 5. Search for Patients Based On: Name ");
        System.out.println(" 6. Search for Patients Based On: Date Of Birth ");
        System.out.println(" 7. Search for Patientss Based On: Employer ");
        System.out.println(" 8. Search for Patients Based On: Insurance Company ");
        System.out.println(" 9. Receptionist Menu");
        System.out.println(" 10. Exit");
        int ansSearchMenu = input.nextInt();
        input.nextLine();

        if (ansSearchMenu == 1) {
            System.out.println(" Enter Doctor`s Name to search");
            String searchDrName = input.nextLine();
            System.out.println(" Information of Drs with " + searchDrName + " Name: "
                    + sr.findDoctorByName(searchDrName, receptionist));
        } else if (ansSearchMenu == 2) {
            System.out.println(" Enter Doctor`s Date of Birth to search");
            System.out.println("Enter birth year");
            int searchY = input.nextInt();
            System.out.println("Enter birth month");
            int searchM = input.nextInt();
            System.out.println("Enter birth day");
            int searchD = input.nextInt();
            input.nextLine();
            LocalDate searchdate = LocalDate.of(searchY, searchM, searchD);
            System.out.println("result" + sr.findDoctorByDateOfBirth(searchdate, receptionist));

        } else if (ansSearchMenu == 3) {
            System.out.println(" Enter a speciality to search ");
            String searchspec = input.nextLine();
            System.out.println(" Drs with " + searchspec + "Speciality: "
                    + sr.findDoctorBySpeciality(searchspec, receptionist));

        } else if (ansSearchMenu == 4) {
            System.out.println(" Enter Doctor`s Date of Employement");
            System.out.println("Enter Employement year");
            int empSearchY = input.nextInt();
            System.out.println("Enter Employement month");
            int empSearchM = input.nextInt();
            System.out.println("Enter Employement day");
            int empSearchD = input.nextInt();
            input.nextLine();
            LocalDate searchEmpDate = LocalDate.of(empSearchY, empSearchM, empSearchD);
            System.out.println("Result for Searching by Employement Date"
                    + sr.findDoctorByDateOfEmployement(searchEmpDate, receptionist));

        } else if (ansSearchMenu == 5) {
            System.out.println(" Enter Patient Name to search");
            String searchPtName = input.nextLine();
            System.out.println(" Information of Patients with " + searchPtName + " Name: "
                    + sr.findPatientByName(searchPtName, receptionist));
        } else if (ansSearchMenu == 6) {
            System.out.println(" Enter Patients`s Date of Birth to search");
            System.out.println("Enter birth year");
            int searchPtY = input.nextInt();
            System.out.println("enter birth month");
            int searchPtM = input.nextInt();
            System.out.println("enter birth day");
            int searchPtD = input.nextInt();
            input.nextLine();
            LocalDate searchPtDate = LocalDate.of(searchPtY, searchPtM, searchPtD);
            System.out.println("result" + sr.findPatientByDateOfBirth(searchPtDate, receptionist));

        } else if (ansSearchMenu == 7) {
            System.out.println(" Enter Patient Employer Name to search");
            String searchPtEmployerName = input.nextLine();
            System.out.println(" Information of Patients with " + searchPtEmployerName + " Employer: "
                    + sr.findPatientByEmployer(searchPtEmployerName, receptionist));

        } else if (ansSearchMenu == 8) {
            System.out.println(" Enter Patient Insurance Name to search");
            String searchPtInsurance = input.nextLine();
            System.out.println(" Information of Patients with " + searchPtInsurance + " Insurance: "
                    + sr.findPatientByInsuranceCo(searchPtInsurance, receptionist));

        } else if (ansSearchMenu == 9) {
            subMenu1();

        } else if (ansSearchMenu == 10) {
            System.out.println("You Selected to Exit, Are you sure? Y/N");
            char answer = input.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {
                System.exit(1);

            } else {
                searchMenu();

            }

        } else {
            System.out.println("You Entered Wrong Number Please Try Again");
            searchMenu();

        }

    }

    public void editMenu() {

        System.out.println("=============================");
        System.out.println("    4. Edit Information      ");
        System.out.println("=============================");
        System.out.println(" 1. Remove a Doctor");
        System.out.println(" 2. Remove a Patient");
        System.out.println(" 3. Update Doctors Birthdate");
        System.out.println(" 4. Update Patients Birthdate");
        System.out.println(" 5. Receptionist Menu");
        System.out.println(" 6. Exit");
        int edit = input.nextInt();
        input.nextLine();
        if (edit == 1) {
            System.out.println(" Enter Doctor`s Name to remove");
            String removeDr = input.nextLine();
            receptionist.removeDoctorBySearch(removeDr);
            System.out.println(" List After removal" + receptionist.viewDoctorsString());

        } else if (edit == 2) {
            System.out.println("Enter Patient`s Name to remove");
            String removePatient = input.nextLine();
            receptionist.removePatientBySearch(removePatient);
            System.out.println("List after removal" + receptionist.viewPatients());

        } else if (edit == 3) {
            System.out.println("Enter Doctor Name to Update Birthdate");
            String drBdateUpdate = input.nextLine();
            System.out.println("Enter new birthdate: Year:");
            int drNewDobY = input.nextInt();
            System.out.println("Enter new birthdate: Month:");
            int drNewDobM = input.nextInt();
            System.out.println("Enter new birthdate: Month:");
            int drNewDobD = input.nextInt();
            LocalDate drNewBdate = LocalDate.of(drNewDobY, drNewDobM, drNewDobD);
            receptionist.updateBirthdateDr(drNewBdate, drBdateUpdate);
            System.out.println(" Birthdate updated");

        } else if (edit == 4) {
            System.out.println("Enter Patient Name to Update Birthdate");
            String ptBdateUpdate = input.nextLine();
            System.out.println("Enter new birthdate: Year:");
            int ptNewDobY = input.nextInt();
            System.out.println("Enter new birthdate: Month:");
            int ptNewDobm = input.nextInt();
            System.out.println("Enter new birthdate: Month:");
            int ptNewDobd = input.nextInt();
            LocalDate ptNewBdate = LocalDate.of(ptNewDobY, ptNewDobm, ptNewDobd);
            receptionist.updateBirthdatePatient(ptNewBdate, ptBdateUpdate);
            System.out.println(" Birthdate updated");

        } else if (edit == 5) {
            subMenu1();

        } else if (edit == 6) {
            System.out.println("You Selected to Exit, Are you sure? Y/N");
            char answer = input.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {
                System.exit(1);
            } else {
                editMenu();
            }
        } else {
            System.out.println("You Entered Wrong Number Please Try Again");
            editMenu();

        }

    }

    public void appointmentMenu() {
        System.out.println("=============================");
        System.out.println("    5. Appointments   ");
        System.out.println("=============================");
        System.out.println(" 1. Add an Appointment");
        System.out.println(" 2. Receptionist Panel");
        System.out.println(" 3. Exit ");
        int appSelect = input.nextInt();
        input.nextLine();
        if (appSelect == 1) {
            System.out.println(" Enter date: Year -To Set a new Appointment");
            int y = input.nextInt();
            System.out.println(" Month:");
            int m = input.nextInt();
            System.out.println(" Day");
            int d = input.nextInt();
            Dateset dd = new Dateset();
            LocalDate appd = dd.dateSet(y, m, d);
            System.out.println(" Enter Start Time ,Hour: ");
            int sh = input.nextInt();
            System.out.println("  Minute: ");
            int sm = input.nextInt();
            LocalTime start = LocalTime.of(sh, sm, 0);
            System.out.println("Enter End Time, Hour: ");
            int eh = input.nextInt();
            System.out.println("  Minute: ");
            int em = input.nextInt();
            input.nextLine();
            LocalTime End = LocalTime.of(eh, em, 0);
            app = new Appointment(appd, End, start);
            System.out.println("Enter Patients Name to add into the appointment");
            String appPatientName = input.nextLine();
            System.out.println("Enter Doctors Name to add into the current appointment");
            String appDrName = input.nextLine();
            Patient appP = sr.appAssignPatientByName(appPatientName, receptionist);
            Specialist appSp = sr.appAssignDoctorByName(appDrName, receptionist);
            app.addPatient(appP);
            app.addDoctor(appSp);

            // receptionist.addAppointmentDrPatient(app, appSp, appP);

            System.out.println(receptionist.viewAppointments(app, appSp, appP));
        } else if (appSelect == 2) {
            subMenu1();
        } else if (appSelect == 3) {
            System.out.println("You Selected to Exit, Are you sure? Y/N");
            char answer = input.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {
                System.exit(1);
            } else {
                appointmentMenu();
            }
        } else {
            System.out.println("You Entered Wrong Number Please Try Again");
            appointmentMenu();

        }

    }

    public void treatmentMenu() {
        System.out.println("=============================");
        System.out.println("        6. Treatments        ");
        System.out.println("=============================");
        System.out.println(" 1. Add a Treatment");
        System.out.println(" 2. Remove a Treatment By ID");
        System.out.println(" 3. Remove a Treatment for specific Patient ");
        System.out.println(" 4. View Treatments for Specific Patient");
        System.out.println(" 5. View Treatments prescribed by specific Doctor");
        System.out.println(" 6. View All Treatments");
        System.out.println(" 7. Receptionist Menu");
        System.out.println((" 8. Exit"));
        int treatmentMenu = input.nextInt();
        input.nextLine();
        if (treatmentMenu == 1) {
            System.out.println("Add a treatment:");
            System.out.println("Enter Treatment ID");
            long treatmentID = input.nextLong();
            input.nextLine();
            System.out.println("Enter Patient Name for the treatment");
            String assignedPatient = input.nextLine();
            System.out.println("Enter Doctor`s Name for the treatment");
            String assignedDr = input.nextLine();
            System.out.println("Enter Treatments for Patient " + assignedPatient + " by " + assignedDr);
            String treatment = input.nextLine();
            receptionist.addTreatment(treatmentID, treatment, assignedDr, assignedPatient);

        } else if (treatmentMenu == 2) {
            System.out.println("Enter Treatment ID to remove");
            long treatmentIdRemove = input.nextLong();
            receptionist.removeTreatmentByID(treatmentIdRemove);
            System.out.println("Treatment removed!");

        } else if (treatmentMenu == 3) {
            System.out.println(" 3. Remove a Treatment for specific Patient ");
            System.out.println("Enter Patient`s Name");
            String assignedPtRemove = input.nextLine();
            receptionist.removeTreatmentByPatient(assignedPtRemove);
            System.out.println("Treatment Removed");

        } else if (treatmentMenu == 4) {
            System.out.println(" 4. View Treatments for Specific Patient");
            String assignedPtView = input.nextLine();
            System.out.println("List of Treatments for " + assignedPtView
                    + receptionist.getTreatmentsForPatient(assignedPtView));

        } else if (treatmentMenu == 5) {
            System.out.println("view Doctor`s Name to view the Treatment");
            String assignedDrTR = input.nextLine();
            System.out.println("List of Treatments for " + assignedDrTR
                    + receptionist.getTreatmentForDr(assignedDrTR));

        } else if (treatmentMenu == 6) {
            System.out.println("Treatment lists:" + receptionist.getTreatment());

        } else if (treatmentMenu == 7) {

            subMenu1();
        } else if (treatmentMenu == 8) {
            System.out.println("You Selected to Exit, Are you sure? Y/N");
            char answer = input.next().charAt(0);
            if (answer == 'y' || answer == 'Y') {
                System.exit(1);
            } else {
                treatmentMenu();
            }

        } else {
            System.out.println("You Entered Wrong Number Please Try Again");
            treatmentMenu();

        }

    }
}
