/*
 * We are given k-srted arrays in the form of a k X k matrix and we need to form a final sorted array 
 * out of that. 
 */


import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Merge_K_Sorted_Arrays 
{

	public static ArrayList<Integer> merge_k_sorted_arrays(int arr[][],int k)
	{
		ArrayList<Integer> arrL=new ArrayList<Integer>();
		PriorityQueue<Triad> pq=new PriorityQueue<>();
		
		for(int i=0;i<k;i++)
			pq.add(new Triad(arr[i][0],i,0));
		while(pq.isEmpty()==false)
		{
			Triad min_ele=pq.remove();
			int data=min_ele.ele;
			int r=min_ele.row;
			int c=min_ele.col;
			if(c!=k-1)
				pq.add(new Triad(arr[r][c+1],r,c+1));
			arrL.add(data);
		}
		return arrL;
	}
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the value of k:");
		int k=input.nextInt();
		int arr[][]=new int[k][k];
		System.out.println("Enter the k arrays:");
        for(int i=0;i<k;i++)
        {
        	for(int j=0;j<k;j++)
        		arr[i][j]=input.nextInt();
        }
        ArrayList<Integer> sorted_array=merge_k_sorted_arrays(arr,k);
        for(int ele: sorted_array)
        	System.out.print(ele+" ");
        System.out.println();
	}

}
/*
 * BRUTE FORCE APPROACH:
 * 
 * Can we storing all the items in an array and then sorting it.
 * 
 * Which is same as forming a heap of size(k2) and then soriting it using heap sort type of apporach.
 */
