package LE3Q1;

public class MyStudent {
    private String firstName;
    private double score;

    public  MyStudent(){}

    public  MyStudent(String firstName, double score){
        this.firstName = firstName;
        this.score = score;
    }
    public String toString(){
        return String.format("%s: %.2f",firstName, score);
    }
}
