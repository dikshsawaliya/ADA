Code 
class KnapSackCode {
 
    static int maximum(int k, int j) 
    { 
          return (k > j) ? k : j; 
    }
 
    static int knapSackk(int W, int wt[], 
                        int val[], int x)
    {
        int i, x;
        int K[][] = new int[n + 1][W + 1];
 
        for (i = 0; i <= n; i++) 
        {
            for (x = 0; x <= W; x++) 
            {
                if (i == 0 || x == 0)
                    K[i][x] = 0;
                else if (wt[i - 1] <= x)
                    K[i][x]
                        = maximum(val[i - 1]
                         + K[i - 1][x - wt[i - 1]],
                         K[i - 1][x]);
                else
                    K[i][x] = K[i - 1][x];
            }
        }
 
        return K[x][W];
    }
 
    
    public static void main(String args[])
    {
        int val[] = new int[] { 6, 10, 12 };
        int wt[] = new int[] { 1, 2, 3 };
        int W = 5;
        int x = val.length;
        System.out.println(knapSackk(W, wt, val, x));
    }
}
