package statistics.matcher;

import java.util.List;
import statistics.Player;

public class Or implements Matcher {

    private Matcher[] matchers;

    public Or(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        boolean result = false;
        for (Matcher matcher : matchers) {
            result = matcher.matches(p);
            if (result) {
                return true;
            }
        }
        return false;
    }
}
