import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxProfitInKtransactions {

    static int maxProfitInKtransactions(int a[] , int k, int d)
    {
        int dp[][] = new int[k+1][d];
        
        for(int i=1; i < k+1; i++)
        {
            for(int j=1; j < d; j++)
            {       
                if(i == 0)
                {
                    dp[i][j] = 0;continue;
                }    

                int max = Integer.MIN_VALUE;
                for(int m=0; m<j ;m++)
                    if(dp[i-1][m] + (a[j]-a[m]) > max)
                        max = dp[i-1][m] + (a[j]-a[m]);
                
                dp[i][j] = Math.max( dp[i][j-1]  , max);
                //System.out.print(dp[i][j] + " ");
            }
            //System.out.println();
        }
      
        return dp[k][d-1];
    }

   
 public static void main(String[] args)
 {
        Scanner in = new Scanner(System.in);
        int t  = in.nextInt();
        while(t-- > 0)
        {
            //System.out.println("Enter max transactions ==>");
            int k  = in.nextInt();
            //System.out.println("No of days ==>");
            int n  = in.nextInt();
            int a[] = new int[n];
            for(int i=0; i<n; i++)
                a[i] = in.nextInt();

            int ans = maxProfitInKtransactions(a , k , n);

            System.out.println(ans);
        }
        
   }
}
