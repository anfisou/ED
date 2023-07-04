import java.util.Scanner;

class Student{
    String name;
    int duvidas;
    int day;
    int dday;

    Student(String n, int du){
        name = n;
        duvidas = du;
        day = 0;
        dday = 0;
    }
}

public class ED270 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        MyQueue<Student> queue = new LinkedListQueue<Student>();
        int t = stdin.nextInt();
        int x = stdin.nextInt();
        int n = stdin.nextInt();
        for (int i = 0;i<n;i++){
            String no = stdin.next();
            int du = stdin.nextInt();
            queue.enqueue(new Student(no,du));
        }
        int day = 1;
        while (!queue.isEmpty()){
            int r = t;
            while (r!=0){
                if (queue.isEmpty()){break;}
                Student s  =queue.first();
                if (s.day != day){s.day=day;s.dday=0;}
                if (s.dday == x){break;}
                queue.dequeue();
                r--;
                s.duvidas--;
                s.dday++;
                if (s.duvidas==0){System.out.println(s.name+" "+day+" "+r);}
                else{queue.enqueue(s);}
            }
            day++;
        }
    }
}
