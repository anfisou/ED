import java.util.Scanner;

public class Desafio {

    public static int[] find(int m, String s){
        s = s.toUpperCase();
        int r[] = new int[2];
        int max = m;
        int posi = 0;
        int used = 0;
        int inicio = 0;
        int fim = 0;
        int current = 0;
        int contains[] = new int[26];
        while (fim<s.length()){
            if (used>m){
                if (Character.isLetter(s.charAt(inicio))){
                if (contains[(int)s.charAt(inicio)-(int)'A'] == 1){
                    used--;
                }
                contains[(int)s.charAt(inicio)-(int)'A']--;}
                inicio++;
                current--;
            }
            else if(s.charAt(fim) == '_'||s.charAt(fim) == '!'||s.charAt(fim) == '?'||s.charAt(fim) == '.'||s.charAt(fim) == ':'||s.charAt(fim) == ';'||s.charAt(fim) == ','){
                current++;
                fim++;
            }
            else if(contains[(int)s.charAt(fim)-(int)'A']!=0){
                contains[(int)s.charAt(fim)-(int)'A']++;
                current++;
                fim++;
            }
            else{
                contains[(int)s.charAt(fim)-(int)'A']++;
                used++;
                current++;
                fim++;
            }
            if (used>m){
                if(Character.isLetter(s.charAt(inicio))){
                if (contains[(int)s.charAt(inicio)-(int)'A'] == 1){
                    used--;
                }
                contains[(int)s.charAt(inicio)-(int)'A']--;}
                inicio++;
                current--;
            }
            if (current>max){max = current;posi=inicio;}

        }
        r[0] = max;
        r[1] = posi;
        return r;
    } 


    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int m = stdin.nextInt();
        String s = stdin.next();
        int res[] = find(m,s);
        System.out.println(res[0]);
        for (int i = 0; i<res[0];i++){
            System.out.print(s.charAt(i+res[1]));
        }
        System.out.println();
    }
}
