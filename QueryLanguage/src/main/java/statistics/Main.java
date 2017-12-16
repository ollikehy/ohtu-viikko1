package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();
        query.hasAtLeast(new HasAtLeast(10, "goals"));
        query.hasAtLeast(new HasAtLeast(10, "assists"));
        query.playsIn(new PlaysIn("PHI"));

        Matcher m = query.and();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        Matcher c = new Not(new HasAtLeast(0, "goals"));
        Matcher b = new HasFewerThan(5, "goals");
        Matcher z = query.oneOf(c, b);

        for (Player p : stats.matches(z)) {
            System.out.println(p);
        }
//                           
//                           
//                           
//        for (Player player : stats.matches(c)) {
//            System.out.println(player);
//        }
//    }
    }
}
