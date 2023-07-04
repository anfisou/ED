public class ED211 {
    public static int countEven(BTree<Integer> t){
        return even(t.getRoot());
    }

    public static int even(BTNode<Integer> n){
        if (n==null){return 0;}
        int a = 1-(n.getValue()%2);
        return a + even(n.getLeft())+even(n.getRight());
    }
}
