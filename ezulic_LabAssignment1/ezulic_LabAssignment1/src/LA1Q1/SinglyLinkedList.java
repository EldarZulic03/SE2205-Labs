package LA1Q1;

public class SinglyLinkedList <T>{
    private Node<T> head = null; //initializing head
    private Node<T> tail = null; //initializing tail
    private int size = 0; //initializing size

    public SinglyLinkedList(Node<T> head, Node<T> tail, int size){
        this.head = head;
        this.tail = tail;
        this.size = size;
    }//constructor with parameters

    public SinglyLinkedList(){}//empty constructor

    public int getSize(){
        return size;
    }//getter method of size of list

    public Boolean isEmpty(){
        if(size ==0){
            return true;
        }else{
            return false;
        }
    }//method that checks if list is empty



    public String toString(){
        String returnString = "";//creation of empty return String
        Node<T> current = head;//head node assigned to the new current node, used to cycle through

        if(!isEmpty()){
            while(current.getNext() != null){
                returnString = returnString + current.getElement() + ", ";
                current = current.getNext();
            }//while loop to concatenate the return String
            returnString = returnString + current.getElement();
        }
        return "[" + returnString + "]";//returns the whole Singly Linked List inside of square brackets
    }//toString method that concatenates all elements and returns them when called

    public void addFirst(T first){

        head = new Node<>(first, head);//creates a new head node that will point to previous head
        if(size == 0){
            tail =head;
            //if the list is empty head is set to the tail
        }
        size++;
    }//method that adds a node at head of linked list and makes it a new head

    public void addLast(T last){
        Node<T> newest = new Node<>(last, null);//creation of new tail node points to null
        Node<T> copy = head;//creation of new node assigned to head that cycles through list to find tail node

        if(isEmpty()){
            head = newest;
        }//if list is empty head node is equal to newest node
        while(copy.getNext()!=null){
            copy = copy.getNext();
        }//while loop to find last node

        if(copy.getNext()==null){
        copy.setNext(newest);//sets the next node equal to newest
        tail = newest;//sets tail equal to newest node
        size++;}

    }//method that adds a node at the tail of the linked list and makes it a new tail


    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T answer = head.getElement();//gets the current element in the head node
        head = head.getNext();//assigns head to the next node after it
        size--;
        if(size==0){
            tail = null;
        }
        return answer;//returns the element in the previous head node
    }//method that removes the head and returns the element then assigns the next node as new head

    public T removeLast(){
        Node<T> secondLast =head;//creation of new node to find the second last node in list

        if(isEmpty()){
            return null;
        }
        if(secondLast.getNext()==null){
            tail = secondLast;//sets tail equal to second last node
            secondLast.setNext(null);//removes the last node
            size --;
            return tail.getElement();//returns tail
        }
        while(((secondLast.getNext().getNext()) != null)) {
            secondLast = secondLast.getNext();
        }//loops through list till it finds the second last node

        tail = secondLast.getNext();//sets tail equal to second last node
        secondLast.setNext((null));//removes last node
        size--;
        return tail.getElement();//returns tail
    }//method that removes the tail and returns the element then assigns the previous node as the new tail

    public void pushAtHead(T element){
        addFirst(element);
    }//method that realizes head as top of stack and pushes an element to the top of the stack

    public T popFromHead(){
        return removeFirst();
    }//method that realizes head as top of stack pops an element from the top of the stack and then returns it

    public void pushAtTail(T element){
        addLast(element);
    }//method that realizes tail as top of stack and pushes an element to top of stack

    public T popFromTail(){
        return removeLast();
    }//method that realizes tail as top of stack and pops an element from the top of the stack then returns it

    public void enqueueAtTail(T element){
        addLast(element);
    }//method that realizes the tail as the rear of the queue and queues element at the rear

    public T dequeueFromHead(){
        return removeFirst();
    }//method that realizes the head as the front of the queue and dequeues the front element and returns the dequeued value

    public int searchStack(T element){
        Node <T> search = head;//creation of new node equal to head to search through list
        int i =1;
        while(search!=null){

            if(search.getElement().equals(element)){
                return i;//if it finds the element return the location
            }
            search = search.getNext();
            i++;
        }//loop to search through whole list
        return 0;//return 0 if element was not found
    }//method that searches for an element in the stack from the head-side and returns an integer value based on the position


}
