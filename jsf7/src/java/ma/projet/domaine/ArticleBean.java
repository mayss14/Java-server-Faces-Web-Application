/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.domaine;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import ma.projet.beans.Article;
import ma.projet.beans.Categorie;
import ma.projet.service.ArticleService;
import ma.projet.service.CategorieService;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author MAYSSAE JABBAR
 */
@ManagedBean(name = "articleBean")
public class ArticleBean {

    private Article art;
    private ArticleService artser;
    private CategorieService catser;
    private List<Categorie> cats;
    private List<Article> arts;
    private Categorie cat;
    private Date date1;
    private Date date2;
    private List<Article> artsbetweendates;

    public ArticleBean() {

        art = new Article();
        artser = new ArticleService();
        catser = new CategorieService();
        cat = new Categorie();
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }
    

    public Article getArt() {
        return art;
    }

    public void setArt(Article art) {
        this.art = art;
    }

    public void setArtser(ArticleService artser) {
        this.artser = artser;
    }

    public String onCreateAction() {
        art.setCat(catser.getById(cat.getId()));
        artser.create(art);
        arts = artser.getAll();
        art = new Article();
        return null;
    }

    public List<Article> getArts() {
        if (arts == null) {
            arts = artser.getAll();
        }
        return arts;
    }

    public void setArts(List<Article> arts) {
        this.arts = arts;
    }

    public void onEdit(RowEditEvent event) {
        art = (Article) event.getObject();
        Article a = artser.getById(art.getId());
        Categorie c = catser.getById(cat.getId());

        a.setNom(art.getNom());
        a.setDateProd(art.getDateProd());
        a.setCat(c);
        a.getCat().setNom(c.getNom());

        artser.update(a);
        arts = artser.getAll();

    }

    public void onCancel(RowEditEvent event) {
    }

    public String onDeleteAction() {

        artser.delete(artser.getById(art.getId()));
        return null;
    }

    public Categorie getCat() {
        return cat;
    }

    public void setCat(Categorie cat) {
        this.cat = cat;
    }

    public List<Article> getArtsbetweendates() {
        return artsbetweendates;
    }

    public void setArtsbetweendates(List<Article> artsbetweendates) {
        this.artsbetweendates = artsbetweendates;
    }
    
    
    public void articleLoad()
    {
        artsbetweendates = artser.getbydates(date1, date2);
    }
    
    

}
