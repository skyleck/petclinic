package be.heh.petclinic.component.owner;

import be.heh.petclinic.AbstractComponentTestBase;
import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.TelephoneNumbeNotValid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class JdbcOwnerDaoTest extends AbstractComponentTestBase {

    private JdbcOwnerDao jdbcOwnerDao;
    private JdbcTemplate template;
    private ArrayList<Owner> list;

    @BeforeEach
    public void setUp() throws TelephoneNumbeNotValid {
        DataSource dataSource = (DataSource)applicationContext.getBean("dataSource");
        template = getJdbcTemplate();
        jdbcOwnerDao = new JdbcOwnerDao(dataSource);

        list = new ArrayList<Owner>();

        list.add(new Owner(1,"Franklin","George","10 W.Liberty St.","Madison",
                            "6085551023"));
        list.add(new Owner(2,"Davis","Betty","638 Cardinal Ave.","Sun Prairie",
                            "6085551749"));
        list.add(new Owner(3,"Rodriquez","Eduardo","2693 Commerce St.","McFarland",
                            "6085558763"));
    }

    @Test
    void getOwners() throws TelephoneNumbeNotValid {
        ArrayList<Owner> loadOwner1 = (ArrayList<Owner>)jdbcOwnerDao.getOwners();
        assertEquals(list.size(),loadOwner1.size());
        assertIterableEquals(list, loadOwner1);
        addOwner();
        updateOwner();
    }

    void addOwner() throws TelephoneNumbeNotValid {
        Owner owner = new Owner(4,"test","test","test","test",
                "0425636696");
        this.list.add(owner);
        jdbcOwnerDao.addOwner(owner);
        Collection<Owner> loadOwner = jdbcOwnerDao.getOwners();
        ArrayList<Owner> test = (ArrayList<Owner>) loadOwner;
        assertEquals(owner, test.get(loadOwner.size()-1));
    }

    void updateOwner() throws TelephoneNumbeNotValid {
        Owner owner = new Owner(4, "Louzo","Stan","89 Avenue du Roi","Mouscron",
                                    "0479636532");
        this.jdbcOwnerDao.updateOwner(4,owner);
        Collection<Owner> loadOwner = jdbcOwnerDao.getOwners();
        ArrayList<Owner> test = (ArrayList<Owner>) loadOwner;
        assertEquals(owner, test.get(loadOwner.size()-1));
    }
}
