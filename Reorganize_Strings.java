import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
class Pair implements Comparable<Pair>
{
	char ch;
	int count;
	
	Pair(char ch,int count)
	{
		this.ch=ch;
		this.count=count;
	}

	@Override
	public int compareTo(Pair p) 
	{
		return this.count-p.count;
	}
}
/*
 * Here the main idea is to first place the character with the most frequency, 
 * 
 * Supoose a character ch1 is having the highest frequency is placed at index i, then it
 * is blocked to be paced at index i+1, some other character ch2 having the highest frequency
 * among after ch2 is placed at i+1. Now ch2 is bolcked from being placed at i+2 but ch1 can be.
 * 
 *  This continues till we run sort of characters 
 *  or we reach a point where we need to place the same character at i and i+1 (no solution)
 */
public class Reorganize_Strings 
{
    public static String rearrange(String s)
    {
    	int n=s.length();
    	char count[]=new char[26];
    	for(int i=0;i<n;i++)
    		count[(int)s.charAt(i)-97]++;
    	PriorityQueue<Pair> mx_pq=new PriorityQueue<Pair>(Collections.reverseOrder());
    	for(int i=0;i<26;i++)
    	{
    		if(count[i]!=0)
    			mx_pq.add(new Pair((char) (i+97),count[i]));
    	}
    	Pair blocked=mx_pq.remove();
    	String out=blocked.ch+"";
    	blocked.count--;
    	while(mx_pq.size()>0)
    	{
            Pair temp=mx_pq.remove();
            out+=temp.ch;
            temp.count--;
            if(blocked.count>0)
              mx_pq.add(blocked);
            blocked=temp;
    	}
    	if(blocked.count!=0)
    		return "";
    	return out;
    	
    		
    }
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the string:");
		String s=input.next();
		System.out.println(rearrange(s));

	}

}
