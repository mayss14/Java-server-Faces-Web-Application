/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ma.projet.beans.Article;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author MAYSSAE JABBAR
 */
public class ArticleService  implements IDao<Article>{

     @Override
    public boolean create(Article o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }
    @Override
    public boolean update(Article o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }
    @Override
    public boolean delete(Article o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Article getById(int id) {
        Article a  = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        a  = (Article) session.get(Article.class, id);
        session.getTransaction().commit();
        return a;
    }

    @Override
    public List<Article> getAll() {
        
         List <Article> a = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        a  = session.createQuery("from Article").list();
        session.getTransaction().commit();
        return a;
    }
    public List<Object[]> nbarticles(){
        List<Object[]> articles = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        articles  = session.createQuery("select count(m.nom), m.nom from Article m group by m.nom").list();
        session.getTransaction().commit();
        return articles;
    }
    
    public List<Article> getbydates(Date d1 , Date d2){
        List <Article> articles = new ArrayList<>();
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
         articles  = session.createQuery("from Article m where m.dateProd between :d1 and :d2").setParameter("d1", d1).setParameter("d2", d2).list();
        session.getTransaction().commit();
        return articles;
        
    }
    
}
