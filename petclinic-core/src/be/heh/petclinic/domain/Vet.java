package be.heh.petclinic.domain;

import be.heh.petclinic.domain.Exception.NullValueException;

public class Vet extends AModelObject{

    private String lastname;
    private String firstname;
    private String speciality;

    public Vet(){}

    public Vet(String lastname, String firstname, String speciality) throws NullValueException {
        this.setLastname(lastname);
        this.setFirstname(firstname);
        this.setSpeciality(speciality);
    }

    public void setLastname(String lastname) throws NullValueException {
        this.setStringField(Vet.class,"lastname", lastname);
    }

    public void setFirstname(String firstname) throws NullValueException {
        this.setStringField(Vet.class,"firstname", firstname);
    }

    public void setSpeciality(String speciality) throws NullValueException {
        this.setStringField(Vet.class,"speciality", speciality);
    }

    public String getLastname(){
        return this.lastname;
    }

    public String getFirstname(){
        return this.firstname;
    }

    public String getSpeciality(){
        return this.speciality;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Vet) obj).getFirstname().equals(this.getFirstname())
                && ((Vet) obj).getLastname().equals(this.getLastname())
                && ((Vet) obj).getSpeciality().equals(this.getSpeciality());
    }
}
