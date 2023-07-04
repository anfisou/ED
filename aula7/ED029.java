import java.util.Scanner;




public class ED029 {

    public static MyQueue<String>  merge(MyQueue<String> l, MyQueue<String> a){
        MyQueue<String> res = new LinkedListQueue<String>();
        while(!(l.isEmpty() && a.isEmpty())){
            if (a.isEmpty()){
                res.enqueue(l.dequeue());
            }
            else if (l.isEmpty()){
                res.enqueue(a.dequeue());
            }
            else{
            String as = a.first();
            String ls = l.first();
            String[] wordsa = as.split("\\s+");
            String[] wordsl = ls.split("\\s+");
            if (Integer.valueOf(wordsa[1])<=Integer.valueOf(wordsl[1])){
                res.enqueue(a.dequeue());
            }
            else{
                res.enqueue(l.dequeue());
            }
        }
        }
    return res;
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        for (int u = 0;u<n;u++){
            MyQueue<String> queuel = new LinkedListQueue<String>();
            MyQueue<String> queuelcopy = new LinkedListQueue<String>();
            MyQueue<String> queuea = new LinkedListQueue<String>();
            MyQueue<String> queueacopy = new LinkedListQueue<String>();
            int l = stdin.nextInt();
            int a = stdin.nextInt();
            String line = stdin.nextLine();
            for(int li = 0;li<l;li++){
                line = stdin.nextLine();
                queuel.enqueue(line);
                queuelcopy.enqueue(line);
            }
            for(int ai = 0;ai<a;ai++){
                line = stdin.nextLine();
                queuea.enqueue(line);
                queueacopy.enqueue(line);
            }
            MyQueue<String> ordenada = new LinkedListQueue<String>();
            ordenada = merge(queuelcopy,queueacopy);
            int time = 1;
            System.out.println(l + " " + a);
            String[][] respostas = new String[a+l+1][2];
            int k = 0;
            while (!(ordenada.isEmpty())){
                String res = ordenada.first();
                String[] words = res.split("\\s+");
                if (time >= Integer.valueOf(words[1])){
                words[1] = ((Integer)(time -Integer.valueOf(words[1]))).toString();
                respostas[k] = words;
                ordenada.dequeue();
                k++;}
                time++;
            }
            for (int i = 0;i<l;i++){
                String linha = queuel.first();
                String[] words = linha.split("\\s+");
                for (int j = 0;j<l+a+1;j++){
                    if (respostas[j][0].equals(words[0])){
                        System.out.println(respostas[j][0] + " " + respostas[j][1]);
                        break;
                    }
                }
                queuel.dequeue();
            }
            for (int i = 0;i<a;i++){
                String linha = queuea.first();
                String[] words = linha.split("\\s+");
                for (int j = 0;j<l+a;j++){
                    if (respostas[j][0].equals(words[0])){
                        System.out.println(respostas[j][0] + " " + respostas[j][1]);
                        break;
                    }
                }
                queuea.dequeue();
            }
        }
    }
}
