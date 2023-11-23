/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author MAYSSAE JABBAR
 */
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
   @OneToMany(mappedBy = "cat", fetch = FetchType.EAGER)
    private List<Article> articles;
   
    @ManyToOne
    @JoinColumn(name = "cat_parent_id")
    private Categorie catParent;


    public Categorie() {
    }

    public Categorie(String nom, Categorie catParent) {
        this.nom = nom;
        this.catParent = catParent;
    }

    public Categorie(String nom) {
        this.nom = nom;
    }
    

 

    public void setCatParent(Categorie catParent) {
        this.catParent = catParent;
    }


    public Categorie getCatParent() {
        return catParent;
    }

   

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", nom=" + nom + ", articles=" + articles + ", catParent=" + catParent + '}';
    }
    
    
    
    
}
