/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author lukas
 */
@Entity
@Table(name = "USERGROUPMAPPINGS")
@NamedQueries({
    @NamedQuery(name = "Usergroupmappings.findAll", query = "SELECT u FROM Usergroupmappings u"),
    @NamedQuery(name = "Usergroupmappings.findByMappingid", query = "SELECT u FROM Usergroupmappings u WHERE u.mappingid = :mappingid")})
public class Usergroupmappings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MAPPINGID")
    private Integer mappingid;
    @JoinColumn(name = "USERGROUPID", referencedColumnName = "USERGROUPID")
    @ManyToOne(optional = false)
    private Usergroups usergroupid;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Users userid;

    public Usergroupmappings() {
    }

    public Usergroupmappings(Integer mappingid) {
        this.mappingid = mappingid;
    }

    public Integer getMappingid() {
        return mappingid;
    }

    public void setMappingid(Integer mappingid) {
        this.mappingid = mappingid;
    }

    public Usergroups getUsergroupid() {
        return usergroupid;
    }

    public void setUsergroupid(Usergroups usergroupid) {
        this.usergroupid = usergroupid;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usergroupid != null ? usergroupid.hashCode() : 0);
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usergroupmappings)) {
            return false;
        }
        Usergroupmappings other = (Usergroupmappings) object;
        return this.usergroupid.equals(other.usergroupid) && this.userid.equals(other.userid);
    }

    @Override
    public String toString() {
        return "com.mycompany.bank.Usergroupmappings[ mappingid=" + mappingid + " ]";
    }
    
}
