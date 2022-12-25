package Q2L2;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.*;

public class WorkingWithArrays {
    public static void header (int questionNumb){
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise 1-Q%d", questionNumb);
        System.out.println("Prepared by: Eldar Zulic");
        System.out.println("Student Number: 251230378");
        System.out.println("Goal of this exercise: Working with arrays and conditional statements.");
        System.out.println("=======================================================");
    } //header method takes question number as input

    public static void footer(int questionNumb){
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Exercise 1-Q%d is succesful!\n",questionNumb );
        System.out.println("Signing off - Eldar");
        System.out.println("=======================================================");
    }//footer method takes question number as input

    public static double[] mma5MethodEldar(int[] Array){
        double max = 0, min = 0, average =0;//initializing variables
        int index = 0;

        double[] finalArray = new double[4];//final array
        int[] divbyFiveArray = new int[0];//array of integers divisible by 5

        for(int i =0;i<Array.length;i++){//for loop that find integers that are divisible by 5
            index = Array[i];
            if(index%5==0){
                divbyFiveArray = Arrays.copyOf(divbyFiveArray,divbyFiveArray.length +1);
                //copies the specified array padding it with zeros so it has the desired length
                divbyFiveArray[divbyFiveArray.length -1]=index;
            }
        }

        if(divbyFiveArray.length==0){
            System.out.println("There was no number in the array divisible by 5 ");
            finalArray[0] = 0.0;
            finalArray[1] = 0.0;
            finalArray[2]=0.0;
            finalArray[3]= 251230378.0;
            return finalArray;
            //if no numbers in the array are divisible by 5 make sure all values in final array are equal to 0
            //except for student number
        }
        //if there are integers divisible by 5 the respective integers will be put into the final array
        min = divbyFiveArray[0];
        index = 0;

        for(int i = 0; i<divbyFiveArray.length;i++){
            index = divbyFiveArray[i];

            if(min>divbyFiveArray[i]){
                min = divbyFiveArray[i];
            }
            if(max<divbyFiveArray[i]){
                max = divbyFiveArray[i];
            }
            average = average+divbyFiveArray[i];
        }

        System.out.printf("Eldar found %d numbers that are divisible by 5\n",divbyFiveArray.length);
        finalArray[0]=min;//sets the min value in final array
        finalArray[1] = max;//sets the max value in final array
        finalArray[2]=(average/divbyFiveArray.length);//sets average in final array
        finalArray[3]=251230378.0;//sets student number in final array
        return finalArray;//returns the final array
    }

    public static void main(String[] args) {
        header(2);//calls header method

        int integerArray[];//initializes the integer array
        double dubArray[] = new double[0];//initializes the double array

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter Array size: ");
        int size = scanner.nextInt();
        integerArray = new int[size];
        //gets the size of the array from the user

        for(int i =0;i<size;i++){
            System.out.printf("Enter a value: ");
            integerArray[i] = scanner.nextInt();
        }//assigns the values of integers in the array

        System.out.println("Here is the result......");
        dubArray = mma5MethodEldar(integerArray);//calls the mma5MethodEldar method

        if(dubArray[2] !=0.0){
            System.out.println("The max is " + dubArray[1] + "." );
            System.out.println("The min is " + dubArray[0]+".");
            System.out.printf("The average of numbers divisible by 5 is %.2f",dubArray[2]);
            System.out.printf("\nMy student number is %.0f\n",dubArray[3]);
        }//prints out all the required values from dubarray
        footer(2);//calls footer method
    }

}
