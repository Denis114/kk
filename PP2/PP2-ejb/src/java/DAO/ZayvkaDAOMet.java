/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modules.User;
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
public class ZayvkaDAOMet implements ZayvkaDAO, Serializable {

    @PersistenceContext(unitName = "PP2-ejbPU")
    private EntityManager em;

    @Override
    public List<Zayvka> getZayvkaall() {
        Query query = em.createQuery("SELECT s FROM Zayvka s", Zayvka.class);
        return (List<Zayvka>) query.getResultList();
    }

    @Override
    public void AddNewZayvka(Zayvka d) {
        Zayvka z = new Zayvka();
        z.setIdClient(d.getIdClient());
        z.setIdUslugi(d.getIdUslugi());
        z.setStatus("rasmotrenie");
        z.setData(d.getData());
        em.persist(z);
    }

    @Override
    public List<Zayvka> getZayvkasIdCl(int user_Id) {
        Query query = em.createQuery("SELECT z FROM Zayvka z JOIN z.idClient u WHERE u.userId=?1 AND u.role=?2", Zayvka.class);
        query.setParameter(1, user_Id);
        query.setParameter(2, "Client");
        return (List<Zayvka>) query.getResultList();
    }

    @Override
    public void DeleteZayvka(Zayvka d) {

        Zayvka z = em.find(Zayvka.class, d.getId());
        em.remove(z);
        System.out.println("id_Zav=" + d.getId());
    }

    @Override
    public void UpdateZayvka(Zayvka d) {
        Zayvka z = em.find(Zayvka.class, d.getId());
     z.setStatus(d.getStatus());
     z.setData(d.getData());
                   em.merge(z);
    }
    
    
   
    @Override
    public Zayvka GetByID(int id_zav) {
        Query query = em.createQuery("SELECT u FROM Zayvka u WHERE u.id=?1", Zayvka.class);
        query.setParameter(1, id_zav);
        return (Zayvka) query.getSingleResult();
    }

}
