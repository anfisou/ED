public class TestSinglyLinkedList {
    public static void main(String[] args) {
 
       // Criacao de lista de inteiros
      SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();
 
      list.addLast('a');
      list.addLast('b');
      list.addLast('d');
      list.addLast('a');
      list.addLast('c');
      //list.addLast(2);
      //list.addLast(1);
      //list.addFirst();
      //list.addFirst();
      SinglyLinkedList<Character> list1 = new SinglyLinkedList<Character>();
      list1.addLast('c');
      list1.addLast('a');
      //list1.addLast(1);
      //list1.addLast('e');
      //System.out.println(list);
      list.remove(list1);
      //System.out.println(list);
      list.duplicate(1);
      //System.out.println(list);
      list.addLast('c');
      list.addLast('a');
      int[] l = new int[2];
      l[0]=1;
      l[1]=2;
      System.out.println("ola");
      System.out.println(list);
      SinglyLinkedList<Character> list2 = list.remove1(l);
      System.out.println(list2);
      System.out.println(list);
      list.addLast('a');
      System.out.println(list2);
      System.out.println(list);




      

       

  
 

 

 
 



    }
 }
