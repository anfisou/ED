import java.util.Scanner;

public class ED200 {
    public static int conta(boolean[][] data,int l,int c,int x,int y){
        int count = 1;
        data[x][y]=false;
        if (y<c-1){if (data[x][y+1]){count+=conta(data,l,c,x,y+1);}}
        if (x<l-1){if (data[x+1][y]){count+=conta(data,l,c,x+1,y);}}
        if (y>0){if (data[x][y-1]){count+=conta(data,l,c,x,y-1);}}
        if (x>0){if (data[x-1][y]){count+=conta(data,l,c,x-1,y);}}
        if (x>0 && y>0){if (data[x-1][y-1]){count+=conta(data,l,c,x-1,y-1);}}
        if (x>0 && y<c-1){if (data[x-1][y+1]){count+=conta(data,l,c,x-1,y+1);}}
        if (x<l-1 && y>0){if (data[x+1][y-1]){count+=conta(data,l,c,x+1,y-1);}}
        if (x<l-1 && y<c-1){if (data[x+1][y+1]){count+=conta(data,l,c,x+1,y+1);}}
        return count;
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        for (int z=0;z<n;z++){
        int l = stdin.nextInt();
        int c = stdin.nextInt();
        boolean[][] data = new boolean[l][c];
        for (int i = 0;i<l;i++){
            String line = stdin.next();
            for (int j = 0;j<c;j++){
                if (line.charAt(j) == '#'){data[i][j]=true;}
            }
        }
        int max = 0;
        int count = 0;
        for (int i = 0;i<l;i++){
            for (int j =0;j<c;j++){
                if (data[i][j]){count = conta(data,l,c,i,j);}
                if (count>max){max=count;}
        }
    }
    System.out.println(max);
}
}
}