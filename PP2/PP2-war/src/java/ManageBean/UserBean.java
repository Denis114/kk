package ManageBean;

import Modules.User;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "usersBean")
@SessionScoped
public class UserBean implements Serializable {

    private int userId;
    private String fio;
    private String email;
    private String role;
    private String parol;
    private String adress;
    private String telefon;

    @EJB
    private DAO.UserDAO dao;

    public List<User> getAllUser() {
        return dao.getAllUsersList();
    }

    public List<User> getAllClients() {
        return dao.getAllClient();
    }

    public List<User> getAllAgents() {
        return dao.getAllUsersAgent();
    }

    public User getUserByID() {
        return dao.getByEmail(email);
    }

    public String getUserByID(int id) {
        return dao.getUserID(id).getFio();
    }

    public String RegisterNewUser() {

        if (dao.RegisterUser(fio, email, parol,adress,telefon)) {
            return "index";
        } else {
            return "register";
        }
    }
    String rn;

    public String ChangeUR(int UserId, int Role) {

        switch (Role) {
            case 1: {
                rn = "Admin";
            }
            ;
            break;
            case 2: {
                rn = "Client";
            }
            ;
            break;
            case 3: {
                rn = "Agent";
            }
            ;
            break;
        }
        //DAO.UserDAO dao = new DAO.UserDAO();
        dao.ChangeRole(UserId, rn);
        return "users";
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

}
