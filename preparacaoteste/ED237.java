import java.util.Scanner;

public class ED237 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int t = stdin.nextInt();
        int n = stdin.nextInt();
        String line = stdin.nextLine();
        MyQueue<String> queue = new LinkedListQueue<String>();
        for (int i = 0;i<n;i++){
            line = stdin.nextLine();
            queue.enqueue(line);
        }
        int iter = 1;
        int tempo = 0;
        while(!queue.isEmpty()){
            String[] tarefa = queue.dequeue().split("\\s+");
            if (Integer.valueOf(tarefa[1])<=t){
                tempo += Integer.valueOf(tarefa[1]);
                System.out.println(tarefa[0]+" "+tempo+" "+iter);
            }
            else{
                tempo+=t;
                tarefa[1]=((Integer)(Integer.valueOf(tarefa[1])-t)).toString();
                queue.enqueue(tarefa[0]+" "+tarefa[1]);
            }
            iter++;
        }
    }
}
