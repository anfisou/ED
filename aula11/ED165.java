import java.util.Scanner;

public class ED165 {


    public static boolean isSum(BSTree <Integer> t,int sum){
        return isSum(t,t.getRoot(),sum);
    }

    public static boolean isSum(BSTree <Integer> t,BSTNode <Integer> n,int sum){
        if (n==null){return false;}
        if (Sum(n.getValue(),t.getRoot(),sum)){return true;}
        if (n.getLeft()==null && n.getRight()==null){return false;}
        if (n.getLeft()==null){return isSum(t,n.getRight(),sum);}
        if (n.getRight()==null){return isSum(t,n.getLeft(),sum);}
        return isSum(t,n.getLeft(),sum) || isSum(t,n.getRight(),sum);        
    }

    public static boolean Sum(int value,BSTNode <Integer> n,int sum){
        if (n==null){return false;}
        if (value+n.getValue()==sum){return true;}
        if (value+n.getValue()>sum){return Sum(value,n.getLeft(),sum);}
        else{return Sum(value,n.getRight(),sum);}
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        BSTree<Integer> t = new BSTree<Integer>();
        for(int i = 0;i<n;i++){
            t.insert(stdin.nextInt());
        }
        int p = stdin.nextInt();   
        for(int i = 0;i<p;i++){
            int q = stdin.nextInt();
            if (isSum(t,q)){System.out.println(q+": sim");}
            else{System.out.println(q+": nao");}
        }
}
}
