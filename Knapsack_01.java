import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Knapsack_01 {

    static int knapsack_01(int []wt, int []val, int n,int total_weight)
    {
        int a[][] = new int[n+1][total_weight+1];
        
        
        for(int i=0; i <= n; i++)
        {
            for(int j=0; j <=total_weight; j++)
            {
                if(i == 0 || j == 0)
                {
                    a[i][j] = 0;
                    System.out.print(a[i][j] + " ");
                    continue;
                }
                
                if(wt[i] > j)
                    a[i][j] = a[i-1][j];
                else
                    a[i][j] = Math.max( (val[i] + a[i-1][j-wt[i]]) , a[i-1][j]);
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        
        return a[n][total_weight];
    }

   
 public static void main(String[] args)
 {
	 
		/*
		*		
	
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Total weight");
        int total_weight = in.nextInt();
        System.out.println("Enter np of items");
        int no_of_items = in.nextInt();
        
        int wt[] = new int[no_of_items+1];
        int val[] = new int[no_of_items+1];
		
		
		
        System.out.println("weights == >");
        for(int i=1; i < no_of_items+1; i++)
            wt[i] = in.nextInt();
     
        System.out.println("values ==>");
        for(int i=1; i < no_of_items+1; i++)
            val[i] = in.nextInt();
		
		*
		*/
		int total_weight = 7;
		int no_of_items = 4;
		int wt[] = {0,1,3,4,5};
        int val[] = {0,1,4,5,7};

        int max_val = knapsack_01(wt, val,no_of_items,total_weight);
        System.out.println(max_val);
   }
}
