/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entities.Banks;
import entities.Users;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Named;
/**
 *
 * @author lukas
 */
@Named
@Stateful
@RequestScoped
public class BankImportController {
    @Inject
    BanksService bankService;
    
    @Inject
    UsersService userService;
    
    private Banks newBank = new Banks();
    private Users newUser = new Users();
    
    private List<Banks> banks = new ArrayList<Banks>();
    private List<Users> users = new ArrayList<Users>();
    
    public Banks getNewBank() {
        return newBank;
    }
    
    public Users getNewUser() {
        return newUser;
    }
    
    public void init() {
        newBank = new Banks();
        newUser = new Users();
    }
    
    public String insertBank() {

        newBank = bankService.AddBank(newBank.getName());
        
        return "index";
    }
    
    
    public String insertUser() {
        
        newUser.setBankid(newBank);
        
        newUser = userService.AddUser(newUser);
        
        return "index";
        
    }
    
    public List<Banks> getBanks() {
        
        List<Banks> banks = bankService.GetBanks();
        
        return banks;
    }
    
    public List<Users> getUsers() {
        
        List<Users> users = userService.GetUsers();
        
        return users;
    }
}
