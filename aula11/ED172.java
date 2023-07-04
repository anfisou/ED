import java.util.LinkedList;
import java.util.Scanner;

public class ED172 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        BSTMap<String,Integer> map = new BSTMap<String,Integer>();
        while(stdin.hasNext()){
            String p = stdin.next();
            if (map.get(p)==null){map.put(p,1);}
            else{map.put(p,map.get(p)+1);}
        }
        LinkedList <String > names = map.keys (); 
        for (String s : names) 
        System.out.println(s + ": " + map.get(s));
    }
}
