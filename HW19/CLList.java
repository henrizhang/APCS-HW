/* Henry Zhang
 ;APCS2 pd9
 ;HW #18: For Each Is the Goal
 ;2016-03-28
 */


/*****************************************************
 * skeleton for class CLList 
 * implements a circularly-linked list of doubly-linked nodes
 ******************************************************/

public class CLList<T> {

    // only 1 head/tail/front/end pointer is necessary,
    // since the list is circularly-linked
    private DLLNode<T> _head;
    private int _size = 0;

    public CLList() {
	    _head=null;
	    _size=0;
    }

    public int size() { return _size; }

    public boolean add( T x ) 
    {
	

	if (_size == 0){
	    _head=new DLLNode(x,null, null);
	    _size++;
	    return true;
	}
	else if (_size==1){
	    DLLNode<T> newNode=new DLLNode(x, _head, _head);	    
	    _head.setNext(newNode);
	    _head.setPrev(newNode);
	    _size++;
	    return true;
	}
	else{
	    DLLNode<T> newNode=new DLLNode(x, _head, _head.getNext());	    
	    _head.getNext().setPrev(newNode);
	    _head.setNext(newNode);
	    _size++;
	    return true;
	}
    }


    public T get( int index ) 
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	T retVal;
	DLLNode<T> tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }


    public T set( int index, T newVal ) 
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode<T> tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	T oldVal = tmp.getCargo();
	
	//modify target node's cargo
	tmp.setCargo( newVal );
	
	return oldVal;
    }


    public String toString() 
    {
	String retStr = "HEAD->";
	DLLNode<T> tmp = _head; //init tr
	int counter =0;
	while( counter<_size) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	    counter++;
	}
	retStr += "NULL";
	return retStr;
    }


    public static void main( String[] args ) {

	CLList<String> liz = new CLList<String>();

	liz.add("kenneth");
	liz.add("jack");
	liz.add("tracy");

	System.out.println(liz);
	
	System.out.println("\ntesting get()...");
	for( int i = 0; i < liz._size; i++ ) {
	    System.out.println("node " + i + " contains " + liz.get(i) );
	    System.out.println(liz);
	}
	
	
	System.out.println("\ntesting set()...");
	for( int i = 0; i < liz._size; i++ ) {
	    System.out.println( liz.set( i, "rock"+i ) );
	    System.out.println(liz);
	}
	

    }//end main

}//end class CLList
