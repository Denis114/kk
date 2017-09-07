/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import Enty.Info;
import Enty.Userinfo;
import Modules.Dogovor;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.naming.NamingException;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author Денис
 */
@Named(value = "infoBean")
@SessionScoped
public class InfoBean implements Serializable {

    private List<Info> userinfs;
    private Userinfo selectedInfo;
    private int id;
    private Integer id_client;
    private Integer id_Uslugi;
    private int period_strax;
    private String periodDog;
    private float kf1;
    private float summa;
    private float summa2;
    private int period;
    private int client;
    private int uslugi;

    @EJB
    private DAO.InfoDAO iDAO;
    @EJB
    private dao.IDAO iDAO2;

    public InfoBean() {
    }

    public String AddInfo() {
        iDAO2.AddInfos(id_client, id_Uslugi, period_strax, kf1);
        return "infos.xhtm";
    }

    public List<Info> getAllInfos() {
        return iDAO2.getAllInfos();
    }

    public String makeChoice(int idClient , int idUslugi) {
        id_client = idClient;
        id_Uslugi = idUslugi;
        return "info-details.xhtml";
    }
    
    public String InfoCalculate2() {
        try {
            iDAO.IngoCalculate(id_client, id_Uslugi);
        } catch (Exception ex) {
            Logger.getLogger(InfoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "info-details.xhtml";
    }

    public List<Userinfo> getInfoDetails() {
          List<Userinfo> userinfos = iDAO2.getInfoDetails(period);
    //    periodDog = userinfos.get(0).getPeriodDog();
     //   id_client = userinfos.get(0).getId();
         
        return userinfos;
    }
     public List<Userinfo> getInfoDetails1() {
        
        List<Userinfo> userinfos = iDAO2.getInfoDetails1(period);
    //    periodDog = userinfos.get(0).getPeriodDog();
     //   id_client = userinfos.get(0).getId();
            
        return userinfos;
    }
       public void onCellEdit(CellEditEvent event)    {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        Info d = userinfs.get(event.getRowIndex());
        if (newValue != null && !newValue.equals(oldValue)) {
            try {
                iDAO2.updateUserInfo(d);
            } catch (Exception ex) {
            Logger.getLogger(InfoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_uslugi() {
        return id_Uslugi;
    }

    public void setId_uslugi(int id_Uslugi) {
        this.id_Uslugi = id_Uslugi;
    }

    public int getPeriod_strax() {
        return period_strax;
    }

    public void setPeriod_strax(int period_strax) {
        this.period_strax = period_strax;
    }

    public float getKf1() {
        return kf1;
    }

    public void setKf1(float kf1) {
        this.kf1 = kf1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSumma1() {
        return summa;
    }

    public void setSumma1(float summa) {
        this.summa = summa;
    }

    public float getSumma2() {
        return summa2;
    }

    public void setSumma2(float summa2) {
        this.summa2 = summa2;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Userinfo getSelectedInfo() {
        return selectedInfo;
    }

    public void setSelectedInfo(Userinfo selectedInfo) {
        this.selectedInfo = selectedInfo;
    }

    public String getPeriodDog() {
        return periodDog;
    }

    public void setPeriodDog(String periodDog) {
        this.periodDog = periodDog;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }
      public List<Info> getUserinfs() {
        return userinfs;
    }

    public void setUserinfs(List<Info> userinfs) {
        this.userinfs = userinfs;
    }

}
