package org.usman.dogs_cats.error;




public class IdOrNameNotFound  extends RuntimeException{

    public  IdOrNameNotFound(String string){
        super(string);
    }
}
