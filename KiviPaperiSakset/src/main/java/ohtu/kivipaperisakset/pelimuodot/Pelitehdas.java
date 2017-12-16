
package ohtu.kivipaperisakset.pelimuodot;

import java.util.HashMap;

public class Pelitehdas {
    
    private HashMap<String, Pelimuoto> pelit;
    
    public Pelitehdas() {
        this.pelit = new HashMap();
        pelit.put("a", new KPSPelaajaVsPelaaja());
        pelit.put("b", new KPSTekoaly());
        pelit.put("c", new KPSParempiTekoaly());
    }
    
    public Pelimuoto hae(String komento) {
        Pelimuoto pelimuoto = pelit.get(komento);
        if (komento == null) {
            return null;
        }
        return pelimuoto;
    }
}
