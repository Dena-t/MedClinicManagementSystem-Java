package ProjectV6;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private String address;
    private LocalDate birtDate;
    private String phone;

    private int id;

    public Person() {
        this.name = "";
        this.address = "";
        this.birtDate = LocalDate.now();
        this.phone = "";
        this.id = 0;
    }

    public Person(int anId, String aName, String aAddress, LocalDate aBirthDate, String aPhone) {
        this.name = aName;
        this.address = aAddress;
        this.birtDate = aBirthDate;
        this.phone = aPhone;
        this.id = anId;
    }

    public void setName(String theName) {
        this.name = theName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirtDate(LocalDate birtDate) {
        this.birtDate = birtDate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirtDate() {
        return birtDate;
    }

    public String getPhone() {
        return phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void updateBirthDate(LocalDate aNewBirthDate) {

        setBirtDate(aNewBirthDate);

    }

    @Override
    public String toString() {
        return String.format("ID: %d Name: %s Address: %s Phone: %s  Birthdate: %s", getId(), getName(), getAddress(),
                getPhone(),
                getBirtDate().toString());
    }
}
