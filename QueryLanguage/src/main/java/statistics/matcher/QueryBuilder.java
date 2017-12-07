package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {

    private List<Matcher> matchers;
    
    public QueryBuilder() {
        this.matchers = new ArrayList();
    }
    
    public void playsIn(Matcher matcher) {
        this.matchers.add(matcher);
    }
    
    public void hasAtLeast(Matcher matcher) {
        this.matchers.add(matcher);
    }
    
    public void hasFewerThan(Matcher matcher) {
        this.matchers.add(matcher);
    }
    
    public void Not(Matcher matcher) {
        this.matchers.add(matcher);
    }
    
    public And and() {
        Matcher[] and = new Matcher[matchers.size()];
        for (int i = 0; i < matchers.size(); i++) {
            and[i] = matchers.get(i);
        }
        this.matchers = new ArrayList();
        return new And(and);
    }
    
    public Or oneOf(Matcher...matchers) {
        Or or = new Or(matchers);
        this.matchers = null;
        return or;
    }
}
