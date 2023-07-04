import java.util.Scanner;

class Life {
    int data[][];
    int r;
    int c;

    Life(int rows, int columns){
        data = new int[rows][columns];
        r = rows;
        c = columns;
    }

    public void read(Scanner in) {
        for (int i=0; i<r; i++){
            String linha = in.next();
           for (int j=0; j<c; j++){
              if (linha.charAt(j) == 'O'){data[i][j] = 1;}
              else {data[i][j] = 0;}
           }
        }
     }
    
     public void print(){
        for (int i = 0; i<r;i++){
            for (int j = 0; j<c-1;j++){
                if (data[i][j] == 1){System.out.print('O');}
                else {System.out.print('.');}
            }
            if (data[i][c-1] == 1){System.out.println('O');}
            else {System.out.println('.');}
        }
     }
     public int vizinhos(int r, int c){
        int vizinhos = 0;
        if (r>0){
            if (data[r-1][c] == 1){vizinhos++;}
            if (c>0){ if (data[r-1][c-1] == 1){vizinhos++;}}
            if (c< this.c -1){if (data[r-1][c+1] == 1){vizinhos++;}}
        }
        if (r<this.r-1){
            if (data[r+1][c] == 1){vizinhos++;}
            if (c>0){if (data[r+1][c-1] == 1){vizinhos++;}}
            if (c<this.c-1)if (data[r+1][c+1] == 1){vizinhos++;}
        }
        if(c>0){if (data[r][c-1] == 1){vizinhos++;}}
        if (c<this.c-1){if (data[r][c+1] == 1){vizinhos++;}}
        return vizinhos;
     }

     public void update(){
        Life nova = new Life(r,c);
        for (int i = 0; i<r;i++){
            for (int j = 0; j<c;j++){
                nova.data[i][j] = data[i][j];
            }
        }
        for (int i = 0; i<r;i++){
            for (int j = 0; j<c;j++){
                if (data[i][j] == 1){
                    if (vizinhos(i,j) <2){nova.data[i][j]= 0;}
                    else if (vizinhos(i,j) >3){nova.data[i][j]= 0;}
                }
                else{
                    if (vizinhos(i,j) == 3){nova.data[i][j] = 1;}
                }
            }
        }
        data = nova.data;
     }
}

class GameLife{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int l = stdin.nextInt();
        int c = stdin.nextInt();
        int i = stdin.nextInt();
        Life jogo = new Life(l,c);
        jogo.read(stdin);
        for (int j = 0; j<i; j++){
            jogo.update();
        }
        jogo.print();
    }
}