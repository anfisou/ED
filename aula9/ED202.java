import java.util.Scanner;


public class ED202 {

    public static double caminho(double[][] v,int curr,boolean used[], int perm[],int n,double max){
        if (curr == n){
            double count = 0;
            for(int i=1;i<n;i++){
                count += v[perm[i]][perm[i-1]];
            }
            count+=v[perm[n-1]][perm[0]];
            return count;
        }
        double min = max;
        for (int i = 0;i<n;i++){
            if(!used[i]){
                used[i]=true;
                perm[curr] = i;
                double count = caminho(v,curr+1,used,perm,n,max);
                if (count<min){min=count;}
                used[i]=false;
            }
        }
        return min;

    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        double[][] val = new double[n][n];
        String line = stdin.nextLine();
        line = stdin.nextLine();
        double max = 0.0;
        for(int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                double f = stdin.nextDouble();
                if (f>max){max=f;}
                val[i][j] = f;
            }
        }
        int[] perm = new int[n];
        boolean[] used = new boolean[n];
        double min = caminho(val,0,used,perm,n,max*n);
        min = Math.round(min*100)/100.0;
        System.out.println(min);
    }
}
