package Modules;

import Modules.Dogovor;
import Modules.Zayvka;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-07T19:47:25")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> role;
    public static volatile ListAttribute<User, Zayvka> zayvkaList;
    public static volatile SingularAttribute<User, String> parol;
    public static volatile SingularAttribute<User, String> telefon;
    public static volatile ListAttribute<User, Dogovor> dogovorList;
    public static volatile SingularAttribute<User, String> adress;
    public static volatile SingularAttribute<User, Integer> userId;
    public static volatile SingularAttribute<User, String> fio;
    public static volatile SingularAttribute<User, String> email;

}