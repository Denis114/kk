package Modules;

import Modules.User;
import Modules.Usluga;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-07T19:47:25")
@StaticMetamodel(Dogovor.class)
public class Dogovor_ { 

    public static volatile SingularAttribute<Dogovor, Date> dataZaklDog;
    public static volatile SingularAttribute<Dogovor, User> idClient;
    public static volatile SingularAttribute<Dogovor, Float> stoimostDog;
    public static volatile SingularAttribute<Dogovor, Usluga> idUslugi;
    public static volatile SingularAttribute<Dogovor, Integer> id;
    public static volatile SingularAttribute<Dogovor, Integer> nomer;
    public static volatile SingularAttribute<Dogovor, String> fioAgent;
    public static volatile SingularAttribute<Dogovor, String> periodDog;

}