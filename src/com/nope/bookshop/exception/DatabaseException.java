
package com.nope.bookshop.exception;

/**
 *
 * @author cda601
 */
public class DatabaseException extends Exception{

    private int type;
    private String message;
    
    public DatabaseException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
