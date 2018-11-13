package be.heh.petclinic.domain;

import java.util.ArrayList;
import java.util.Calendar;

public class Pet {
    private String name;
    private Calendar birthdate;
    private TypePet type;
    //private ArrayList<Visit> visits;

    public Pet(String name, Calendar birthdate, TypePet type) {
        this.name = name;
        this.birthdate = birthdate;
        this.type = type;
    }

    public String getName(){
        return this.name;
    }

    public Calendar getBirthdate() {
        return this.birthdate;
    }

    public TypePet getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }

    public void setType(TypePet type) {
        this.type = type;
    }

    /*public ArrayList<Visit> getvisits() {
        return this.visits;
    }*/

    /*public void addVisit(Visit visit) {
        this.visits.add(visit);
    }*/
}