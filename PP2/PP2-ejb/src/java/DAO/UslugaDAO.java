/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modules.Usluga;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Денис
 */
@Local
public interface UslugaDAO {

    public void DeleteUsluga(Usluga d);

    public void AddNewUsluga(Usluga z);

    public List<Usluga> getAllUsluga();

    public void UpdateUsluga(Usluga d);

    public Usluga GetByID(int usliga_Id);

}
