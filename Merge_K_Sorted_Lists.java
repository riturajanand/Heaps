/*
 * Here we have k sorted linked list and we need to merge them to form a new sorted liked list
 */

import java.util.PriorityQueue;
class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
/*
 * We need to compare the data of the nodes as we will be using a PrioritQueue, and the 
 * site at which I was coding didn't had a nodd which will help us to compare so I rougly made 
 * comprable interface for comparing node.
 */
class NNode implements Comparable<NNode>
{
    Node n;
    
    NNode(Node n)
    {
        this.n=n;
    }
    
    public  int compareTo(NNode node)
    {
        return this.n.data-node.n.data;
    }
}
public class Merge_K_Sorted_Lists 
{
	Node mergeKList(Node[]arr,int k)
    {
        Node ans=new Node(1);
        Node head=ans;
        PriorityQueue<NNode> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++)
            pq.add(new NNode(arr[i]));
        while(pq.isEmpty()==false)
        {
            NNode min=pq.remove();
            if(min.n.next!=null)
                 pq.add(new NNode(min.n.next));
            ans.next=min.n;
            ans=ans.next;
        }
        ans.next=null;
        head=head.next;
        return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
