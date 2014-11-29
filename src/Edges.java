/*
 * The class that determines whether an array contains three integers that can make a triangle.
 * This has an average case time complexity of O(N+M), and a worst case of O(N*log(N)).
 */

import java.util.Arrays; //For Calling Sorting Function

class Edges 
{
	public boolean possTriangle(int [] A) //Determine if Triangle is Possible
	{
		int N = A.length; //Get Length
		
		if (N<3) //If Less Than Three Elements, Automatically Impossible
			return false;
		else if (N==3) //If Exactly Three
		{
			if (A[0]<1 || A[1]<1 || A[2]<1) //If Any are at Least Zero
				return false; //Triangle Impossible
			if ((long)A[0]+A[1]<=A[2]) //If Sum of any Two Sides Not Greater Than Third
				return false; //Triangle Impossible
			if ((long)A[1]+A[2]<=A[0])
				return false;
			if ((long)A[0]+A[2]<=A[1])
				return false;
			
			return true; //If Reached Here, Triangle is Possible
		}
		/*
		 * If You Know the Order of the Three Numbers From Min to Max, Example: X<=Y<=Z,
		 * You Only Need to Check if X+Y>Z, Since Z is Max it's Sum Will be Valid With
		 * Any of the Other Sides
		 */
		try //Try Sorting Using Quicker Method
		{
			Sorter Counters = new Sorter(); //Class That Sorts Using Counters
			A = Counters.sortArray(A); //Sort Using Array of Counters, Makes Program O(N+M)
		}
		catch (java.lang.OutOfMemoryError e) //If Exceeds Memory Space Limit
			{Arrays.sort(A);} //Sort Using Built in Function, Makes Program O(N*log(N))
		if (A[N-3]<1) //If At Most Two Elements Greater Than Zero
			return false; //Triangle Impossible
		for (int i=N-3; i>0; i--) //From Third To Last Element, to Zero
		{	
			if(A[i]<1) //If Element is Less Than 1
				break; //Stop Looking
			if ((long)A[i]+A[i+1]>A[i+2]) //Sum of Smaller Two Edges is Greater Than Biggest of Three
				return true; //Triangle Possible
		}
		
		return false; //If Reached Here, Triangle Not Possible
	}
}