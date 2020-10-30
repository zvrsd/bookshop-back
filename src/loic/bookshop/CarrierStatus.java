/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

/**
 *
 * @author Loïc
 */
public class CarrierStatus {
    
    long id;
    String label;
    String postIt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPostIt() {
        return postIt;
    }

    public void setPostIt(String postIt) {
        this.postIt = postIt;
    }

    public CarrierStatus(long id, String label, String postIt) {
        this.id = id;
        this.label = label;
        this.postIt = postIt;
    }

    @Override
    public String toString() {
        return label;
    }
    
    
    
}
