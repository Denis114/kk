/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modules.Dogovor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Денис
 */
@Local
public interface DogovorDAO {

    public List<Dogovor> getAll();
    //  public void AddDogovor(int usliga_Id, int user_Id, Date dataZaklDog, String periodDog, Float stoimostDog, int  nomer, String fioagent );

    public void update(Dogovor d);
     public void update1(Dogovor d,float sum);

    public void delete(Dogovor d);

    public List<Dogovor> getSelectDogIsClient(int idClient);

    public List<Dogovor> getSelectDogIsAgent(String fioagent);

    public void greate(Dogovor d);
    
    public List<Dogovor> getIsClientUsluga(int idClient, int idusluga);

}
