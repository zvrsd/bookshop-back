/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librairie;


/***********************************************************************
 * Module:  Auteur.java
 * Author:  Charlène
 * Purpose: Defines the Class Auteur
 ***********************************************************************/

import java.util.*;

/** @pdOid 309638e6-2cbf-40b2-b086-9e9cf9bfab6c */
public class Author implements Comparable {
   /** @pdOid 03cb6453-5a94-4d9f-a4b7-f8911bf3819d */
  
   private Author auteur; 
   private String name;
   private String firstname;
   private String postIt;
   
   public Author (Long id, String name, String firstname, String postIt) {
	   this.id = id; this.name = name; this.firstname = firstname; this.postIt = postIt;
   }
   
   public Author (Long id, String name, String firstname) {
	   this.id = id; this.name = name; this.firstname = firstname;
   }
   
   public Author(String name, String firstname) {
	    this.name = name; this.firstname = firstname;
   }
   
   public Author(String name, String firstname, String postIt) {
	    this.name = name; this.firstname = firstname; this.postIt = postIt;
   }
   
   private Long id;
   public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getPostIt() {
	return postIt;
}

public void setPostIt(String postIt) {
	this.postIt = postIt;
}

public void createAuthor(String name, String firstname, String postIt) {
	Author auteur = new Author(name, firstname, postIt); 
	//Ajouter la méthode de sauvegarde DAO
}

public void createAuthor(String name, String firstname) {
	Author auteur = new Author(name, firstname); 
	//Ajouter la méthode de sauvegarde DAO
}
   
   public Author getAuteur() {
      // TODO: implement
      return null;
   }
   

   public boolean equals(Author auteur) {
	   return
	  auteur instanceof Author &&
	   ((Author)auteur).name.equalsIgnoreCase(name) &&
	   ((Author)auteur).firstname.equalsIgnoreCase(firstname);
	   }
   
	   public int hashCode() {
	   return 31*name.hashCode() + firstname.hashCode();
	   }
	   
	   
	   public int compareTo(Object o) {
	  Author auteur = (Author)o;
	   int compAuthor = name.compareTo(auteur.name);
	   return
	   compAuthor!=0 ? compAuthor : ((Author)o).firstname.compareTo(firstname);
	   }


}
