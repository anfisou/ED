import java.util.Scanner;


public class ED006{

    public static int countwords(String input) {
        if (input == null || input.isEmpty()) { return 0; } 
        String[] words = input.split("\\s+");
        return words.length; 
    }

    public static void main(String[] args){
    Scanner stdin = new Scanner(System.in);
    int n = stdin.nextInt();
    String line = stdin.nextLine();
    for (int u = 0;u<n;u++){
        CircularLinkedList<String> list = new CircularLinkedList<String>();
        line = stdin.nextLine();
        int words = countwords(line);
        int t = stdin.nextInt();
        for(int o = 0;o<t;o++){
            String nome = stdin.next();
            list.addLast(nome);
        }
        while(list.size()>1){
            for(int i = 0;i<words;i++){
                list.rotate();
            }
                list.removeLast();
            }
        if (list.getLast().equals("Carlos")){
            System.out.println("O Carlos nao se livrou");
        }    
        else{
            System.out.println("O Carlos livrou-se (coitado do " +list.getLast() + "!)");
        }
        line = stdin.nextLine();
        }
    }
}
