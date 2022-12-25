package LA3Q1;
import java.util.Scanner;
public class EldarDemoHashingWithLinearProbing {

    public static int items; //holds value of total number of data items to be added to hash table
    public static Scanner input = new Scanner(System.in);
    public static double lf;//loading factor
    public static int tableCapacity;
    public static EldarValueEntry[] hashTable ;
    public static EldarValueEntry[] workingHashTable ;//used to store the copy of the hashTable for rehashing operations

    public static void addValueLinearProbe(Integer k){
        int i = k%tableCapacity;//hashcode equal to k mod table capacity
        if(i<0){
            i = i + tableCapacity;
        }
        //System.out.println(i);
        //System.out.println("get key" + hashTable[i].getKey());
        while(true){
            if(hashTable[i].getKey()==-1||hashTable[i].getKey()==-111){
                hashTable[i].setKey(k);
                break;
            }
            else{
                i++;
                i = i % tableCapacity;
            }
            //while loop to find an available spot for k
        }

        //System.out.println(hashTable[i].getKey() + " at position " + i);
    }//accepts an integer key and adds this to hash table based on linear probing technique

    //since in hashing, the prime number has to be greater than 2, we can
    //discard 2; 0 and 1 are not prime numbers by definition
    public static int checkPrime(int n) {
        int m = n / 2;//we just need to check half of the n factors
        for (int i = 3; i <= m; i++) {
            if (n % i == 0) {//if n is not a prime number
                i = 2; //reset i to 2 so that it is incremented to 3 in the forheader
                //System.out.printf("i = %d\n",i);
                n++;//next n value
                m = n / 2;//we just need to check half of the n factors
            }
        }
        return n;
    }//end of checkPrime()

    public static void printHashTable(){
        String returnString = "";//return string

        for(int i = 0;i<hashTable.length;i++) {
            if (i != hashTable.length - 1) {
                if (hashTable[i].getKey() != -1 && hashTable[i].getKey() != -111) {
                    returnString += hashTable[i].getKey() + ", ";//if element at i is not -1 or -111 print it
                } else if (hashTable[i].getKey() == -1) {
                    returnString += "null, ";//if element at i is -1 print null
                } else {
                    returnString += "available, ";//if element at i is -111 print available
                }
            }
            else{
                if (hashTable[i].getKey() != -1 && hashTable[i].getKey() != -111) {
                    returnString += hashTable[i].getKey();
                } else if (hashTable[i].getKey() == -1) {
                    returnString += "null";
                } else {
                    returnString += "available";
                }
            }//if else statement so that the last element doesn't have a comma after it
        }
        System.out.print("The Current Hash-Table: [" + returnString + "]");

    }

    public static void removeValueLinearProbe(Integer k){
        int i = k%tableCapacity;//hashcode is equal to k mod table capacity
        if(i<0){
            i = i+tableCapacity;
        }
        int j = 1;
        while(hashTable[i].getKey()!=k){
            i++;//increments i
            i = i%tableCapacity;
            if(j==tableCapacity){
                System.out.print(k + " is not found! ");
                break;
            }//if we have searched the whole table capacity print k is not found
            j++;
        }//while element at i is not equal to k
        if(hashTable[i].getKey() == k){
            hashTable[i].setKey(-111);
            System.out.print(k + " is found and removed! ");
        }//if we have found k set the element at i equal to -111 (available) and print k is found and removed

    }

    public static void rehashingWithLinearProbe(){
        workingHashTable = hashTable;//copy original hashtable
        tableCapacity = checkPrime(tableCapacity*2);//increase the table capacity
        EldarValueEntry[] arr2 = new EldarValueEntry[tableCapacity];
        hashTable = arr2;//make new array to increase table capacity and set hashTable equal to it to resize

        System.out.println("The rehashed table capacity is: " + tableCapacity);

        for(int i = 0; i<tableCapacity; i++){
            hashTable[i] = new EldarValueEntry();

        }//instantiate all values of the resized hashTable
        for(int i = 0;i<workingHashTable.length;i++){
            if(workingHashTable[i].getKey()!=-1 && workingHashTable[i].getKey()!=-111) {
                addValueLinearProbe(workingHashTable[i].getKey());
            }
        }//add all values from the original hashTable to the resized hashTable
    }


    public static void myHeader(int exerciseNumber, int assignNumber){
        System.out.println("=======================================================");
        System.out.println("Lab Assignment " + assignNumber + " Q" + exerciseNumber);
        System.out.println("Prepared by: Eldar Zulic");
        System.out.println("Student Number: 251230378");
        System.out.println("Goal of this Exercise: Working with Hash tables and collision avoidance techniques!");
        System.out.println("=======================================================");
    }

    public static void myFooter(int assignmentN, int qNum){
        System.out.println("\n=======================================================");
        System.out.printf("Completion of Lab Assignment %d, Q%d is successful\n",assignmentN,qNum);
        System.out.println("Signing off- Eldar");
        System.out.println("=======================================================");

    }//footer method

    public static void main(String[] args) {

        myHeader(1,3);//call header
        System.out.println("Let's decide on the initial table capacity based on the load factor and dataset size");
        System.out.print("How many data items: ");//prompt user
        //store the data items
        int n = input.nextInt();
        System.out.print("What is the load factor (Recommended: <= 0.5): ");
        //store the data items
        double lf = input.nextDouble();
        int m = (int)(n/lf);//calculate table capacity
        //System.out.println(m);
        tableCapacity = checkPrime(m); //call check prime to get the nearest prime number

        System.out.printf("The minimum required table capacity would be: %d\n",tableCapacity  );
        EldarValueEntry[] arr1 = new EldarValueEntry[tableCapacity]; //assign to hashTable field
        hashTable = arr1;

        for(int i = 0; i<tableCapacity; i++){
            hashTable[i] = new EldarValueEntry();
        }//Instantiate the table contents with no-argument constructor

        int answer = 0;
        for(int i = 1;i<=n;i++){
            System.out.print("Enter Item " + i + ": " );
            answer = input.nextInt();
            addValueLinearProbe(answer);
        }//add each key to hashTable using linear probing technique

        //print hashTable by calling printHashTable method

        printHashTable();

        //remove 2 items from hashTable by prompting user and calling removeValueLinearProbe method
        System.out.print("\n\nLet's remove two values from the table and then add one.....\n");
        System.out.print("\nEnter a value you want to remove:");
        int remove = input.nextInt();
        removeValueLinearProbe(remove);
        printHashTable();

        System.out.print("\nEnter a value you want to remove:");
        remove = input.nextInt();
        removeValueLinearProbe(remove);
        printHashTable();

        //add new key to the hashTable and print again
        System.out.print("\nEnter a value to add to the table: ");
        int add = input.nextInt();
        addValueLinearProbe(add);
        printHashTable();

        //call the rehashing method and then print the table again
        System.out.print("\n\nRehashing the table...\n");
        rehashingWithLinearProbe();
        printHashTable();

        //call the footer method
        myFooter(3,1);
    }
}
