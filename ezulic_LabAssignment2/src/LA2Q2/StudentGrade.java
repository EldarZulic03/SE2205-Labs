package LA2Q2;

public class StudentGrade implements Comparable<StudentGrade>{
    private String firstName;
    private String lastName;
    private int grade;
    //initializing data fields

    public StudentGrade(){}//empty constructor

    public StudentGrade(String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }//constructor

    public void setGrade(int grade){
        this.grade = grade;
    }//setter

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }//setter

    public void setLastName(String lastName){
        this.lastName = lastName;
    }//setter

    public String getFirstName(){
        return firstName;
    }//setter

    public String getLastName(){
        return lastName;
    }//setter

    public int getGrade(){
        return grade;
    }//setter

    public int compareTo(StudentGrade s){
        int value = 0;
        if(this.grade >s.grade){
            value = 1;
        }else if(this.grade <s.grade){
            value = -1;
        }else{
            value = 0;
        }
        return value;
    }//compares the object it is called on to object in the parameters

    @Override
    public String toString(){
        String output = String.format("\b\b%9s %9s\t:\t%d\n", this.firstName, this.lastName, this.grade);
        return output;
    }//toString method

}
