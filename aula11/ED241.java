import java.util.Scanner;


class V{
int aceites;
int tentados;

V(int a,int t){
    aceites = a;
    tentados=t;
}

}
public class ED241 {

    public static void map(BSTMap<String,Integer> m){
        BSTMapNode<String,Integer> res = map(m.getRoot());
        System.out.println(res.getKey()+" "+res.getValue());
    }

    public static BSTMapNode<String,Integer> map(BSTMapNode<String,Integer> n){
        if(n==null){return new BSTMapNode<String,Integer>("",-1,null,null);}
        if(n.getLeft()==null && n.getRight()==null){return n;}
        BSTMapNode<String,Integer> left = map(n.getLeft());
        BSTMapNode<String,Integer> right = map(n.getRight());
        BSTMapNode<String,Integer> max = right;
        if (left.getValue()>right.getValue()){max = left;}
        if (max.getValue()>n.getValue()){return max;}
        return n;
    }

    public static void media(BSTMapNode<String,V> n){
        if(n==null){return;}
        media(n.getLeft());
        if(n.getValue().aceites*1.0/n.getValue().tentados>=0.5){System.out.println(n.getKey());}
        media(n.getRight());
        return;
    }

    public static void aceite(BSTMapNode<String,BSTree<String>> n, int nex){
        if(n==null){return;}
        aceite(n.getLeft(),nex);
        if(n.getValue().numberNodes()==nex){System.out.println(n.getKey());}
        aceite(n.getRight(),nex);
        return;
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int flag = stdin.nextInt();
        int n = stdin.nextInt();
        if(flag==1){
            int size=0;
            BSTree<String> t = new BSTree<>();
            for(int i=0;i<n;i++){
                String nome = stdin.next();
                String problema = stdin.next();
                String resultado = stdin.next();
                if(t.insert(nome)){size++;}
            }
            System.out.println(size);
        }
        else if(flag==2){
            BSTMap<String,Integer> t = new BSTMap<>();
            for(int i=0;i<n;i++){
                String nome = stdin.next();
                String problema = stdin.next();
                String resultado = stdin.next();
                if(t.get(problema)==null){t.put(problema,1);}
                else{t.put(problema,t.get(problema)+1);}
            }
            map(t);
        }
        else if(flag==3){
            BSTMap<String,V> t = new BSTMap<>();
            for(int i=0;i<n;i++){
                String nome = stdin.next();
                String problema = stdin.next();
                String resultado = stdin.next();
                if(t.get(problema)==null){
                    if(resultado.equals("Accepted")){t.put(problema,new V(1,1));}
                    else{t.put(problema,new V(0,1));}
                }
                else{
                    if(resultado.equals("Accepted")){t.put(problema,new V(t.get(problema).aceites+1,t.get(problema).tentados+1));}
                    else{t.put(problema,new V(t.get(problema).aceites,t.get(problema).tentados+1));}
                }
            }
            media(t.getRoot());
        }
        else if(flag==4){
            BSTMap<String,BSTree<String>> t = new BSTMap<>();
            BSTree<String> ex = new BSTree<>();
            for(int i=0;i<n;i++){
                String nome = stdin.next();
                String problema = stdin.next();
                String resultado = stdin.next();
                if(resultado.equals("Accepted")){
                    if(t.get(nome)==null){BSTree<String> temp = new BSTree<String>();temp.insert(problema);t.put(nome,temp);}
                    else{BSTree<String> temp = t.get(nome);temp.insert(problema);t.put(nome,temp);}
                }
                ex.insert(problema);
            }
            int nex = ex.numberNodes();
            aceite(t.getRoot(),nex);
        }
    }
}
