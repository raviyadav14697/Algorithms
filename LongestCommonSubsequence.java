import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LongestCommonSubsequence {

    static int longestCommonSubsequence(char a[] , char b[])
    {
        int l1 = a.length;
        int l2 = b.length;

        int dp[][] = new int[l1+1][l2+1];
        
        for(int i=1; i <= l1; i++)
        {
            for(int j=1; j <= l2; j++)
            {                
                if(a[i-1] == b[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max( dp[i][j-1]  , dp[i-1][j]);
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        
        
        // To actually find the longestCommonSubsequence String
        StringBuilder s = new StringBuilder();
        for( int i=l1 , j=l2; i > 0 && j > 0;  )
        {
            if(dp[i][j-1] == dp[i][j])
                j = j-1;
            else if(dp[i-1][j] == dp[i][j])
                i = i-1;
            else
            {
                s.append(a[i-1]);
                i--;j--;
            }
            
        }
        
        System.out.println("LCS is ===>  " + s.reverse());
      
        return dp[l1][l2];
    }

   
 public static void main(String[] args)
 {
        Scanner in = new Scanner(System.in);
        System.out.println("1st String");
        String a  = in.next();
        System.out.println("2nd String");
        String b = in.next();

        int ans = longestCommonSubsequence(a.toCharArray() , b.toCharArray());
        
        System.out.println(ans);
   }
}
