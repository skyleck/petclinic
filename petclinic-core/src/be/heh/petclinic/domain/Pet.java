package be.heh.petclinic.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pet {
    private int id;
    private String name;
    private Calendar birthdate;
    private TypePet type;
    //private ArrayList<Visit> visits;

    public Pet(int id,String name, int year, int month, int day, TypePet type) {
        this.id=id;
        this.name = name;
        month = month-1; // Car janvier = l'index 0 de la liste !!!
        this.birthdate = new GregorianCalendar(year,month,day);
        this.type = type;
    }

    public int getId() { return this.id; }

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

    public void setBirthdate(int year, int month, int day) {
        this.birthdate = new GregorianCalendar(year,month,day);
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