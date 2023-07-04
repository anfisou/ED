import java.util.Scanner;
import java.lang.Math;

public class Desafio {

    static public boolean pintado(int x, int y, boolean[][] data, int n, int g){
        if (g==1){return data[x][y];}
        else{int t =(int)(Math.pow(n,Math.pow(2,g-2))); return pintado(x/t,y/t,data,n,g-1) && pintado(x%t,y%t,data,n,g-1);}
    }

    static public  boolean ispintado(int x, int y, boolean geracaoanterior[][], int n){
        return (geracaoanterior[x/n][y/n] && geracaoanterior[x%n][y%n]);
    }


    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int g = stdin.nextInt();
        boolean[][] geracaoanterior;
        boolean[][] data = new boolean[n][n];
        //if (g>1){geracaoanterior = new boolean[(int)(Math.pow(n,Math.pow(2,g-2)))][(int)(Math.pow(n,Math.pow(2,g-2)))];}
        //else{geracaoanterior = new boolean[n][n];}
        for (int i = 0; i<n;i++){
            String s = stdin.next();
            for (int j = 0;j<n;j++){
                if (s.charAt(j) == '#'){data[i][j] = true;}
            }
        }
        /*for (int geracao = 2;geracao<g;geracao++){
                for (int r = 0;r<n;r++){
                    for (int c = 0;c<n;c++){
                        if (geracaoanterior[r][c]){
                            for (int a = 0;a<n;a++){
                                for (int b = 0;b<n;b++){
                                    geracaoanterior[r*n+a][c*n+b] = geracaoanterior[a][b];
                                }
                            }
                        }
                    }
                }         
            n = n*n;
        }*/
        int p = stdin.nextInt();
        for (int i = 0;i<p;i++){
            int soma = 0;
            int x1 = stdin.nextInt();
            int y1 = stdin.nextInt();
            int x2 = stdin.nextInt();
            int y2 = stdin.nextInt();
            for (int r = x1;r<=x2;r++){
                for (int c = y1;c<=y2;c++){
                    if (pintado(r,c,data,n,g)){soma++;}
                }
            }
            System.out.println(soma);
        }
    }
}
