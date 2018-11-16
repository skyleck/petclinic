package be.heh.petclinic.component.visit;

import be.heh.petclinic.domain.Visit;

import javax.sql.DataSource;

import java.util.Collection;

class VisitComponentImpl implements VisitComponent {
    private JdbcVisitDao visitDao;
    
    public VisitComponentImpl(DataSource dataSource) {
        this.visitDao = new JdbcVisitDao(dataSource);
    }
    
    @Override
    public Collection<Visit> getVisits() {
        this.visitDao.getVisits();
    }
    
    @Override
    public void addVisit(Visit v) {
        this.visitDao.addVisit(v);
    }
    
    @Override
    public void updateVisit(Visit v) {
        this.visitDao.updateVisit(v);
    }
}