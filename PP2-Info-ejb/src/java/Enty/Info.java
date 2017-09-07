/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enty;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Денис
 */
@Entity
@Table(name = "info", catalog = "stoimost_dog", schema = "")

public class Info implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
     @Column(name = "id")
    private Integer id;
    @Column(name = "id_client")
    private int idClient;
    @Column(name = "id_uslugi")
    private int idUslugi;
    @Column(name = "strax_period")
    private int straxPeriod;
    @Column
    private float kf1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInfo")
    private List<Userinfo> userinfoList;

    public Info() {
    }

    public Info(Integer id) {
        this.id = id;
    }

    public Info(Integer id, int idClient, int idUslugi, int straxPeriod, float kf1) {
        this.id = id;
        this.idClient = idClient;
        this.idUslugi = idUslugi;
        this.straxPeriod = straxPeriod;
        this.kf1 = kf1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdUslugi() {
        return idUslugi;
    }

    public void setIdUslugi(int idUslugi) {
        this.idUslugi = idUslugi;
    }

    public int getStraxPeriod() {
        return straxPeriod;
    }

    public void setStraxPeriod(int straxPeriod) {
        this.straxPeriod = straxPeriod;
    }

    public float getKf1() {
        return kf1;
    }

    public void setKf1(float kf1) {
        this.kf1 = kf1;
    }

    @XmlTransient
    public List<Userinfo> getUserinfoList() {
        return userinfoList;
    }

    public void setUserinfoList(List<Userinfo> userinfoList) {
        this.userinfoList = userinfoList;
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
        if (!(object instanceof Info)) {
            return false;
        }
        Info other = (Info) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Enty.Info[ id=" + id + " ]";
    }
    
}
