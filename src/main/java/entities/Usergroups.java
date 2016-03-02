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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "USERGROUPS")
@NamedQueries({
    @NamedQuery(name = "Usergroups.findAll", query = "SELECT u FROM Usergroups u"),
    @NamedQuery(name = "Usergroups.findByUsergroupid", query = "SELECT u FROM Usergroups u WHERE u.usergroupid = :usergroupid"),
    @NamedQuery(name = "Usergroups.findByName", query = "SELECT u FROM Usergroups u WHERE u.name = :name"),
    @NamedQuery(name = "Usergroups.findByDescription", query = "SELECT u FROM Usergroups u WHERE u.description = :description")})
public class Usergroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USERGROUPID")
    private Integer usergroupid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinTable(name = "USERS_USERGROUPS", joinColumns = {
        @JoinColumn(name = "USERGROUPID", referencedColumnName = "USERGROUPID")}, inverseJoinColumns = {
        @JoinColumn(name = "USERID", referencedColumnName = "USERID")})
    @ManyToMany
    private List<Users> usersList;

    public Usergroups() {
    }

    public Usergroups(Integer usergroupid) {
        this.usergroupid = usergroupid;
    }

    public Usergroups(Integer usergroupid, String name) {
        this.usergroupid = usergroupid;
        this.name = name;
    }

    public Integer getUsergroupid() {
        return usergroupid;
    }

    public void setUsergroupid(Integer usergroupid) {
        this.usergroupid = usergroupid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (usergroupid != null ? usergroupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usergroups)) {
            return false;
        }
        Usergroups other = (Usergroups) object;
        if ((this.usergroupid == null && other.usergroupid != null) || (this.usergroupid != null && !this.usergroupid.equals(other.usergroupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usergroups[ usergroupid=" + usergroupid + " ]";
    }
    
}
