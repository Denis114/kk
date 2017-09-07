/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Enty.Info;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Денис
 */
@Local

public interface InfoDAO {
 public void IngoCalculate(int idClient, int idUslugi) throws Exception;
//     public List<Info> getAllInfos() ; 
}
