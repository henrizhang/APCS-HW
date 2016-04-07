/* Henry Zhang
 ;APCS2 pd9
 ;HW #27: Now Let’s Consider You Lot at Fake Terry’s
 ;2016-04-05
 */

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linked list points opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/

import java.util.Random;

public class RQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
	{
	    _front =null;
	    _end=null;
	}//end default constructor


    public void enqueue( T enQVal ) 
    {
        //special case: when enqueuing to an empty list, 
	//make _front && _end point to same node
	if ( isEmpty() ) {
	    _front = _end = new LLNode<T>( enQVal, null );
	}
	else {
	    // Q: Why is this a bad idea:
	    //    _end = new LLNode<T>( enQVal, null );
	    _end.setNext( new LLNode<T>( enQVal, null ) );
	    _end = _end.getNext();
	}
    }//end enqueue()


    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() {
	if (_front==null){
	    return null;
	}
	else{
	    sample();
	    if (_front==null){
		return null;
	    }
	    T foo = _front.getValue();
	    _front = _front.getNext();
	    //check for emptiness
	    if ( _front == null )
		_end = null;
	    return foo;
	}
    }
//end dequeue()


    public T peekFront() {
	sample();
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     * gen rand int from 0-size of LLQ
     * use temp and iterate through to find the node there
     * break that node's link to the next one, setting the next to null
     * the end 's linked node is now the former front
     * the new front is the Node that used to be after the generated number's node
    ******************************************/
    public void sample (){
	
	int rand=((int)Math.random())*(_size-1);
	LLNode<T> temp=_front;
	for (int i =0; i<rand; i++){
	    temp=temp.getNext();
	}
	
	temp.setNext(null);
	LLNode<T> temp2=temp.getNext();
	_end.setNext(_front);
	_end=temp;
	_front=temp2;
	
    }
    //end sample()


    public boolean isEmpty() 
    {
	return _size==0;
    } //O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
	
	String foo = "";
	LLNode<T> tmp = _front;
	while ( tmp != null ) {
	    foo += tmp.getValue() + " ";
	    tmp = tmp.getNext();
	}
	return foo;
    }//end toString()



    //main method for testing
    public static void main( String[] args ) {


	Queue<String> PirateQueue = new RQueue<String>();
	System.out.println("\nnow enqueuing..."); 
	PirateQueue.enqueue("Dread");
	PirateQueue.enqueue("Pirate");
	PirateQueue.enqueue("Robert");
	PirateQueue.enqueue("Blackbeard");
	PirateQueue.enqueue("Peter");
	PirateQueue.enqueue("Stuyvesant");
	System.out.println("\nnow testing toString()..."); 
	System.out.println( PirateQueue ); //for testing toString()...
	System.out.println("\nnow dequeuing..."); 
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println("\nnow dequeuing fr empty queue..."); 
	System.out.println( PirateQueue.dequeue() );
        
    }//end main

}//end class RQueue
