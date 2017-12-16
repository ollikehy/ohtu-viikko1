package ohtu.kivipaperisakset.pelimuodot;


import java.util.Scanner;
import ohtu.kivipaperisakset.tekoaly.TekoalyParannettu;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KPSPeli {

    private static final Scanner scanner = new Scanner(System.in);
    private static final TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    @Override
    protected String ekanSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    @Override
    protected String tokanSiirto() {
        String tokanSiirto;
        tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        
        return tokanSiirto;
    }

}
