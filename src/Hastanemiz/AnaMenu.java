package Hastanemiz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class AnaMenu {
    static Scanner scan = new Scanner(System.in);

    public static void giris() throws IOException {

        AnaMenu object = new AnaMenu();

        slowPrint("******* TEAM-TEN HOSPİTAL *******\n********** HOŞGELDİNİZ **********\n\n",60);

        System.out.println("Lütfen giriş yapmak istediğiniz menü kodunu giriniz..\n\n" +
                "1-HASTA İŞLEMLERİ GİRİŞİ\n" +
                "2-DOKTOR  İŞLEMLERİ GİRİŞİ\n" +
                "3-İLETİŞİM-HASTANE YÖNETİMİ\n" +
                "4-HASTANEMİZ DOKTORLARINI GÖRÜNTÜLE\n" +
                "5-ÇIKIŞ");


        int scm = scan.nextInt();

        switch(scm){
            case 1:
                object.hastaislemleri();
                break;
            case 2:
                object.doktorislemleri();
                break;
            case 3:
                iletisim();
                break;
            case 4:
                Databank.doctorlarimiz();
                break;
            case 5:
                cikis();
                break;
            default :
                System.out.println("lütfen geçerli bir seçim yapınız");
                giris();
        }
    }

    public void hastaislemleri() throws IOException {
        Islemler.IslemlerMenu(1);
    }

    public void doktorislemleri() throws IOException {
        Islemler.IslemlerMenu(2);
    }

    public static void cikis() {
        slowPrint("Çıkış işleminiz gerçekleşti.\nSağlıcakla kalın.",60);
    }
    public static void slowPrint(String text, int delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void iletisim() throws IOException {
       Files.lines(Paths.get("src/Hastanemiz/HastaneYonetimIletisim")).forEach(System.out::println);

    }

}
