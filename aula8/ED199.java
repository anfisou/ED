import java.util.Scanner;

public class ED199 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int b = stdin.nextInt()-1;
        int i = stdin.nextInt();
        boolean[] mapa = new boolean[n];
        String line = stdin.next();
        for (int k = 0;k<n;k++){
            if (line.charAt(k) == 'T'){mapa[k]=true;}
        }
        int max = b;
        int min = b;
        for (int k = 0;k<i;k++){
            char c = stdin.next().charAt(0);
            int p = stdin.nextInt();
            if (c=='D'){b+=p;}
            else{b-=p;}
            if (b>max){max = b;}
            if (b<min){min = b;}
        }
        int count = 0;
        for (int k = min;k<=max;k++){
            if (mapa[k]){count++;}
        }
        System.out.println(count);
    }
}
