
public class Selection
{
   public static void main(String args[])
   {
       int temp;
       int a[] = {2,9,8,4,3,1};
      
       for(int i=0; i<6; i++)
       {
           for(int j=i+1; j<6; j++)
           {
               if(a[i] > a[j])
               {
                   temp = a[i];
                   a[i] = a[j];
                   a[j] = temp;
               }
           }
       }	   
    
       for(int i=0; i<6; i++)
       {
           System.out.print(a[i]+ "  ");
       }
   }
}
