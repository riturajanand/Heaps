/*
 * APPROACH 1:
 * There given two arrays which represent two max heaos separartely, we need to merge into a singl array 
 * which will represent a max heap.
 * 
 * The approach is pretty simple:
 * 
 * First copy each element from the two arrays into an array of size m+n. Then form a max heap 
 * in O(m+n) complexity.
 * 
 * The above approach is simple and can be easily implemented as in the comment below
 */

/*
 * APPROACH 2:
 * Another approach can be compare the top elements of two different heaps and insert the greater element 
 * in the result array.
 * Then delete the element inserted from the correspoding heap. 
 * 
 * And this is more optimised code
 * 
 * The time comlexity for this can be nlg n + m lg m.
 * 
 * time taken on GFG: 1.1/2.4
 */

/*
 * APPROACH 3:
 * Another approach can be as the both the arrays are already max heaps, we can copy an array into res, and then
 * insert the elements of the another array in the heap res.
 * 
 * Time complexity for this is min(n,m) log(n+m)
 * 
 * time taken of GFG: 1.4/2.4
 */
/*
 * Aproach 2 takes less time then the approach 2 because once one of the heaps gets over, 
 * then it takes liner time. May be inputs are such that it that it took less time,
 * but when it comes to worst case comlexity, APPROACH 3 IS MOST OPTIMISED.
 */


import java.util.Scanner;
public class Merge_Two_Max_Heaps 
{
	//Aproach 1:
   /*
	public static void heapify(int arr[],int index,int size)
	{
		if(index>=size/2)
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
			int temp=arr[index];
			arr[index]=arr[largest];
			arr[largest]=temp;
			heapify(arr,largest,size);
		}
		
	}
	public static void build_heap(int arr[],int size)
	{
		//in 0 based indexing the last non leaf node is size-1/2
		for(int i=(size-1)/2;i>=0;i--)
			heapify(arr,i,size);
	}
	public static int[] merge_heaps(int arr[],int brr[],int n,int m)
	{
		int res[]=new int[m+n];
		
		//Copying elements from both the arrays into a single array.
		for(int i=0;i<n;i++)
			res[i]=arr[i];
		for(int i=0;i<m;i++)
			res[i+n]=brr[i];
		
		//Now we will convert the array res into a max heap.
		build_heap(res,m+n);
		return res;
	}*/
	
	//Aproach 2:
	/*
	public static void heapify(int arr[],int index,int size)
	{
		if(index>=size/2)
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
			int temp=arr[index];
			arr[index]=arr[largest];
			arr[largest]=temp;
			heapify(arr,largest,size);
		}
		
	}
	
	public static void delete(int arr[],int size)
	{
		swap(arr,size-1,0);
		size--;
		heapify(arr,0,size);
	}
	
	public static void swap(int arr[],int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static int[] merge_heaps(int arr[],int brr[],int n,int m)
	{
		int size1=n;
		int size2=m;
		int ptr=0;
		int res[]=new int[m+n];
		while(size1>0 && size2>0)
		{
			if(arr[0]>=brr[0])
			{
				res[ptr++]=arr[0];
				delete(arr,size1);
				size1--;
			}
			else
			{
				res[ptr++]=brr[0];
				delete(brr,size2);
				size2--;
			}
		}
		
		for(int i=0;i<size1;i++)
			res[ptr++]=arr[i];
		
		for(int i=0;i<size2;i++)
			res[ptr++]=brr[i];
		
		return res;
	}*/
	
	//Aproach 3:
	public static void moveUp(int arr[],int index)
	{
		if(index==0)
			return;
		
		int parent=(index-1)/2;
		if(arr[parent]<arr[index])
		{
			swap(arr,parent,index);
			moveUp(arr,parent);
		}
	}
	public static void insert(int arr[],int ele,int size)
	{
	    arr[size]=ele;
	    moveUp(arr,size);
	}
	public static void swap(int arr[],int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void merge_another(int res[],int arr[],int n,int ptr)
	{
		//nlog n 
		for(int i=0;i<n;i++)
			insert(res,arr[i],ptr++);
	}
	public static int[] merge_heaps(int arr[],int brr[],int n,int m)
	{
		int res[]=new int[n+m];
		if(n>=m)
		{
			for(int i=0;i<n;i++)
				res[i]=arr[i];
			merge_another(res,brr,m,n);
		}
		else
		{
			for(int i=0;i<m;i++)
				res[i]=brr[i];
			merge_another(res,arr,n,m);
		}
		return res;
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the size of the first heap:");
		int n=input.nextInt();
		int arr[]=new int[n];
		
		System.out.println("Enter the elements in the first heap:");
		for(int i=0;i<n;i++)
			arr[i]=input.nextInt();
		
		System.out.println("Enter the size of the second heap:");
		int m=input.nextInt();
		
        int brr[]=new int[m];
        System.out.println("Enter the elements inthe second heap:");
        for(int i=0;i<m;i++)
        	brr[i]=input.nextInt();
        int res[]=merge_heaps(arr,brr,n,m);
        System.out.println("Merged max heap is:");
        for(int i=0;i<n+m;i++)
        	System.out.print(res[i]+" ");
        System.out.println();

	}

}
