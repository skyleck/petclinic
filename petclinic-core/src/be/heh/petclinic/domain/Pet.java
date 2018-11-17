package be.heh.petclinic.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pet {
    private int id;
    private String name;
    private Calendar birthdate;
    private TypePet type;
    private int ownerId;
    //private ArrayList<Visit> visits;

    public Pet(int id,String name, int year, int month, int day, TypePet type, int ownerId) {
        this.id=id;
        this.name = name;
        this.birthdate = new GregorianCalendar(year,month,day);
        this.type = type;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(int year, int month, int day) {
        this.birthdate = new GregorianCalendar(year,(month-1),day);// !!!
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
}