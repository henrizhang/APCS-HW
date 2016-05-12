/* Henry Zhang
 ;APCS2 pd9
 ;HW #37: Algorithm as Data Structure
 ;2016-05-11
 */


public class ArrayST{
	private int[] nodes;
	public ArrayST(){
		nodes=new int[100];
	}

	public void insert( int newVal){
		for(int x=0; x<nodes.length;x++){
			if (nodes[x]==0){
				nodes[x]=newVal;
				return;
			}
		}
	}

	public void preOrderTrav(int index){
		if (nodes[index]==0){
			return;
		}
		
		else{
			System.out.println(nodes[index]);
			preOrderTrav(index*2+1);
			preOrderTrav(index*2+2);
		}

		
	}

	public void postOrderTrav(int index){
		if (nodes[index]==0){
			return;
		}
		preOrderTrav(index*2+1);
		preOrderTrav(index*2+2);
		System.out.println(nodes[index]);
		
	}

	public void inOrderTrav(int index){
		if (nodes[index]==0){
			return;
		}
		preOrderTrav(index*2+1);
		System.out.println(nodes[index]);
		preOrderTrav(index*2+2);
		
	}

	public static void main(String[] args){
		ArrayST a = new ArrayST();
		int[] b=new int[]{9,432,12,4,3};
		for (int i:b){
			a.insert(i);
		}
		a.inOrderTrav(0);
		System.out.println("Done with inorder");
		a.postOrderTrav(0);
		System.out.println("Done with postorder");
		a.preOrderTrav(0);
		System.out.println("Done with preorder");
		
	}
	/*1. What can be gleaned from a pre-, in-, and post-order traversal, 
 without seeing the binary tree from which it came?
	
	The node and values, though the in-order traversal also reveals the
	ordered values

   2. How many trees can generate a given traversal?

   Different orders can be represented because of left/right disrepancies
	

3. What information is required (a la combinations of traversals) to 
reconstruct an unknown tree?
	
	Inorder sequence + either post or pre order sequence

*/
}