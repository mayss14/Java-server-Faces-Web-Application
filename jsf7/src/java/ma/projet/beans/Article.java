/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import java.util.Locale.Category;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author MAYSSAE JABBAR
 */
@Entity
public class Article {
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
     private String nom;
    @Temporal(javax.persistence.TemporalType.DATE)
    private  Date dateProd;
    @ManyToOne
    private Categorie cat;


    public Categorie getCat() {
        return cat;
    }

    public void setCat(Categorie cat) {
        this.cat = cat;
    }
  
    public Article() {
    }

    
    public Article(String nom, Date dateProd) {
        this.nom = nom;
        this.dateProd = dateProd;
    }

    public Article(String nom, Date dateProd, Categorie cat) {
        this.nom = nom;
        this.dateProd = dateProd;
        this.cat = cat;
    }
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateProd() {
        return dateProd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateProd(Date dateProd) {
        this.dateProd = dateProd;
    }
    
    
    
    
    
    
   
}
