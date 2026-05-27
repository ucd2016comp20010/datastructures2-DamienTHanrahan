package project20280.stacksqueues;
import project20280.interfaces.Queue;








class StackViaQueue<E> implements Queue<E> {


    private LinkedStack<E> s1; 
    private LinkedStack<E> s2;
    

    
    
    public StackViaQueue(){

        s1 = new LinkedStack<>();
        s2 = new LinkedStack<>();
        
        
    }

    

   
   
   

    public int size(){
        return s2.size() + s1.size();
    }

    public boolean isEmpty(){

        return s2.isEmpty() && s1.isEmpty();
    }

    public void enqueue(E e){

        s1.push(e);
    }

    public E first(){

        if(s1.isEmpty()) {return null;}

        s1.transfer(s2);

        
        E temp = s2.top();

        s2.transfer(s1);

        return temp;



    }

    public E dequeue(){

        if(s1.isEmpty()) {return null;}

        s1.transfer(s2);

        
        E temp = s2.pop();

        
        if (s2.isEmpty()) return temp;
       
        s2.transfer(s1);

        return temp;



    }







}
