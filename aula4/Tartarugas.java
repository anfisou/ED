import java.util.Scanner;

class Tartaruga{
    int data[][];
    int x;
    int y;
    int r;
    int c;
    int dir;
    boolean caneta;

    Tartaruga(int rows, int columns){
        x = 0;
        y = 0;
        data = new int[rows][columns];
        r = rows;
        c = columns;
        dir = 0;
        caneta = false;
    }

    public void up(){
        caneta = false;
    }

    public void down(){
        caneta = true;
        data[x][y] = 1;
    }

    public void rigth(){
        dir = (dir+1) % 4;
    }
    public void left(){
        dir = (dir+3) % 4;
    }
    public void forward(int n){
        if (dir == 0){
            for (int i = 0; i<n;i++){
            if (caneta){data[x][y] = 1;}
            if (y+1 == c){break;}
            y++;
            }
        }
        else if (dir == 1){
            for (int i = 0; i<n;i++){
                if (caneta){data[x][y] = 1;}
                if (x+1 == r){break;}
                x++;
                }
        }
        else if (dir == 2){
            for (int i = 0; i<n;i++){
                if (caneta){data[x][y] = 1;}
                if (y-1 < 0){break;}
                y--;
                }
        }
        else if (dir == 3){
            for (int i = 0; i<n;i++){
                if (caneta){data[x][y] = 1;}
                if (x-1 < 0){break;}
                x--;
                }
        }
        if(caneta){data[x][y] = 1;}
    }

    public void print(){
        for (int i = 0;i<r;i++){
            for (int j = 0;j<c-1;j++){
                if (data[i][j] == 1){System.out.print("*");}
                else{System.out.print(".");}
                System.out.print(" ");
            }
            if (data[i][c-1] == 1){System.out.println("*");}
            else{System.out.println(".");}
        }
    }

    public int conta(){
        int sum =0;
        for (int i = 0;i<r;i++){
            for (int j = 0;j<c;j++){
                if (data[i][j] == 1){sum++;}
            }
        }
        return sum;
    }
    public int linhas(){
        int s =0;
        for (int i = 0;i<r;i++){
            for (int j = 0;j<c;j++){
                if (data[i][j] == 1){break;}
                if (j == c-1){s++;}
            }
        }
        return s;
    }

    public int colunas(){
        int s =0;
        for (int j = 0;j<c;j++){
            for (int i = 0;i<r;i++){
                if (data[i][j] == 1){break;}
                if (i == r-1){s++;}
            }
        }
        return s;
    }

    public boolean find(Matriz m){
        int temp[][];
        temp = new int[m.r][m.c];
        for (int i = 0; i <= r-m.r;i++){
            for (int j = 0; j <= c-m.c;j++){
                if (data[i][j] == m.data[0][0]){
                    for(int k = 0;k<m.r;k++){
                        for (int l = 0;l<m.c;l++){
                            temp[k][l] = data[i+k][j+l];
                        }
                    }
                    int same = 1;
                    for(int k = 0;k<m.r;k++){
                        for (int l = 0;l<m.c;l++){
                            if (!(temp[k][l] == m.data[k][l])){same *=0;}
                        }
                    }
                    if (same == 1){return true;}
                }
            }
        }
        return false;
    }
}

class Matriz {
    int data[][];
    int r;
    int c;

    Matriz(int rows, int columns){
        data = new int[rows][columns];
        r = rows;
        c = columns;
    }

    public void read(Scanner in) {
        for (int i=0; i<r; i++){
           for (int j=0; j<c; j++){
                    String c = in.next();
              if (c.equals("*")){data[i][j] = 1;}
              else {data[i][j] = 0;}
           }
        }
     }
    }

public class Tartarugas {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int flag = stdin.nextInt();
        int r = stdin.nextInt();
        int c = stdin.nextInt();
        Tartaruga tartaruga = new Tartaruga (r,c);
        String s = stdin.next();
        while (!(s.equals("end"))){
            if(s.equals("D")){tartaruga.down();}
            else if (s.equals("U")){tartaruga.up();}
            else if (s.equals("R")){tartaruga.rigth();}
            else if (s.equals("L")){tartaruga.left();}
            else if (s.equals("F")){
                int n = stdin.nextInt();
                tartaruga.forward(n);
            }
            s = stdin.next();
        }
        int a = stdin.nextInt();
        int b = stdin.nextInt();
        Matriz m = new Matriz(a,b);
        m.read(stdin);
        if (flag == 0){
            tartaruga.print();
        }
        else if (flag == 1){
            int total = tartaruga.r * tartaruga.c;
            System.out.print((tartaruga.conta() * 100)/total);
            System.out.print(" ");
            System.out.print(tartaruga.linhas());
            System.out.print(" ");
            System.out.println(tartaruga.colunas());
        }

        else if (flag == 2){
            if (tartaruga.find(m)){System.out.println("Sim");}
            else{System.out.println("Nao");}
        }
    }
}
