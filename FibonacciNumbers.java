 
import javax.security.sasl.SaslClient;
import java.util.Scanner;
 
public class FibonacciSeries {
    public static int mod = 1000000007;
    public static long[][] mat;
    public static long[][] idt;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
      // Logic is with Matrix Multiplication
        mat=new long[2][2];
        mat[0][0]=1;
        mat[0][1]=1 ;
        mat[1][0]=1 ;
        mat[1][1]=0;
        idt=new long[2][2];
        idt[0][0]=1;
        idt[0][1]=0;
        idt[1][0]=0;
        idt[1][1]=1;
        mat=pow(n,mat);
        System.out.println(mat[1][0]);
    }
    public static long[][] pow(long n,long[][] mat){
        if(n==0) return idt;
        long[][] x=pow(n/2,mat);
        if((n & 1) ==1){
            return mul(mul(x,x),mat);
        }
        else{
            return mul(x,x);
        }
    }
    public static  long[][] mul(long mat[][],long c[][]){
 
        long[][] ans=new long[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                long temp=0;
                for(int k=0;k<2;k++){
                    temp=(temp%mod+(mat[i][k]*c[k][j])%mod)%mod;
                }
                ans[i][j]=temp;
                //System.out.print(temp+" ");
            }
//            System.out.println();
        }
//        System.out.println("-------------------");
        return ans;
    }
}
