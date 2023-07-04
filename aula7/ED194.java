public class ED194 {
    public static void reverse(MyStack<Integer> s, int n){
        if (n < 2 || s.size()<2){
            return;
        }
        int memory[] = new int[n];
        for(int i = 0;i<n; i++){
            memory[i] = s.pop();
        }
        for (int j = 0;j<n;j++){
            s.push(memory[j]);
        }
        return;
    }
}
