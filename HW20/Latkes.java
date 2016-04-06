/* Henry Zhang
 ;APCS2 pd9
 ;HW #20: Stacks on Stacks on Stacks on Stacks… …  (Do I Smell Recursion?)
 ;2016-03-29
 */
/*****************************************************
 * skeleton for class Latkes
 * Implements a stack of Strings using an array as underlying container.
 *****************************************************/
//Note for 3-30-16... try recursive implementation

public class Latkes {

    private String [] _stack;
    private int _stackSize;

    //constructor
    public Latkes( int size ) 
    {
	_stack=new String[size];
	_stackSize=0;

    }

    //means of insertion
    public void push( String s ) 
    {
	if (isEmpty()){
	    _stack[0]=s;
	    _stackSize++;
	    return;
	}
	int counter=_stackSize-1;
	while ((counter >=0)&&(!isFull())){
	    _stack[counter+1]=_stack[counter];                    
	    counter--;
	}
	if (!isFull()){
	    
	_stack[0]=s;
	_stackSize++;
	}
    }

    //means of removal
    public String pop( ) 
    {
	
	int counter=1;
	String retStr=_stack[0];
	while ((counter<_stackSize)&&(!isFull())){
	    _stack[counter-1]=_stack[counter];
	    counter++;
	}
	_stackSize--;
	return retStr;
    }

    //chk for emptiness
    public boolean isEmpty() 
    {
	return _stackSize==0;
    }

    //chk for fullness
    public boolean isFull() 
    {
	return _stackSize==_stack.length;
    }

    public void test(){
	for (String x:_stack){
	    System.out.println(x);
	}
    }


    //main method for testing
    public static void main( String[] args ) {
	

	Latkes tastyStack = new Latkes(10);
	tastyStack.push("aoo");
	tastyStack.push("boo");
	tastyStack.push("coo");
	tastyStack.push("doo");
	tastyStack.push("eoo");
	tastyStack.push("foo");
	tastyStack.push("goo");
	tastyStack.push("hoo");
	tastyStack.push("ioo");
	tastyStack.push("joo");
	tastyStack.push("coocoo");
	tastyStack.push("cachoo");
        tastyStack.test();
	/*
	//cachoo
	System.out.println( tastyStack.pop() );
	//coocoo
	System.out.println( tastyStack.pop() );
	//joo
	System.out.println( tastyStack.pop() );
	//ioo
	System.out.println( tastyStack.pop() );
	//hoo
	System.out.println( tastyStack.pop() );
	//goo
	System.out.println( tastyStack.pop() );
	//foo
	System.out.println( tastyStack.pop() );
	//eoo
	System.out.println( tastyStack.pop() );
	//doo
	System.out.println( tastyStack.pop() );
	//coo
	System.out.println( tastyStack.pop() );
	//boo
	System.out.println( tastyStack.pop() );
	//aoo
	System.out.println( tastyStack.pop() );
	//stack empty by now; SOP(null)
	System.out.println( tastyStack.pop() );
        
	*/
    }//end main()

}//end class Latkes
