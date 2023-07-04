import java.util.Scanner;

public class ED164 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        BSTree<String> t = new BSTree<String>();
        int c = 0;
        for(int i = 0;i<n;i++){
            if(t.insert(stdin.next())){c++;}
        }
        System.out.println(c);
    }
}
