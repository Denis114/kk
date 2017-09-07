/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Денис
 */
@Entity
@Table(name = "usluga")

public class Usluga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "UsligaId")
    private Integer usligaId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "chena")
    private float chena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUslugi")
    private List<Zayvka> zayvkaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUslugi")
    private List<Dogovor> dogovorList;

    public Usluga() {
    }

    public Usluga(Integer usligaId) {
        this.usligaId = usligaId;
    }

    public Usluga(Integer usligaId, String name, float chena) {
        this.usligaId = usligaId;
        this.name = name;
        this.chena = chena;
    }

    public Integer getUsligaId() {
        return usligaId;
    }

    public void setUsligaId(Integer usligaId) {
        this.usligaId = usligaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getChena() {
        return chena;
    }

    public void setChena(float chena) {
        this.chena = chena;
    }

    @XmlTransient
    public List<Zayvka> getZayvkaList() {
        return zayvkaList;
    }

    public void setZayvkaList(List<Zayvka> zayvkaList) {
        this.zayvkaList = zayvkaList;
    }

    @XmlTransient
    public List<Dogovor> getDogovorList() {
        return dogovorList;
    }

    public void setDogovorList(List<Dogovor> dogovorList) {
        this.dogovorList = dogovorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usligaId != null ? usligaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usluga)) {
            return false;
        }
        Usluga other = (Usluga) object;
        if ((this.usligaId == null && other.usligaId != null) || (this.usligaId != null && !this.usligaId.equals(other.usligaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modules.Usluga[ usligaId=" + usligaId + " ]";
    }
    
}
