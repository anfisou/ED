import java.util.Scanner;


class Bid implements Comparable<Bid>{
    String name;
    Integer val;
    Bid(String n, int v){
        name = n;
        val = v;
    }
    public int compareTo(Bid b){return b.val.compareTo(val);}
    public String toString(){return val+" "+name;}
}
public class ED215 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        MinHeap<Bid> heap = new MinHeap<>(n);
        for(int i=0;i<n;i++){
            String operacao = stdin.next();
            if (operacao.equals("OFERTA")){
                String name = stdin.next();
                int val = stdin.nextInt();
                heap.insert(new Bid(name,val));
            }
            else{
                System.out.println(heap.removeMin());
            }
        }
    }
}
