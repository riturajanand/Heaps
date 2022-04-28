import java.util.Scanner;

public class K_Largest_Elements_More_Optimised 
{
	public static void min_heapify(int arr[],int index,int size)
	{
		if(index>size/2)
			return;
		int smallest=index;
		int left=2*index+1;
		int right=left+1;
		
		if(left<size && arr[left]<arr[smallest])
			smallest=left;
		if(right<size && arr[right]<arr[smallest])
			smallest=right;
		
		if(smallest!=index)
		{
			swap(arr,index,smallest);
			min_heapify(arr,smallest,size);
		}
	}
	

	public static void swap(int arr[],int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
    public static void build_min_heap(int arr[],int size) 
    {
    	for(int i=size/2;i>=0;i--)
    		min_heapify(arr,i,size);
    }
    
    public static int[] find_k_largest(int arr[],int k,int n)
    {
    	int k_largest[]=new int[k];
    	for(int i=0;i<k;i++)
    		k_largest[i]=arr[i];
    	
    	//O(k) time
    	build_min_heap(k_largest,k);
    	
    	//n lg k time
    	for(int i=k;i<n;i++)
    	{
    		if(k_largest[0]<arr[i])
    		{
    			k_largest[0]=arr[i];
    			min_heapify(k_largest,0,k);
    		}
    	}
    	
    	/*
    	 * After the completion of the above loop, k_largest[0] will have the k_th largest element at it
    	 * and the k_th largest will k largest elements among arr.
    	 * 
    	 * k_largest[0] will be the kth largest element of the array because among k largest elements, kth largest
    	 * element will be smallest and hence will be present at the top of the priority queue.
    	 */
    	
    	//now we need to arrange the elements in descending order
    	
    	//k lg k time
    	while(k>1)
    	{
    		swap(k_largest,k-1,0);
    		k--; 
    		min_heapify(k_largest,0,k);
    	}
    	
    	return k_largest;
    }
    /*
     * Though, mathematically time complexity comes out to be same, this algorithm will take less computation time 
     * as we are eliminating the step of delition of the min element while updating (which we did in the less 
     * optimised version in line 31).
     */
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the number of elements in the array:");
		int n=input.nextInt();
		
		int arr[]=new int[n];
		System.out.println("Enter the data in the array:");
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
	 * If we want k smallest elements we can use a max priority queue.
	 * 
	 * We will update if any element lesser than the maximum element is there.
	 * At the end we will have k smallest element in the priority queue 
	 * with k_th largest element at the top of the priority queue
	 */

}
