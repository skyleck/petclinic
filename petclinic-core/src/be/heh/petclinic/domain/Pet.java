package be.heh.petclinic.domain;

import be.heh.petclinic.domain.Exception.NullValueException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Pet extends AModelObject {
    private int id;
    private String name;
    private Calendar birthdate;
    private String birthdateString;
    private TypePet type;
    private int ownerId;
    //private ArrayList<Visit> visits;

    public Pet(int id,String name, int year, int month, int day, TypePet type, int ownerId) throws NullValueException {
        this.id=id;
        this.setName(name);
        birthdate = Calendar.getInstance();
        birthdate.set(year,month,day);
        System.out.println("DATE+++ : "+year +"/"+month+"/"+day);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.birthdateString = simpleDateFormat.format(birthdate.getTime());
        this.type=type;
        this.ownerId = ownerId;
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

    public void setName(String name) throws NullValueException {
        this.setStringField(Pet.class, "name", name);
    }

    public void setBirthdate(int year, int month, int day) {
        this.birthdate = new GregorianCalendar(year,month,day);
    }

    public void setType(TypePet type) {
        this.type = type;
    }

    public int getOwnerId(){
        return  ownerId;
    }

    /*public ArrayList<Visit> getvisits() {
        return this.visits;
    }*/

    /*public void addVisit(Visit visit) {
        this.visits.add(visit);
    }*/

    @Override
    public boolean equals(Object obj) {
        Calendar calendar = ((Pet)obj).getBirthdate();
        System.out.println("PO : " + calendar.get(Calendar.YEAR) + " == " + this.getBirthdate().get(Calendar.YEAR));
        return (((Pet) obj).getId()==this.getId()
                &&((Pet) obj).getName().equals(this.getName())
                && ((Pet) obj).getBirthdate().get(Calendar.YEAR) == this.getBirthdate().get(Calendar.YEAR))
                && ((Pet) obj).getType().equals(this.getType());
    }

    @Override
    public String toString() {
        return  birthdate.get(Calendar.YEAR) + " " + birthdate.get(Calendar.MONTH) + " " + birthdate.get(Calendar.DAY_OF_MONTH);
    }

    public String getBirthdateString() {
        return birthdateString;
    }
}