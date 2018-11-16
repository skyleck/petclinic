package be.heh.petclinic.component.visit;

import be.heh.petclinic.domain.Visit;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collection;

public class JdbcVisitDao {

    private DataSource dataSource;

    public JdbcVisitDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public Collection<Visit> getVisits() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        StringBuilder s = new StringBuilder();
        s.append("SELECT vi.id, vi.visitdate, vi.description,");
        s.append("vi.vet_id, ve.firstname, ve.lastname, ve.speciality,");
        s.append("vi.pet_id, p.name, p.birthdate, p.pettype,");
        s.append("p.owner_id, o.firstname, o.lastname, o.address, o.city, o.telephone");
        s.append("FROM visits vi");
        s.append("INNER JOIN vets ve ON vi.vet_id = ve.id");
        s.append("INNER JOIN pets p ON vi.pet_id = p.id");
        s.append("INNER JOIN owners o ON p.owner_id = o.id;");
        return select.query(s.toString(), new VisitRowMapper());
    }
    
    public void addVisit(Visit v) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("INSERT INTO visits :" +
                "(pet_id, vet_id, visitdate, description) VALUES (?,?,?,?)",
        new Object[]{v.getPet().getId(), v.getVet().getId(),
                            v.getDate(), v.getDescription()});
    }
    
    public void updateVisit(Visit v) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("UPDATE visits SET pet_id = ?, vet_id = ?," +
                "visitdate = ?, description = ? WHERE id = ?",
        new Object[]{v.getPet().getId(), v.getVet().getId(),
                            v.getDate(), v.getDescription(), v.getId()});
    }
}