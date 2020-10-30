package com.nope.bookshop.entity;

import librairie.Customer;
import librairie.Order_Row;

/**
 *
 * @author Cy
 */
public class Comment {

    private int commentId;
    private Customer customer;
    private Order_Row orderRow;
    private Book book;
    private String commentTitle;
    private int commentRating;
    private String commentText;
    private String commentDate;
    private String commentUserIp;
    private String commentEditDate;
    
    public Comment(){
        
    }
    public Comment(int commentId, Customer customer, Order_Row orderRow, Book book, String commentTitle, int commentRating, String commentText, String commentUserIp, String commentEditDate){
        
    }
    public Comment(Customer customer, Order_Row orderRow, Book book, String commentTitle, int commentRating, String commentText, String commentUserIp, String commentEditDate){
        
    }
   
      public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order_Row getOrderRow() {
        return orderRow;
    }

    public void setOrderRow(Order_Row orderRow) {
        this.orderRow = orderRow;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public int getCommentRating() {
        return commentRating;
    }

    public void setCommentRating(int commentRating) {
        this.commentRating = commentRating;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentUserIp() {
        return commentUserIp;
    }

    public void setCommentUserIp(String commentUserIp) {
        this.commentUserIp = commentUserIp;
    }

    public String getCommentEditDate() {
        return commentEditDate;
    }

    public void setCommentEditDate(String commentEditDate) {
        this.commentEditDate = commentEditDate;
    }

}