package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        Matcher m = new And( new HasAtLeast(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        Matcher c = new Not(new HasAtLeast(1, "goals"));
                           
        for (Player player : stats.matches(c)) {
            System.out.println(player);
        }
    }
}
