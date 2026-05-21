package project20280.list;

import project20280.interfaces.List;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {

    private static class Node<E> {

        private final E element;            // reference to the element stored at this node

        /**
         * A reference to the subsequent node in the list
         */
        private Node<E> next;         // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e the element to be stored
         * @param n reference to a node that should follow the new node
         */
        public Node(E e, Node<E> n) {
            
            this.element = e;
            this.next = n;
        }

        // Accessor methods

        /**
         * Returns the element stored at the node.
         *
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         *
         * @return the following node
         */
        public Node<E> getNext() {
            
            return next;
        }

        // Modifier methods

        /**
         * Sets the node's next reference to point to Node n.
         *
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) {
            
            this.next = n;
        }
    } //----------- end of nested Node class -----------

    /**
     * The head node of the list
     */
    private Node<E> head = null;               // head node of the list (or null if empty)


    /**
     * Number of nodes in the list
     */
    private int size = 0;                      // number of nodes in the list

    public SinglyLinkedList() {
    }              // constructs an initially empty list

    //@Override
    public int size() {
        
        return size;
    }

    //@Override
    public boolean isEmpty() {
        
        return size == 0;
    }

    @Override
    public E get(int position) {
        Node<E> walk = head;
        int index =0; 
        while (walk != null){

            if (index == position) {
                return walk.getElement();
            }
            else{
                walk = walk.getNext();
                index++;
            }


        }
    throw new IndexOutOfBoundsException();

    }

    @Override
    public void add(int position, E e) {
        
    Node<E> walk = head;
    Node<E> added = new Node<>(e, walk);

    if (position == 0) {
        
        head = added;
        size++;
        return;
    
    }
    
    int count = 0; 
    while (walk != null){

        if (count == position -1) {

            added.setNext(walk.getNext());
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
    public void addFirst(E e) {
        
        Node<E> first = new Node<>(e, head);
        head = first;
        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> last = new Node<>(e, null);
        if (head == null) {head = last; size++; return;}
        
       
        else {

            Node<E> walk = head;
            while (walk != null) {
                if (walk.getNext() == null) {
                    walk.setNext(last);
                    size++;
                    return;
                }
                else {
                    walk = walk.getNext();
                }
            }
        }
    }

    @Override
    public E remove(int position) {
        
        Node<E> walk = head;
        if (walk == null){ throw new IndexOutOfBoundsException();}
        else if(position == 0) {E element = walk.getElement(); head = walk.getNext(); size--; return element;}
       
        else {
            int count = 0; 

            while (walk.getNext() != null) {
                if (count == position-1){

                    E element = walk.getNext().getElement();
                    walk.setNext(walk.getNext());
                    size--;
                    return element;

                }
                else{
                    walk = walk.getNext();
                    count++;

                }

            
            }
           
        }

        throw new IndexOutOfBoundsException();

       
        
    }

    @Override
    public E removeFirst() {
        
        
        if (head == null) {return null;}
        E element = head.getElement();
        head = head.getNext();
        size--;
        return element;
        
    }

    @Override
    public E removeLast() {
        
        Node<E> walk = head;
        if (walk == null){ throw new IndexOutOfBoundsException();}
        if (walk.getNext() == null){head = null; size--; return walk.getElement();}
        while (walk.getNext() != null){
            if (walk.getNext().getNext() == null){
                E element = walk.getNext().getElement();
                walk.setNext(null);
                size--;
                return element;
            }
            else{
                walk = walk.getNext();
            }


        }

        throw new IndexOutOfBoundsException();
    }

    //@Override
    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator<E>();
    }

    private class SinglyLinkedListIterator<E> implements Iterator<E> {
        Node<E> curr = (Node<E>) head;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {
            E res = curr.getElement();
            curr = curr.getNext();
            return res;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curr = head;
        while (curr != null) {
            sb.append(curr.getElement());
            if (curr.getNext() != null)
                sb.append(", ");
            curr = curr.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
        System.out.println("ll " + ll + " isEmpty: " + ll.isEmpty());
        //LinkedList<Integer> ll = new LinkedList<Integer>();

        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addLast(-1);
        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);
        ll.removeFirst();
        System.out.println(ll);
        System.out.println("I accept your apology");
        ll.add(3, 2);
        System.out.println("reach me?");
        System.out.println(ll);
        System.out.println(ll);
        ll.remove(3);
        System.out.println(ll);

    }
}
