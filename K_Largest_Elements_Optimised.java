import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * The idea here is to use a min priority queue of size k.
 * 
 *  -> First insert the k elements from the array in the priority queue
 *  -> Now, start traversing the other n-k elements
 *     if the element if greater than the peek element (minimum element at the top in the priority queue)
 *     then pop out( delete the minimum element) and insert the element currently being traversed on.
 *  
 *  After we are finished with traversing all the elements, we can will have k largest elements in our min 
 *  priority queue. And the kth largest element will be on the top of the priority queue.
 */

public class K_Largest_Elements_Optimised 
{

	public static int[] find_k_largest(int arr[],int k,int n)
	{
		int k_largest[]=new int[k];
		PriorityQueue<Integer> min_pq=new PriorityQueue<Integer>(k);
		for(int i=0;i<k;i++)
			min_pq.add(arr[i]);    //lg k
		for(int i=k;i<n;i++)
		{
			if(min_pq.peek()<arr[i])
			{
				//delete the min element
				min_pq.poll();      //lg k
				//add the current element
				min_pq.add(arr[i]);     //lg k
			}
		}
		/*
		 * If we want to return the kth largest element then we can return min_pq.peek() for min_pq.poll()
		 * 
		 * Among k largest elements, kth largest element will be the smallest one and will be stored at the 
		 * top of the min priority  queue.
		 */
		//k largest elements getting stored in decreasing order
		for(int i=k-1;i>=0;i--)
			k_largest[i]=min_pq.poll();
		return k_largest;
	}
	/*
	 * Time complexity is O(n lg k) roughly.
	 */
	public static void main(String[] args) 
	{
	    Scanner input=new Scanner(System.in);
	    System.out.println("Enter the number of elements:");
	    int n=input.nextInt();
	    
	    int arr[]=new int[n];
	    System.out.println("Enter the element in the array:");
	    for(int i=0;i<n;i++)
	    	arr[i]=input.nextInt();
	    System.out.println("Enter the value of k:");
	    int k=input.nextInt();
	    int k_largest[]=find_k_largest(arr,k,n);
	    System.out.println(k+" largest elements of the array are:");
	    for(int i=0;i<k;i++)
	    	System.out.print(k_largest[i]+" ");
	    System.out.println();

	}
	/*
	 * If we want k smallests element we can use a max priority queue.
	 * 
	 * We will update if any element lesser than the maximum element is there.
	 * At the end we will have k smallest element in the priority queue 
	 * with k_th largest element at the top of the priority queue
	 */
	

}
