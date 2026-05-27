package project20280.stacksqueues;

import project20280.interfaces.Stack;
import project20280.list.DoublyLinkedList;

public class LinkedStack<E> implements Stack<E> {

    private DoublyLinkedList<E> ll;

    public static void main(String[] args) {

        


    }

    public LinkedStack() {
        
        this.ll = new DoublyLinkedList<E>();
    }

    @Override
    public int size() {
        return ll.size();
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public void push(E e) {

        ll.addFirst(e);
        
    }

    @Override
    public E top() {
        
        if(!isEmpty()){
            return ll.get(0);
        }
        else{
            return null;
        }
    }

    @Override
    public E pop() {
        
        if(!isEmpty()){
            return ll.removeFirst();
        }
        else{
            return null;
        }
        
    }

    public String toString() {
        return ll.toString();
    }
}
