//kadane's Algorithm

import java.util.Scanner;
 
class MaximumSumSubarray{
 
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n+1];
        for(int i=1; i<=n; i++)
        {
            a[i] = sc.nextInt();
        }
        int max = a[1], curMax =  a[1];
        for(int i=2; i<=n; i++)
        {
            curMax = Math.max(a[i] , a[i]+curMax);
            if(curMax > max)
                max = curMax; 
            
        }
        System.out.println(max);
    }
 
} 