package Hastanemiz;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Islemler implements IslemlerInterface {

        static Scanner scan = new Scanner(System.in);
        static int secim = 0;

        public static void IslemlerMenu(int i)  {
            secim = i;
            Islemler obj = new Islemler();

            System.out.println("Lütfen seçim yapınız");
            System.out.println(" 1 Ekleme Yapmak için\n" +
                    " 2 Kimlik veya Sicil No ile Arama Yapmak için\n" +
                    " 3 Liste Almak için\n" +
                    " 4 Silmek için\n" +
                    " 5 Anamenu\n" +
                    " 6 Cıkış");


            int scm=scan.nextInt();

            switch (scm) {

                case 1:
                    obj.ekleme();
                    IslemlerMenu(secim);
                    break;
                case 2:
                    obj.arama();
                    IslemlerMenu(secim);
                    break;
                case 3:
                    obj.listeleme();
                    IslemlerMenu(secim);
                    break;
                case 4:
                    obj.silme();
                    IslemlerMenu(secim);
                    break;
                case 5:
                    obj.anaMenu();

                    break;
                case 6:
                    obj.cikis();
                    break;
                default :
                    System.out.println("lütfen geçerli bir giriş yapınız");
                    IslemlerMenu(secim);
            }
        }

        private void doktorBilgiKaydet() {

            System.out.println("Lütfen Adınızı ve Soyadınızı Giriniz");
            scan.nextLine();//dummy
            String adSoyad = scan.nextLine();
            System.out.println("Lütfen doğum yılınızı giriniz.");
            int dYili = scan.nextInt();
            System.out.println("Unvani");
            String Unvani = scan.next();
            System.out.println("Uzmanligi");
            String Uzmanligi = scan.next();
            String sicilID=GetId();
            AnaMenu.slowPrint( "Sicil Numaranız : "+sicilID+" \nLütfen Sicil numaranızı kaydediniz.",60);
            Doktor obj = new Doktor(adSoyad, dYili, Unvani, Uzmanligi);
            Doktor.doktorListesiMap.put(sicilID,obj);
            System.out.println(Doktor.doktorListesiMap.toString());
            System.out.println("Kayıt işleminiz başarıyla tamamlandı...");
            IslemlerMenu(2);
        }
        private void hastaBilgiAlKaydet(String kimlikID) {

            System.out.println("Lütfen Ad ve Soyadınızı Giriniz");
            scan.nextLine();//dummy
            String adSoyad = scan.nextLine();
            System.out.println("Lütfen Yaşınızı Giriniz");
            String yas = scan.next();
            System.out.println("Rahatsizliginız");
            String Rahatsizligi = scan.next();
            System.out.println("Aciliyeti");
            scan.nextLine();//dummy
            String Aciliyeti = scan.nextLine();
            Hasta obj = new Hasta(adSoyad, yas, Aciliyeti, Rahatsizligi );
            Hasta.hastaMap.put(kimlikID, obj);
            System.out.println("Kayıt işleminiz başarıyla tamamlandı...");
            IslemlerMenu(1);


        }
        private void kimlikIDKontrol(String kimlikID)  {
            if (Hasta.hastaMap.containsKey(kimlikID) || Doktor.doktorListesiMap.containsKey(kimlikID)) {
                System.out.println("Bu ID kayıt yapılmış");
                try {
                    AnaMenu.giris();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    @Override
    public void arama() {
        System.out.println("Kimlik veya Hastane sicil numarası giriniz");
        String kimlikID = scan.next();
        if (secim == 1) {

            if (Hasta.hastaMap.containsKey(kimlikID)) {
                System.out.println(Hasta.hastaMap.get(kimlikID).getAdSoyad()+" Durumu :"+Hasta.hastaMap.get(kimlikID).getAciliyeti());
            } else System.out.println("Kayıtlı degil");
        } else if (secim == 2) {
            if (Doktor.doktorListesiMap.containsKey(kimlikID)) {
                System.out.println(Doktor.doktorListesiMap.get(kimlikID).getBolum()+
                        "  "+Doktor.doktorListesiMap.get(kimlikID).getAdSoyad()+" Uzmanlık :"+Doktor.doktorListesiMap.get(kimlikID).getUzmanligi());
            } else System.out.println("kayıtlı degil");
        }
    }

    @Override
    public void ekleme() {

        if (secim == 1) {
            System.out.println("kimlik numarası giriniz");
            String kimlikID = scan.next();
            if(kimlikID.length()!=11){
                System.out.println("Eksik bir kimlik numarası girdiniz\n" +
                        "Kimlik numaranız 11 haneli olmalıdır.");
                ekleme();
            }else
            kimlikIDKontrol(kimlikID);
            hastaBilgiAlKaydet(kimlikID);
        } else if (secim == 2){
            AnaMenu.slowPrint("Doktorumuzun hastanemizde kullanacağı SİCİL NUMARASI oluşturuldu\n",60);
            //String sicilID=GetId();
            //System.out.println( "Sicil Numaranız : "+sicilID+" \nLütfen Sicil numaranızı kaydediniz.");
            doktorBilgiKaydet();

        }
    }
        @Override
        public void listeleme() {
            if (secim == 1) {
                System.out.println(Hasta.hastaMap);
            } else if (secim == 2) {
                System.out.println(Doktor.doktorListesiMap);
            }

        }
        @Override
        public void silme() {
            System.out.println("kimlik numarası giriniz");
            String kimlikID = scan.next();
            if (secim == 1) {
                if (Hasta.hastaMap.containsKey(kimlikID)) {
                    Hasta.hastaMap.remove(kimlikID);
                    System.out.println("Kayıt Silindi");
                } else System.out.println("KimlikID mevcut değil");
            } else if (secim == 2) {
                if (Doktor.doktorListesiMap.containsKey(kimlikID)) {
                    Doktor.doktorListesiMap.remove(kimlikID);
                    System.out.println("Kayıt Silindi");
                }else System.out.println("KimlikID mevcut değil");
            }
        }

        @Override
        public void anaMenu()  {
            try {
                AnaMenu.giris();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        @Override
        public void cikis() {
            System.out.println("Sağlıcakla kalın");
            }

    public static String GetId() {
        int sayac = 0;
        String sifre = "";
        String karakterler = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int maxindex = karakterler.length();
        while (sayac < 5) {
            int rastgeleIndeks = (int) (Math.random() * maxindex);
            sifre += karakterler.charAt(rastgeleIndeks);
            sayac++;

        }
        return "DR." + sifre;

    }
    }

