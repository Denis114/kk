package ManageBean;

import Modules.Dogovor;
import Modules.User;
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
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.CellEditEvent;

@Named(value = "dogovorsBean")
@SessionScoped
public class DogovorBean implements Serializable {

    @EJB
    private DAO.DogovorDAO dao;
    @EJB
    private DAO.UserDAO daoo;

  //  @EJB
   // private DAO.InfoDAOMet daoo2;

    private List<Dogovor> dogovors;
    private Dogovor selectedDogovor;
    private Integer id;
    private Date dataZaklDog;
    private String periodDog;
    private float stoimostDog;
    private Integer nomer;
    private Integer idUslugi;
    private Integer idClient;
    private String fioAgent;
    ;
private Dogovor newDogovor = new Dogovor();

    public String getFioAgent() {
        return fioAgent;
    }

    public void setFioAgent(String fioAgent) {
        this.fioAgent = fioAgent;
    }

    public List<Modules.Dogovor> getSelectDogByAgent() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        User currentuser = daoo.getByEmail(request.getUserPrincipal().getName());
        return dao.getSelectDogIsAgent(currentuser.getFio());
    }

    public List<Modules.Dogovor> getSelectDogByClient() throws SQLException, NamingException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        User currentuser = daoo.getByEmail(request.getUserPrincipal().getName());
        return dao.getSelectDogIsClient(currentuser.getUserId());
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        Dogovor d = dogovors.get(event.getRowIndex());
        if (newValue != null && !newValue.equals(oldValue)) {
            dao.update(d);
        }
    }

//    public void delete() throws IOException {
    //                 dao.delete(int id);
    //        FacesContext.getCurrentInstance().getExternalContext().redirect("./agentDogovors.xhtml");
    // }
    //  public String delete(int id) {
    //  dao.delete(id);
    //  return "";
    // }
    public void delete() throws ParseException, NamingException, IOException {
        dao.delete(selectedDogovor);
        FacesContext.getCurrentInstance().getExternalContext().redirect("./agentDogovors.xhtml");

    }

    public String addDog() throws ParseException, NamingException, IOException {
        Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        newDogovor.setFioAgent(daoo.getByEmail(principal.getName()).getFio());
        dao.greate(newDogovor);
        return "clientZayvka.xhtml";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getIdUslugi() {
        return idUslugi;
    }

    public void setIdUslugi(int idUslugi) {
        this.idUslugi = idUslugi;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Float getStoimostDog() {
        return stoimostDog;
    }

    public void setStoimostDog(Float stoimostDog) {
        this.stoimostDog = stoimostDog;
    }

    public int getNomer() {
        return nomer;
    }

    public void setNomer(int nomer) {
        this.nomer = nomer;
    }

    public List<Dogovor> getDogovors() {
               return dogovors;
    }

    public Dogovor getSelectedDogovor() {
        return selectedDogovor;
    }

    public void setDogovors(List<Dogovor> dogovors) {
        this.dogovors = dogovors;
    }

    public void setSelectedDogovor(Dogovor selectedDogovor) {
        this.selectedDogovor = selectedDogovor;
    }

    @PostConstruct
    public void all() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        User currentuser = daoo.getByEmail(request.getUserPrincipal().getName());
        if ("Agent".equals(currentuser.getRole())) {
            setDogovors((List<Dogovor>) dao.getSelectDogIsAgent(currentuser.getFio()));
        } else if ("Client".equals(currentuser.getRole())) {
            setDogovors((List<Dogovor>) dao.getSelectDogIsClient(currentuser.getUserId()));
        } else {
            setDogovors(dao.getAll());

        }
    }

    public Dogovor getNewDogovor() {
        return newDogovor;
    }

    public void setNewDogovor(Dogovor newDogovor) {
        this.newDogovor = newDogovor;
    }
}
