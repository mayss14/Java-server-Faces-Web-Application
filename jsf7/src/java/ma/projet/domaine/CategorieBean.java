/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.domaine;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.binding.Bindings;
import javax.faces.bean.ManagedBean;
import ma.projet.beans.Article;
import ma.projet.beans.Categorie;
import ma.projet.beans.Salle;
import ma.projet.service.ArticleService;
import ma.projet.service.CategorieService;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author MAYSSAE JABBAR
 */
@ManagedBean(name = "categorieBean")
public class CategorieBean {

    private List<Categorie> cats;
    private List<Article> articles;
    private CategorieService catser;
    private ArticleService artser;
    private Categorie categorie;
    private Categorie catParent;
    private static ChartModel barModel;

    public CategorieBean() {

        catser = new CategorieService();
        categorie = new Categorie();
        catParent = new Categorie();
        articles = new ArrayList<>();
        artser = new ArticleService();

    }

    public List<Article> getArticles() {

        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Categorie getCatParent() {
        return catParent;
    }

    public void setCatParent(Categorie catParent) {
        this.catParent = catParent;
    }

    public List<Categorie> getCats() {
        if (cats == null) {
            cats = catser.getAll();
        }
        return cats;
    }

    public void setCats(List<Categorie> cats) {
        this.cats = cats;
    }

    public ChartModel getBarModel() {
        return barModel;
    }

    public Categorie getCat() {
        return categorie;
    }

    public void setCat(Categorie cat) {
        this.categorie = cat;
    }

    public String onCreateAction() {
        categorie.setCatParent(catser.getById(catParent.getId()));
        catser.create(categorie);
        cats = catser.getAll();
        categorie = new Categorie();
        return null;
    }

    public void onEdit(RowEditEvent event) {

        categorie = (Categorie) event.getObject();
        Categorie c1 = catser.getById(categorie.getId());
        Categorie catp = catser.getById(c1.getCatParent().getId());

        c1.setArticles(null);
        c1.setNom(categorie.getNom());
        c1.setCatParent(catParent);
        c1.getCatParent().setNom(catser.getById(catParent.getId()).getNom());
        catser.update(c1);
        cats = catser.getAll();
        System.out.println(c1);
    }

    public void onCancel(RowEditEvent event) {
    }

    public void onDeleteAction() {
        categorie.setArticles(null);
        catser.delete(categorie);

    }

    public void load() {
        setArticles(null);
        categorie = catser.getById(categorie.getId());
        setArticles(categorie.getArticles());

    }

    public ChartModel initBarModel() {

        CartesianChartModel model = new CartesianChartModel();
        ChartSeries arts = new ChartSeries();
        arts.setLabel("Categories");
        model.setAnimate(true);

        for (Categorie c : catser.getAll()) {
            setArticles(null);
            categorie = catser.getById(c.getId());
            setArticles(categorie.getArticles());
            arts.set(c.getNom(), articles.size());
        }

        model.addSeries(arts);

        return model;

    }

}
