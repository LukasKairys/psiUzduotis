/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lukas
 */
@Entity
@Table(name = "BANKS")
@NamedQueries({
    @NamedQuery(name = "Banks.findAll", query = "SELECT b FROM Banks b"),
    @NamedQuery(name = "Banks.findByBankid", query = "SELECT b FROM Banks b WHERE b.bankid = :bankid"),
    @NamedQuery(name = "Banks.findByName", query = "SELECT b FROM Banks b WHERE b.name = :name")})
public class Banks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BANKID")
    private Integer bankid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankid")
    private List<Users> usersList;

    public Banks() {
    }

    public Banks(Integer bankid) {
        this.bankid = bankid;
    }

    public Banks(Integer bankid, String name) {
        this.bankid = bankid;
        this.name = name;
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banks)) {
            return false;
        }
        Banks other = (Banks) object;
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return "entities.Banks[ bankid=" + bankid + " ]";
    }
    
}
