package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;

import be.heh.petclinic.domain.TypePet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PetRowMapper implements RowMapper<Pet> {

    @Override
    public Pet mapRow(ResultSet rs, int i) throws SQLException {
        Pet pet = new Pet(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("year"),
                rs.getInt("month"),
                rs.getInt("name"),
                Enum.valueOf(TypePet.class,rs.getString("type"))
        );
        return pet;
    }
}
