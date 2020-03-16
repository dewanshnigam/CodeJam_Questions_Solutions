// Kickstart - 2019 - Round A - Question Name : Training
import java.util.*;
import java.lang.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        StringBuilder sb=new StringBuilder();
        int cases=1;
        while(t-->0)
        {
            int n=ob.nextInt();
            int p=ob.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=ob.nextInt();

            Arrays.sort(a);
            
            long x=0L;
            for(int i=n-1;i>=(n-p);i--)
            x+= a[n-1] - a[i];
            
            int d[]=new int[n-1];
            int k=0;
            for(int i=1;i<n;i++)
            d[k++] = a[i]-a[i-1];
            
            long min = x;
            for(int i=n-2;i>=0;i--)
            {
                int j=i-p+1;
                if(j<0)
                break;
                long calc = (a[i] - a[j]) + x - (d[i] * (p-1));
                min = Math.min(min,calc);
                x = calc;
            }
            sb.append("Case #"+cases+": "+min+"\n");            
            cases++;
        }
        System.out.println(sb);
    }
}