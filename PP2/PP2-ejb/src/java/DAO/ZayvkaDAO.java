/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modules.Zayvka;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Денис
 */
@Local
public interface ZayvkaDAO {

    public List<Zayvka> getZayvkaall();

    public void AddNewZayvka(Zayvka d) ;

    public void DeleteZayvka(Zayvka d);

    public List<Zayvka> getZayvkasIdCl(int user_Id);

    public Zayvka GetByID(int id_zav);

    public void UpdateZayvka(Zayvka d);

}


