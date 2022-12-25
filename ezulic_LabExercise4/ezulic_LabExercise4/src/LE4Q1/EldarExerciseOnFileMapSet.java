package LE4Q1;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.util.Set;

public class EldarExerciseOnFileMapSet {
    public static void myHeader(int exerciseNumber){
        System.out.println("=======================================================");
        System.out.println("Lab Exercise " + exerciseNumber);
        System.out.println("Prepared by: Eldar Zulic");
        System.out.println("Student Number: 251230378");
        System.out.println("Goal of this Exercise:  Working with Files and ADTs!");
        System.out.println("=======================================================");
    }

    public static void myFooter(int exerciseNumber){
        System.out.println("\n=======================================================");
        System.out.println("Completion of Lab Exercise " + exerciseNumber +" is successful!");
        System.out.println("Signing off - Eldar Zulic");
        System.out.println("=======================================================");
    }
    public static TreeMap<String, Integer> populateToTreeMap(String[] list){
        TreeMap<String, Integer> map = new TreeMap();

        for(int i = 0; i<list.length;i++){
            String value = list[i];
            if(map.get(value)==null){
                map.put(value,1);
                //if value is not in map put it at index 1
            }else{
                int j = map.get(value);
                j++;
                map.put(value,j);
                //if value is in the map already put it at the index right after it already is
            }
        }
        return map;
    }

    public static void printList(Set<Map.Entry<String, Integer>> entrySet){
        for(Map.Entry<String,Integer> Entry : entrySet){
            //for each Entry in entry set loop through
            if(Entry.getValue()>1){
                System.out.printf("\n%12s \t %d",Entry.getKey(),Entry.getValue());
            }//if the key appears more than once print the key and the amount of times it appears
        }
    }




    public static void main(String[] args) throws FileNotFoundException {

        //call header
        myHeader(4);

        //size of txt file is 238 lines
        //goal is to put last names into tree map
        //strongly recommended to create as many public static methods

        TreeMap<String, Integer> lastNameMap; //creating Treemap which will hold lastnames

        File file = new File("SE2205Students.txt");
        Scanner fileInput = new Scanner(file);
        if(!file.exists()){
            System.out.println("File not found! Goodbye!");
            System.exit(0);
        }//File object-reference and checks whether file exists

        String[] lastNames = new String[238];//array to hold all the last names
        int i = 0;

        while(fileInput.hasNextLine()){
            String[] fullNames = fileInput.nextLine().split("\s");
            //array to hold full name split into 3 parts last, middle and first name, indexed at 0,1,2

            lastNames[i] = fullNames[0];
            //adds last name to array

            i++;//increments the index by 1
        }//now we have an array of type string filled with all the last names
        //now we need to put this array into a TreeMap, do this using populateTreeMap method suggested in lab

        lastNameMap = populateToTreeMap(lastNames);
        //populates lastNameMap with lastNames array

        //get all entries into a set

        Set<Map.Entry<String,Integer>> entry_set = lastNameMap.entrySet();

        //now we need to print list of number of students with same last names using public static void method suggested in lab
        //use printf statements like suggested in lab

        System.out.print("List of students with the same Last Names:\n   Last-Name\tnumbers\n-----------------------------------");


        printList(entry_set);//printing entry set of last names

        //repeat everything above for first names
        System.out.print("\nList of the Number of students with the same First Names:\n   First-Name\tnumbers\n-----------------------------------");

        //TreeMap to hold first names
        TreeMap<String, Integer> firstNameMap;
        String[] firstNames = new String[238];//array to hold first names
        int index = 0;

        Scanner fileInput2 = new Scanner(file);

        while(fileInput2.hasNextLine()){
            String[] firstNameArray = fileInput2.nextLine().split("\s");
            firstNames[index] = firstNameArray[firstNameArray.length-1];
            //first names at last element of the array so length - 1
            index++;
        }


        firstNameMap = populateToTreeMap(firstNames);//populate TreeMap with firstNames array elements

        Set<Map.Entry<String, Integer>> entrySet2 = firstNameMap.entrySet();
        //put TreeMap into Entry set

        printList(entrySet2);//print the entry set of first names

        //call Footer
        myFooter(4);

    }

}
