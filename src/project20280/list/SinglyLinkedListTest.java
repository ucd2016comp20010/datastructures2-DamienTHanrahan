package project20280.list;

import org.junit.jupiter.api.Test;
import project20280.interfaces.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class SinglyLinkedListTest {

    @Test
    void testIsEmpty() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        assertTrue(ll.isEmpty());
        assertEquals("[]", ll.toString());

        ll.addLast(1);
        assertFalse(ll.isEmpty());

        ll.removeLast();
        assertTrue(ll.isEmpty());
    }

    @Test
    void testGet() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        Integer r = ll.get(2);
        assertEquals(3, r, "did not get right element" + r);
    }

    @Test
    void testAdd() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        ll.add(1, 100);

        assertEquals("[1, 100, 2, 3]", ll.toString(), "item not added correctly");
    }

    @Test
    void testRemove() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        assertEquals(3, ll.remove(2), "the removed value should be 3");
        assertEquals(2, ll.size(), "the size should be 2");
    }

    @Test
    void testSize() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        assertEquals(0, ll.size());

        ll.addFirst(1);
        assertEquals(1, ll.size());

        ll.removeFirst();
        assertEquals(0, ll.size());
    }

    @Test
    void testRemoveFirst() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
		assertNull(ll.removeFirst());

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        Integer r = ll.removeFirst();
        assertEquals(1, r);
        assertEquals(2, ll.size());
    }

    @Test
    void testRemoveLast() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        assertEquals(3, ll.removeLast());
        assertEquals(2, ll.size());
    }

    @Test
    void testAddFirst() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(-1);
        ll.addFirst(1);

        assertEquals(2, ll.size());
        assertEquals("[1, -1]", ll.toString());
    }

    @Test
    void testAddLast() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addFirst(1);
        ll.addLast(-1);

        assertEquals(2, ll.size());
        assertEquals("[1, -1]", ll.toString());
    }

    @Test
    void testToString() {
        List<Integer> ll = new SinglyLinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        assertEquals("[1, 2, 3]", ll.toString());
    }

    @Test 

    void testSortedMerge(){

        
        SinglyLinkedList<Integer> a = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> b = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> c = new SinglyLinkedList<>();
        Random r = new Random();

        int j=1;
        int k = 0;
        
        for (int i =0; i< 100; i++){

            k = r.nextInt(j) + k + 1;
            System.out.println(k);
            c.addLast(k);
            if (k%2 == 0){
                a.addLast(k);
            }
            else{
                b.addLast(k);
            }

            j = j + 3; 
            System.out.println(j);
        }

        System.out.println(c);
        System.out.println(a);
        System.out.println(b);
        System.out.println();

        a.sortedMerge(b); 

        assertEquals(0, b.size());
        assertEquals(100, c.size());
        assertEquals(a.size(), c.size());

        for (j=0; j<99; j++){

            assertTrue(a.get(j) - a.get(j+1) <= 0); 
            assertEquals(a.get(j), c.get(j)); 

        }






       
    

        
        
         
        
        


    }

}
