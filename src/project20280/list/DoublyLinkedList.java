package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> p, Node<E> n) {
            data = e;
            prev = p;
            next = n;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }
        public void setNext(Node<E> node) {
            this.next = node;
        }

        public void setPrev(Node<E> node) {
            this.prev = node;
        }

    }

    private final Node<E> head;
    private final Node<E> tail;
    private int size = 0;

    public DoublyLinkedList() {
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null, head, null);
        head.next = tail;
    }

    private void addBetween(E e, Node<E> pred, Node<E> succ) {
        
        if(pred.getNext() != succ || succ.getPrev() != pred) {
            throw new IllegalArgumentException();
        }

        else {
            Node<E> added = new Node <>(e, pred, succ);
            pred.setNext(added);
            succ.setPrev(added);
        }
        
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0; 
    }

    @Override
    public E get(int i) {

        Node<E> walk = head;
        int count = -1;
        while (walk != tail){

            if (count == i && i >= 0) {
                return walk.getData();

            }
            else {
                walk = walk.getNext();
                count++;
            }
        }

        throw new IndexOutOfBoundsException();



    }

    @Override
    public void add(int i, E e) {
        
        Node<E> walk = head;
        int count = -1;
        while (walk != tail){
            if (count == i - 1){
                Node<E> added = new Node<>(e, walk, walk.getNext());
                walk.getNext().setPrev(added);
                walk.setNext(added);
                size++;
                return;
            }
            else {
                count++;
                walk = walk.getNext();
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public E remove(int i) {
        
        Node<E> walk = head;
        int count = -1;
        while (walk.getNext() != tail){
            if (count == i -1){
                E data = walk.getNext().getData();
                walk.setNext(walk.getNext().getNext());
                walk.getNext().setPrev(walk);
                size--;
                return data;

            }
            else {
                walk = walk.getNext();
                count++;

            }
        }

        throw new IndexOutOfBoundsException();
    }

    private class DoublyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) head.next;

        @Override
        public boolean hasNext() {
            return curr != tail;
        }

        @Override
        public E next() {
            E res = curr.data;
            curr = curr.next;
            return res;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator<E>();
    }

    private E remove(Node<E> n) {
        
        if (n.getPrev() == null || n.getNext() == null){ throw new IllegalArgumentException();}
        else{

            n.getPrev().setNext(n.getNext());
            n.getNext().setPrev(n.getPrev());
            size--;
            return n.getData();
        }
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getNext().getData();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }

        return tail.getPrev().getData();
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        else{
            E data = head.getNext().getData();
            head.getNext().getNext().setPrev(head);
            head.setNext(head.getNext().getNext());
            size--;
            return data;
            
        }
    }

    @Override
    public E removeLast() {

        if (isEmpty()) {
            return null;
        }
        else {
            E data = tail.getPrev().getData();
            tail.getPrev().getPrev().setNext(tail);
            tail.setPrev(tail.getPrev().getPrev());
            size--;
            return data;
        }
        
    }

    @Override
    public void addLast(E e) {
        
        
        Node<E> added = new Node<>(e, tail.getPrev(), tail);
        tail.getPrev().setNext(added);
        tail.setPrev(added);
        size++;

    }

    @Override
    public void addFirst(E e) {
        Node<E> added = new Node<>(e, head, head.getNext());
        head.getNext().setPrev(added);
        head.setNext(added);
        size++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = head.next;
        while (curr != tail) {
            sb.append(curr.data);
            curr = curr.next;
            if (curr != tail) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(-1);
        System.out.println(ll);

        ll.removeFirst();
        System.out.println(ll);

        ll.removeLast();
        System.out.println(ll);

        for (Integer e : ll) {
            System.out.println("value: " + e);
        }
    }
}