/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modules.User;
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
public class UserDAOMet implements UserDAO, Serializable {

    @PersistenceContext(unitName = "PP2-ejbPU")
    private EntityManager em;

   @Override
    public User getByEmail(String email) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.email=?1", User.class);
        query.setParameter(1, email);
        return (User) query.getSingleResult();
    }

    @Override
    public User getByFio(String fio) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.fio=?1", User.class);
        query.setParameter(1, fio);
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> getAllClient() {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.role=?1", User.class);
        query.setParameter(1, "Client");
        return (List<User>) query.getResultList();
    }

    @Override
    public User getUserID(int userId) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.userId=?1", User.class);
        query.setParameter(1, userId);
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> getAllUsersAgent() {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.role=?1", User.class);
        query.setParameter(1, "Agent");
        return query.getResultList();
    }

    @Override
    public List<User> getAllUsersList() {
        Query query = em.createQuery("SELECT u FROM User u", User.class);
        return (List<User>) query.getResultList();
    }

    @Override
    public void ChangeRole(int userId, String role) {
        User user = em.find(User.class, userId);
        user.setRole(role);
        em.persist(user);
    }

    @Override
    public boolean RegisterUser(String fio, String email, String parol, String adress, String telefon) {
        User user = new User();
        user.setFio(fio); 
        user.setEmail(email);
        user.setParol(parol);
        user.setRole("Client");
        user.setAdress(adress);
        user.setTelefon(telefon);
        em.persist(user);
        return true;
    }

    @Override
    public void DeleteUser(int user_Id) {
        User z = em.find(User.class, user_Id);
        em.remove(z);
        System.out.println("user_Id=" + user_Id);
    }

}

  
    
