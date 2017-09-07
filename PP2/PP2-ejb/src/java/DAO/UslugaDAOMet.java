/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modules.Usluga;
import Modules.Zayvka;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Денис
 */
@Stateless
public class UslugaDAOMet implements Serializable, UslugaDAO {

    @PersistenceContext(unitName = "PP2-ejbPU")
    private EntityManager em;

    @Override
     public  void DeleteUsluga(Usluga d) {
      Usluga u = em.find(Usluga.class,d.getUsligaId());
        em.remove(u);
        System.out.println("usliga_Id=" + d.getUsligaId());
    }

   
        @Override
    public  void AddNewUsluga(Usluga z) {
       Usluga u = new Usluga();
        u.setName(z.getName());
        u.setChena(z.getChena());
        em.persist(u);
    }

    @Override
    public List<Usluga> getAllUsluga() {
        Query query = em.createQuery("SELECT s FROM Usluga s", Usluga.class);
        return (List<Usluga>) query.getResultList();

    }


   @Override
   public Usluga GetByID(int usliga_Id) {
      Query query = em.createQuery("SELECT u FROM Usluga u WHERE u.usligaId=?1", Usluga.class);
      query.setParameter(1, usliga_Id);
      return (Usluga) query.getSingleResult();
   }
    
    
    @Override
  public  void UpdateUsluga(Usluga d)   {
       
          
       Usluga u = em.find(Usluga.class, d.getUsligaId());
        u.setName(d.getName());
        u.setChena(d.getChena());
        em.merge(u);
    }
   }
