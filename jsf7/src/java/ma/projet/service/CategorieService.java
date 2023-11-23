/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.beans.Article;
import ma.projet.beans.Categorie;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author MAYSSAE JABBAR
 */
public class CategorieService implements IDao <Categorie>{

     @Override
    public boolean create(Categorie o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }
    @Override
    public boolean update(Categorie o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }
    @Override
    public boolean delete(Categorie o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Categorie getById(int id) {
        Categorie a  = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        a  = (Categorie) session.get(Categorie.class, id);
        session.getTransaction().commit();
        return a;
    }

    @Override
    public List<Categorie> getAll() {
        
         List <Categorie> a = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        a  = session.createQuery("from Categorie").list();
        session.getTransaction().commit();
        return a;
    }
    
}
