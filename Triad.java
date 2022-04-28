public class Triad implements Comparable<Triad>
{
	int ele;
	int row;
	int col;
	
	Triad(int ele,int row,int col)
	{
		this.ele=ele;
		this.row=row;
		this.col=col;
	}

	public int compareTo(Triad o) 
	{
	    
		return this.ele-o.ele;
	}
	
}