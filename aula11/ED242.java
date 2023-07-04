import java.util.Scanner;
import java.util.LinkedList;

public class ED242 {

    public static int enche(boolean[][] map,int l, int c,  int x, int y){
        int count = 1;
        map[x][y]=true;
        if (y<c-1){if (!map[x][y+1]){count+=enche(map,l,c,x,y+1);}}
        if (x<l-1){if (!map[x+1][y]){count+=enche(map,l,c,x+1,y);}}
        if (y>0){if (!map[x][y-1]){count+=enche(map,l,c,x,y-1);}}
        if (x>0){if (!map[x-1][y]){count+=enche(map,l,c,x-1,y);}}
        return count;
    }

    public static void insert(int[] max, int k, int v){
        for(int i=0;i<k;i++){
            if(v>max[i]){
                if(i==0){max[0]=v;}
                else{max[i-1]=max[i];max[i]=v;}
            }
            else{break;}
        }
        return;
    }

    public static int soma(int[] max, int k){
        int c=0;
        for(int i= 0;i<k;i++){
            c+=max[i];
        }
        return c;
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        LinkedList<Boolean> list = new LinkedList<>();
        int k = stdin.nextInt();
        int lines = 0;
        String line = "";
        int agua=0;
        while(stdin.hasNext()){
            line = stdin.next();
            lines++;
            for(int i =0;i<line.length();i++){
                if(line.charAt(i)=='#'){list.addFirst(true);}
                else{list.addFirst(false);agua++;}
            }
        }
        int col = line.length();
        boolean[][] map = new boolean[lines][col];
        for(int i=lines-1;i>=0;i--){
            for(int  j=col-1;j>=0;j--){
                map[i][j] = list.getFirst();
                list.removeFirst();
            }
        }
        for(int j = 0;j<col;j++){
            if(!map[0][j]){agua-=enche(map,lines,col,0,j);}
            if(!map[lines-1][j]){agua-=enche(map,lines,col,lines-1,j);}
        }
        for(int i = 0;i<lines;i++){
            if(!map[i][0]){agua-=enche(map,lines,col,i,0);}
            if(!map[i][col-1]){agua-=enche(map,lines,col,i,col-1);}
        }
        int[] max = new int[k];
        for(int i = 0;i<lines;i++){
            for(int j=0;j<col;j++){
                if(!map[i][j]){insert(max,k,enche(map,lines,col,i,j));}
            }
        }
        int enche = agua-soma(max,k);
        System.out.println(enche);
    }       
}
