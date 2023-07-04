import java.util.Scanner;

public class ED235 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int p = stdin.nextInt();
        for (int k = 0;k<p;k++){
            int n = stdin.nextInt();
            for (int i = 0;i<n;i++){
                for (int c = 0;c<n-i;c++){
                    System.out.print("#");
                }
                for(int d=0;d<i;d++){
                    System.out.print(".");
                }
                System.out.println();
            }
        }
    }
}
