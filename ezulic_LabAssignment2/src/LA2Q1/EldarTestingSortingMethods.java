package LA2Q1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.List;
import java.util.Collections;

public class EldarTestingSortingMethods {
    //all methods return a long so can't implement any algorithms recursively
    //algorithms can be implemented recursively doesn't return a long till its done I was wrong

    public static <T extends Comparable <? super T>>long selectionSort (T [] a){
        long startTime = System.nanoTime();//time at start of call

        //loops through unsorted array until it finds the smallest element, first smallest element will be put to front of unsorted array
        //next smallest element will be put to front of the unsorted array but behind the first smallest element and so on...
        for(int i = 0;i<a.length-1;i++){
            int nextSmallest = i; //i assigned to nextSmallest
            for(int j =i+1;j<a.length;j++){ //locates the smallest index
                if((a[j].compareTo(a[nextSmallest]))<0){
                    nextSmallest = j;
                    //if element at j is smaller than element at nextSmallest, j is assigned ot nextSmallest
                }
            }
            T temp  = a[i];
            a[i] = a[nextSmallest];
            a[nextSmallest]  = temp;
            //swapping elements at next smallest and i
        }
        long endTime = System.nanoTime();//time at end of call
        return endTime-startTime; //return timer
    }

    public static < T extends Comparable <? super T >> long bubbleSort(T[] a){
        long startTime = System.nanoTime();//time at start of call

        //loops through the unsorted array and compares the outer index to the inner index (compares element to the element 1 to the right)
        //swaps them if right element is smaller than left element
        //once largest element is at n-1 index loop restarts sorting all elements until it is finally sorted
        for(int i=1;i<a.length;i++){

            for(int j = 0; j<a.length-i;j++){

                if((a[j].compareTo(a[j+1]))>0){
                    //if element at j is greater then element at j + 1 swap them
                    T temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();//time at end of call
        return endTime - startTime;//returns timer
    }

    public static < T extends Comparable <? super T >> long insertionSort(T[] a){
        long startTime = System.nanoTime();//time at start of call
        int j=0;
        //on each iteration removes 1 element from list, finds the best location and inserts it there
        //repeats this process until there are no input elements to be checked for their correct order
        for(int i =1; i<a.length;i++){
            T key = a[i];
            for(j = i-1; j>=0 && ((a[j].compareTo(key))>0);j--){
                //loops through the array backwards comparing element at index j to "key"
                //once element at index j is smaller than key, key is inserted at index j + 1
                a[j+1] = a[j];
            }
            a[j+1] = key;
        }
        long endTime = System.nanoTime(); //time at end of call
        return endTime - startTime;//returns time
    }

    public static <T extends Comparable<? super T>> long mergeSort(T[] S){
        //tweaked a bit from 4.3 companion
        long startTime = System.nanoTime();//time at start of call
        //continuously divides unsorted list until it reaches n single element sub-lists
        //then repeatedly merges the sub-lists until all elements are fully merged int sorted array

        int n = S.length;
        if(n<2){ //array is trivially sorted
            long endTime = System.nanoTime();//time at end of call
            return endTime - startTime;//return time
        }

        //divide and conquer
        int mid = n/2; //midpoint
        T[] s1 = Arrays.copyOfRange(S,0,mid);//copy of S array from index 0 to mid
        T[] s2 = Arrays.copyOfRange(S,mid,n);//copy of S array from mid to n

        mergeSort(s1);
        mergeSort(s2); //merge sort the sub list halves of the array

        int i = 0, j = 0;
        //while loop to combine the sub arrays until the indices of the 2 sub array are equal to length of original
        //when added up
        while((i+j)<S.length){
            if(j==s2.length||(i<s1.length && (s1[i].compareTo(s2[j])<0))){
                S[i+j] = s1[i++]; //copy ith element of s1 and increment i by 1
            }else{
                S[i+j] = s2[j++]; //copy jth element of s2 and increment j by 1
            }
        }

        long endTime = System.nanoTime();//time at end of method call
        return endTime - startTime;//returns time
    }



    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b){
        //given in 4.3 lecture slides
        long startTime = System.nanoTime();//time at start of call

        if(a>=b){
            long endTime = System.nanoTime();
            return endTime - startTime;
        }

        T p = s[b];//assigning pivot
        int left =a;
        int right = b-1;

        //while loop scans array from index left, left to right, and index right, right to left until they cross each other
        //element at index left and index right are swapped when the lth element is larger than the pivot
        //and the rth element is smaller than the pivot
        while(left<=right){
            while(left<=right && (s[left].compareTo(p))<=0){
                left = left + 1;
            }
            while(left<=right && (s[right].compareTo(p)>=0)){
                right = right -1;
            }
            if(left<right){
                T temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left = left + 1;
                right = right+1;
            }
        }
        //final swap witht the pivot, completes one partition step
        T temp = s[left];
        s[left] = s[b];
        s[b] = temp;

        quickSort(s,a,left-1);//recursive call
        quickSort(s,left + 1,b);//recursive call

        long endTime = System.nanoTime();//time at end of method call
        return endTime - startTime;//returns time
    }

    public static long bucketSort(Integer[] a, int first, int last, int maxDigits){
        long startTime = System.nanoTime();//time at method call
        Vector<Integer>[] bucket = new Vector[10];
        //instantiate each bucket
        for(int i =0;i<10;i++){
            bucket[i] = new Vector<>();
        }
        //loops through n times, where n is equal to the number of digits for each integer
        for(int i = 0;i<maxDigits;i++) {


            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements(); //clear vector buckets of any previous elements
            }

            //sorts the numbers into their respective buckets
            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(a[index], i);//calls findDigit method
                bucket[digit].add(a[index]);//adds digit to respective bucket
            }
            int index = 0;

            //for loop adds all sorted buckets back together
            for(int m = 0;m<10;m++){
                for(int n = 0;n<bucket[m].size();n++){
                    a[index++] = bucket[m].get(n);
                }
            }
        }
        long endTime = System.nanoTime();//time at method end
        return endTime-startTime;//returns time
    }

    public static Integer findDigit(int number, int i){
        int target = 0;
        //get the required digit
        for(int k = 0;k<=i;k++){
            target = number %10;
            number = number/10;
        }
        return target;
    }
    public static void myHeader(int assignmentN, int qNum){
        System.out.println("=======================================================");
        System.out.printf("Lab Assignment %d, Q%d\n",assignmentN,qNum);
        System.out.println("Prepared By: Eldar Zulic");
        System.out.println("Goal of this Exercise: Working with Sorting Algorithms and their run times");
        System.out.println("=======================================================\n");
    }
    public static void myFooter(int assignmentN, int qNum){
        System.out.println("\n=======================================================");
        System.out.printf("Completion of Lab Assignment %d, Q%d is successful\n",assignmentN,qNum);
        System.out.println("Signing off- Eldar");
        System.out.println("=======================================================");

    }


    public static void main(String[] args) {

        myHeader(2,1);//header method

        int sz = 5;//size of array
        //sz = 50000;
        Integer[] arr = new Integer[sz];//array 1
        Integer[] arr2 = new Integer[sz];//backup array

        for(int i = 0; i<arr.length;i++){
            arr[i] = (int)(Math.random() * 80) +13 ;
        }//generates random numbers within a range to fill the arr1
        System.arraycopy(arr,0,arr2,0,sz);//fills arr2 with arr1 elements to serve as a bakcup

        List<Integer> list =Arrays.asList(arr);//fills list with elements from arr using Arrays.asList method

        //print unsorted list
        System.out.println("The unsorted list: " + list.toString());

        //start timer
        long startTime = System.nanoTime();//time before sort method call
        //sort list
        Collections.sort(list);
        long endTime = System.nanoTime();//time after sort method call
        long time = endTime- startTime;//total time

        //prints run time of collections sort method
        System.out.printf("Collections' Sorting Time: %.2f milliseconds\n",(double)((time)/1000000));
        System.out.println("The sorted list using Collections'sort method: " + list.toString());//prints sorted list using collections sort method

        System.arraycopy(arr2,0,arr,0,sz);
        list = Arrays.asList(arr);//resets arr and list using elements from arr2 (backup array)

        System.out.println("\nThe Unsorted List: " + list.toString());//prints unsorted list
        System.out.printf("My Selection-Sort time: %.2f milliseconds\n",(double)(selectionSort(arr)/1000000));//prints runtime of Selection-sort method
        list = Arrays.asList(arr);//fills list with elements from sorted arr
        System.out.println("The sorted list using selection-sort: " + list.toString());//prints sorted list

        System.arraycopy(arr2,0,arr,0,sz);
        list = Arrays.asList(arr);//resets arr and list using elements from arr2 (backup array)

        System.out.println("\nThe Unsorted List: " + list.toString());
        System.out.printf("My Bubble-Sort time %.2f milliseconds\n",(double)(bubbleSort(arr))/1000000);//prints runtime of Bubble-sort method and sorts arr
        list=Arrays.asList(arr);//fills list with elements from sorted arr
        System.out.println("The sorted list with Bubble-sort: " + list.toString());//prints sorted list

        System.arraycopy(arr2,0,arr,0,sz);
        list = Arrays.asList(arr);//resets arr and list using elements from arr2 (backup array)

        System.out.println("\nThe Unsorted List: " + list.toString());
        System.out.printf("My Insertion-Sort time %.2f milliseconds\n",(double)(insertionSort(arr))/1000000);//prints runtime of Insertion-sort method and sorts arr
        list = Arrays.asList(arr);
        System.out.println("The sorted list with Insertion-sort: " + list.toString());

        System.arraycopy(arr2,0,arr,0,sz);
        list = Arrays.asList(arr);//resets arr and list using elements from arr2 (backup array)

        System.out.println("\nThe Unsorted List: " + list.toString());
        System.out.printf("My Merge-Sort time %.2f milliseconds\n",(double)(mergeSort(arr))/1000000);//prints runtime of mergeSort method and sorts arr
        list = Arrays.asList(arr);
        System.out.println("The sorted list with Merge-sort: " + list.toString());
        //merge sort doesn't work redo it tomorrow
        //fixed merge sort generic recursive solution worked

        System.arraycopy(arr2,0,arr,0,sz);
        list = Arrays.asList(arr);//resets arr and using elements from arr2 (backup array)

        System.out.println("\nThe Unsorted List: " + list.toString());
        System.out.printf("My Quick-Sort time %.2f milliseconds\n",(double)(quickSort(arr,0,(sz-1)))/1000000);//prints runtime of quick sort method and sorts arr
        list = Arrays.asList(arr);
        System.out.println("The sorted list with Quick-sort: " + list.toString());
        //quick sort doesn't work redo it tomorrow
        //fixed it was passing in the wrong parameters

        System.arraycopy(arr2,0,arr,0,sz);
        list = Arrays.asList(arr);//resets arr and list using elements from arr2 (backup array)

        System.out.println("\nThe Unsorted List: " + list.toString());
        System.out.printf("My Bucket-Sort time %.2f milliseconds\n",(double)(bucketSort(arr,0,(sz-1),2))/1000000);//prints runtime of bucket sort method and sorts arr
        list = Arrays.asList(arr);
        System.out.println("The sorted list with Bucket-sort: " + list.toString());
        //bucket sort does not work either
        //fixed it was passing in the wrong  parameters

        myFooter(2,1);//footer method

    }
}
