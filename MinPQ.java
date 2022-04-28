
/*
 * The <Key extends Comparable<Key>> helps us facilitate us to create priority queues of any type 
 * may it be Integer, Long, Double, or float
 * 
 * And for user defined types you have to implement comparable for it then we can create a 
 * Min priority queue at of that type.
 */

public class MinPQ<Key extends Comparable<Key>>
{
	public Key[] pq;
	public int size;
	public int capacity;
	/*
	 * Capacity here represents the maximum number of elements out priority queue can hold.
	 */
	/*
	 * Here we are creating an array of size n+1 because we will be start the array from index 1 not 0
	 * 
	 * Reason for this has been explained in the README.md file
	 */
	MinPQ(int capacity)
	{
		
		
		pq=(Key[]) new Comparable[capacity+1];
		size=0;
		this.capacity=capacity;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	
	/*
	 * The algorithm to insert an element in an heap/ priority queue is that 
	 * 
	 *  -> Place the element at the end of the heap i.e left most position empty in the CBT.
	 *  -> All the other element except the last element will follow the min heap property.
	 *  -> So in order to make sure that the new element is at a position where it follows the min heap property
	 *     call moveUp() function on the index at which the new element was being inserted.
	 */
	
	public void insert(Key x)
	{
		if(size==capacity)
		{
			System.out.println("Priority queue is full!!");
			return;
		}
		//Pre-increment of variable size required because we need to follow 1 based indexing
		pq[++size]=x;
		moveUp(size);
	}
	/*
	 * This method moves an element to its right place by comparing it with parent element
	 * 
	 * 
	 * While the parent (element at index/2) is greater than the child element at index keep moving it up 
	 * and stop when it follows the min-heap property. 
	 */
	public void moveUp(int index)
	{
		
		while(index > 1 &&  pq[index/2].compareTo(pq[index])>0)
		{
		     swap(index,index/2);
		     index=index/2;
		}
	}
	
	/*
	 * The algorithm to delete from an min heap / min priority queue is :
	 * 
	 * -> Place the element at the end at index 1 i.e the starting of the heap.
	 * -> Decrease the heap size by 1.
	 * -> Now all the other elements except the element at index 1 will follow the min heap property
	 * -> So in order to ensure that the element at index 1 follows the min heap property 
	 *   run movedown(1).
	 */
	public Key delMin()
	{
		if(size==0)
		{
			System.out.println("The heap is already empty.");
			return null;
		}
		Key deleted_element=pq[1];
		pq[1]=pq[size--];
		moveDown(1);
		return deleted_element;
	}
	/*
	 * This method moves the element downwards if it doesn't follows the min - heap property
	 * 
	 * If the element if greater than it child then swap it with the smallest child.
	 */
	public void moveDown(int index)
	{
		//till we reach the leaf node or the last node
		while(index * 2<=size)
		{
			//left child
			int ind=2*index;
			//comparing left and right child(if exist) and making ind point to the least
			if(ind<size && pq[ind].compareTo(pq[ind+1])>0)
				ind++;
			
			//if the value at index(parent) is already less than it's children
			//i.e already follows the min heap property then break because the element is at it right position now
			if(pq[index].compareTo(pq[ind])<0)
				break;
			
			//else swap the parent with the least children and check whether we can go further down or not 
			swap(index,ind);
			index=ind;
			
		}
		
	}
	
	public void swap(int i,int j)
	{
		Key temp=pq[i];
		pq[i]=pq[j];
		pq[j]=temp;
	}
}