import java.util.Scanner;

class Tarefa{
    String nome;
    int tempo;

    Tarefa(String s, int t){
        nome = s;
        tempo = t;
    }

    public String toString(){
        return nome+" "+tempo;
    }
}



public class ED2371 {
    public static void main (String[] args){
    Scanner stdin = new Scanner(System.in);
    int t = stdin.nextInt();
    int n = stdin.nextInt();
    MyQueue<Tarefa> queue = new LinkedListQueue<Tarefa>();
    for (int i = 0;i<n;i++){
        String s = stdin.next();
        int p = stdin.nextInt();
        queue.enqueue(new Tarefa(s,p));
    }
    int c = 0;
    int time = 0;
    while(!queue.isEmpty()){
        c++;
        Tarefa temp = queue.dequeue();
        if (temp.tempo>t){time+=t;temp.tempo = temp.tempo-t;queue.enqueue(temp);}
        else{time+=temp.tempo;System.out.println(temp.nome+" "+time+" "+c);}
    }
}

}
