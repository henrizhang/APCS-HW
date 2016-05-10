/* Henry Zhang
 ;APCS2 pd9
 ;HW #31: Fast Selection  (RIP Yams)
 ;2016-04-13
 */

public class FastSelect{
    
    public static void swap(int index1, int index2, int[] arr){
	int oldVal=arr[index1];
	arr[index1]=arr[index2];
	arr[index2]=oldVal;
    }
    
    public static int partition(int[] arr, int pvtPos){
	int pvtVal=arr[pvtPos];
	int savPos=0;
	swap(pvtPos, arr.length-1, arr);
	for (int i=0; i<arr.length; i++){
	    if (arr[i]<pvtVal){
		swap(savPos,i,arr);
		savPos++;
	    }
	}
	swap(arr.length-1,savPos, arr);
	return savPos;
    }
    //O(n)

    public static int FSel(int[] arr, int k, int lo, int hi){
	if (lo>hi){
	    return arr[k];
	}
	else{
	    int index=(lo+hi)/2;
	    int stored=arr[index];
	    int newIndex=partition(arr, index);
	    if (arr[k-1]==stored){
		return arr[k-1];
	    }
	    else if(arr[k-1]>stored){
		lo=newIndex+1;
		//furthers the recursive process by eliminating old midval and others to the left of it from possible indexes
	    }
	    else{
		hi=newIndex-1;
	        //furthers the recursive process by eliminating old midval and others to the right of it from possible indexes
	    }
	    return FSel(arr,k,lo,hi);
	}
    }
    //O(nlogn)

    public static void main(String[] args){
	int[] betterThings = {8,9,13,12,1};
	System.out.println(FSel(betterThings, 5, 0,4));
	System.out.println(FSel(betterThings, 4, 0,4));
	System.out.println(FSel(betterThings, 3, 0,4));
	System.out.println(FSel(betterThings, 2, 0,4));
	System.out.println(FSel(betterThings, 1, 0,4));
	
    }
}
	    
