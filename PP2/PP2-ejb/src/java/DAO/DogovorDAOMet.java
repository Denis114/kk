/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modules.Dogovor;
import Modules.User;
import Modules.Usluga;
import Modules.Zayvka;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Денис
 */
@Stateless
public class DogovorDAOMet implements DogovorDAO, Serializable {

    @PersistenceContext(unitName = "PP2-ejbPU")
    private EntityManager em;

    @Override
    public List<Dogovor> getSelectDogIsClient(int idClient) {
        Query query = em.createQuery("SELECT u FROM Dogovor u JOIN u.idClient z WHERE z.userId=?1 AND z.role=?2", Dogovor.class);
        query.setParameter(1, idClient);
        query.setParameter(2, "Client");
        return (List<Dogovor>) query.getResultList();
    }
 // @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public List<Dogovor> getIsClientUsluga(int idClient, int idusluga) {
        Query query = em.createQuery("SELECT u FROM Dogovor u JOIN u.idClient z JOIN u.idUslugi p WHERE z.userId=?1 AND p.usligaId=?2", Dogovor.class);
        query.setParameter(1, idClient);
        query.setParameter(2, "idusluga");
        return (List<Dogovor>) query.getResultList();
    }
    
    @Override
    public List<Dogovor> getSelectDogIsAgent(String fioagent) {
        Query query = em.createQuery("SELECT u FROM Dogovor u WHERE u.fioAgent=?1", Dogovor.class);
        query.setParameter(1, fioagent);
         System.out.println("фио " + fioagent);
        
        return query.getResultList();
    }

    @Override
    public List<Dogovor> getAll() {
        Query query = em.createQuery("SELECT s FROM Dogovor s", Dogovor.class);
        return query.getResultList();
    }

    @Override
    public void greate(Dogovor d) {
        Dogovor dog = new Dogovor();
        Usluga usl = new Usluga();
        User u = new User();
        u.setUserId(d.getIdClient().getUserId());
        usl.setUsligaId(d.getIdUslugi().getUsligaId());
        dog.setIdClient(u);
        dog.setIdUslugi(usl);
        dog.setDataZaklDog(d.getDataZaklDog());
        dog.setNomer(d.getNomer());
        dog.setFioAgent(d.getFioAgent());
        dog.setPeriodDog(d.getPeriodDog());
        dog.setStoimostDog(d.getStoimostDog());
        //нехватает услуги
        em.persist(dog);
    }

    @Override
    public void delete(Dogovor d) {
        Dogovor z = em.find(Dogovor.class, d.getId());
        em.remove(z);
        System.out.println("id_dog=" + d.getId());
    }

   // @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public void update(Dogovor d) {
        Dogovor dog = em.find(Dogovor.class, d.getId());
        dog.setDataZaklDog(d.getDataZaklDog());
        dog.setNomer(d.getNomer());
        dog.setFioAgent(d.getFioAgent());
        dog.setPeriodDog(d.getPeriodDog());
        dog.setStoimostDog(d.getStoimostDog());
        //нехватает услуги
        em.merge(dog);
    }
    
     public void update1(Dogovor d, float summ) {
        Dogovor dog = em.find(Dogovor.class, d.getId());
        dog.setDataZaklDog(d.getDataZaklDog());
        dog.setNomer(d.getNomer());
        dog.setFioAgent(d.getFioAgent());
        dog.setPeriodDog(d.getPeriodDog());
        dog.setStoimostDog(summ);
        //нехватает услуги
        em.merge(dog);
    }

}
