package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collection;

public class JdbcPetDao {
    private DataSource dataSource;

    public JdbcPetDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public Collection<Pet> getPets(){
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM pet", new PetRowMapper());
    }

    public void addPet(Pet pet){
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("INSERT INTO Pet (name, birthdate, pettype) VALUES (?,?,?)",
                new Object[]{pet.getName(),pet.getBirthdate(),pet.getType()});
    }

    public void updatePet(int id,Pet pet) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("UPDATE pet SET name = :name, birthdate = :birthdate, WHERE id",);
    }
}