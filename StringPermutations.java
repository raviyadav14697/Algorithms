import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class StringPermutations {

    static void permute(char a[] , int n)
    {
        TreeMap<Character , Integer> hm = new TreeMap();
        for(char c : a)
        {
            if(hm.containsKey(c))
            {
                int tp = hm.get(c);
                hm.remove(c);
                hm.put(c,tp+1);
            }
            else
                hm.put(c , 1);
        }

        char str[] = new char[hm.size()];
        int count[] = new int[hm.size()];
        int index = 0;
        for(Map.Entry<Character,Integer> set : hm.entrySet())
        {
            str[index] = set.getKey();
            count[index] = set.getValue();
            index++;
        }

        char result[] = new char[a.length];
        permuteUtil(str,count,result,0);
    }

    static void permuteUtil(char str[] , int count[], char result[], int level)
    {
        if(level == result.length)
        {
            printArray(result);
            return;
        }   

        for(int i = 0; i < str.length; i++)
        {
            if(count[i] == 0)
                continue;

            count[i]--;
            result[level] = str[i];
            permuteUtil(str,count,result,level+1);
            count[i]++;
        } 
    }

    static void printArray(char result[])
    {
        for(char c : result)
            System.out.print(c);
        System.out.println();
    }

   
 public static void main(String[] args)
 {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter String");
        String s  = in.next();
        char a[] = s.toCharArray();

        permute(a , a.length);
        
        
   }
}
