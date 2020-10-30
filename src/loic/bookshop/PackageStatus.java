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
public class PackageStatus {
    
    private Long id;
    private String label;
    
    // accesseurs

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    // constructeur

    public PackageStatus(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    
    
    
}