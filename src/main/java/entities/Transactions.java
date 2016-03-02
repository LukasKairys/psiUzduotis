/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lukas
 */
@Entity
@Table(name = "TRANSACTIONS")
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t"),
    @NamedQuery(name = "Transactions.findByTransactionid", query = "SELECT t FROM Transactions t WHERE t.transactionid = :transactionid"),
    @NamedQuery(name = "Transactions.findBySenderid", query = "SELECT t FROM Transactions t WHERE t.senderid = :senderid"),
    @NamedQuery(name = "Transactions.findByReceiverid", query = "SELECT t FROM Transactions t WHERE t.receiverid = :receiverid"),
    @NamedQuery(name = "Transactions.findByDate", query = "SELECT t FROM Transactions t WHERE t.date = :date"),
    @NamedQuery(name = "Transactions.findByAmountofmoney", query = "SELECT t FROM Transactions t WHERE t.amountofmoney = :amountofmoney")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRANSACTIONID")
    private Integer transactionid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SENDERID")
    private short senderid;
    @Column(name = "RECEIVERID")
    private Short receiverid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNTOFMONEY")
    private int amountofmoney;

    public Transactions() {
    }

    public Transactions(Integer transactionid) {
        this.transactionid = transactionid;
    }

    public Transactions(Integer transactionid, short senderid, Date date, int amountofmoney) {
        this.transactionid = transactionid;
        this.senderid = senderid;
        this.date = date;
        this.amountofmoney = amountofmoney;
    }

    public Integer getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Integer transactionid) {
        this.transactionid = transactionid;
    }

    public short getSenderid() {
        return senderid;
    }

    public void setSenderid(short senderid) {
        this.senderid = senderid;
    }

    public Short getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(Short receiverid) {
        this.receiverid = receiverid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmountofmoney() {
        return amountofmoney;
    }

    public void setAmountofmoney(int amountofmoney) {
        this.amountofmoney = amountofmoney;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (date != null ? date.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        return this.date.equals(other.date) && Objects.equals(this.receiverid, other.receiverid) && this.senderid == other.senderid && this.amountofmoney == other.amountofmoney;
    }

    @Override
    public String toString() {
        return "entities.Transactions[ transactionid=" + transactionid + " ]";
    }
    
}
