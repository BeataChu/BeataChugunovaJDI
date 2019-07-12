package homework7.entities;

public enum HeaderMenuData {
    Home("Home"),
    ContactForm("Contact form"),
    Service("Service"),
    Support("Support"),
    Dates("Dates"),
    Search("Search"),
    ComplexTable("Complex Table"),
    SimpleTable("Simple Table"),
    UserTable("User Table"),
    TableWithPages("Table with pages"),
    DifferentElements("Different elements"),
    Performance("Performance"),
    MetalsColors("Metals & Colors");


    public String value;

    HeaderMenuData(String value) {
        this.value = value;
    }

    public String getUpperCase() {
        return value.toUpperCase();
    }
}
