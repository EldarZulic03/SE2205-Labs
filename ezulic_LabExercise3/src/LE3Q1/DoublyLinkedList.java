package LE3Q1;

import java.lang.annotation.ElementType;
import java.util.ArrayList;

public class DoublyLinkedList <E>{

    public static class Node <E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> previous, Node<E> next){
            this.element = element;
            this.prev = previous;
            this.next = next;
        }

        public E getElement(){
            return element;
        }

        public void setPrev(Node<E> p){
            prev = p;
        }

        public void setNext(Node<E> n){
            next = n;
        }

        public Node<E> getPrev(){
            return prev;
        }

        public Node<E> getNext(){
            return next;
        }

    }

    private Node<E> trailer;
    private int size = 0;
    private Node<E> header;

    public DoublyLinkedList(){
        header = new Node<>(null,null,null);
        trailer = new Node<>(null,header,null);
        header.setNext(trailer);
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
       return size==0;
    }
    public void addLast(E element){
        addBetween(element,trailer.getPrev(),trailer);
    }
    public void addBetween(E element, Node<E> predecessor, Node<E> successor){
        Node<E> newest= new Node<E>(element,predecessor,successor);
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size++;
    }
    public Node<E> findNode(E element){
        Node<E> search = header;

        while(search != null){

            if(search.getElement().equals(element)){
                return search;
            }
            search = search.getNext();
        }
        return null;
    }

    /*public String toString(){
        String returnString = "";
        Node<E> current = header;
        if(!isEmpty()){
            while(current.getNext()!=null){
                returnString = returnString + current.getElement() + ",";
                current = current.getNext();
            }
            returnString = returnString + current.getElement();
        }
        return returnString;
    }*/ //didn't work

    public String toString(){
        ArrayList<E> returnArrayList = new ArrayList<>();
        Node<E> current = header;
        if(!isEmpty()){
            while(current.getNext()!= null){
                E element = current.getElement();
                returnArrayList.add(element);
                current = current.getNext();
            }
        }
        return returnArrayList.toString();
    }

}
