package be.heh.petclinic.component.owner;

import be.heh.petclinic.domain.Owner;
import be.heh.petclinic.domain.TelephoneNumbeNotValid;
import be.heh.petclinic.domain.Vet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerRowMapper  implements RowMapper<Owner> {

    @Override
    public Owner mapRow(ResultSet rs, int i) throws SQLException {
        Owner owner = null;
        try {
            owner = new Owner(rs.getInt("id"),
                                    rs.getString("lastname"),
                                    rs.getString("firstname"),
                                    rs.getString("address"),
                                    rs.getString("city"),
                                    rs.getString("telephone"));
        } catch (TelephoneNumbeNotValid telephoneNumbeNotValid) {
            telephoneNumbeNotValid.printStackTrace();
        }
        return owner;
    }
}