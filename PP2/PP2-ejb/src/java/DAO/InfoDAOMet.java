/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Enty.Info;
import Enty.Userinfo;
import Modules.Dogovor;
import Modules.User;
import com.sun.org.apache.bcel.internal.generic.Select;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Objects;
import static javafx.scene.input.KeyCode.BEGIN;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import static javax.persistence.FlushModeType.COMMIT;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Денис
 */
@Stateless
public class InfoDAOMet implements InfoDAO {

    @PersistenceContext(unitName = "PP2-ejbPU")
    private EntityManager em;
    @Resource
    SessionContext ctx;

    @EJB
    private dao.IDAO iDAO2;
    @EJB
    private DogovorDAO dogovorDAO;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public void IngoCalculate(int idClient, int idUslugi) throws Exception {
          Userinfo info=iDAO2.getbyUserAndUsluga(idClient, idUslugi);
       String periodDog=info.getPeriodDog();
        Query query = em.createQuery("Select u FROM Dogovor u JOIN u.idClient z JOIN u.idUslugi p WHERE z.userId=?1 AND p.usligaId=?2 AND u.periodDog=?3", Dogovor.class);
        query.setParameter(1, idClient);
        query.setParameter(2, idUslugi);
        query.setParameter(3, periodDog);
        List<Dogovor> dogovorList = query.getResultList();
        for (Dogovor m : dogovorList) {
            float summa = m.getStoimostDog() *info.getIdInfo().getKf1();
            iDAO2.SetInfo(info.getId(), m.getStoimostDog(), summa);
        }
    }
}
