package dao;

import Enty.Info;
import Enty.Userinfo;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IDAO {

 //public Info getbyUserAndUsluga(int id_client, int id_uslugi);
  public Userinfo getbyUserAndUsluga(int id_client, int id_uslugi);
    public void AddInfos(int id_client, int id_uslugi, int strax_period, float kf1);

    public List<Info> getAllInfos();

    public List<Info> getbyUser(int id_client, int id_usl);

    public void DellInfo(int id_client, int id_uslugi);

    public void SetInfo(int id, float summa,float summa2);


    public List<Userinfo> getInfoDetails(int period);
      public List<Userinfo> getInfoDetails1(int period);
    
    public void updateUserInfo(Info userinfo);
    //  public Userinfo getbyUserinfoPeriod(int id_info);
}
