package project20280.stacksqueues;
import project20280.interfaces.Queue;








class StackViaQueue<E> implements Queue<E> {


    private LinkedStack<E> s1; 
    private LinkedStack<E> s2;
    

    
    
    public StackViaQueue(){

        s1 = new LinkedStack<>();
        s2 = new LinkedStack<>();
        
        
    }

    public void transfer(LinkedStack<E> a, LinkedStack<E> b) {

        
        if(a.isEmpty() || !b.isEmpty()) throw new IllegalArgumentException("param 1 must transfer to empty param 2");
        while (!a.isEmpty()){
            b.push(a.pop());
        }
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

        transfer(s1, s2);

        
        E temp = s2.top();

        transfer(s2, s1);

        return temp;



    }

    public E dequeue(){

        if(s1.isEmpty()) {return null;}

        transfer(s1, s2);

        
        E temp = s2.pop();

        
        if (s2.isEmpty()) return temp;
       
        transfer(s2, s1);

        return temp;



    }







}
