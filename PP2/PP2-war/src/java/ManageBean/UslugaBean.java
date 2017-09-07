package ManageBean;

import Modules.User;
import Modules.Usluga;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.Query;
import org.primefaces.event.CellEditEvent;

@Named(value = "uslugasBean")
@RequestScoped
public class UslugaBean implements Serializable {

    private int usliga_Id;
    private String name;
    private Float chena;
    private List<Usluga> uslugas;
    private Usluga selectedUsluga;
    private Usluga newUsluga = new Usluga();

    @EJB
    private DAO.UslugaDAO dao;

    public String delete() {
       dao.DeleteUsluga(selectedUsluga);
        return "adminUsluga";
    }
         public String addUsluga()  {
       dao.AddNewUsluga(newUsluga);
        return "usluga";
    }
   
    public List<Usluga> getAllUslugas() {
        return dao.getAllUsluga();
    }
    
     public void EditUsluga(CellEditEvent event)  {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        Usluga d = uslugas.get(event.getRowIndex());
        if (newValue != null && !newValue.equals(oldValue)) {
           
                dao.UpdateUsluga(d);
           
                  }
     }
       

    public String getUslugaByID(int id) {
      return dao.GetByID(id).getName();
   }

    public int getUsliga_Id() {
        return usliga_Id;
    }
    public void setUsliga_Id(int usliga_Id) {
        this.usliga_Id = usliga_Id;
    }
    
    public Usluga getNewUsluga() {
        return newUsluga;
    }
    public void setNewUsluga(Usluga newUsluga) {
        this.newUsluga = newUsluga;
    }
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Float getChena() {
        return chena;
    } 
    public void setChena(Float chena) {
        this.chena = chena;
    }
    
    public List<Usluga> getUslugas() {
        return uslugas;
    }
    public void setUslugas(List<Usluga> uslugas) {
        this.uslugas = uslugas;
    }

  
    
      public Usluga getSelectedUsluga() {
        return selectedUsluga;
    }

    public void setSelectedUsluga(Usluga selectedUsluga) {
        this.selectedUsluga = selectedUsluga;
    }
   

    
        @PostConstruct
    public void all() {
           setUslugas(dao.getAllUsluga());
    }
}