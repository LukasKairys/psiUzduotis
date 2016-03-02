/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lukas
 */
@Entity
@Table(name = "USERS")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserid", query = "SELECT u FROM Users u WHERE u.userid = :userid"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.username = :name"),
    @NamedQuery(name = "Users.findByBalance", query = "SELECT u FROM Users u WHERE u.balance = :balance")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USERID")
    private Integer userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BALANCE")
    private int balance;
    @ManyToMany(mappedBy = "usersList")
    private List<Usergroups> usergroupsList;
    @JoinColumn(name = "BANKID", referencedColumnName = "BANKID")
    @ManyToOne(optional = false)
    private Banks bankid;

    public Users() {
    }

    public Users(Integer userid) {
        this.userid = userid;
    }

    public Users(Integer userid, String name, int balance) {
        this.userid = userid;
        this.username = name;
        this.balance = balance;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Usergroups> getUsergroupsList() {
        return usergroupsList;
    }

    public void setUsergroupsList(List<Usergroups> usergroupsList) {
        this.usergroupsList = usergroupsList;
    }

    public Banks getBankid() {
        return bankid;
    }

    public void setBankid(Banks bankid) {
        this.bankid = bankid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        return this.username.equals(other.username) && other.balance == this.balance;
    }

    @Override
    public String toString() {
        return "entities.Users[ userid=" + userid + " ]";
    }
    
}
