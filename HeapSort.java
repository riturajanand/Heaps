import java.util.Scanner;
public class HeapSort 
{
    
	/*
	 * Heapify checks whether the element is largest among its left and child children, 
	 * if not ten swap them with the larger value among the children.
	 * Once swapped there may be possibility that the index from which the larger value was fethched and
	 * smaller value was placed can violate the max heap poperty, so call heapify again for the index at 
	 * which the largest element was found
	 * 
	 *                         12
	 *                         /\
	 *                        /  \
	 *                       10   20
	 *                            /\
	 *                           /  \
	 *                          18  17
	 *                          
	 *                      After swapping 12 and 20 heap becomes 
	 *                         20
	 *                         /\
	 *                        /  \
	 *                       10   12
	 *                            /\
	 *                           /  \
	 *                          18  17
	 *                          
	 *                    So calling heapify on index 2 (formely the largest element 2 was at index 2) is neccessary.
	 */
	public static void  heapify(int arr[],int index,int size)
	{
		if(index>size/2)
			return;
		int largest=index;
		int left=index*2;
		int right=left+1;
		
		if(left<=size && arr[left]>arr[largest])
			largest=left;
		if(right<=size && arr[right]>arr[largest])
			largest=right;
		if(largest!=index)
		{
			swap(largest,index,arr);
			heapify(arr,largest,size);
		}
			
	}
	/*
	 * This function build the max heap out of the given array. 
	 * There are two very important questions which can be asked in an interview from this:
	 * 
	 *    1. Why we are runnning the loop from n/2 down to 1 why not 1 upto n/2?
	 *    2. What is the time complexity of this function
	 *        or
	 *       What is the time complexity of building a heap using heapify algorithm?
	 *       
	 *   Let us first address the second question
	 *   Though it is apprarent that heapify() takes lg n time and we are calling heapify for n/2 times
	 *   which makes the time complexity O(n lg n)
	 *   
	 *   But here comes the catch the time complexity of build heap is O(n) not O(n lg n).
	 *   Check out this link for description:
	 *         https://www.geeksforgeeks.org/time-complexity-of-building-a-heap/
	 *         
	 *         
	 *   Now coming to the first question...
	 *   
	 *   Imagine a case where all the nodes follow the max heap property other than the very last node or a node at 
	 *   the last level. 
	 *              
	 *                  10
				     /     \
				    5       3
				   /  \    /
				  4    1  50
				  
		  In the above case if we run the loop from 1 upto n the final outcome will be 
		                10
				     /     \
				    5       50
				   /  \    /
				  4    1  3
		 Which is not a max heap 
		 
		 If the max element is at the last level we will see that it goes only on level upwards but its correct 
		 position is at the first level( the root level)
	     
	     In order to build an heap from anarbitrary array, we need to move some elements upwards and some downwards 
	     (two way movement), so in order to achieve that as the heapify follows downward movement, so there must be 
	     an upward movement also which is facilitated by the loop which helps us move upwards. 
		  
	*/
	
	public static void build_heap(int arr[],int size)
	{
		//here n/2+1 to n will be the leaf nodes in the heap so we do not need to call heapify on those elements/nodes
		//as they will be heap in themselves i.e a single node heap follows the max heap property.
		for(int i=size/2;i>=1;i--)
			heapify(arr,i,size);
			
	}
	
	public static void swap(int i,int j, int arr[])
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	/*
     * -> Construct a max heap. 
     *    After we have constructed the max heap the element at index 1 will be the maximum element.
     *    
     * -> Now swap the element at index 1 and element at index heap size( last element of the heap)
     * -> decrease the heap size by 1. 
     * -> Now all the elements other than the element at index 1 follow the max heap property.
     *    So in order to make the element at index 1 follow the max heap property move it down until 
     *    it reaches a place where it follows the max heap property.
     *     
     */
	
	public static void heap_sort(int arr[],int size)
	{
		build_heap(arr,size);
		while(size!=1)
		{
			swap(1,size,arr);
			size--;
			heapify(arr,1,size);
		}
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=input.nextInt();
		
		int arr[]=new int[n+1];
		System.out.println("Enter the data in the array:");
		for(int i=1;i<=n;i++)
			arr[i]=input.nextInt();
		heap_sort(arr,n);
		System.out.println("The sorted array is:");
		for(int i=1;i<=n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	/*
	 * Why time complexity of build_heap is O(n)?
	 * 
	 * We know that heapify is called for n/2 elements down the line and the height of the nodes for which the 
	 * heapify is called lies between 1 to lg(n)  0 is not included because we do not call the heaify for leaf nodes.
	 * 
	 * Also for a complete binary tree, the number of nodes at height h is given by 
	 *             n
	 *            ---
	 *              h+1
	 *             2
	 *             
	 *   On each call of heapify we make we just do a simple swapping which is O(1) work and 
	 *   if recursive call is made in that we will have atmost h or recusrive calls  
	 *   Explanation : if we call heapify for a node at height h, we go down atmost h steps 
	 *   
	 *   and h has a range [1 lg(n)]
	 *   
	 *   So, the time complexity of build_heap can be written as:
	 *   
	 *               sum of all possible ->number of nodes at height h * h(number of steps)
	 *               
						      lg(n)     n
						      sigma    ---    X h
						      h=1      h+1
						              2
						 
						        lg(n)   h
						  n X  sigma  -----
						         h=1     h
	 *                                  2 . 2
	 *                            
	 *   
	 */

}
