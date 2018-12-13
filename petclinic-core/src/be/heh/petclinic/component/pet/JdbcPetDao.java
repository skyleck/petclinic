package be.heh.petclinic.component.pet;

import be.heh.petclinic.domain.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Calendar;

class JdbcPetDao {
    private DataSource dataSource;

    public JdbcPetDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public Collection<Pet> getPets(){
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM pet ORDER BY ownerId", new PetRowMapper());
    }

    public Collection<Pet> getPets(int ownerId){
        JdbcTemplate template = new JdbcTemplate(dataSource);
        return template.query("SELECT * FROM pet WHERE ownerId = " + ownerId, new PetRowMapper());
    }

    public void addPet(Pet pet){
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("INSERT INTO pet (name, birthdate, typepet,ownerId) VALUES (?,?,?,?)",
                new Object[]{pet.getName(),pet.getBirthdate(),pet.getType().toString(),pet.getOwnerId()});
    }

    public void updatePet(int id,Pet pet) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("UPDATE pet SET name = ?, birthdate = ?, typepet = ? WHERE id = ?",
                new Object[]{pet.getName(),pet.getBirthdate(),pet.getType().toString(),id});
    }

    public void deletePet(int id) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("DELETE FROM pet WHERE id = ?",id);
    }
}
