/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enty;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Денис
 */
@Entity
@Table(name = "userinfo", catalog = "stoimost_dog", schema = "")

public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column(name = "period_dog")
    private String periodDog;
    @Column
    private float summa;
    @Column
    private float summa2;
    @Column(name = "id_dogovora")
    private int idDogovora;
    @JoinColumn(name = "id_info", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Info idInfo;

    public Userinfo() {
    }

    public Userinfo(Integer id) {
        this.id = id;
    }

    public Userinfo(Integer id, String periodDog, float summa, float summa2, int idDogovora) {
        this.id = id;
        this.periodDog = periodDog;
        this.summa = summa;
        this.summa2 = summa2;
        this.idDogovora = idDogovora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriodDog() {
        return periodDog;
    }

    public void setPeriodDog(String periodDog) {
        this.periodDog = periodDog;
    }

    public float getSumma() {
        return summa;
    }

    public void setSumma(float summa) {
        this.summa = summa;
    }

    public float getSumma2() {
        return summa2;
    }

    public void setSumma2(float summa2) {
        this.summa2 = summa2;
    }

    public int getIdDogovora() {
        return idDogovora;
    }

    public void setIdDogovora(int idDogovora) {
        this.idDogovora = idDogovora;
    }

    public Info getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(Info idInfo) {
        this.idInfo = idInfo;
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
        if (!(object instanceof Userinfo)) {
            return false;
        }
        Userinfo other = (Userinfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Enty.Userinfo[ id=" + id + " ]";
    }
    
}
