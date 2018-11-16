package be.heh.petclinic.domain;

public class Owner {
    int id;
    private String lastname;
    private String firstname;
    private String address;
    private String city;
    private String telephone;

    public Owner(int id, String lastname, String firstname, String address, String city, String telephone)
                    throws TelephoneNumbeNotValid {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.city = city;
        this.setTelephone(telephone);
    }

    public int  getId(){
        return id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTelephone(String telephone) throws TelephoneNumbeNotValid {
        if(telephone.matches("^\\d{3,4}[/]?(\\s?\\d{2}?){3}$")) {
            this.telephone = telephone;
        }
        else {
            throw new TelephoneNumbeNotValid("Telephone number is not valid");
        }
    }

    @Override
    public boolean equals(Object obj) {
        return (((Owner) obj).getId() == id &&
                ((Owner) obj).getLastname().equals(lastname) &&
                ((Owner) obj).getFirstname().equals(firstname) &&
                ((Owner) obj).getAddress().equals(address) &&
                ((Owner) obj).getCity().equals(city) &&
                ((Owner) obj).getTelephone().equals(telephone));
    }
}