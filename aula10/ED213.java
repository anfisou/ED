class Data{
    int soma;
    String caminho;
    Data(int s,String c){
        soma = s;
        caminho=c;
    }
}

public class ED213 {
    public static String maxSum(BTree<Integer> t){
        String s = max(t.getRoot()).caminho;
        String res;
        res = s.substring(0,s.length()-1);
        return res;
    }

    public static Data max(BTNode<Integer> n){
        if (n==null){return new Data(0, "");}
        int v = n.getValue();
        Data dataLeft = max(n.getLeft());
        Data dataRigth = max(n.getRight());
        if (dataLeft.soma>dataRigth.soma){dataLeft.soma+=v;dataLeft.caminho="E"+dataLeft.caminho;return dataLeft;}
        else {dataRigth.soma+=v;dataRigth.caminho="D"+dataRigth.caminho;return dataRigth;}
    }
}
