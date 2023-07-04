import java.util.Scanner;

public class ED222 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int k = stdin.nextInt();
        int t = stdin.nextInt();
        boolean[] prof = new boolean[n];
        for (int i = 0;i<n;i++){
            int temp = stdin.nextInt();
            if (temp>=t){prof[i]=true;}
        }
        int count = 0;
        int total = 0;
        int inicio = 0;
        int fim = k-1;
        for (int l = 0;l<k;l++){
            if (prof[l]){count++;}
        }
        if (count>=k/2.0){total++;}
        while(fim<n-1){
            if (prof[inicio]){count--;}
            if (prof[fim+1]){count++;}
            fim++;
            inicio++;
            if (count>=k/2.0){total++;}
        }
        System.out.println(total);
    }
}
