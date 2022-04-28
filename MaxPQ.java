
public class MaxPQ<Key extends Comparable<Key>> 
{
    public Key pq[];
    public int size;
    public int capacity;
    
    MaxPQ(int capacity)
    {
    	pq=(Key[]) new Comparable[capacity+1];
    	size=0;
    	this.capacity=capacity;
    }
    
    public boolean isEmpty()
    {
    	return size==0;
    }
    
    public void insert(Key x)
    {
    	if(size==capacity)
    	{
    		System.out.println("Priority queue is alreayd full!!");
    		return;
    	}
    	pq[++size]=x;
    	moveUp(size);
    }
    public void moveUp(int index)
    {
    	while(index > 1 && pq[index/2].compareTo(pq[index])<0)
    	{
    		swap(index,index/2);
    		index/=2;
    	}
    }
    
    public Key delMax()
    {
    	if(size==0)
    	{
    		System.out.println("The priority queue is already emepty");
    		return null;
    	}
    	Key deleted_element=pq[size];
    	pq[1]=pq[size--];
    	moveDown(1);
    	return deleted_element;
    }
    public void moveDown(int index)
    {
    	while(index * 2<=size)
    	{
    		int ind=index*2;
    		if(ind<size && pq[ind].compareTo(pq[ind+1])<0)
    		    ind++;
    		
    		if(pq[index].compareTo(pq[ind])>0)
    			break;
    		
    		swap(ind,index);
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
