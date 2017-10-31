package ohtuesimerkki;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void palauttaaOikeanPelaajan() {
        Player g = new Player("Gretzky", "EDM", 35, 89);
        assertEquals(stats.search("Gretzky").getName(), "Gretzky");
    }

    @Test
    public void palauttaaOikeanPelaajan2() {
        assertEquals(stats.topScorers(1).get(0).getName(), "Gretzky");
    }

    @Test
    public void eiVoiHakeaNollaa() {
        assertEquals(stats.topScorers(-1), new ArrayList());
    }

    @Test
    public void palauttaaNullOikein() {
        assertNull(stats.search("Jaakko"));
    }

    @Test
    public void palauttaaOikeanJoukkueen() {
        Player p = new Player("Lemieux", "PIT", 45, 54);
        assertEquals(stats.team("PIT").get(0).getName(), p.getName());
    }

    @Test
    public void palauttaaTyhjänJoukkueen() {
        List<Player> p = new ArrayList();
        assertEquals(stats.team("ebin"), p);
    }
}
