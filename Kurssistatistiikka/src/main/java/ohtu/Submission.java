package ohtu;

public class Submission {
    private int week;
    private int hours;
    private int[] exercises;
    private int max;
    
    public int[] getExercises() {
        return this.exercises;
    }
    
    public void setHours(int hours) {
        this.hours = hours;
    }
    
    public int getHours() {
        return this.hours;
    }
    
    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }
    
    public String getTehdyt() {
        String s = "";
        for (int exercise : exercises) {
            s = s + exercise + " ";
        }
        return s;
    }

    @Override
    public String toString() {
        return "Viikko: "+week
                + " tehtyjä tehtäviä: " + exercises.length + " (maksimi " + max + ")"
                + ", aikaa tehtävien tekemiseen kului: " + hours + "h"
                + ", tehtyjä tehtäviä ovat: " + getTehdyt();
    }

    public void setMax(int max) {
        this.max = max;
    }
    
}