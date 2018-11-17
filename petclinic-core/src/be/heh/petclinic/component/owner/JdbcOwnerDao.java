package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.Pet;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class JdbcOwnerDao {

    private DataSource dataSource;

    public JdbcOwnerDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public Collection<Owner> getOwners(){
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM owner", new OwnerRowMapper());
    }

    public void addOwner(Owner owner){
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("INSERT INTO owner (lastname,firstname,address,city,telephone) VALUES (?,?,?,?,?)",
                             new Object[]{owner.getLastname(),
                                          owner.getFirstname(),
                                          owner.getAddress(),
                                          owner.getCity(),
                                          owner.getTelephone()});
    }

    public void updateOwner(int id, Owner owner){
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.update("UPDATE owner SET lastname = ?, firstname = ?,address = ?,city = ?,telephone = ? WHERE id = ?",
                new Object[]{owner.getLastname(),
                            owner.getFirstname(),
                            owner.getAddress(),
                            owner.getCity(),
                            owner.getTelephone(),
                            id});
    }
}