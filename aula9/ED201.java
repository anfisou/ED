import java.util.Scanner;


public class ED201 {
    public static int max(int a,int b){
        if (a>b){return a;}
        return b;
    }

    public static int playlist(int[] v,int n,int d,int count,int curr){
        if (curr == n){return count;}
        int count1=0;
        if (count+v[curr]<=d){count1 = playlist(v,n,d,count+v[curr],curr+1);}
        int count2 = playlist(v,n,d,count,curr+1);
        count = max(count1,count2);
        return count;
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int d = stdin.nextInt();
        int n = stdin.nextInt();
        int[] val = new int[n];
        for (int i = 0;i<n;i++){
            val[i] = stdin.nextInt();
        }
        int max = playlist(val,n,d,0,0);
        System.out.println(max);
    }
}
