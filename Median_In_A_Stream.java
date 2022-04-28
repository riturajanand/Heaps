import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;
/*
 * Median is calculated on sorted data 
 * And is the average of two middle data (if the number of elements is even) and 
 * the middle element if the number of elements is odd.
 * 
 * If we look closely, we do not need to sort the complete data. 
 * IF we are given a data set and we divide that into two parts left and right such that
 * every data on the right part is greater than the data set on the left part.
 * 
 * So in order to find median we will need the largest element from the keft part and the 
 * smallest element from the right part.
 * 
 * So in order to easily access the largest element from the left part we can use the max heap
 * and to get the smallest element from the right part we can use a min heap.
 */
public class Median_In_A_Stream 
{

	static PriorityQueue<Integer> max_pq;
	static PriorityQueue<Integer> min_pq;
	
	/*
	 * Here the we have the following objective:
	 *  1. If the max heap is empty i.e no data in the left part then insert the current element
	 *     in the left part i.e max priority queue
	 *  
	 *  2. If the current data is greater than the top element of the max heap (left part)
	 *     then it must go to the right part.
	 *  
	 *  3. And if it is lesser than that, then it will go to the left part.
	 */
	
	public static void insertHeap(int x)
	{
		if(max_pq.isEmpty()||max_pq.peek()>=x)
			max_pq.add(x);
		else
			min_pq.add(x);
		balanceHeaps();
	}
	/*
	 * After we have appended data to the suitable left or right part, we need to balance the 
	 * heaps in such a way that:
	 * 1. If the total number of elements is even both the parts (max heap and min heap) should 
	 * contain equal number of elements.
	 * 
	 * 2. If the total number of elements in odd, then left part(max heap) should have one element 
	 *    more than the right part (min heap)
	 *    
	 * The above two objectives should be fuilfilled by keeping the partioning rule for this scenario
	 * in mind   all the elements in the left part should be less that the elements in the right part
	 * 
	 * And whenever there is an imbalance we need to balance the heaps.
	 * 
	 * If the size of right part(min heap) is greater than the left part(max heap) then 
	 * we will pop the min element from the right part (top element of min heap) to the left 
	 * part (max heap) this way we will stick to partition rule as the min element of the right
	 * part will have all the elements smaller than it in the left part leaving behind all the 
	 * elements greater than it in the right part.
	 * 
	 * If the size of max heap is greater than by more than 1 then we need to send the maximum
	 * element from the left part (max heap) to the right part (min heap) this way we will
	 * stick to the partition rule as the max element from the max heap (left part) will leave all the 
	 * elements lesser than  it and will join the right part where all the elements are greater
	 * from it.
	 */
	public static void balanceHeaps()
	{
		int sz1=max_pq.size();
		int sz2=min_pq.size();
		if(sz1==sz2)
			return;
		if(sz1>sz2+1)
			min_pq.add(max_pq.poll());
		else if(sz1<sz2)
			max_pq.add(min_pq.poll());
	}
	/*
	 * If the sizes of the two heaps are same this implies that the number of elements are 
	 * even, then median is the average of the two middle terms i.e
	 * the largest element from the left part (max heap) and the smallest element from the 
	 * right half (min heap) as the elements are partitioned equally between the min and max heaps.
	 * 
	 * If the size of the heaps are not equal then the size of the left heap will be one greater
	 * than that of left heap (as we have maintained using balanced heaps method) number of
	 * elements is odd and the median is the middle element i.e the largest element from the 
	 * max heap.
	 */
	public static double getMedian()
	{
		int sz1=min_pq.size();
		int sz2=max_pq.size();
		if(sz1==sz2)
			return (min_pq.peek()+max_pq.peek())/2.0;
		else return max_pq.peek();
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the number of elements in the array:");
		int n=input.nextInt();
		
		int arr[]=new int[n];
		System.out.println("Enter the data in the array:");
		for(int i=0;i<n;i++)
			arr[i]=input.nextInt();
		min_pq=new PriorityQueue<Integer>();
		max_pq=new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0;i<n;i++)
		{
			insertHeap(arr[i]);
			System.out.println(getMedian());
		}

	}

}
