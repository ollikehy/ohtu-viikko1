import java.util.*;
import ohtu.Multiplier;

public class Main {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Multiplier kolme = new Multiplier(3);
        System.out.print("anna luku ");
        int luku = lukija.nextInt();

        System.out.println("luku kertaa kolme on: " + kolme.multipleBy(luku));
    }
}