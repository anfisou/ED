import java.util.Scanner;

class JogoGalo {
    int data[][];
    int n;

    JogoGalo(int n){
        data = new int[n][n];
        this.n = n;
    }

    public void read(Scanner in) {
        for (int i=0; i<n; i++){
            String linha = in.next();
           for (int j=0; j<n; j++){
              if (linha.charAt(j) == 'X'){data[i][j] = 1;}
              else if (linha.charAt(j) == 'O'){data[i][j] = 2;}
              else if (linha.charAt(j) == '.'){data[i][j] = 0;}
           }
        }
     }
    
    public boolean row(int player, int r){
       for (int j=0; j<n; j++){
            if (data[r][j] != player){ return false;}
        }
        return true;
    }

    public boolean column(int player, int c){
        for (int j=0; j<n; j++){
            if (data[j][c] != player){ return false;}
        }
    return true;

    }

    public boolean diagonal1(int player){
        for (int j=0; j<n; j++){
            if (data[j][j] != player){ return false;}
        }
        return true;
    }

    public boolean diagonal2(int player){
        for (int j=0; j<n; j++){
            if (data[j][n-j-1] != player){ return false;}
        }
        return true;
    }

    public int winner(){
        for (int i = 1; i<=2;i++){
            for (int r = 0; r<n;r++){
                if (row(i, r)){return i;}
            }
            for (int c = 0; c<n;c++){
                if (column(i, c)){return i;}
            }
            if (diagonal1(i)){return i;}
            if (diagonal2(i)){return i;}
        }
        return 0;
    }

    public boolean isfull(){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (data[i][j] == 0){return false;}
            }
        }
        return true;
    }
}

class Galo{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        JogoGalo jogo = new JogoGalo(n);
        jogo.read( stdin);
        if (jogo.winner() == 1){System.out.println("Ganhou o X");}
        else if (jogo.winner() == 2){System.out.println("Ganhou o O");}
        else{
            if( jogo.isfull()){System.out.println("Empate");}
            else{System.out.println("Jogo incompleto");}
        }
    }
}