import java.util.Scanner;

public class ED231 {

    public static int[] saltos(int[] lista, int size){
        int[] res = new int[2];
        int max = 0;
        int min = lista[1]-lista[0];
        for (int i = 1;i<size;i++){
            int salto = lista[i] - lista[i-1];
            if (salto>max){max = salto;}
            else if (salto<min){min = salto;}
        }
        res[0]=min;
        res[1] = max;
        return res;
    }

    public static int max(int[] lista, int size){
        int max = lista[0];
        for (int i=1;i<size;i++){
            if (lista[i]>max){max = lista[i];}
        }
        return max;
    }

public static int[] periodosbaixapropagacao(int[] lista, int size){
    int res[] = new int[2];
    int count = 0;
    int current = 0;
    int max = 0;
    for (int i = 1;i<size;i++){
        if ((((lista[i]-lista[i-1]))/((double)lista[i-1]))<=0.05){
            if (current == 0){count++;}
            current++;
            if (current>max){max=current;}
        }
        else{current = 0;}
    }
    res[0] = count;
    res[1] = max;
    return res;
}
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int[] lista = new int[n];
        for (int i = 0;i<n;i++){
            lista[i] = stdin.nextInt();
        }
        int flag = stdin.nextInt();
        if (flag==1){int res[] = saltos(lista,n);System.out.println(res[0]+" "+res[1]);}
        else if (flag==2){int[] res = periodosbaixapropagacao(lista, n);System.out.println(res[0]+" "+res[1]);}
        else if(flag==3){
            for (int i = 0;i<n;i++){
                lista[i] /= 100;   
            }
            int max = max(lista,n);
            while(max>0){
            for (int i = 0;i<n;i++){
                if (lista[i]>=max){System.out.print("#");}
                else{System.out.print(".");}
            }
            System.out.println();
            max--;
        }
        }
    }
}
