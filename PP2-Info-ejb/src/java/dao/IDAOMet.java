package dao;

import Enty.Info;
import Enty.Userinfo;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class IDAOMet implements IDAO, Serializable {

    @PersistenceContext(unitName = "PP2-Info-ejbPU")
    private EntityManager em2;

    @Override
    public List<Info> getAllInfos() {
        Query query = em2.createQuery("SELECT i FROM Info i", Info.class);
        return (List<Info>) query.getResultList();
    }

    //  @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
       public Userinfo getbyUserAndUsluga(int id_client, int id_uslugi) {
        Query query_info = em2.createQuery("SELECT g FROM Userinfo g JOIN g.idInfo p WHERE p.idClient =:idClient And p.idUslugi =:idUslugi", Userinfo.class);
        query_info.setParameter("idClient", id_client);
        query_info.setParameter("idUslugi", id_uslugi);
        return (Userinfo) query_info.getSingleResult();
    }

    @Override
    public void AddInfos(int id_client, int id_uslugi, int strax_period, float kf1) {
        Info g = new Info();
        g.setIdClient(id_client);
        g.setIdUslugi(id_uslugi);
        g.setStraxPeriod(strax_period);
        g.setKf1(kf1);
        em2.persist(g);
    }

    @Override
    public void DellInfo(int id_client, int id_uslugi) {
        Query query = em2.createQuery("DELETE FROM Info gu WHERE gu.idClient=?1 And gu.idUslugi=?2", Info.class);
        query.setParameter(1, id_client);
        query.setParameter(1, id_uslugi);
        query.executeUpdate();
    }

    @Override
    public List<Userinfo> getInfoDetails(int period) {
       Query query = em2.createQuery("SELECT gu FROM Userinfo gu JOIN gu.idInfo gr WHERE gr.straxPeriod=?1", Userinfo.class);
        query.setParameter(1, period);
          List<Userinfo>UserinfoList = query.getResultList();
        //      List<Dogovor> dogovorList = u.getDogovorList();
        for (Userinfo m : UserinfoList) {
         //   m.setSumma(0);
         //   m.setSumma2(0);
        }
            
            //               dogovorDAO.update1(m,summa);
               return (List<Userinfo>) query.getResultList();
    }

     @Override
     public List<Userinfo> getInfoDetails1(int period) {
        Query query = em2.createQuery("SELECT gu FROM Userinfo gu JOIN gu.idInfo gr WHERE gr.straxPeriod=?1", Userinfo.class);
        query.setParameter(1, period);
          List<Userinfo>UserinfoList = query.getResultList();
        //      List<Dogovor> dogovorList = u.getDogovorList();
        for (Userinfo m : UserinfoList) {
            m.setSumma(0);
           m.setSumma2(0);
        }
            
            //               dogovorDAO.update1(m,summa);
               return (List<Userinfo>) query.getResultList();
    }
     
    @Override
    public List<Info> getbyUser(int id_client, int id_usl) {
        Query query = em2.createQuery("SELECT i FROM Info i WHERE i.idClient=?1 And i.idUslugi=?2", Info.class);
        query.setParameter(1, id_client);
        query.setParameter(2, id_usl);
        return (List<Info>) query.getResultList();
    }

    @Override
    public void SetInfo(int id, float summa, float summa2) {
        //Info g = em2.find(Info.class, id);
        Userinfo qq = em2.find(Userinfo.class, id);

        // Userinfo gu = new Userinfo();
//        qq.setPeriodDog(period_dog);
        qq.setSumma(summa);
        qq.setSumma2(summa2);
        em2.merge(qq);
    }

    //   @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public void updateUserInfo(Info userinfo) {
        Info ui = em2.find(Info.class, userinfo.getId());
       ui.setKf1(userinfo.getKf1());
        em2.merge(ui);
    }

}
