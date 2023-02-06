package Hastanemiz;

import java.util.HashMap;
import java.util.Map;

public class Hasta extends Databank {


    private String adSoyad="";
    private String yas ="";

    private String Rahatsızlığı = "";
    private String Aciliyeti = "";

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getRahatsızlığı() {
        return Rahatsızlığı;
    }

    public void setRahatsızlığı(String rahatsızlığı) {
        Rahatsızlığı = rahatsızlığı;
    }

    public String getAciliyeti() {
        return Aciliyeti;
    }

    public void setAciliyeti(String aciliyeti) {
        Aciliyeti = aciliyeti;
    }

    public Hasta(String adSoyad, String yas, String aciliyeti, String rahatsızlığı ) {
        this.adSoyad= adSoyad;
        this.Aciliyeti = aciliyeti;
        this.Rahatsızlığı = rahatsızlığı;
        this.yas = yas;
    }


    @Override
    public String toString() {
        return "Hasta{" +
                "adSoyad='" + adSoyad + '\'' +
                ", yas='" + yas + '\'' +
                ", Rahatsızlığı='" + Rahatsızlığı + '\'' +
                ", Aciliyeti='" + Aciliyeti + '\'' +
                '}';
    }
}