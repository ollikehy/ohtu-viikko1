/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author keolli
 */
public class Nollaa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int arvo;
    
    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        try {
            arvo = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + 0);
    }
    
    @Override
    public void peru() {
        sovellus.setTulos(arvo);
        this.tuloskentta.setText(""+ sovellus.tulos());
    }
    
}
