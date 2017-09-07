package Modules;

import Modules.Dogovor;
import Modules.Zayvka;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-07T19:47:25")
@StaticMetamodel(Usluga.class)
public class Usluga_ { 

    public static volatile SingularAttribute<Usluga, Float> chena;
    public static volatile ListAttribute<Usluga, Zayvka> zayvkaList;
    public static volatile SingularAttribute<Usluga, String> name;
    public static volatile ListAttribute<Usluga, Dogovor> dogovorList;
    public static volatile SingularAttribute<Usluga, Integer> usligaId;

}