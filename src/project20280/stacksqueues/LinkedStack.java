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

    public void transfer(LinkedStack<E> a) {

        
        if(isEmpty() || !a.isEmpty()) throw new IllegalArgumentException("param 1 must transfer to empty param 2");
        
        while (!isEmpty()){
            
            a.push(pop());
        }
    }

    public void reverse(){

        LinkedStack<E> s1 = new LinkedStack<>();
        LinkedStack<E> s2 = new LinkedStack<>();

        if (isEmpty()) throw new IllegalArgumentException("need elements to reverse");

        transfer(s1);
        s1.transfer(s2);
        s2.transfer(this);



    }
}
