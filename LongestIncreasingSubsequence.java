import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LongestIncreasingSubsequence {

    static int longestIncreasingSubsequence(int a[] , int n)
    {
        int i=1,j=0;
        int result[] = new int[n];

        //initially consider a longestIncreasingSubsequence to be 1 for each i...
        Arrays.fill(result , 1);

        for ( i = 1; i < n; i++ )
              for ( j = 0; j < i; j++ ) 
                         if ( a[i] > a[j] && result[i] < result[j] + 1)
                    result[i] = result[j] + 1;
        
        // To actually find the maximum
        int max = Integer.MIN_VALUE;
        for( int k=0; k < n; k++ )
        {
            System.out.println(result[k] + " ");
            if(result[k] > max)
                max = result[k];           
        }
      
        return max;
    }

   
 public static void main(String[] args)
 {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter array size");
        int n  = in.nextInt();
        int a[] = new int[n];
        System.out.println("Array elements === >");
        for(int i=0; i < n; i++)
             a[i] = in.nextInt();

        int ans = longestIncreasingSubsequence(a , n);
        
        System.out.println(ans);
   }
}
