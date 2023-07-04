import java.util.Scanner;

public class Caderno {


    static public long diagonal(long i){
        long r = 1 + (i*(i+1))/2; 
        return r;
    }


    static public int finddiagonal(long a){
        int r =(int) Math.floor(Math.sqrt((2*a) - (3.0/4))-(1.0/2));
        return r;
    }
    static public long find1(int x, int y){
        int d  =x+y;
        long r = diagonal(d);
        r += y;
        return r;
    }
    static public int[] find(long a){
        int x = finddiagonal(a); 
        long c = diagonal(x);
        int y = 0;
        long b = a-c;
        x -= b;
        y +=b;
        int r[] = {x,y};
        return r;
    }


    static public int min(int a, int b){
        if (a>b){return b;}
        return a;
    }
    // cada inicio de diagonal ate p = min(x1-x,y2-y) fazer valor(x,y)*p + (p-1)p/2
    //descendo x ate chegar a x2, e depois mexendo y ate char a y2
    //      x= x1;
    //      y = y1
    /*      for (; x<= x2;){
        int a = min(x1-x,y2-y);
        soma += a * find(a) + (a*(a-1))/2;
        x++;
    }

    for (;y<= y2;){
        int a = min(x1-x,y2-y);
        soma += a * find(a) + (a*(a-1))/2;
        y++;
    }
     * 
     * 
     */

    static public long area(long a, int x1,int y1, int x2, int y2){
        int x= x1;
        int y = y1;
        long soma = 0;
        for (; x<= x2;){
            long r = min(x-x1+1,y2-y+1);
            soma += r * find1(x,y) + (r*(r-1))/2;
            x++;
        }
        x--;
        y++;
        for (;y<= y2;){
            long r = min(x-x1+1,y2-y+1);
            soma += r * find1(x,y) + (r*(r-1))/2;
            y++;
        }
        return soma;
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int p = stdin.nextInt();
        for (int j = 0; j<p;j++){
            long ini = stdin.nextLong();
            long f = stdin.nextLong();
            int r[] = find(ini);
            int s[] = find(f);
            long res1 = area(ini,r[0],r[1],s[0],s[1]);
            System.out.println(res1);
        }
        }
    
}
