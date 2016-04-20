/* Henry Zhang
 ;APCS2 pd9
 ;HW #34: An Optimized Version of This is Java’s Built-in Sort Mechanism  (RIP Yams)
 ;2016-04-20
 */
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): 
 *     Partition the array from the middle, and save the pivot index. Since we
know the pivot index is in its final position, recursively call the method with 2 other indexes together determining the two parts the pivot point divides the array into.
 * 2a. Worst pivot choice and associated runtime: 
 *     A pivot point at the end of the a sorted array, results in O(n squared)
 * 2b. Best pivot choice and associated runtime:
 *     A pivot point at the middle of a sorted array, O(logn)
 * 3. Approach to handling duplicate values in array:
 *     Move Duplicates to either side of pivot point
 *****************************************************/

public class QuickSort {

    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }
    
    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }
    
    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------

    public static int partition(int[] arr, int lo, int hi){
	int pvtPos=(lo+hi)/2;
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
    
    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void quickSort( int[] d,int lo, int hi ) { 
	if ((hi-lo)<=1){
	    return;
	}
	else{
	    int pivPos=partition(d,lo,hi);
	    quickSort(d,lo,pivPos);//not pivPos-1 or the first and second can be mis-swapped
	    quickSort(d,pivPos+1,hi);
	  
	}
    }
    public static void qsort( int[] d ) { 
        quickSort(d,0,d.length-1);
    }

    //you may need a helper method...


    //main method for testing
    public static void main( String[] args ) {

        
	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println(partition(arr1,0,arr1.length-1));
	
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);
	qsort( arr1);	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);
	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);
       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);
	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);
	


 
	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);
	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);
	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);
       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);
	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);


    }//end main

}//end class QuickSort
