package be.heh.petclinic.component.visit;

import be.heh.petclinic.domain.Visit;

import java.util.Collection;

public interface VisitComponent {
    Collection<Visit> getVisits();
    
    void addVisit(Visit v);
    
    void updateVisit(Visit v);
}