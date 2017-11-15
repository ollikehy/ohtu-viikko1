package ohtu;

public class Info {
    private String id;
    private String name;
    private String term;
    private String url;
    private String week;
    private int[] exercises;
    
    public String getName() {
        return this.name;
    }
    public String getId() {
        return this.id;
    }
    public String getTerm() {
        return this.term;
    }
    public String getUrl() {
        return this.url;
    }
    public int getExercises(int week) {
        return this.exercises[week-1];
    }
}
