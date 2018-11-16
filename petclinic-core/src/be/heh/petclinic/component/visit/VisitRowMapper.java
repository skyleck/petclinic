package be.heh.petclinic.component.visit;

import be.heh.petclinic.domain.Visit;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

public class VisitRowMapper implements RowMapper<Visit> {
    
    @Override
    public Visit mapRow(ResultSet rs, int i) throws SQLException {
        Calendar visitdate = GregorianCalendar();
        calendar.setTime(rs.getDate("vi.visitdate"));
        Calendar birthdate = GregorianCalendar();
        calendar.setTime(rs.getDate("p.birthdate"));
        
        return new Visit(rs.getInt("vi.id"),
            new Pet(rs.getInt("vi.pet_id"), rs.getString("p.name"),
                birthdate, Enum.valueOf(TypePet.class,rs.getString("typepet"),
                new Owner(rs.getInt("p.owner_id"), rs.getString("o.firstname"),
                    rs.getString("o.lastname"), rs.getString("o.address"),
                    rs.getString("o.city"), rs.getString("o.telephone"))),
            new Vet(rs.getInt("vi.vet_id"), rs.getString("ve.firstname"),
                rs.getString("ve.lastname"), rs.getString("ve.speciality")),
                visitdate, rs.getString("vi.description"));
    }
}