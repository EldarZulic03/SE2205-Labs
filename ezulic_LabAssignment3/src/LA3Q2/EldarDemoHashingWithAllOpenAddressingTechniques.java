package LA3Q2;
import LA3Q1.*;
import static LA3Q1.EldarDemoHashingWithLinearProbing.*;

public class EldarDemoHashingWithAllOpenAddressingTechniques {

    public static void printArray(Integer[] arr){
        String returnString = "";//return string

        for(int i = 0;i<arr.length;i++){
            if(i!=arr.length-1){
                returnString += arr[i] + ", " ;
            }else{
                returnString += arr[i];
            }
        }//if else statement to make sure when at the last element no comma is added to the end
        System.out.print("The given dataset is: [" + returnString + "]");//prints return string
    }

    public static void addValueQuadraticProbe(Integer k){
        for(int i =0;i<tableCapacity; i++){
            int hC = k%tableCapacity;//gets hash code k mod tableCapacity
            if(hashTable[hC].getKey() ==-1) {
                hashTable[hC].setKey(k);//if the element at index hC is -1 (null-flag) set key at hc equal to k
                return;
            }
            else{//if element at index i is not -1
                for(int j = 0;j<tableCapacity;j++){
                    int hC2 = (hC + (j*j))%tableCapacity;//new hash code is equal to original (hashcode + j^2) mod table capacity
                    if(hashTable[hC2].getKey() == -1){//if element at index hC2 is equal to -1 (null-flag) set key at hc2 equal to k
                        hashTable[hC2].setKey(k);
                        return;
                    }
                }
            }
        }
    }

    public static void emptyHashTable(){
        //resets hashTable with values -1 (null flag)
        EldarValueEntry[] emptyArr = new EldarValueEntry[tableCapacity];
        hashTable = emptyArr;
        for(int i = 0; i<tableCapacity; i++){
            hashTable[i] = new EldarValueEntry();
        }//Instantiate the table contents with no-argument constructor
    }

    public static int thePrimeNumberForSecondHashFunction(int p){
        for(int i = p-1;i>=1;i--){//reverse for loop
            int n = 0;

            for(int j = 2;(j*j)<=i;j++){//for loop from 2 to the desired number
                if(i%j==0){
                    n++;//if the number is divisible by j then i is not a prime number
                    //so go to the next number increase n by 1
                }

            }
            if(n == 0 ){
                return i;//the number is no longer divisible so return it
            }
        }
        return 3;//3 is the default prime number
    }

    public static void addValueDoubleHashing(Integer key){
        int i = thePrimeNumberForSecondHashFunction(tableCapacity);// i equal to the next smallest prime number
        int j = key%tableCapacity;//j = key mod table capacity
        if(j<0){
            j = j+ tableCapacity;
        }
        int k = (i-(key%i));//k is equal to i minus the key mod i
        if(k<0){
            k = k + tableCapacity;
        }

        while(hashTable[j].getKey()!=-1){
            j = j+k;//j is equal to j plus k
            j = j%tableCapacity;//j is equal to to j mod table capacity
        }
        hashTable[j].setKey(key);//set element at j equal to the key
    }

    public static void main(String[] args) {

        myHeader(3,2);

        System.out.println("Let's demonstrate our understanding on all the open addressing techniques...");
        System.out.print("How many data items: ");
        int n  = input.nextInt();
        System.out.print("What is the load factor (Recommended: <=0.5): ");
        double lf = input.nextDouble();
        int m = (int)(n/lf);
        tableCapacity = checkPrime(m);//table capacity from the above 2 values, getting the nearest prime using the checkPrime method
        System.out.printf("The minimum required table capacity would be: %s\n",tableCapacity);


        EldarValueEntry[] arr1 = new EldarValueEntry[tableCapacity];
        hashTable = arr1;//create EldarValueEntry type array of size table capacity and assign to hashTable filed

        for(int i = 0; i<tableCapacity; i++){
            hashTable[i] = new EldarValueEntry();
        }//Instantiate the table contents with no-argument constructor

        Integer[] integerArr = new Integer[5];
        /*integerArr[0] = -11;
        integerArr[1] = 22;
        integerArr[2] = -33;
        integerArr[3] = -44;
        integerArr[4] = 55; //create Integer type array*/

        //creating Integer type array
        integerArr[0] = 7;
        integerArr[1] = 14;
        integerArr[2] = -21;
        integerArr[3] = -28;
        integerArr[4] = 35;


        //print values on screen using printArray() method
        printArray(integerArr);
        System.out.print("\nLet's enter each data item from the above to the hash table: \n\n");

        System.out.print("Adding data - linear probing resolves \n");

        for(int j = 0;j<integerArr.length;j++){
            addValueLinearProbe(integerArr[j]);
        }//adds each of the key items from Integer Array to hashTable by calling addValueLinearProbe method, adds using linear probing technique

        printHashTable(); //prints hashTable

        //reset hashTable by calling emptyHashTable method
        emptyHashTable();


        System.out.print("\n\nAdding data - quadratic probing resolves collision\n");
        if(lf<=0.5) {
            for (int j = 0; j < integerArr.length; j++) {
                addValueQuadraticProbe(integerArr[j]);
            }
        }
        else{
            System.out.println("Probing failed! Use a load factor of 0.5 or less. Goodbye!");
            /*for (int j = 0; j < integerArr.length; j++) {
                addValueQuadraticProbe(integerArr[j]);
            }*/
        }

        printHashTable();//print hash table

        emptyHashTable();//clear hash table

        System.out.print("\n\nAdding data - double-hashing resolves collision");
        System.out.print("\nThe q value for double hashing is: " + thePrimeNumberForSecondHashFunction(tableCapacity));
        System.out.print("\n");
        for(int i = 0;i<integerArr.length;i++){
            addValueDoubleHashing(integerArr[i]);
        }//add value to hashTable using Double Hashing technique

        printHashTable();//print hash table


        myFooter(3,2);//call footer


    }
}
