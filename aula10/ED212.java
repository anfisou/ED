public class ED212 {
    public static int[] sumLevels(BTree<Integer> t){
        int[] r = new int[t.depth()+1];
        sum(t.getRoot(),0,r);
        return r;
    }

    public static void sum(BTNode<Integer> n, int depth,int[] r){
        if (n==null){return;}
        r[depth]+=n.getValue();
        sum(n.getLeft(),depth+1,r);
        sum(n.getRight(),depth+1,r);
    }
}
