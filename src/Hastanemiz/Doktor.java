package Hastanemiz;

import java.util.HashMap;
import java.util.Map;

public class Doktor extends Databank{



    private String Unvani ="";
    private String adSoyad="";

    private int dYili=0;

    private String Uzmanligi ="";



       public Doktor(String adSoyad,  int dYili, String unvani, String uzmanligi) {
        this.adSoyad= adSoyad;
        this.dYili = dYili;
        this.Unvani = unvani;
        this.Uzmanligi = uzmanligi;
    }

    public String getUnvani() {
        return Unvani;
    }

    public void setUnvani(String unvani) {
        Unvani = unvani;
    }


    public String getAdSoyad() {
        return adSoyad;
    }


    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public int getdYili() {
        return dYili;
    }

    public void setdYili(int dYili) {
        this.dYili = dYili;
    }

    public String getBolum() {
        return Unvani;
    }
    public void setBolum(String bolum) {
        this.Unvani = bolum;
    }

    public String getUzmanligi() {
        return Uzmanligi;
    }

    public void setUzmanligi(String uzmanligi) {
        this.Uzmanligi = uzmanligi;
    }

    @Override
    public String toString() {
        return "Doktor{" +
                "Unvani='" + Unvani + '\'' +
                ", adSoyad='" + adSoyad + '\'' +
                ", dYili=" + dYili +
                ", Uzmanligi='" + Uzmanligi + '\'' +
                '}';
    }
}

