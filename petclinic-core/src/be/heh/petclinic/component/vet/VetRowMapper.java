package be.heh.petclinic.component.vet;

import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;
import java.sql.ResultSet;

import be.heh.petclinic.domain.Vet;

public class VetRowMapper implements RowMapper<Vet> {

    @Override
    public Vet mapRow(ResultSet rs,int i) throws SQLException {
        Vet vet = new Vet();
        vet.setLastname(rs.getString("lastname"));
        vet.setFirstname(rs.getString("firstname"));
        vet.setSpeciality(rs.getString("speciality"));
        return vet;
    }
}