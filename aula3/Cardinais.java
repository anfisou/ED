import java.util.Scanner;

public class Cardinais {
    public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n = stdin.nextInt();
    int m = stdin.nextInt();
    int data[][] = new int [n][m];
    for (int i = 0;i<n;i++){
        String s = stdin.next();
        for (int j =0;j<m;j++){
            if (s.charAt(j) == '.'){
                data[i][j] = 0;
            }
            else{
                data[i][j] = 1;
            }
        }
    }
    int max = 0;
    int count = 0;
    int sum = 0;
    for (int i = 0;i<n;i++){
        sum = 0;
        for (int j =0;j<m;j++){
            if (data[i][j] == 1){
                sum++;
            }
            else{sum = 0;}
        
        if (sum > max){
            count = 1;
            max = sum;
        }
        else if (sum == max){
            count++;
        }
    }
    }
    for (int j = 0;j<m;j++){
        sum = 0;
        for (int i =0;i<n;i++){
            if (data[i][j] == 1){
                sum++;
            }
            else{sum = 0;}
        if (sum > max){
            count = 1;
            max = sum;
        }
        else if (sum == max){
            count++;
        }
    }
    }
    System.out.println(max + " " + count);


}
}
