import java.util.Scanner;
import java.util.PriorityQueue;
/*
 * We are given ropes of different lengths, and we need to connect them or tie them together.
 * Cost of connecting two ropes is equla to the sum of their lengths.
 * We need to connect them minimising the total cost.
 * 
 * The idea is to connect two ropes of minimum costs which forms a single rope of larger length
 * and then insert that into collection of ropes again select two ropes of min lengths and do
 * this until it becomes a single rope.
 * 
 * We can use min heap to implement the above algorithmic idea.
 */
public class Minimum_Cost_Of_Ropes 
{
	
	public static long min_cost(long arr[],int n)
	{
		PriorityQueue<Long> m_pq=new PriorityQueue<>();
		for(int i=0;i<n;i++)
			m_pq.add(arr[i]);
		long cost=0;
		while(m_pq.size()>1)
		{
			long len1=m_pq.remove();
			long len2=m_pq.remove();
			long sum=len1+len2;
			cost+=sum;
			m_pq.add(sum);
		}
		return cost;
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the number of ropes:");
		int n=input.nextInt();
		
		long arr[]=new long[n];
		System.out.println("Enter the lengths of the ropes:");
		for(int i=0;i<n;i++)
			arr[i]=input.nextLong();
	    System.out.println("Minimum cost of connecting all ropes is:"+min_cost(arr,n));

	}

}
