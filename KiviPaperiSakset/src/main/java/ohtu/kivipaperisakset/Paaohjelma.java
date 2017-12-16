package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner lukija = new Scanner(System.in);

    public static void main(String[] args) {
        Peliluokka peliluokka = new Peliluokka(lukija);
        peliluokka.run();
    }
}
