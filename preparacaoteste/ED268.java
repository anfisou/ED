import java.util.Scanner;

public class ED268 {

    public static void lambda(int t){
        for (int i=1;i<=t;i++){
            for (int j = 1;j<=t;j++){
                if (i==j){System.out.print("#");}
                else if (i+j==t+1 && i > t/2){System.out.print("#");}
                else{System.out.print(".");}
            }
            System.out.println();
        }
        return;
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        for (int i = 0;i<n;i++){
            int t = stdin.nextInt();
            lambda(t);
        }
    }
}