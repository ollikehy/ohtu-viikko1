package ohtu.kivipaperisakset.pelimuodot;

import ohtu.kivipaperisakset.tekoaly.Tuomari;

public abstract class KPSPeli implements Pelimuoto {

    @Override
    public void pelaa() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");

        Tuomari tuomari = new Tuomari();
        String ekanSiirto = ekanSiirto();
        String tokanSiirto = tokanSiirto();
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            ekanSiirto = ekanSiirto();
            tokanSiirto = tokanSiirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    protected abstract String ekanSiirto();

    protected abstract String tokanSiirto();
}
