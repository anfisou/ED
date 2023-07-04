import java.util.Scanner;


public class ED198 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int[] val = new int[n];
        for (int i = 0;i<n;i++){
            val[i]= stdin.nextInt();
        }
        int inicio = 0;
        int fim = 1;
        int soma = val[0];
        int somamax = val[0];
        while(fim<n){
            if (val[fim]>soma+val[fim]){
                inicio = fim;
                fim++;
                soma = val[inicio];
            }
            else if (val[fim] + soma <0 ){
                inicio = fim+1;
                fim = fim+2;
                if (inicio<n){soma = val[inicio];}
            }
            else{
                soma += val[fim];
                fim++;
            }
            if (soma >somamax){somamax=soma;}
        }
        System.out.println(somamax);
    }
}
