import java.util.Scanner;
public class K_Largest_Elements 
{

	/*
	 * Time complexity of this approach can be analyzed as:
	 * 
	 * O(n) - build heap
	 * O(k lg n) to extract the k largest elements at the end 
	 * 
	 * So time complexity is written as: O(k lg n)
	 */
	public static void heapify_max(int arr[],int index,int size)
	{
		if(index>size/2)
			return;
		int largest=index;
		int left=2*index+1;
		int right=left+1;
		if(left<size && arr[left]>arr[largest])
			largest=left;
		if(right<size && arr[right]>arr[largest])
			largest=right;
		
		if(largest!=index)
		{
			swap(arr,index,largest);
			heapify_max(arr,largest,size);
		}
	}
	
	public static void build_heap(int arr[],int size)
	{
		for(int i=size/2;i>=0;i--)
			heapify_max(arr,i,size);
		
	}
	
	public static void swap(int arr[],int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static int[] find_k_largest(int arr[],int n,int k)
	{
		//building a max heap
		build_heap(arr,n);
		int size=n;
		int k_copy=k;
		
		//extracting k of its largest elements at the end of the array
		while(k!=0)
		{
			swap(arr,0,size-1);
			size--;
			k--;
			heapify_max(arr,0,size);
		}
		/*
		 * If we need to return kth largest element return the kth element from the end now
		 */
		int k_largest[]=new int[k_copy];
		int index=n-1;
		for(int i=0;i<k_copy;i++)
			k_largest[i]=arr[index--];
		return k_largest;
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
		
		System.out.println("Enter the valueof k:");
		int k=input.nextInt();
		
		int k_largest[]=find_k_largest(arr,n,k);
		for(int i=0;i<k;i++)
			System.out.print(k_largest[i]+" ");

	}
	/*
	 * If we want to have k smallest elements we can use min heap and accumulate the k smallest elements at the 
	 * end of the array.
	 */

}
