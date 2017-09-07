/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;

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
@Table(name = "user")

  public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "UserId")
    private Integer userId;
       @Column(name = "FIO")
    private String fio;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
   
  
  
    @Column(name = "Email")
    private String email;
       @Column(name = "Role")
    private String role;
        @Column(name = "Parol")
    private String parol;
       @Column(name = "adress")
    private String adress;
       @Column(name = "telefon")
    private String telefon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private List<Zayvka> zayvkaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private List<Dogovor> dogovorList;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String fio, String email, String role, String parol, String adress, String telefon) {
        this.userId = userId;
        this.fio = fio;
        this.email = email;
        this.role = role;
        this.parol = parol;
        this.adress = adress;
        this.telefon = telefon;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getParol() {
        return parol;
    }

    public void setParol(String parol) {
        this.parol = parol;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modules.User[ userId=" + userId + " ]";
    }
    
}
