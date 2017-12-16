package ohtu.kivipaperisakset;

import java.util.Scanner;
import ohtu.kivipaperisakset.pelimuodot.Pelimuoto;
import ohtu.kivipaperisakset.pelimuodot.Pelitehdas;

public class Peliluokka {

    private Scanner lukija;
    private Pelitehdas pelitehdas;

    public Peliluokka(Scanner lukija) {
        this.lukija = lukija;
        this.pelitehdas = new Pelitehdas();
    }

    public void run() {
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = lukija.nextLine();
            Pelimuoto peli = pelitehdas.hae(vastaus);
            if (peli == null) {
                break;
            }
            peli.pelaa();
        }
    }
}
