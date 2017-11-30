package ohtu.intjoukkosovellus;

import java.util.*;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        alustaTaulukko(KAPASITEETTI, OLETUSKASVATUS);
    }

    private void alustaTaulukko(int kapasiteetti, int kasvatuskoko) {
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        alustaTaulukko(kapasiteetti, OLETUSKASVATUS);

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti > 0 && kasvatuskoko > 0) {
            alustaTaulukko(kapasiteetti, kasvatuskoko);
        }
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        } else {
            if (ljono.length == alkioidenLkm) {
                int[] uusiTaulukko = new int[ljono.length + OLETUSKASVATUS];
                for (int i = 0; i < ljono.length; i++) {
                    uusiTaulukko[i] = ljono[i];
                }
                ljono = uusiTaulukko;
            }
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            return true;
        }
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < ljono.length; i++) {
            if (ljono[i] == luku) {
                return true;
            }
        }
        return false;
    }

    public int luvunKohta(int luku) {
        int kohta = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                kohta = i;
                ljono[kohta] = 0;
                break;
            }
        }
        return kohta;
    }

    public boolean poista(int luku) {
        int kohta = luvunKohta(luku);
        int apu;
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                apu = ljono[j];
                ljono[j] = ljono[j + 1];
                ljono[j + 1] = apu;
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + ljono[0] + "}";
        } else {
            String palautettava = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                palautettava += ljono[i] + ", ";
            }
            palautettava += ljono[alkioidenLkm - 1];
            palautettava += "}";

            return palautettava;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }

        return z;
    }

}
