import java.util.Scanner;

public class ED238 {

    static public int max(int[] n, int size, int k){
        int inicio = 0;
        int fim = 0;
        int max = 0;
        int nm = 0;
        int count = 0;
        for(fim = 0;fim<size;fim++){
            if (n[fim] == 1){
                count++;
            }
            else{
                nm++;
                count++;
            }
            while (nm > k){
                if (n[inicio]==0){
                    nm--;
                }
                count--;
                inicio++;
            }
            if (count>max && nm<=k){max=count;}}
        return max;
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int size = stdin.nextInt();
        int[] n = new int[size];
        String s = (String)stdin.next();
        for(int i = 0;i<size;i++){
            if (s.charAt(i) == '1'){n[i]=1;}
            else{n[i]=0;}
        }
        int q = stdin.nextInt();
        for (int i = 0;i<q;i++){
            int l = stdin.nextInt();
            System.out.println(max(n,size,l));
        }
    }
}
