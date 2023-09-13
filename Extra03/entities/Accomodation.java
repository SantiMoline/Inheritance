package Extra03.entities;

public class Accomodation {
    private String name;
    private String address;
    private String city;
    private String managerName;


    public Accomodation(String name, String address, String city, String managerName) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.managerName = managerName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getManagerName() {
        return this.managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }


    @Override
    public String toString() {
        return "------------------------------------------" +
            "\nName: " + getName() +
            "\nAddress: " + getAddress() +
            "\nCity: " + getCity() +
            "\nManager's name: " + getManagerName();
    }

}
