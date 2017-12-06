/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

/**
 *
 * @author keolli
 */
public class Not implements Matcher {

    private Matcher matcher;

    public Not(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean matches(Player p) {
        boolean result = matcher.matches(p);
        if (!result) {
            return true;
        }
        return false;
    }

}
