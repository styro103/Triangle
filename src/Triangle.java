/*
 * Shaun Mbateng
 * Triangle Program
 * This program displays whether an array contains three integers that can make a triangle.
 * It has a best and average case time complexity of O(N+M), and a worst case of O(N*log(N)).
 */

import java.util.Scanner; //For Inputs

public class Triangle 
{
	public static void main(String[] args) 
	{
		Scanner cin = new Scanner(System.in); //For Inputs
		Edges Values = new Edges(); //Class That Checks for Possible Triangle
		int [] arr; //Array to Sort
		int len; //Length of Array
		boolean triangle;
		
		//Enter and Set Array Length
		System.out.print("Enter the Array Length: ");
		len = cin.nextInt();
		arr = new int [len];
		
		//Fill Array
		for (int i=0; i<len; i++)
		{
			System.out.print("Enter Element "+(i+1)+": ");
			arr[i] = cin.nextInt();
		}
		
		cin.close(); //No More Inputs Needed
		
		triangle = Values.possTriangle(arr); //Check If Possible Triangle With Inputted Array
		
		System.out.println(); //Print Line Space
		
		//Display Result
		if (triangle) 
			System.out.println("Triangle is Possible With Given Edges");
		else
			System.out.println("Triangle isn't Possible With Given Edges");
	}
}
