/* Henry Zhang
 ;APCS2 pd9
 ;HW #28: All Hands on Deque! (Not Schenectady; rather, synecdoche.)
 ;2016-04-06
 */
/*==============================================================/
Deque changes: 
For each method adding, peeking or removing from one side of the queue...
another method was written doing the same for the other end of the queue
/==============================================================*/
public class Deque<T>  {
    public DLLNode<T> _front, _end;

    public Deque(){
	_front = null;
	_end = null;
    }

    public void enqueue(T enQVal){
	//special case: when enqueuing to an empty list, 
	//make _front && _end point to same node
	if ( isEmpty() ) {
	    _front = _end = new DLLNode<T>( enQVal, null, null );
	}
	else {
	    // Q: Why is this a bad idea:
	    //    _end = new LLNode<T>( enQVal, null );
	    _end.setNext( new DLLNode<T>( enQVal, _end, null  ) );
	    _end = _end.getNext();
	}
    }
    //O(1)
    public void enqueueF(T enQVal){
	//special case: when enqueuing to an empty list, 
	//make _front && _end point to same node
	if ( isEmpty() ) {
	    _front = _end = new DLLNode<T>( enQVal, null, null );
	}
	else {
	    // Q: Why is this a bad idea:
	    //    _end = new LLNode<T>( enQVal, null );
	    _front.setPrev( new DLLNode<T>( enQVal, null , _front) );
	    _front = _front.getPrev();
	}
    }
    //O(1)
    public T dequeue() 
    { 
	T foo = _front.getCargo();
	_front = _front.getNext();
	//check for emptiness
	if ( _front == null )
	    _end = null;
	return foo;
	
    }//O(1)

    public T dequeueE(){
	T foo=_end.getCargo();
	_end=_end.getPrev();
	if(_end==null)
	    _front=null;
	return foo;

    }//O(1)
    
     public T peekFront() 
    {
	return _front.getCargo(); 
    }//O(1)

     public T peekEnd() 
    {
	return _end.getCargo(); 
    }//O(1)



    public boolean isEmpty() 
    {
	return _front == null; 
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
	String foo = "";
	DLLNode<T> tmp = _front;
	while ( tmp != null ) {
	    foo += tmp.getCargo() + " ";
	    tmp = tmp.getNext();
	}
	return foo;
    }
    public static void main(String[] args){
	Deque<String> q1 = new Deque<String>();

	System.out.println("\nnow enqueuing thrice..."); 
	q1.enqueue("James");
	q1.enqueueF("Todd");
	q1.enqueue("Smith");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( q1 ); //for testing toString()...

	System.out.println("\nnow dequeuing thrice..."); 
	System.out.println( q1.dequeue() );
	System.out.println( q1.dequeueE() );
	System.out.println( q1.dequeue() );


    }
}
	
