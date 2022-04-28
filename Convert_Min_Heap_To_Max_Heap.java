import java.util.Scanner;
/*
 * Here we will follow the 0 based indexing for forming the max heap, as on many competitive 
 * coding sites or contests the array is 0-base indexed.
 */

/*
 * Here we have to convert a min heap in array form to max heap in O(n) time.
 * 
 * At first we might think in various directions, but the solution is pretty simple 
 * we can convert any given array into max or min heap in O(n) time by using heapify for n/2 down to 1 using 
 * build_heap algorithms. 
 */
public class Convert_Min_Heap_To_Max_Heap 
{

	public static void heapify_max(int arr[],int index,int size)
	{
		//leaf nodes
		if(index>(size/2))
			return;
		int largest=index;
		int left=index*2+1;
        //right for 0 based indexing is 2*index +2 which can be written as left+1.
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
	
	public static void swap(int arr[],int i, int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void convert_to_max_heap(int arr[],int size) 
	{
	      for(int i=size/2;i>=0;i--)
	    	  heapify_max(arr,i,size);
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the number of elements in the min heap");
		int n=input.nextInt();
		
		int arr[]=new int[n];
		
		System.out.println("Enter the data in the min heap:");
		for(int i=0;i<n;i++)
			arr[i]=input.nextInt();
		convert_to_max_heap(arr,n);
		System.out.println("Max heap is:");
        for(int i=0;i<n;i++)
        	System.out.print(arr[i]+" ");
        System.out.println();
	}

}
