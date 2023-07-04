public class ED197 {
    public static MyQueue<Integer>  merge(MyQueue<Integer> a, MyQueue<Integer> b){
        MyQueue<Integer> res = new LinkedListQueue<Integer>();
        while(!(a.isEmpty() && b.isEmpty())){
            if (a.isEmpty()){
                res.enqueue(b.dequeue());
            }
            else if (b.isEmpty()){
                res.enqueue(a.dequeue());
            }
            else if (a.first()<=b.first()){
                res.enqueue(a.dequeue());
            }
            else{
                res.enqueue(b.dequeue());
            }
        }
    return res;
    }
}
