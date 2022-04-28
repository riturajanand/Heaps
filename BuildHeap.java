import java.util.Scanner;
public class BuildHeap 
{

	public static void heapify_min(int arr[],int index,int size)
	{
		if(index>size/2)
			return;
		int smallest=index;
		int left=index*2;
		//right=index*2+1 so it can be written a left+1
		int right=left+1;
		
		if(left<=size && arr[left]<arr[smallest])
			smallest=left;
		if(right<=size && arr[right] < arr[smallest])
			smallest=right;
		if(smallest!=index)
		{
			swap(arr,index,smallest);
			heapify_min(arr,smallest,size);
		}	

	}
	
	public static void build_min_heap(int arr[],int size)
	{
		for(int i=size/2;i>=1;i--)
		  heapify_min(arr,i,size);
	}
	public static void heapify_max(int arr[],int index,int size)
	{
		//no need to check for leaf nodes
		if(index>size/2)
			return;
		int largest=index;
		int left=2*index;
		//right is 2*index+1 so can be written as left +1 
		int right=left+1;
		
		if(left<=size && arr[left]>arr[largest])
			largest=left;
		if(right<=size && arr[right]>arr[largest])
			largest=right;
		if(largest!=index)
		{
			swap(arr,largest,index);
			heapify_max(arr,largest,size);
		}
	}
	public static void build_max_heap(int arr[],int size)
	{
		for(int i=size/2;i>=1;i--)
			heapify_max(arr,i,size);
	}
	
	public static void swap(int arr[],int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the number of elements in an array:");
		int n=input.nextInt();
		
		int arr[]=new int[n+1];
		System.out.println("Enter the elements in the array:");
		for(int i=1;i<=n;i++)
			arr[i]=input.nextInt();
		System.out.println("Which heap ypu want to build?");
		System.out.println("1. Min heap");
		System.out.println("2. Max heap");
		System.out.println("Enter your choice:");
		int choice=input.nextInt();
		if(choice==1)
			build_min_heap(arr,n);
		else if(choice==2)
			build_max_heap(arr,n);
		else
		{
			System.out.println("Invalid input");
			System.exit(-1);
		}
		for(int i=1;i<=n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();

	}

}
