package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;

import be.heh.petclinic.domain.TypePet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;


public class PetRowMapper implements RowMapper<Pet> {

    @Override
    public Pet mapRow(ResultSet rs, int i) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(rs.getDate("birthdate"));
        Pet pet = new Pet(
                rs.getInt("id"),
                rs.getString("name"),
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) +1,//!!!
                calendar.get(Calendar.DATE) +1,//!!! Dont know why
                Enum.valueOf(TypePet.class,rs.getString("typepet"))
        );
        return pet;
    }
}
