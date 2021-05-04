import java.util.*;
public class KAlgo
{
    public static void main(String[] args) 
    {
        Scanner m=new Scanner(System.in);
        int[][] matrixx=new int[5][5];
        int[] parentt =new int[5];
        int min=999;
        int a=0;
        int b=0;
        int nofedge=1;
        int total=0;
        for(int i=0;i<5;i++)
        {
            parent[i]=0;
            for(int j=0;j<5;j++)
            {
                System.out.println(" Edge weight for vertices "+i+" "+j+" :");
                matrixx[i][j]=m.nextInt();
                if(matrixx[i][j]==0)
                   matrixx[i][j]=999;
            }
        }
        while(noofedges<5)
        {
            min=999;
            for(int i=0;i<5;i++)
            {
                for(int j=0;j<5;j++)
                {
                    if(matrixx[i][j]<min)
                    {
                        min=matrixx[i][j];
                        a=i;
                        b=j;
                    }
                }
            }
            int x=a;
            int y=b;
            while(parentt[x]!=0)
            {
                x=parentt[x];
            }
            while(parentt[y]!=0)
            {
                y=parentt[y];
            }
            if(x!=y)
            {
                nofedge++;
                System.out.println("Edge found "+a+"-"+b+" Min:"+min);
                total+=min;
                parent[b]=a;
            }
            matrixx[a][b]=matrixx[b][a]=999;
        }
        System.out.println("The weight is "+total);
    }
}    