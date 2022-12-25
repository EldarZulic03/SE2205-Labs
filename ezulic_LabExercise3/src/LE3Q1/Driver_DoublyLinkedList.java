package LE3Q1;

public class Driver_DoublyLinkedList {
    public static void myHeader (int labE_number, int q_number){
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise %d-Q%d", labE_number,q_number);
        System.out.println("Prepared by: Eldar Zulic");
        System.out.println("Student Number: 251230378");
        System.out.println("Goal of this exercise: Working with Doubly Linked Lists");
        System.out.println("=======================================================");
    } //header method takes question number and exercise number as input

    public static void myFooter(int labE_number, int q_number){
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Exercise %d-Q%d is succesful!\n",labE_number,q_number );
        System.out.println("Signing off - Eldar");
        System.out.println("=======================================================");
    }//footer method takes question number and exercise number as input

    public static void main(String[] args) {
        myHeader(3,1); //calls header method

        DoublyLinkedList<MyStudent> yourFirstNameList = new DoublyLinkedList<>();//DoublyLinkedList reference variable of MyStudent

        MyStudent s0 = new MyStudent();
        MyStudent s1 = new MyStudent("Harry", 67.35);;
        MyStudent s2 = new MyStudent("Luna", 87.5);
        MyStudent s3 = new MyStudent("Vincent", 60.5);
        MyStudent s4 = new MyStudent("Hermione", 89.2);

        yourFirstNameList.addLast(s0);
        yourFirstNameList.addLast(s1);
        yourFirstNameList.addLast(s2);
        yourFirstNameList.addLast(s3);

        System.out.println(yourFirstNameList.toString());

    }
}
