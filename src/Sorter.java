/*
 * The Class That Sorts the Array Using an Array of Counters
 * It has a time complexity of O(N+M)
 */
public class Sorter 
{
	public int [] sortArray(int [] A)
	{
		boolean sort = true; //To Check If Array is Already Sorted
		int N = A.length; //Length of Array
		int min = A[0]; //Minimum Value in Array
        int max = A[0]; //Maximum Value in Array
		int t = 0; //For Traversing Array of Counters
        int [] count; //Array of Counters
		
		for (int i=1; i<N; i++) //Loop Through Array, Get Minimum and Max, and Check if Sorted Already
        {
            if (sort && A[i]<A[i-1]) //If Not Sorted, Then Eventually One Element
            	sort = false; //Will be Smaller Then it's Precedent
			if (A[i]<min) //If Smaller Than Current Min
                min = A[i]; //Change Min
            else if (A[i]>max) //If Greater Than Current Max
                max = A[i]; //Change Max
        }
		if (sort) //If Already Sorted
			return A; //Return Array as is
		
        count = new int[max-min+1]; //Set Size of Counters Array to Range of Elements
		
		for (int i=0; i<N; i++) //Loop through Array A
            count[A[i]-min]++; //Increment Count of Number in Respective Position in Counters Array
		for (int i=0; i<N;) //Sort Array Using Counters
		{
			while (count[t]==0) //Find Next Smallest Number that Appears in Array
				t++;
			for (int j=0; j<count[t]; j++) //Place It in Array However Many Times the Count is
				A[i++] = t+min;
			
			t++; //Increment Traverser of Counter Array
		}
		
		return A; //Return Sorted Array
	}
}