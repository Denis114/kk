/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Денис
 */
@Entity
@Table(name = "zayvka")
@XmlRootElement

public class Zayvka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "idUslugi", referencedColumnName = "UsligaId")
    @ManyToOne(optional = false)
    private Usluga idUslugi;
    @JoinColumn(name = "idClient", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private User idClient;

    public Zayvka() {
    }

    public Zayvka(Integer id) {
        this.id = id;
    }

    public Zayvka(Integer id, String status, Date data ) {
        this.id = id;
        this.status = status;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usluga getIdUslugi() {
        return idUslugi;
    }

    public void setIdUslugi(Usluga idUslugi) {
        this.idUslugi = idUslugi;
    }

    public User getIdClient() {
        return idClient;
    }

    public void setIdClient(User idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zayvka)) {
            return false;
        }
        Zayvka other = (Zayvka) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modules.Zayvka[ id=" + id + " ]";
    }
    
}
