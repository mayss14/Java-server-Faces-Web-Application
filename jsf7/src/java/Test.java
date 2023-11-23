
import ma.projet.beans.Article;
import ma.projet.beans.Categorie;
import ma.projet.service.ArticleService;

import ma.projet.service.CategorieService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LACHGAR
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        CategorieService catser = new CategorieService();
        ArticleService artser = new ArticleService();
    
       catser.create(new Categorie("electromenagers"));
       catser.create(new Categorie("meuble",catser.getById(1)));
       
       artser.create(new Article("Art1",null,catser.getById(1)));
       
       
      
    }
}
