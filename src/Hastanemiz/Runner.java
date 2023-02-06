package Hastanemiz;

import java.io.IOException;
import java.util.InputMismatchException;

public class Runner {
    public static void main(String[] args) throws IOException {
        try{
        AnaMenu.giris();
        }catch (InputMismatchException e){
            System.out.println("Geçersiz giriş\n1'den 6'ya kadar menü karşılığı değer girmelisiniz");
        }
    }
}
