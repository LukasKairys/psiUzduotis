/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entities.Banks;
import entities.Users;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import static javax.persistence.PersistenceContextType.TRANSACTION;
import javax.persistence.PersistenceException;
import static javax.persistence.SynchronizationType.UNSYNCHRONIZED;

/**
 *
 * @author lukas
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class UsersService {
    
    @PersistenceContext 
    private EntityManager em;
    
    public Users UpdateUser(Users user) {
        
        try {
            em.refresh(user);
        } catch (EntityNotFoundException e) {
            return null; 
        }
        
        try {
            Users updatedUser = em.merge(user);
            em.flush();

            return updatedUser;
        } catch (PersistenceException pe) {
            em.clear();
        }
        
        return null;
    }
    
    public Users AddUser(Users user) {
        
        try {
            em.persist(user);
            em.flush();

            return user;
            
        } catch (PersistenceException pe) {
            em.clear();
        }
        
        return null;
    }
    
    public Users GetUser(int userId) {
        Users user = em.find(Users.class, userId);
        
        return user;            
    }
    
    public List<Users> GetUsers() {
        List<Users> users = (em.createNamedQuery("Users.findAll")).getResultList();
      
        return users;
    }
    
    
    
}
