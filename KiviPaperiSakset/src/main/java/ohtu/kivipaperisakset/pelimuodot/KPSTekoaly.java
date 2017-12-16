package ohtu.kivipaperisakset.pelimuodot;

import java.util.Scanner;
import ohtu.kivipaperisakset.tekoaly.Tekoaly;

public class KPSTekoaly extends KPSPeli {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Tekoaly tekoaly = new Tekoaly();
    

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    @Override
    protected String ekanSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        return scanner.nextLine();
    }

    @Override
    protected String tokanSiirto() {
        String tokanSiirto;
        tokanSiirto = tekoaly.annaSiirto();
        System.out.println("tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }
}
