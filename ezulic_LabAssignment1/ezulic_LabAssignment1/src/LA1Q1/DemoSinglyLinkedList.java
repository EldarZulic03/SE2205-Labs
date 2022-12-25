package LA1Q1;
import java.util.*;

public class DemoSinglyLinkedList {
    public static Scanner input = new Scanner(System.in);//creating scanner to read input

    public DemoSinglyLinkedList(){}//empty constructor

    public static void myHeader (int labNumb){
        System.out.println("=======================================================");
        System.out.printf("Lab Assignment %d\n", labNumb);
        System.out.println("Prepared by: Eldar Zulic");
        System.out.println("Student Number: 251230378");
        System.out.println("Goal of this exercise: Using Singly Linked Lists to work with Queue and Stack");
        System.out.println("=======================================================");
    }//header

    public static void myFooter(int labNumb){
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Assignment %d is succesful!\n",labNumb );
        System.out.println("Signing off - Eldar");
        System.out.println("=======================================================");
    }//footer

    //method that accepts SinglyLinkedList type parameter and demonstrates the stack operations
    public static void stackDemo(SinglyLinkedList stackTest){
        int choice = 0;
        try{
            System.out.println("Which end of the Linked List would you like to use as the stack top?");
            System.out.print("Enter 1 for head or 2 for tail: ");//prompts user
            choice = input.nextInt();
            while(choice != 1 && choice !=2){
                System.out.print("\nIncorrect Input! Enter 1 for head or 2 for tail: ");
                choice = input.nextInt();
            }
        }catch(InputMismatchException e){
            System.out.println("Incorrect Input!");
        }//try catch statement to catch if the user inputs wrong input

        if(choice ==1){//if user inputs 1 the head will be treated as top of stack
            System.out.println("\nStack top: Head of the linked list");
            System.out.println("\nLet's pop all the elements from the stack in sequence: ");
            System.out.println("The current stack: " + stackTest.toString() + "\n");//prints the currrent stack
            while(stackTest.getSize() !=0){
                System.out.println(stackTest.popFromHead() + " had been popped! The revised stack : " +stackTest.toString() );
            }//while loop to pop all elements of the stack from head
            System.out.println("\nLet's push 39 and -58 in the stack...");
            System.out.println("The current stack :" + stackTest.toString());
            stackTest.pushAtHead(39);//pushes element to head of stack
            System.out.println("After 39 is pushed, the revised stack: " +stackTest.toString());
            stackTest.pushAtHead(-58);//pushes element to head of stack
            System.out.println("After -58 is pushed, the revised stack: " + stackTest.toString() + "\n");
        }
        else if(choice == 2){ //if user inputs 2 the tail will be treated as top of stack
            System.out.println("Stack top: Tail of the linked list\n");
            System.out.println("Let's pop all the elements from the stack in sequence:");
            System.out.println("The current stack: " + stackTest.toString() + "\n"); //prints the current stack
            while(stackTest.getSize()>2){
                System.out.println(stackTest.popFromTail() + " has been popped! The revised stack: " + stackTest.toString());
            }//while loop to pop 3 elements of the stack from tail
            System.out.println("\nLet's push 39 and -58 in the stack...");
            System.out.println("The current stack : " + stackTest);
            stackTest.pushAtTail(39);//pushes element to tail of stack
            System.out.println("After 39 is pushed, the revised stack: " +stackTest);
            stackTest.pushAtTail(-58);//pushes element to tail of stack
            System.out.println("After -58 is pushed, the revised stack: " + stackTest.toString() + "\n");
        }
    }

    //method that accepts SinglyLinkedList type parameter and demonstrates the queue operations
    public static void queueDemo(SinglyLinkedList queueTest){
        System.out.println("Note: Head is the Q-front, and Tail is the Q-rear\n");
        System.out.println("Let's enqueue Joelle and Lukas in the queue in sequence...\n ");
        System.out.println("The current Queue: " + queueTest);//prints the current queue

        queueTest.enqueueAtTail("Joelle");//queues element at tail
        System.out.println("\nAfter Joelle is enqueued, the revised Queue: " + queueTest);
        queueTest.enqueueAtTail("Lukas");//queues element at tail
        System.out.println("After Lukas is enqueued, the revised Queue: " + queueTest);

        System.out.println("\nLet's dequeue first three elements from the queue in sequence ....");
        System.out.println("The current Queue: " + queueTest);//prints current stack

        System.out.println("\n" +queueTest.dequeueFromHead()+ " has been dequeued! The revised queue:" + queueTest);
        queueTest.dequeueFromHead();//dequeues element from head
        System.out.println(queueTest.dequeueFromHead() + " has been dequeued! The revised queue:" + queueTest);
        queueTest.dequeueFromHead();//dequeues element from head
        System.out.println(queueTest.dequeueFromHead() +" has been dequeued! The revised queue: " + queueTest);
    }

    public static void main(String[] args) {

        myHeader(1);//calls header

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(56,-22,34,57,98));//creates ArrayList of type Integer

        ArrayList<String> names = new ArrayList<>(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));//creates ArrayList of type String
        System.out.println("The given Integer Array" + numbers);
        System.out.printf("\nThe given String Array %s\n",names);
        //prints the 2 ArrayLists

        SinglyLinkedList<Integer> integerSinglyLinkedList = new SinglyLinkedList<>();
        SinglyLinkedList<String> stringSinglyLinkedList = new SinglyLinkedList<>();
        //creates 2 SinglyLinkedLists of type Integer and String

        for(int i = 0; i<numbers.size()-2; i++){
            integerSinglyLinkedList.addFirst(numbers.get(i));
        }for(int i = numbers.size()-1; i>2;i--){
            integerSinglyLinkedList.addLast(numbers.get(i));
        }//adds elements of Integer ArrayList to integerSinglyLinkedList
        System.out.println("Your Integer  list: "+ integerSinglyLinkedList.toString() );//prints integerSinglyLinkedList


        for(int i = 0; i<3;i++){
            stringSinglyLinkedList.pushAtHead(names.get(i));
        }for(int i = 4; i>=3;i--){
            stringSinglyLinkedList.pushAtTail(names.get(i));
        }//adds elements of String ArrayList to stringSinglyLinkedList

        System.out.println("Your String list: " + stringSinglyLinkedList.toString() );//prints stringSinglyLinkedList
        System.out.println("\nStack demo with the Integer linked list...");
        stackDemo(integerSinglyLinkedList);//calls stackDemo method
        System.out.println("Queue demo with the String linked list ... ");
        queueDemo(stringSinglyLinkedList);//calls queueDemo method

        System.out.println("\nLet's search the stack");
        System.out.println("The current stack: " + integerSinglyLinkedList + "\n");//prints current stack

        System.out.println("\nSearch:");

        String answer = "";//creates empty string to store user's answer

        do{
            System.out.print("Enter the value you are searching for: ");
            int element = input.nextInt();
            int searchResult = integerSinglyLinkedList.searchStack(element);
            if(searchResult==0){
                System.out.println("The value is not found! ");
            }else{
                System.out.println("The value is found in location " + searchResult + " from the top of the stack");
            }

            System.out.print("Do you want to continue? (enter 'y' for yes, or enter any other key to discountinue): ");
            answer = input.next();

        }while((answer.equals("y")||answer.equals("Y")));//do while loop to search stack for element and prompt user if they want to keep searching



        myFooter(1);//calls footer method
    }

}
