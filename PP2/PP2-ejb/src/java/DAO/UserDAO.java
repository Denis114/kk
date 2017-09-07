/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modules.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Денис
 */
@Local
public interface UserDAO {

    public User getByEmail(String email);

    public User getByFio(String fio);

    public List<User> getAllClient();

  public List<User> getAllUsersAgent();

    public User getUserID(int userId);

    public List<User> getAllUsersList();

    public void DeleteUser(int user_Id);

    public void ChangeRole(int userId, String role);

    public boolean RegisterUser(String fio, String email, String parol, String adress, String telefon);
}

    

