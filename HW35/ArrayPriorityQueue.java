/* 
 * Henry Zhang
 * Team Mozzarella
 * Shantanu Jha, Elias Milborn, Henry Zhang
 * APCS2 pd9
 * HW35--Privileged Status Gets You to the Front of the Line  
 * 2016-05-04
 */


import java.util.*;
public class ArrayPriorityQueue{
    private ArrayList data;
    
    public ArrayPriorityQueue(){
	data=new ArrayList();
    }
    
    public void add(Object x){
	int i=0;
	while ((i<data.size())&&(data.size()>0)){
	    if (((Comparable)x).compareTo(data.get(i))>=0){
		data.add(i,x);
		return;
	    }
	    i++;
	}
	data.add(x);
    }
    
    public boolean isEmpty(){
        return (data.size() == 0);
    }
    public Object peekMin(){
        return data.get(data.size()-1);
    }
    public Object removeMin(){
        return data.remove(data.size()-1);
    }
    
    public static void main(String[] args){
	ArrayPriorityQueue jedi=new ArrayPriorityQueue();
	System.out.println(jedi.isEmpty());

	/*=======================*/
	Comparable luke=new Integer(8);
	Comparable ben=new Integer(7);
	Comparable yoda=new Integer(10);
	Comparable jarjar=new Integer(0);
	jedi.add(luke);
	jedi.add(ben);
	jedi.add(yoda);
	jedi.add(jarjar);
	/*=======================*/
	for (Object i: jedi.data){
	       System.out.println(i);
	}
	System.out.println(jedi.peekMin());
	System.out.println(jedi.removeMin());
	
	
	
    }
}
