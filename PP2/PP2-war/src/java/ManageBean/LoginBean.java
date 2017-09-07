/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

/**
 *
 * @author Денис
 */
import ManageBean.AccountBean;
import Modules.User;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    @EJB
    private DAO.UserDAO udao;

    private Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
    private String login;
    private String role;

    public LoginBean() throws SQLException, NamingException {
//        if (principal != null) {
//            login = principal.getName();
//            role = udao.getByEmail(login).getRole();
//        }
    }

    public User getUserByUsername() throws SQLException, Exception {
        if (principal != null) {
            login = principal.getName();
        }
        User user = udao.getByEmail(login);
        return user;
    }

    public boolean getUserIn() {
        if (principal != null) {
            return true;
        } else {
            return false;
        }
    }

    public void logout() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try {
            request.logout();
            FacesContext.getCurrentInstance().getExternalContext().redirect("./index.xhtml");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AccountBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
