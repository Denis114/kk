/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import Modules.User;
import Modules.Zayvka;
import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.CellEditEvent;


/**
 *
 * @author Денис
 */
@Named(value = "zayvkasBean")
@RequestScoped
public class ZayvkaBean implements Serializable {

    @EJB
    private DAO.UserDAO udao;

    @EJB
    private DAO.ZayvkaDAO zdao;

    @EJB
    private DAO.UslugaDAO usdao;

    private List<Zayvka> zayvkas;
    private Integer id;
    private String status;
    private Date data;
    private Integer idClient;
    private Integer idUslugi;
    private Zayvka selectedZayvka;
    private Zayvka newZayvka = new Zayvka();

    public List<Zayvka> getZayvkaByIdCl() throws SQLException, NamingException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        User currentuser = udao.getByEmail(request.getUserPrincipal().getName());
        return zdao.getZayvkasIdCl(currentuser.getUserId());
    }
    public List<Zayvka> getAllZayvka() throws SQLException, NamingException {
        return zdao.getZayvkaall();
    }

    public String AddZayvka() throws SQLException, NamingException {
        Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        newZayvka.setIdClient(udao.getByEmail(principal.getName()));
        zdao.AddNewZayvka(newZayvka);
        return "clientZayvka.xhtml";
    }

   public void EditZayvka(CellEditEvent event) throws NamingException {
       Object oldValue = event.getOldValue();
      Object newValue = event.getNewValue();
       Zayvka d = zayvkas.get(event.getRowIndex());
      if (newValue != null && !newValue.equals(oldValue)) {

           zdao.UpdateZayvka(d);

       }
   }

    @PostConstruct
    public void all() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        User currentuser = udao.getByEmail(request.getUserPrincipal().getName());
        if ("Client".equals(currentuser.getRole())) {
            setZayvkas(zdao.getZayvkasIdCl(currentuser.getUserId()));
        } else {
            setZayvkas(zdao.getZayvkaall());
        }
    }
    public void delete() throws ParseException, NamingException, IOException {
        zdao.DeleteZayvka(selectedZayvka);
        FacesContext.getCurrentInstance().getExternalContext().redirect("./clientZayvka.xhtml");

    }

    public List<Zayvka> getZayvkas() {
        return zayvkas;
    }

    public void setZayvkas(List<Zayvka> zayvkas) {
        this.zayvkas = zayvkas;
    }

    public Zayvka getSelectedZayvka() {
        return selectedZayvka;
    }

    public void setSelectedZayvka(Zayvka selectedZayvka) {
        this.selectedZayvka = selectedZayvka;
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

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdUslugi() {
        return idUslugi;
    }

    public void setIdUslugi(Integer idUslugi) {
        this.idUslugi = idUslugi;
    }

    public Zayvka getNewZayvka() {
        return newZayvka;
    }

    public void setNewZayvka(Zayvka newZayvka) {
        this.newZayvka = newZayvka;
    }
}
