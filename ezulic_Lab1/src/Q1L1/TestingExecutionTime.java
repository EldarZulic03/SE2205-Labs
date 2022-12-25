package Q1L1;
import java.util.Scanner;//importing Scanner
public class TestingExecutionTime {

    public static void header (int questionNumb){
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise 1-Q%d", questionNumb);
        System.out.println("Prepared by: Eldar Zulic");
        System.out.println("Student Number: 251230378");
        System.out.println("Goal of this exercise: Testing the difference in code execution time " +
                "between recursive and iterative methods");
        System.out.println("=======================================================");
    } //header method takes question number as input

    public static void footer(int questionNumb){
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Exercise 1-Q%d is succesful!\n",questionNumb );
        System.out.println("Signing off - Eldar");
        System.out.println("=======================================================");
    }//footer method takes question number as input

    public static void iterativeMethod(double factorial){
        double result =1;
        int i =1;
        while(i<=factorial){
            result = result*i;
            i++;
        }
        System.out.printf("\nFactorial (%.0f) with iterative method is %.0e",factorial,result);
    }//iterative method takes the factorial as input calculates it iteratively

    public static void recursiveMethod(double n, double interval, double factorial){
        if (interval<=n) {
            factorial = factorial*interval;
            interval++;
            recursiveMethod(n,interval,factorial);
        }else if(n==0){
            System.out.println("1");
        }else {
            System.out.printf("\nFactorial (%.0f) with recursive call is:%.0e",n,factorial);
        }
    }//recursive method takes the factorial as input and calculates it recursively

    public static void main(String[] args) {
        double factorialInMain = 1.0;//initializes factorialInMain double
        double interval = 1.0;//initializes interval double
        double startingFactorial = 1.0;//initializes startingFactorial double


        header(1);//calls header method

        Scanner scanner = new Scanner(System.in);//creates scanner object

        //User Input
        System.out.printf("Enter an integer number: ");
        double factorial = scanner.nextDouble();//prompts user and stores input in factorial double


        if(factorial<0){
            System.out.printf("Invalid input, input an integer that is greater or equal to 0: ");
            factorial = scanner.nextDouble();

        }else {
            System.out.printf("");
        }//if and else statement to check if inputted number is less than 0

        //starts the timer
        long nanoTimeStart = System.nanoTime();
        for(double i =1; i<=factorial; i++){
            factorialInMain = factorialInMain*i;
        }//iterative method in main
        long  nanoTimeEnd = System.nanoTime();//ends timer
        long totalTime = (nanoTimeEnd-nanoTimeStart);//calculates time
        double timeConverted = ((double) totalTime)/1000000000;//converts so seconds

        System.out.printf("Factorial (%.0f) is %.0e" ,factorial,factorialInMain);
        System.out.printf("\nTime taken by iterative solution inside main: %.2e sec",timeConverted);

        nanoTimeStart = System.nanoTime();
        iterativeMethod(factorial);//calls the iterative method
        nanoTimeEnd = System.nanoTime();
        totalTime = (nanoTimeEnd-nanoTimeStart);
        timeConverted = ((double) totalTime)/1000000000;
        //starts ends and calculates the time

        System.out.printf("\nTime taken by iterative method call: %.0e sec", timeConverted);

        nanoTimeStart = System.nanoTime();
        recursiveMethod(factorial, interval, startingFactorial); //calling the recursive method
        nanoTimeEnd = System.nanoTime();
        totalTime = (nanoTimeEnd-nanoTimeStart);
        timeConverted = ((double)totalTime)/1000000000;
        //starts ends and calculates the time

        System.out.printf("\nTime taken by recursive method call is %.2e sec\n",timeConverted);

        footer(1); //calling the footer method
    }
}
