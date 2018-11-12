package be.heh.petclinic.component.vet;

import be.heh.petclinic.domain.Vet;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcVetDao {

    private DataSource dataSource;

    public JdbcVetDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Vet> getVets() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT lastname, firstname, speciality FROM vet", new VetRowMapper());
    }
}
