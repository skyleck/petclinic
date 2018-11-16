package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;

class OwnerComponentImpl implements OwnerComponent {

    private JdbcOwnerDao ownerDao;

    public OwnerComponentImpl(DataSource dataSource){
        ownerDao = new JdbcOwnerDao(dataSource);
    }

    @Override
    public Collection<Owner> getOwner(){
        return ownerDao.getOwners();
    }

    @Override
    public void addOwner(Owner owner) {
        ownerDao.addOwner(owner);
    }

    @Override
    public void updateOwner(int id, Owner owner) {
        ownerDao.updateOwner(id,owner);
    }
}
