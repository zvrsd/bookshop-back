package com.nope.bookshop.entity;
/**
 *
 * @author Cy
 */
public class Group {

    private int groupId;
    private String groupName;
    
    public Group(){
        
    }
    public Group(int groupId, String groupName){
        
    }
    public Group(String GroupName){
                
    }
        public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}