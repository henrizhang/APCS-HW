/* Henry Zhang
;APCS2 pd9
;HW #01: I Am Still Searching 
;2016-02-11
*/

public class Constrained{
    public static String searchMatrix(int[][] matrix, int target){
	int currentRow=0;
	int currentCol=matrix.length-1;
	//easiest to implement when starting at the top right since you can tell right away if it will be in that column
	boolean endLoop=false;
	while (!endLoop){
	
	    if (matrix[currentRow][currentCol]==target){
		return ""+currentRow+", "+currentCol;
	    }
	    if (matrix[currentRow][currentCol]>target){
		if (currentCol==0){
		    return "Target not found";
		    //if it has gone to the far left and is still less than the least int, it must not be in the matrix
		}
		else{
		    currentCol-=1;
		    currentRow=0;
		    continue;
		}
	    }
	    else if (matrix[currentRow][currentCol]<target){
		if (currentRow==matrix.length-1){
		    return "Target not found";
		    //if it is not in the furthest left column, it ain't there
		}
		else{
		    currentRow++;
		    continue;
		}
	    }
	}
	return "Target not found";
    }
    public static int findMissing(int[] arr){
	int correctSumArray= arr.length*((arr.length*1)/2);
	//uses formula to calculate what the sum should be for a consecutive arary of numbers based on its length
	int actualSumArray=0;
	for (int x: arr){
	    actualSumArray+=x;
	}
	//adds all ints to find the actual sum
	int correctProductArray=1;
	for (int i=1; i<arr.length; i++){
	    correctProductArray*=i;
	}
	//finds what the product would be if all numbers were consecutive
	int actualProductArray=1;
	for (int i=0; i<arr.length;i++){
	    actualProductArray*=arr[i];
	}
	//multiples all actual ints to find actual sum
	int difference=correctSumArray-actualSumArray;
	double quotient=(double)correctProductArray/actualProductArray;
	double missingNo=(difference*quotient)/(quotient-1);
	//based on a calculation i did with x-y x squared over y squared, solve for x in terms of difference and quotient
	return (int) missingNo;
    }
    public static void main(String[] args){
	int[][] squad=new int[3][3];
	squad[0][0]=1;
	squad[0][1]=3;
	squad[0][2]=5;
	squad[1][0]=1;
	squad[1][1]=7;
	squad[1][2]=8;
	squad[2][0]=5;
	squad[2][1]=12;
	squad[2][2]=15;
	System.out.println(searchMatrix(squad, 5));
	int[] array={1,2,2,4,5};
	System.out.println(findMissing(array));
	
    }
    
	    
}
	
	
	    
				   
