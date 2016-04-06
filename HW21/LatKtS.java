/* Henry Zhang
 ;APCS2 pd9
 ;HW #21: Stack: What is It Good For?    
 ;2016-03-30
 */


/*****************************************************
 * skeleton for class LatKtS (LatKeysToSuccess)
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS 
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) {
	Latkes stacksson=new Latkes(10);
	String flipped="";
	for (int i = 0; i < s.length(); i++){
	    String c = String.valueOf(s.charAt(i));
	    stacksson.push(c);
	    //Process char
	}
	for (int o=0; o < s.length(); o++){
	    flipped+=stacksson.pop();
	}
	return flipped;
		
	
	
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/

    public static String findOpener(String s){
	if (s=="}"){return "{";}
	if (s=="]"){return "[";}
	if (s==")"){ return "(";}
	else{return "";}
    }
	    

    public static boolean allMatched( String s ) 
    {
	Latkes stacksson=new Latkes(s.length());
	
	for (int i = 0; i < s.length(); i++){
	    String c = s.substring(i,i+1);
	    if(c.equals("{")||c.equals("(")||c.equals("[")){
		stacksson.push(c);
	    }
	    else if (c.equals("}")||c.equals(")")||c.equals("]")){
		if (stacksson.isEmpty()||stacksson.pop().equals(findOpener(c))){
		    return false;
		}
	    }
	}
	
        if (stacksson.isEmpty()){
	    return true;
	}
        return false;
	
	
    }//end allMatched()


    //main method to test
    public static void main( String[] args ) { 

	
	System.out.println(flip("stressed"));
        System.out.println(allMatched( "({}[()])" )); //true
        System.out.println(allMatched( "([)]" ) ); //false
        System.out.println(allMatched( "(){([])}" ) ); //true
        System.out.println(allMatched( "](){([])}" ) ); //false
        System.out.println(allMatched( "(){([])}(" ) ); //false
        System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true

    }

}//end class LatKtS
