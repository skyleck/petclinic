package be.heh.petclinic.component.vet;

import be.heh.petclinic.domain.Vet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class VetComponentImpl implements VetComponent {

    private Collection<Vet> vets = new ArrayList<>();

    @Override
    public Collection<Vet> getVets() {
        vets.add(new Vet("James","James","none"));
        vets.add(new Vet("Helen","Helen","radiology"));
        vets.add(new Vet("Linda","Linda","surgery"));

        return vets;
    }
}
