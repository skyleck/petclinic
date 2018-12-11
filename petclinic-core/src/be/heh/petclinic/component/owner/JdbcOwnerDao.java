package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class JdbcOwnerDao {

    private DataSource dataSource;

    public JdbcOwnerDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public Owner getOwner(int id){
        JdbcTemplate template = new JdbcTemplate(dataSource);
        Collection<Owner> owners = template.query("SELECT * FROM owner WHERE id = "+id,new OwnerRowMapper());
        if(owners.size() != 0){
            return  ((List<Owner>) owners).get(0);
        }
        return null;
    }

    public Collection<Owner> getOwners(){
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM owner", new OwnerRowMapper());
    }

    public void addOwner(Owner owner){
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("INSERT INTO owner (lastname,firstname,address,city,telephone,pets) VALUES (?,?,?,?,?,?)",
                             new Object[]{owner.getLastname(),
                                          owner.getFirstname(),
                                          owner.getAddress(),
                                          owner.getCity(),
                                          owner.getTelephone(),
                                          " "});
    }

    public void updateOwner(int id, Owner owner){
        JdbcTemplate template = new JdbcTemplate(dataSource);
        StringBuilder pets = new StringBuilder();
        if(owner.getPets() != null && owner.getPets().size() != 0){
            for (Pet pet:owner.getPets()) {
                pets.append(pet.getName() + " ");
            }
        } else {
            pets.append(" ");
        }
        template.update("UPDATE owner SET lastname = ?, firstname = ?,address = ?,city = ?,telephone = ?, pets = ? " +
                            "WHERE id = ?",
                             new Object[]{owner.getLastname(),
                                owner.getFirstname(),
                                owner.getAddress(),
                                owner.getCity(),
                                owner.getTelephone(),
                                pets,
                                id});
    }
}