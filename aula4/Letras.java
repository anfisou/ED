import java.util.Scanner;


class SopaLetras{
    char data[][];
    int respostas[][];
    int l;
    int c;

    SopaLetras(int linhas, int colunas){
        data = new char[linhas][colunas];
        respostas = new int[linhas][colunas];
        l = linhas;
        c = colunas;
    }
    
    public void read(Scanner in){
        for (int i=0; i<l; i++){
            String linha = in.next();
           for (int j=0; j<c; j++){
              data[i][j] = linha.charAt(j);
              respostas[i][j] = 0;
           }
        }
    }

    public void find(String palavra){
        for (int i = 0; i<l;i++){
            for (int j = 0; j<c;j++){
                if (data[i][j]== palavra.charAt(0)){
                    for (int k = 1; k<palavra.length();k++){
                        if (!(i+k<l)){break;}
                        if (i+k<l){
                            if (data[i+k][j] != palavra.charAt(k)){break;}
                        if (k == palavra.length()-1){
                            for(int r = 0;r<=k;r++){
                                respostas[i+r][j] = 1;
                            }
                        }
                    }
                    }
                    for (int k = 1; k<palavra.length();k++){
                        if (!(i-k>=0)){break;}
                        if (i-k>=0){
                            if (data[i-k][j] != palavra.charAt(k)){break;}
                        
                        if (k == palavra.length()-1){
                            for(int r = 0;r<=k;r++){
                                respostas[i-r][j] = 1;
                            }
                        }
                    }
                    }
                    for (int k = 1; k<palavra.length();k++){
                        if (!(j+k<c)){break;}
                        if (j+k<c){
                            if (data[i][j+k] != palavra.charAt(k)){break;}
                        
                        if (k == palavra.length()-1){
                            for(int r = 0;r<=k;r++){
                                respostas[i][j+r] = 1;
                            }
                        }
                    }
                    }
                    for (int k = 1; k<palavra.length();k++){
                        if (!(j-k>=0)){break;}
                        if (j-k>=0){
                            if (data[i][j-k] != palavra.charAt(k)){break;}
                        
                        if (k == palavra.length()-1){
                            for(int r = 0;r<=k;r++){
                                respostas[i][j-r] = 1;
                            }
                        }
                    }
                }
                }
            }
        }
    }
        
public void print(){
    for (int i = 0;i<l;i++){
        for (int j = 0;j<c-1;j++){
            if (respostas[i][j] == 1){System.out.print(data[i][j]);}
            else{System.out.print(".");}
        }
        if (respostas[i][c-1] == 1){System.out.println(data[i][c-1]);}
        else{System.out.println(".");}
    }
}   
}



public class Letras {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int l = stdin.nextInt();
        int c = stdin.nextInt();
        int input = 1;
        while(l!=0 || c!=0){
            SopaLetras jogo = new SopaLetras(l,c);
            jogo.read(stdin);
            int n = stdin.nextInt();
            for (int i = 0;i<n;i++){
                String s = stdin.next();
                jogo.find(s);
            }
            System.out.println("Input #" + input);
            jogo.print();
            l = stdin.nextInt();
            c = stdin.nextInt();
            input++;
        }
    }
    
}
