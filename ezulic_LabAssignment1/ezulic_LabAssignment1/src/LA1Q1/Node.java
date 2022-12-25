package LA1Q1;

public class Node <T>{
    private T element;
    private Node<T> next;
    //creating 2 private fields

    public Node(){}//empty constructor

    public Node(T element, Node<T> next){
        this.element = element;
        this.next = next;
    }//constructor with parameters

    public Node<T> getNext(){
        return next;
    }//getter method of next node

    public T getElement(){
        return element;
    }//getter method of current element

    public void setNext(Node <T> next){
        this.next = next;
    }//setter method of next node

}
