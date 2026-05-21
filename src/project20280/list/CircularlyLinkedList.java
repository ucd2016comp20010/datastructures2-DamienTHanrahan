package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T e, Node<T> n) {
            data = e;
            next = n;
        }

        

        public T getData() {
            return data;
        }

        public void setNext(Node<T> n) {
            next = n;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) {
        if (isEmpty()){
            return null;
        }
        else {
            Node<E> walk = tail.getNext();
            int count = 0;
            
         
            do {
                if (count == i) {
                    return walk.getData();
                }
                else {
                    walk = walk.getNext();
                    count++;
                }
            } while (walk != tail.getNext());

            throw new IndexOutOfBoundsException();

            


        }
    }

    /**
     * Inserts the given element at the specified index of the list, shifting all
     * subsequent elements in the list one position further to make room.
     *
     * @param i the index at which the new element should be stored
     * @param e the new element to be stored
     */
    @Override
    public void add(int i, E e) {

       Node<E> temp = new Node <>(e, null);

       if (isEmpty()) {tail = temp; tail.setNext(tail); return;}

       else {

        Node<E> walk = tail;
        int count = -1;

        do{
            if (count == i - 1){

                temp.setNext(walk.getNext());
                walk.setNext(temp);
                size++;
                return;
            }
            else {

                count++;
                walk = walk.getNext();
            }
        } while (walk != tail);

       }

       throw new IndexOutOfBoundsException();

       

       

    
       
    

        
    }

    @Override
    public E remove(int i) {

        int count = -1;
        Node<E> walk = tail;
        if (isEmpty()){return null;}
        else {
            do{
                if (count == i -1){
                    
                    E element = walk.getNext().getData();
                    if (walk.getNext() == tail){tail = walk;}
                    walk.setNext(walk.getNext().getNext());
                    size--;
                    return element;
                }
                else{

                    count++;
                    walk = walk.getNext();
                }
            } while (walk != tail);
        }

        throw new IndexOutOfBoundsException();
    
    }

    public void rotate() {

        tail = tail.getNext();

    }

    private class CircularlyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) tail.getNext();
        Node<E> temp = curr;

        @Override
        public boolean hasNext() {
            return temp != tail;
        }

        @Override
        public E next() {
            E res = curr.getData();
            if (curr.getNext() != tail) {temp= temp.getNext();}
            curr = curr.getNext();
            return res;
        }

    }

    @Override
    public Iterator<E> iterator() {
        return new CircularlyLinkedListIterator<E>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E removeFirst() {
        
        if (isEmpty()){return null;}
        else{
 
            E element = tail.getNext().getData();
            tail.setNext(tail.getNext().getNext());
            size--;
            return element;
        }

    }

    @Override
    public E removeLast() {
        
        if (isEmpty()){return null;}
        
        Node<E> walk = tail;

        do{
            if (walk.getNext() == tail){
                
                E element = tail.getData();
                walk.setNext(tail.getNext());
                tail = walk;
                size--;
                return element;

            }
            
            else {
                walk = walk.getNext();
            }
        }while(walk != tail);

        throw new IndexOutOfBoundsException();
    }

    @Override
    public void addFirst(E e) {
        
        
        
        Node<E> added = new Node<>(e, null);

        if (isEmpty()) {tail = added; tail.setNext(tail); size++; return;}
        added.setNext(tail.getNext());
        tail.setNext(added);
        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> added = new Node<>(e, null);
        if (isEmpty()) {tail = added; tail.setNext(tail); size++; return;}
        added.setNext(tail.getNext());
        tail.setNext(added);
        tail = added;
        size++;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        
        if (isEmpty()){ return "[]";}
        Node<E> curr = tail;
        do {
            curr = curr.next;
            sb.append(curr.data);
            if (curr != tail) {
                sb.append(", ");
            }
        } while (curr != tail);
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
        for (int i = 10; i < 20; ++i) {
            ll.addLast(i);
        }

        System.out.println(ll);

        ll.removeFirst();
        System.out.println(ll);

        ll.removeLast();
        System.out.println(ll);

        ll.rotate();
        System.out.println(ll);

        ll.removeFirst();
        ll.rotate();
        System.out.println(ll);

        ll.removeLast();
        ll.rotate();
        System.out.println(ll);

        for (Integer e : ll) {
            System.out.println("value: " + e);
        }

    }
}
