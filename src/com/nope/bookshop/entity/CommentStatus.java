package com.nope.bookshop.entity;
/**
 *
 * @author Cy
 */
public class CommentStatus {

    private int commentStatusId;
    private String commentStatusName;
    private String commentStatusPostIt;
    
    public CommentStatus(){
        
    }
    public CommentStatus(int commentStatusId, String commentStatusName, String commentStatusPostIt){
        
    }
    public CommentStatus(String commentStatusName, String commentStatusPostIt){
                
    }

    public int getCommentStatusId() {
        return commentStatusId;
    }

    public void setCommentStatusId(int commentStatusId) {
        this.commentStatusId = commentStatusId;
    }

    public String getCommentStatusName() {
        return commentStatusName;
    }

    public void setCommentStatusName(String commentStatusName) {
        this.commentStatusName = commentStatusName;
    }

    public String getCommentStatusPostIt() {
        return commentStatusPostIt;
    }

    public void setCommentStatusPostIt(String commentStatusPostIt) {
        this.commentStatusPostIt = commentStatusPostIt;
    }
    
}