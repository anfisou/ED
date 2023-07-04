import java.util.Scanner;
import java.lang.*;


public class Caderno {
    static long power(int a, long b){
        long r = 1;
        for(long i = 0;i<b;i++){
            r *=a;
        }
        return r;
    }

    static long pintados(long n, long size[]){
        int i;
        long pintados = 0;
        while (n > 0){
            i = 0;
            while (n > size[i+1]){
                i++;
            }
            pintados += power(2,i);
            n -= (size[i] + power(2,i));        
        }
        return pintados;
    }
    
    
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        int p = stdin.nextInt();
        long [] inicio = new long[p];
        long [] fim = new long[p];
        int maxline = 0;
        for (int i  = 0; i<p;i++){
            int n = stdin.nextInt();
            if (n > maxline){maxline = n;}
            inicio[i] = stdin.nextLong();
            fim[i] = stdin.nextLong();
        }
        long []size = new long[maxline];
        size[0] = 1;
        for(int i = 1; i<maxline;i++){
            size[i] = 2*size[i-1] + power(2,(i-1));
        }
        for(int i = 0; i<p; i++){
            System.out.println(pintados(fim[i],size)-pintados(inicio[i]-1,size));
        }
        
    
}
}
