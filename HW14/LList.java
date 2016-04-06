/*****************************************************
 * Wish for Success - Elias Milborn, Henry Zhang
 * APCS2 pd09
 * HW #14b: On the DLL
 * 2016--03-17
 *  
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 * new in v2: add-at-index, remove
 *****************************************************/

public class LList implements List { //your List interface must be in same dir

    //instance vars
    private DLLNode _head;
    private DLLNode _tail;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) {
	_tail = null;
	_head = null; //at birth, a list has no elements
	_size = 0;
    }


    //--------------v  List interface methods  v--------------
    public boolean add( String newVal ) { 
	DLLNode tmp = new DLLNode( newVal, null, _head );
	if (_size > 0)//if size is 0 then _head is null and has no setPrev()
	    _head.setPrev(tmp);
	if (_size == 0)//if size is 0 then _tail and _head are the same
	    _tail = tmp;
	_head = tmp;
	_size++;
	return true;
    } 

    public boolean addEnd( String newVal ) { 

	DLLNode tmp = new DLLNode( newVal, _tail, null );

	if (_size > 0)//if size is 0 then _tail is null and has no setPrev()
	    _tail.setNext(tmp);

	if (_size == 0)//if size is 0 then _tail and _head are the same
	    _head = tmp;

	_tail = tmp;
	_size++;
	return true;
    } 


    public String get( int index ) { 

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	
	DLLNode tmp;

	if (index >= _size / 2){
	    tmp = _tail;
	    
	    for(int i = _size - 1; i > index; i--)
		tmp = tmp.getPrev();
	    
	}
	else {
	    tmp = _head; //create alias to head

	    //walk to desired node
	    for( int i=0; i < index; i++ )
		tmp = tmp.getNext();
	}

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
	
    } 


    public String set( int index, String newVal ) { 

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode tmp;
	
	String oldVal;

	if ( index < _size / 2){
	    tmp = _head; //create alias to head

	    //walk to desired node
	    for( int i=0; i < index; i++ )
		tmp = tmp.getNext();
	
	    
	    //store target node's cargo
	    oldVal = tmp.getCargo();
	
	    //modify target node's cargo
	    tmp.setCargo( newVal );
	}
	
	else {
	    tmp = _tail; //create alias to head
	    
	    //walk to desired node
	    for( int i = _size - 1; i > index; i-- )
		tmp = tmp.getPrev();
	    
	    
	    //store target node's cargo
	    oldVal = tmp.getCargo();
	    
	    //modify target node's cargo
	    tmp.setCargo( newVal );
	}
	    
	return oldVal;
    } 


    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------


    //insert a node containing newVal at position index
    public void add( int index, String newVal ) {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode newNode = new DLLNode( newVal, null, null );

	//if index==0, insert node before head node
	if ( index == 0 ) {
	    add( newVal );
	    return;}
	
	if (index == _size - 1){
	    addEnd(newVal);
	    return;}

	DLLNode tmp;

	if (index>_size/2){
	    tmp=_tail;
	    for(int i=_size-1; i>index; i--){
		tmp=tmp.getPrev();
	    }
	    newNode.setPrev(tmp);
	    newNode.setNext(tmp.getNext());
	}	    

	else {
	    tmp=_head;
	    for(int i=0; i<index; i++){
		tmp=tmp.getNext();
	    }
	    newNode.setNext(tmp);
	    newNode.setPrev(tmp.getPrev());
	}

	tmp.getPrev().setNext(newNode);

	tmp.setPrev(newNode);
	_size++;
	
    }


    //remove node at pos index, return its cargo
    public String remove( int index ) {
        

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal="";
	//create alias to head

	//if index==0, remove head node
	if ( index == 0 ) {
	    //check target node's cargo hold
	    retVal = _head.getCargo();

	    //remove target node
	    _head = _head.getNext();	    
	}
	else if (index == _size-1){
	    //check target node's cargo hold
	    retVal = _tail.getCargo();
	    
	    //remove target node's cargo
	    _tail = _tail.getPrev();
	    
	}
	else if(index >= _size/2) {
	    
	    //walk to node before desired node
	    DLLNode tmp=_tail;
	    for(int i=_size-1; i>index; i--){
		tmp=tmp.getPrev();
	    }
	    

	    //check target node's cargo hold
	    retVal = tmp.getCargo();
	    tmp.getPrev().setNext(tmp.getNext());
	    tmp.getNext().setPrev(tmp.getPrev());
	  
	  


	}
	else{
	    DLLNode tmp=_head;
	    for(int i=0; i<index; i++){
		tmp=tmp.getNext();
	    }
	    retVal = tmp.getCargo();
	    tmp.getPrev().setNext(tmp.getNext());
	    tmp.getNext().setPrev(tmp.getPrev());
	 

	}

	//decrement size attribute
	_size--;

	return retVal;
    }


    // override inherited toString
    public String toString() { 
	String retStr = "NULL<-";
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "<->";
	    tmp = tmp.getNext();
	}
	retStr = retStr.substring(0, retStr.length()-3);
	retStr += "->NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ) {

	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
	System.out.println( james );

	james.add(1,"whut");
	System.out.println( "...after add(1,whut): " );
	System.out.println( james );

	james.add(4,"phat");
	System.out.println( "...after add(4,phat): " );
	System.out.println( james );

	System.out.println( "...after remove last: " 
			    + james.remove( james._size-1) );
	System.out.println( james );

	System.out.println( "...after remove(3): " + james.remove(3) );
	System.out.println( james );

	System.out.println( "...after add(3): three" );
	james.add(3, "three");
	System.out.println( james );

	System.out.println( "...after add(4): four" );
	james.add(4, "four");
	System.out.println( james );

	System.out.println( "...after remove(4): " + james.remove(4) );
	System.out.println( james );

    }//end main

}//end class LList
