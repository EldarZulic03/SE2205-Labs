package Q_LE2;
import java.util.*;

public class GenericsAndArrays_Eldar {
    public static void header (int questionNumb){
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise 2-Q%d", questionNumb);
        System.out.println("Prepared by: Eldar Zulic");
        System.out.println("Student Number: 251230378");
        System.out.println("Goal of this exercise: Working with Generics and Arrays.");
        System.out.println("=======================================================");
    }//header
    public static void footer(int questionNumb){
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Exercise 2-Q%d is succesful!\n",questionNumb );
        System.out.println("Signing off - Eldar");
        System.out.println("=======================================================");
    }//footer

    public static void main(String[] args) {

        header(1);//calling header method

        ArrayList<Integer> Years = new ArrayList(Arrays.asList(2,3,4,3,2,2));
        //declaring ArrayList type reference variable with Integer-tag to hold the student Leader's years

        ArrayList<String> Names = new ArrayList(Arrays.asList("Harry", "Lavender","Ron","Hermione","Luna"
        ,"Vincent"));
        //declaring ArrayList type reference variable with String-tag to hold the student's leader's names

        int namesSize = Names.size();
        //size of the Names ArrayList

        Pair[] studentLeaders = new Pair[namesSize];
        //Array of Pair type reference variable

        String name;//initializing name
        int year;//initializing year

        for(int i=0;i<namesSize;i++){
            name = Names.get(i);
            year = Years.get(i);

            studentLeaders[i] = new Pair(name,year);
        }//for loop to add the name and year of the student's leaders to studentLeaders array


        int yearinput;
        String answer;

        do{


            while(true){//infinite loop


                try{
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter Academic Year (2, 3 or 4):");//prompts user
                    yearinput = scanner.nextInt();
                    while(yearinput!=2 && yearinput!=3 && yearinput!=4){
                        System.out.println("Incorrect input! Enter Academic Year (2, 3 or 4):");
                        yearinput = scanner.nextInt();
                    }//reprompts the user if they enter an integer that isn't in the range
                    break;
                }catch(InputMismatchException e){
                    System.out.printf("\nIncorrect input! ");

                }//catches any errors if the user doesn't enter an integer
                //try catch block to catch the exception inside an infite loop

            }

            ArrayList<String> finalArrayList = new ArrayList(); //ArrayList to hold the names of Leaders from specific years
            int count =0;
            for(int i=0;i<namesSize;i++){
                int leadersYear = (int) (studentLeaders[i].getValue());

                if(yearinput==leadersYear){
                    String leaders = studentLeaders[i].getKey().toString();
                    finalArrayList.add(leaders);
                    count++;
                }//if statement to check if the user's input is equal to the year of the indexed leader
            }//for loop to check the years of each leader then add them to the finalArrayList

            System.out.println("Found " + count + " leader(s) from year "+ yearinput +".");
            System.out.println("Here is the list: ");
            System.out.println(finalArrayList);
            System.out.println("Do you wish to continue? (press y to continue or any other key to terminate):");
            Scanner continueScanner = new Scanner(System.in);
            answer = continueScanner.nextLine();

        }while(answer.equals("Y")||answer.equals("y"));
        //do while loop that keeps looping through if user answers yes if they wish to continue

        footer(1);//calls footer method
    }
}
