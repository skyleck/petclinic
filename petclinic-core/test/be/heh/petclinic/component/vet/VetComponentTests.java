package be.heh.petclinic.component.vet;

import be.heh.petclinic.AbstractComponentTestBase;
import be.heh.petclinic.domain.Exception.NullValueException;
import be.heh.petclinic.domain.Vet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class VetComponentTests extends AbstractComponentTestBase {

    private Collection<Vet> list;

    @BeforeEach
    public void setUp() throws NullValueException {
        list = new ArrayList<Vet>();

        list.add(new Vet("Carter", "James", "none"));
        list.add(new Vet("Helen", "Leary", "radiology"));
        list.add(new Vet("Douglas", "Linda", "dentistry surgery"));
        list.add(new Vet("Ortega", "Rafael", "surgery"));
        list.add(new Vet("Stevens", "Henry","radiology"));
        list.add(new Vet("Jenkins", "Sharon","none"));
    }

    @Test
    public void getVets(){
        assertIterableEquals(list, getVetComponent().getVets());
    }
}
