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
@Table(name = "dogovor")
public class Dogovor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
    private Integer id;
    
    @Column(name = "data_zakl_dog")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataZaklDog;
   
    @Column(name = "period_dog")
    private String periodDog;
    
    @Column(name = "FioAgent")
    private String fioAgent;
    
    @Column(name = "stoimost_dog")
    private float stoimostDog;
    
    @Column(name = "nomer")
    private int nomer;
    @JoinColumn(name = "idUslugi", referencedColumnName = "UsligaId")
    @ManyToOne(optional = false)
    private Usluga idUslugi;
    @JoinColumn(name = "idClient", referencedColumnName = "UserId")
    @ManyToOne(optional = false)
    private User idClient;

    public Dogovor() {
    }

    public Dogovor(Integer id) {
        this.id = id;
    }

    public Dogovor(Integer id, Date dataZaklDog, String periodDog, String fioAgent, float stoimostDog, Integer nomer,Usluga idUslugi, User idClient  ) {
        this.id = id;
        this.dataZaklDog = dataZaklDog;
        this.periodDog = periodDog;
        this.fioAgent = fioAgent;
        this.stoimostDog = stoimostDog;
        this.nomer = nomer;
        this.idUslugi=idUslugi;
        this.idClient=idClient;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataZaklDog() {
        return dataZaklDog;
    }

    public void setDataZaklDog(Date dataZaklDog) {
        this.dataZaklDog = dataZaklDog;
    }

    public String getPeriodDog() {
        return periodDog;
    }

    public void setPeriodDog(String periodDog) {
        this.periodDog = periodDog;
    }

    public String getFioAgent() {
        return fioAgent;
    }

    public void setFioAgent(String fioAgent) {
        this.fioAgent = fioAgent;
    }

    public float getStoimostDog() {
        return stoimostDog;
    }

    public void setStoimostDog(float stoimostDog) {
        this.stoimostDog = stoimostDog;
    }

    public int getNomer() {
        return nomer;
    }

    public void setNomer(int nomer) {
        this.nomer = nomer;
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
        if (!(object instanceof Dogovor)) {
            return false;
        }
        Dogovor other = (Dogovor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modules.Dogovor[ id=" + id + " ]";
    }
    
}
