package be.heh.petclinic.domain;

import be.heh.petclinic.domain.Exception.NullValueException;
import be.heh.petclinic.domain.Exception.TelephoneNumbeNotValid;

import java.util.ArrayList;

public class Owner extends AModelObject {

    private int id;
    private String lastname;
    private String firstname;
    private String address;
    private String city;
    private String telephone;
    private ArrayList<Pet> pets;

    public Owner(){}

    public Owner(int id, String lastname, String firstname, String address, String city, String telephone,
                        ArrayList<Pet> pets) throws TelephoneNumbeNotValid, NullValueException {
        this.id = id;
        this.setLastname(lastname);
        this.setFirstname(firstname);
        this.setAddress(address);
        this.setCity(city);
        this.setTelephone(telephone);
        this.pets = pets;
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

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setLastname(String lastname) throws NullValueException {
        this.setStringField(Owner.class,"lastname", lastname);
    }

    public void setFirstname(String firstname) throws NullValueException {
        this.setStringField(Owner.class ,"firstname", firstname);
    }

    public void setAddress(String address) throws NullValueException {
        this.setStringField(Owner.class,"address", address);
    }

    public void setCity(String city) throws NullValueException {
        this.setStringField(Owner.class,"city", city);
    }

    public void setTelephone(String telephone) throws be.heh.petclinic.domain.Exception.TelephoneNumbeNotValid {
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

    @Override
    public String toString() {
        return id + " " + lastname + " " + firstname + " " + address + " " + city + " " + telephone;
    }
}