import java.util.*;
class Main {
    static long [] pre;
    static int mod=1000000007;
    public Main()
    {
      pre=new long [1000000+1];
      pre[0]=1L;
      //pre[1]=1;
      for(int i=1;i<=1000000;i++)
          {
              pre[i]=(i*pre[i-1])%mod;
          }
    }
    public static void main(String[] args) 
    {
        //int t;
        Scanner sc=new Scanner(System.in);
        Main m=new Main();
        int t=sc.nextInt();
        while(t-->0)
            {
              int a=sc.nextInt();
              int b=sc.nextInt();
              long facta= pre[a];
              long factb=pre[b];
              long facta_b=pre[a-b];
              long d=(factb*facta_b*1L)%mod;
              long result=(facta*m.pow(d,mod-2,mod)*1L)%mod;
              System.out.println(result);
            }
       // System.out.println("Hello, World!");
    }
    public long pow(long d,int b,int mod)
    {
        if(b==0)
        return 1L;
        if(b==1)
        return (d%mod);
        long half=pow(d,b/2,mod);
        long sqr=((half%mod)*(half%mod))%mod;
        if(b%2==0)
        return sqr;
        return ((sqr%mod)*(d%mod))%mod;
    }
}
