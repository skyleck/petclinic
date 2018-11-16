package be.heh.petclinic.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Visit {
    
    private Pet pet;
    private Vet vet;
    
    private Calendar date;
    private String description;
    
    //..........................................................................
    
    public Visit() {
        this.date = new GregorianCalendar();
    }
    
    public Visit(int id, Pet pet, Vet vet, Calendar date, String description) {
        this.id = id;
        this.setPet(pet);
        this.setVet(vet);
        this.setDate(date);
        this.setDescription(description);
    }
    
    //--------------------------------------------------------------------------
    
    public Pet getPet() {
        return this.pet;
    }
    
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    public Vet getVet() {
        return this.vet;
    }
    
    public void setVet(Vet vet) {
        this.vet = vet;
    }
    
    public Calendar getDate() {
        return this.date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}