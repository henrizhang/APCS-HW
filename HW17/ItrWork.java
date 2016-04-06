/* Henry Zhang
 ;APCS2 pd9
 ;HW #17: Iteratorator
 ;2016-03-22
 */


/*****************************************************
 * class ItrWork -- skeleton
 * Allows for familiarization with iterators
 *****************************************************/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork {

    //using FOREACH loop
    //returns a boolean to indicate whether key is present in L
    public static boolean foundA( Integer key, List<Integer> L ) { 
	/*** YOUR IMPLEMENTATION HERE ***/
	for (Integer i: L){
	    if (key.equals(i)){
		return true;
	    }
	}
	return false;
    }

    //explicitly using an iterator
    //returns a boolean to indicate whether key is present in L
    public static boolean foundB( Integer key, List<Integer> L ) { 
	/*** YOUR IMPLEMENTATION HERE ***/
	Iterator itr=L.iterator();
	while (itr.hasNext()){
	    if (itr.next().equals(key)){
		return true;
	    }
	}
	return false;
	    
    }

    //using FOREACH loop
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsA( List<Integer> L ) { 
	/*** YOUR IMPLEMENTATION HERE ***/
	List<Integer> newList=new ArrayList();
	for (Integer i: L){
	    if(i%2==1){
		newList.add(i);
	    }
	}
	return newList;
    }

    //explicitly using an iterator
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsB( List<Integer> L ) { 
	/*** YOUR IMPLEMENTATION HERE ***/
	List<Integer> newList=new ArrayList();
	Iterator itr=L.iterator();
	while (itr.hasNext()){
	    Integer i=(Integer)itr.next();
	    if (i%2==1){
		newList.add(i);
	    }
	}
	return newList;
    }


    //explicitly using an iterator
    //modifies L s.t. it contains no evens
    public static void removeEvens( List<Integer> L ) { 
	/*** YOUR IMPLEMENTATION HERE ***/
	Iterator itr=L.iterator();
	while (itr.hasNext()){
	    if ((((int)(itr.next()))%2)==0){
	    
		itr.remove();
	    }
	}
	
    }


    public static void main( String [] args ) {

	//var type: List   obj type: ArrayList	
	List<Integer> L = new ArrayList<Integer>();

	for( int i = 0; i < 10; i++ )
	    L.add(i);


        
	// a) using a FOREACH loop
	// b) explicitly using an iterator
	System.out.println("\nTesting foundA...");
	System.out.println("9 in L? -> " + foundA(9,L) );
	System.out.println("13 in L? -> " + foundA(13,L) );
	System.out.println("\nTesting foundB...");
	System.out.println("9 in L? -> " + foundB(9,L) );
	System.out.println("13 in L? -> " + foundB(13,L) );
	System.out.println("\nTesting oddsA...");
	List<Integer> A = oddsA(L);
	for( int n : A ) System.out.println(n);
	System.out.println("\nTesting oddsB...");
	List<Integer> B = oddsB(L);
	for( int n : B ) System.out.println(n);
	System.out.println("\nTesting removeEvens...");
	removeEvens(L);
	for( int n : L ) System.out.println(n);


    }//end main

}//end class ItrWork
