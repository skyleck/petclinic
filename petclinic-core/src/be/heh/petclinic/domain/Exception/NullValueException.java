package be.heh.petclinic.domain.Exception;

import java.io.IOException;

public class NullValueException  extends IOException {

    public NullValueException(){
        super();
    }

    public NullValueException(String message){
        super(message);
    }
}
