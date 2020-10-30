/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librairie;



import java.util.*;


public class Employe {

   private int id;
   private String login;
   private String password;
   private String dateD_entree;
   private String dateDeSortie;
   
   
   public Employe (String login, String password, String dateEntree) {
	   this.login = login; this.password = password; this.dateD_entree = dateEntree;
   }
   public Employe (String login, String password) {
	   this.login = login; this.password = password;
   }
   
   public int getId() {
		return id;
	}
   
   public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateD_entree() {
		return dateD_entree;
	}

	public void setDateD_entree(String dateD_entree) {
		this.dateD_entree = dateD_entree;
	}

	public String getDateDeSortie() {
		return dateDeSortie;
	}

	public void setDateDeSortie(String dateDeSortie) {
		this.dateDeSortie = dateDeSortie;
	}

   
   public Employe createEmploye() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 3aefca51-0787-43a3-9d9d-ff9f21604ba9 */
   public void archiveEmploye() {
      // TODO: implement
   }
   
   /** @pdOid 85d851c1-b18f-450e-a03c-99e5d86fb0ec */
   public Employe getEmploye() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 46e25762-d450-427f-bf9a-474c04df98ed */
   public java.lang.Character renewPassword() {
      // TODO: implement
      return null;
   }
   
   public String toString() {
	   return getLogin() + " " + getPassword() + " " + getDateDeSortie();
   }

}
