package Modules;

import Modules.User;
import Modules.Usluga;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-07T19:47:25")
@StaticMetamodel(Zayvka.class)
public class Zayvka_ { 

    public static volatile SingularAttribute<Zayvka, Date> data;
    public static volatile SingularAttribute<Zayvka, User> idClient;
    public static volatile SingularAttribute<Zayvka, Usluga> idUslugi;
    public static volatile SingularAttribute<Zayvka, Integer> id;
    public static volatile SingularAttribute<Zayvka, String> status;

}