package Hastanemiz;

import java.util.HashMap;
import java.util.Map;

public class Databank {
    static Map<String, Doktor> doktorListesiMap = new HashMap<>();
    static Map<String, Hasta> hastaMap = new HashMap<>();




    public static void doctorlarimiz(){
    Doktor a=new Doktor("Ahmet YILDIRIM",1960,"Prof.Dr","Kardiyoloji");
    Doktor b=new Doktor("Sule AKYOL",1975,"Prof.Dr.","Dahiliye");
    Doktor c=new Doktor("Deniz YALÇIN ",1967,"Doc.Dr.","Ortopedi");
    Doktor d=new Doktor("Hilmi ONER",1985,"Uz.Dr.","KBB");
    Doktor e=new Doktor("Cem YILDIZ",1979,"Uz.Dr.","Onkoloji");
    doktorListesiMap.put("DR.A1K63",a);
    doktorListesiMap.put("DR.A1K64",b);
    doktorListesiMap.put("DR.A1K65",c);
    doktorListesiMap.put("DR.A1K66",d);
    doktorListesiMap.put("DR.A1K67",e);
    doktorListesiMap.entrySet().forEach(t-> System.out.println(t+" \n"));
}

}
