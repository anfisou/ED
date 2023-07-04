public class ED196 {
    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b){
        int n = q.size();
        for (int i = 0; i<n/2;i++){
            String nome = q.dequeue();
            String operacao = q.dequeue();
            if (operacao.equals("A")){
                a.enqueue(nome);
            }
            else if (operacao.equals("B")){
                b.enqueue(nome);
            }
            
            else if (operacao.equals("X")){
                if (a.size()<b.size()){
                    a.enqueue(nome);
                }
                else if  (a.size()>b.size()){
                    b.enqueue(nome);
                }
            }
        }
    }    
}
