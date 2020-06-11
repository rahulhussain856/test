import java.util.*;
import java.lang.*;
class pair{
    String name;
    int score;
    pair(String name,int score)
    {
        this.name=name;
        this.score=score;
    }
}
class pair2{
    String []names;
    float sum;
    pair2(String[] names,float sum)
    {
        this.names=names;
        this.sum=sum;
    }
}
class finalAns{
    String s;
    float diff;
    finalAns(String s,float diff)
    {
        this.s=s;
        this.diff=diff;
    }
}
class rahul{
    static int[][] ans;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("enter number of player each side");
        int n=scan.nextInt();
        pair p[]=new pair[2*n];
        String name;
        int score;
        int l=fact(2*n)/(fact(n)*fact(n));
        int []arr=new int[2*n];
        ans=new int[l][n];
        for(int i=0;i<2*n;i++){
            arr[i]=i;
            System.out.println("enter "+(i+1)+"th player name and score");
            name=scan.next();
            score=scan.nextInt();
            p[i]=new pair(name,score);
        }
        combinations2(arr, n, 0, new int[n]);

        //printing indexes for verifying
      /* for(int i=0;i<l;i++)
        {
            for(int j=0;j<ans[i].length;j++)
                System.out.print(ans[i][j]);
            System.out.println();
        }*/

        pair2[] p2=new pair2[ans.length]; 
        for(int i=0;i<ans.length;i++)
        {
            String temp[]=new String[ans[i].length];
            float sum=0;
            for(int j=0;j<ans[i].length;j++)
            {
                temp[j]=p[ans[i][j]].name;
                sum+=p[ans[i][j]].score;
            }
            sum/=n;
            p2[i]=new pair2(temp,sum);
        }
        int len2=p2.length/2;
        finalAns []fA=new finalAns[len2];
        for(int i=0;i<len2;i++)
        {
            String s="";
            String s2=") vs ";
            float diff=Math.abs(p2[i].sum-p2[p2.length-(i+1)].sum);
            for(int j=0;j<p2[i].names.length;j++)
            {
                if(j==p2[j].names.length-1)
                {
                    s=s+p2[i].names[j]+"("+p2[i].sum;
                    s2=s2+p2[p2.length-(i+1)].names[j]+"("+p2[p2.length-(i+1)].sum+")";
                }
                else
                {
                    s=s+p2[i].names[j]+",";
                    s2=s2+p2[p2.length-(i+1)].names[j]+",";
                }
            }
            String s3=s+s2;
            fA[i]=new finalAns(s3,diff);
        }

      Comparator<finalAns> c1=(o1,o2)->{return o1.diff<o2.diff?-1:o1.diff>o2.diff?1:0;};
    //  Comparator<pair2> c1=(o1,o2)->{return  new Float(o1.sum).compareTo(new Float(o2.sum));};
        Arrays.sort(fA,c1);


     for(int i=0;i<fA.length;i++)
         System.out.println(fA[i].s);

    }
    static int j=0;
    static void combinations2(int[] arr, int len, int startPosition, int[] result){
        if (len == 0){
            for(int i=0;i<result.length;i++)
                ans[j][i]=result[i];
            j++;
            return;
        }       
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations2(arr, len-1, i+1, result);
        }
    }  
    private static int fact(int n)
    {
        if(n==0)
        return 1;

        return n*fact(n-1);
    }     
}