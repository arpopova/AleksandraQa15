package addressbook.model;

public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String telephone;
    private String email;

    public Contact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public Contact setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }
}
