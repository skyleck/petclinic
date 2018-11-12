package be.heh.petclinic.component.vet;

import be.heh.petclinic.domain.Vet;

import javax.sql.DataSource;

import java.util.Collection;
import java.util.List;

class VetComponentImpl implements VetComponent {

    private JdbcVetDao vetDao;

    public VetComponentImpl(DataSource dataSource){
        vetDao = new JdbcVetDao(dataSource);
    }
    @Override
    public Collection<Vet> getVets() {
        List<Vet> vets = vetDao.getVets();
        return vets;
    }
}
