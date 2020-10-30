package com.nope.bookshop.entity;
/**
 *
 * @author Cy
 */
public class Permission {

    private int permissionId;
    private String permissionName;
    
    public Permission(){
        
    }
    public Permission(int permissionId, String permissionName){
        
    }
    public Permission(String permissionName){
                
    }
        public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public String setPermissionName(String permissionName) {
        this.permissionName = permissionName;
        return null;
    }


}