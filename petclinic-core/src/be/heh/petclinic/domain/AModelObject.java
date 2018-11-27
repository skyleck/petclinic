package be.heh.petclinic.domain;

import be.heh.petclinic.domain.Exception.NullValueException;

import java.lang.reflect.Field;

abstract class AModelObject {

    protected void setStringField(Class c,String field, String value) throws NullValueException {

        if(value == null || value.isEmpty())
            throw new NullValueException(field);

        try {
            Field f = c.getDeclaredField(field);
            f.setAccessible(true);
            f.set(this,value);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
