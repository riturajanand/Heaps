/*
 * We are given an array, we need to find the kth largest sum of all possible sums of 
 * contigious subarrays
 */

/*
 * It is obvious that we will use a min heap of size k and then we will insert the sum 
 * of k subarrays, then we will generate other subarrays and update only if the min element 
 * of the heap is less than the sum of that subarray.
 */
import java.util.Scanner;
import java.util.PriorityQueue;
public class K_th_Largest_Sum_Contiguous_Subarray 
{
    static int sum[];
    
    public static void update_heap(PriorityQueue<Integer> pq,int sum,int k)
    {
    	if(pq.size()<k)
    	   pq.add(sum);
    	else
    	{
    		if(pq.peek()<sum)
    		{
    			pq.poll();
    			pq.add(sum);
    		}
    	}
    }
    public static int find_kth_largest_sum(int arr[],int n,int k)
    {
    	sum=new int[n];
    	sum[0]=arr[0];
    	PriorityQueue<Integer> m_pq=new PriorityQueue<Integer>();
    	m_pq.add(arr[0]);
    	for(int i=1;i<n;i++)
    	{
           sum[i]=arr[i]+sum[i-1];
           update_heap(m_pq,arr[i],k);
    	}
    	for(int i=0;i<n;i++)
    	{
    		for(int j=i+1;j<n;j++)
    		{
    			int s=sum[j]-sum[i]+arr[i];
    			update_heap(m_pq,s,k);
    		}
    	}
    	return m_pq.remove(); 
    	
    }
	public static void main(String[] args) 
	{
	   Scanner input=new Scanner(System.in);
	   System.out.println("Enter the number of elements in the array:");
	   int n=input.nextInt();
	   
	   int arr[]=new int[n];
	   System.out.println("Enter the elements in the array:");
	   for(int i=0;i<n;i++)
		   arr[i]=input.nextInt();
	   System.out.println("Enter the value of k:");
	   int k=input.nextInt();
	   System.out.println(find_kth_largest_sum(arr,n,k));
	}

}
