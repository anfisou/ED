import java.util.Scanner;

public class ED005 {

    public static boolean isnumber(String s){
        for (int i = 0; i<s.length();i++){
            if (!(Character.isDigit(s.charAt(i)))){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        String line = stdin.nextLine();
        for (int u = 0;u<n;u++){
            boolean erro = false;
            MyStack<Integer> s = new LinkedListStack<Integer>();
            line = stdin.nextLine();
            String[] words = line.split("\\s+");
            for(int p = 0; p<words.length;p++){
                if (isnumber(words[p])){
                    s.push(Integer.valueOf(words[p]));
                }
                else {
                    if  (s.size()<2){erro = true;break;}
                    int a = s.pop();
                    int b = s.pop();
                    if (words[p].equals("+")){s.push(b+a);}
                    else if (words[p].equals("-")){s.push(b-a);}
                    else if (words[p].equals("*")){s.push(b*a);}
                    else if (words[p].equals("/")){s.push(b/a);}
            }
        }
            if(s.size()!=1 || erro){System.out.println("Expressao Incorrecta");}
            else{System.out.println(s.top());}
        }
    }
}
