/* Team Stacked Cacs: Henry Zhang, Sean Bourke
 ;APCS2 pd9
 ;HW #24: Schemin
 ;2016-04-02
 */
/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
      1. Steal underpants.
      2. add specific cases for numbers or brackets. 
3. recursively address interior "( )"s
4. Unload when reach an operator
6. Unload by popping off numbers and adding, subtracting or multiplying as appropriate 
7. Return total
8. Profit!
 *
 * STACK OF CHOICE: ALStack by TBM tha Prophet
 * b/c ...
    Practice with the ArrayList 
 ******************************************************/

public class Scheme {

    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String s ) 
    {
        int ret=0;
        String curr="";
        ALStack a=new ALStack();
        a.push(s.substring(s.length()-1));
        for(int x=s.length()-3;x>0;x-=2){
            if(s.substring(x,x+1).equals(")")){
                int y=1;
                while(!(s.substring(x,x+1).equals("("))){
                    y++;
                    x--;
                }
                a.push(evaluate(s.substring(x,x+y)));
            }
            else if(isNumber(s.substring(x,x+1))){
		if(isNumber(s.substring(x-1,x))){
		    a.push(s.substring(x-1,x+1));
		    x--;
		}
		else{
		    a.push(s.substring(x,x+1));
		}
            }
            else if(s.substring(x,x+1).equals("+")){
                ret+=Integer.parseInt(unload(1,a));
            }
            else if(s.substring(x,x+1).equals("-")){
                ret+=Integer.parseInt(unload(2,a));
            }
            else if(s.substring(x,x+1).equals("*")){
                ret+=Integer.parseInt(unload(3,a));
            }
        }
        return ret+"";
    }//end evaluate()


    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, ALStack<String> numbers ) 
    {
	numbers=(ALStack)numbers;
        int ret=Integer.parseInt(numbers.pop());
	while(!numbers.isEmpty()){
	    if(numbers.peek().equals(")")){
		return ret+"";
            }
            else if(op==1){
                ret+=Integer.parseInt(numbers.pop());
	    }
	    else if(op==2){
                ret-=Integer.parseInt(numbers.pop());
	    }
	    else if(op==3){
                ret*=Integer.parseInt(numbers.pop());
            }
        }
	return ret+"";
    }//end unload()


    
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
        try {
	    Integer.parseInt(s);
	    return true;
	}
        catch( NumberFormatException e ) {
	    return false;
	}
    }


    //main method for testing
    public static void main( String[] args ) {

	
	String zoo1 = "( + 4 3 )";
	System.out.println(zoo1);
	System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	//...7
	String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	System.out.println(zoo2);
	System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	//...17
	String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	System.out.println(zoo3);
	System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	//...29
	String zoo4 = "( - 1 2 3 )";
	System.out.println(zoo4);
	System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	//...-4
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }//main

}//end class Scheme
