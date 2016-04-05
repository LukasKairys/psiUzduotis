/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entities.Banks;
import entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static javax.persistence.PersistenceContextType.TRANSACTION;
import static javax.persistence.SynchronizationType.UNSYNCHRONIZED;

/**
 *
 * @author lukas
 */
@Stateless
public class BanksService {
   
    @PersistenceContext
    private EntityManager em;
    
    public Banks AddBank(String name) {
        
        Banks newBank = new Banks();
        
        newBank.setName(name);
        
        em.persist(newBank);
        
        em.flush();
        
        return newBank;
    }
    
    public Banks GetBank(int bankId) {
        Banks bank = em.find(Banks.class, bankId);
        
        return bank;            
    }
    
    public List<Banks> GetBanks() {
        List<Banks> banks = (em.createNamedQuery("Banks.findAll")).getResultList();
      
        return banks;
    }
}
