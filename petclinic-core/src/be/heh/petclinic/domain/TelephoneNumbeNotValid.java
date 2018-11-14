package be.heh.petclinic.domain;

import java.io.IOException;

public class TelephoneNumbeNotValid extends IOException {

    public TelephoneNumbeNotValid(){
        super();
    }

    public TelephoneNumbeNotValid(String message){
        super(message);
    }
}
