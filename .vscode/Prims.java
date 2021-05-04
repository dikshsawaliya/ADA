Code 
import java.util.*;
public class Prims
{
    public static void main(String[] args) 
    {
        Scanner a=new Scanner(System.in);
        int[][] matrix=new int[5][5];
        int[] visit=new int[5];
        int mini;
        int u=0,v=0;
        int tot=0;
        for(int i=0;i<5;i++)
        {
            visit[i]=0;
            for(int j=0;j<5;j++)
            {
                System.out.print("Enter the "+i+” “+j+" weight :");
                matrix[i][j]=a.nextInt();
                if(matrix[i][j]==0)
                   matrix[i][j]=999;
            }
        }
        visit[0]=1;
        for(int c=0;c<4;c++)
        {
            mini=999;
            for(int i=0;i<5;i++)
            {
                if(visit[i]==1)
                {
                    for(int j=0;j<5;j++)
                    {
                        if(visit[j]!=1)
                        {
                            if(mini>matrix[i][j])
                            {
                                mini=matrix[i][j];
                                u=i;
                                v=j;
                            }
                        }
                    }
                }
            }
            visit[u]=1;
            visit[v]=1;
            tot+=mini;
            System.out.println("Edge found "+u+"-"+v+" weight : "+mini);
        }
        System.out.println("minimum weight is : "+tot);
    }
}
