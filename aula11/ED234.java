import java.util.Scanner;

class Rating{
    int soma;
    int n;

    Rating(int s, int nu){
        soma = s;
        n = nu;
    }
}

public class ED234 {

    public static void map(BSTMap<String,Rating> m){
        BSTMapNode<String,Rating> res = map(m.getRoot());
        System.out.println(res.getKey()+" "+res.getValue().n);
    }

    public static BSTMapNode<String,Rating> map(BSTMapNode<String,Rating> n){
        if(n==null){return new BSTMapNode<String,Rating>("",new Rating(0,-1),null,null);}
        if(n.getLeft()==null && n.getRight()==null){return n;}
        BSTMapNode<String,Rating> left = map(n.getLeft());
        BSTMapNode<String,Rating> right = map(n.getRight());
        BSTMapNode<String,Rating> max = right;
        if (left.getValue().n>right.getValue().n){max = left;}
        if (max.getValue().n>n.getValue().n){return max;}
        return n;
    }

    public static void media(BSTMapNode<String,Rating> n){
        if(n==null){return;}
        media(n.getLeft());
        if(n.getValue().soma/n.getValue().n>=5){System.out.println(n.getKey());}
        media(n.getRight());
        return;
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        BSTMap<String,Rating> map = new BSTMap<>();
        int flag = stdin.nextInt();
        int n = stdin.nextInt();
        for(int i=0;i<n;i++){
            String nome = stdin.next();
            int nota = stdin.nextInt();
            if (map.get(nome)==null){map.put(nome,new Rating(nota,1));}
            else{map.put(nome,new Rating(map.get(nome).soma+nota,map.get(nome).n+1));}
        }
        if(flag==1){System.out.println(map.size());}
        else if(flag==2){
            map(map);
        }
        else if(flag==3){
            media(map.getRoot());
        }
    }
}
