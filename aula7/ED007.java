import java.util.Scanner;


public class ED007 {
    public static int[]  balanced(String s){
        MyStack<Character> stack = new LinkedListStack<Character>();
        int r[] = new int[2];
        for (int i = 0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' ){
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')'){
                if (stack.size() <= 0){r[0] = 1; r[1] = i; return r;}
                else if (stack.top() == '('){stack.pop();}
                else{r[0] = 1; r[1] = i; return r;}
            }
            else if (s.charAt(i) == ']'){
                if (stack.size() <= 0){r[0] = 1; r[1] = i; return r;}
                else if (stack.top() == '['){stack.pop();}
                else{r[0] = 1; r[1] = i; return r;}
            }
        }
        if (stack.size() != 0){r[0] = 2; return r;}
        r[0] = 0; return r;
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int[] r = new int[2];
        String line = stdin.nextLine();
        for (int i = 0;i<n;i++){
            line = stdin.nextLine();
            r = balanced(line);
            if (r[0] == 0){System.out.println("Expressao bem formada");}
            else if (r[0] == 1){System.out.println("Erro na posicao " + r[1]);}
            else if (r[0] == 2){System.out.println("Ficam parenteses por fechar");}
        }
    }
}
