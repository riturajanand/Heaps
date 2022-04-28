/*
 * We are given with k sorted lists/array. We need find the shortest possible range such that 
 * we atleast one element from each subarray is included.
 */
/*
 * We will use a min heap, and we will insert the first elements from each of the arrays i.e we will
 * have min-elements from such there one element from each element is there.
 * Now, a possible range with the given range will be [min in the heap - to max in the heap].
 * 
 * Now we need to minimse the size of the range as we need the shortest range.
 * 
 * So delete the min element from the heap, and next element from the array to which the min element
 * which has been removed from the heap. 
 * Again find the min and max in the array if it is shorter than the the range we already have, 
 * the we will update our range. 
 * 
 * The above steps will continue till we exhaust an row (an array) because we need to find a range 
 * such that it has atleast 1 element from each of the given arrays.
 */
import java.util.Scanner;
/*
class Triad implements Comparable<Triad>
{
	int ele;
	int row;
	int col;
	
	Triad(int ele,int row,int col)
	{
		this.ele=ele;
		this.row=row;
		this.col=col;
	}

	public int compareTo(Triad o) 
	{
	    
		return this.ele-o.ele;
	}
	
}*/
public class Smallest_Range_In_K_Lists 
{

	public static int get_max(Triad heap[],int k)
	{
		int max=Integer.MIN_VALUE;
		for(int i=0;i<k;i++)
		{
			if(heap[i].ele>max)
				max=heap[i].ele;
		}
		return max;
	}
	public static void heapify(Triad heap[],int index,int k)
	{
		if(index>=k/2)
			return;
		int smallest=index;
		int left=2*index+1;
		int right=left+1;
		
		if(left<k && heap[left].compareTo(heap[smallest])<0)
			smallest=left;
		
		if(right<k && heap[right].compareTo(heap[smallest])<0)
			smallest=right;
		
		if(smallest!=index)
		{
			swap(heap,index,smallest);
			heapify(heap,smallest,k);
		}
			
	}
	public static void swap(Triad heap[],int i,int j)
	{
		Triad temp=heap[i];
		heap[i]=heap[j];;
		heap[j]=temp;
	}
	public static void build_heap(Triad heap[],int k)
	{
		for(int i=(k-1)/2;i>=0;i--)
			heapify(heap,i,k);
	}
	public static int[] find_smallest_range(int arr[][],int n,int k)
	{
		Triad heap[]=new Triad[k];
		for(int i=0;i<k;i++)
			heap[i]=new Triad(arr[i][0],i,0);
		build_heap(heap,k);
		int range[]=new int[2];
		range[0]=Integer.MIN_VALUE; range[1]=Integer.MAX_VALUE;
		int diff=Integer.MAX_VALUE;
		while(true)
		{
			int min=heap[0].ele;
			int max=get_max(heap,k);
			int d=max-min;
			if(d<diff)
			{
				range[0]=min;
				range[1]=max;
				diff=d;
			}
			int r=heap[0].row;
			int c=heap[0].col;
			if(c==n-1)
				break;
			heap[0]=new Triad(arr[r][c+1],r,c+1);
			heapify(heap,0,k);
			
		}
		return range;
		
	}
	
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the number of arrays:");
		int k=input.nextInt();
		
		System.out.println("Enter the size of the arrays:");
		int n=input.nextInt();
		
		int arr[][]=new int[k][n];
		for(int i=0;i<k;i++)
		{
			for(int j=0;j<n;j++)
				arr[i][j]=input.nextInt();
		}
		int range[]=find_smallest_range(arr,n,k);
		System.out.println("Samllest range is:[ "+range[0]+" "+range[1]+" ]");

	}

}
