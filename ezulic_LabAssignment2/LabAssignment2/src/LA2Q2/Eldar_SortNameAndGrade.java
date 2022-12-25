package LA2Q2;
import java.util.Vector;
import java.util.Collections;

public class Eldar_SortNameAndGrade {

    public static void myHeader(int assignmentN, int qNum){
        System.out.println("=======================================================");
        System.out.printf("Lab Assignment %d, Q%d\n",assignmentN,qNum);
        System.out.println("Prepared By: Eldar Zulic");
        System.out.println("Goal of this Exercise: Working with Sorting Algorithms and their run times");
        System.out.println("=======================================================\n");
    }//header method

    public static void myFooter(int assignmentN, int qNum){
        System.out.println("\n=======================================================");
        System.out.printf("Completion of Lab Assignment %d, Q%d is successful\n",assignmentN,qNum);
        System.out.println("Signing off- Eldar");
        System.out.println("=======================================================");

    }//footer method


    public static void main(String[] args) {
    //call your header method

        myHeader(2,2);

    /*Three arrays with 8 first names, 8 last names and 8 randomly
        generated grades between 60 and 85 inclusive have been created below
        for your use*/

        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny",
                "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood",
                "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26)};

        //Vector<> class instance ‘sg’ with StudentGrade tag.
        Vector<StudentGrade> sg = new Vector<>();

        //Each student object is added to the Vector class with its add method
        for(int i = 0;i<grd.length;i++){
            StudentGrade newStudent = new StudentGrade(fnArray[i], lnArray[i],grd[i]);
            sg.addElement(newStudent);
        }

        //print the unsorted ‘sg’ contents just by using toString() method
        System.out.println("The unsorted Array ................");
        System.out.println(sg.toString() + " \b");
        //sort ‘sg’ using Collections’ sort method, which will sort the list based on the grade
        Collections.sort(sg);

        System.out.println("Sorted by Grades ................");
        System.out.println(sg.toString() + "\b");
        //print the sorted content by using toString() method

        //Create an array of StudentGrade type with the length of the fnArray that has been created above.
        StudentGrade[] arr = new StudentGrade[fnArray.length];
        sg.copyInto(arr);
        //with the help of Vector’s copyInto() method, copy ‘sg’ to StudentGrade array

        insertionSort(arr,1);//sorts the array by first name
        System.out.println("Sorted by First Names .............");
        printArray(arr);//prints the first name sorted array


        insertionSort(arr, 2);//sorts the array by last name
        System.out.println("\nSorted by Last Names .............");
        printArray(arr);//prints the last name sorted array



//print the sorted array (see the sample output) with the aid of your printArray() method
// Call your sort-method again with the argument of StudentGrade array (you created above) and key =2
//print the sorted array (see the sample output) with the aid of your printArray() method
//call your footer method here
      myFooter(2,2);

    }
//Your sort-method will go here.

    public static < T extends Comparable <? super T >> void insertionSort(StudentGrade[] arr, int key){
        int i = 0;
        int j = 0;
        //on each iteration removes 1 element from list, finds the best location and inserts it there
        //repeats this process until there are no input elements to be checked for their correct order
        //if k = 1 then first names will be compared
        if (key == 1) {

            for (i = 1; i < arr.length; i++) {
                StudentGrade student = arr[i];
                //loops through the array backwards comparing element at index j to "student"
                //once element at index j is smaller than student, student is inserted at index j + 1
                for (j = (i - 1); j >= 0 && (arr[j].getFirstName()).compareTo(student.getFirstName()) > 0; j--) {
                    arr[j + 1] = arr[j];

                    arr[j] = student;
                }
            }
        }

        //if k = 2 then last names will be compared
        else if (key == 2) {

            for (i = 1; i < arr.length; i++) {
                StudentGrade student = arr[i];
                //loops through the array backwards comparing element at index j to "student"
                //once element at index j is smaller than student, student is inserted at index j + 1
                for (j = (i - 1); j >= 0 && (arr[j].getLastName()).compareTo(student.getLastName()) > 0; j--) {
                    arr[j + 1] = arr[j];

                    arr[j] = student;
                }
            }
        }
    }


//Add your printArray() method here.
    public static void printArray(StudentGrade[] a){
        for(int i = 0; i< a.length;i++){
            System.out.printf("%9s %9s\t:\t%d\n", a[i].getFirstName(), a[i].getLastName(), a[i].getGrade());
        }
    }//prints the array
}
