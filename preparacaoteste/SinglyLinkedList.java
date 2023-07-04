public class SinglyLinkedList<T> {
    private Node<T> first;    // Primeiro no da lista
    private int size;         // Tamanho da lista
 
    // Construtor (cria lista vazia)
    SinglyLinkedList() {
       first = null;
       size = 0;
    }
 
    // Retorna o tamanho da lista
    public int size() {
       return size;
    }
 
    // Devolve true se a lista estiver vazia ou falso caso contrario
    public boolean isEmpty() {
       return (size == 0);
    }
    
    // Adiciona v ao inicio da lista
    public void addFirst(T v) {
       Node<T> newNode = new Node<T>(v, first); 
       first = newNode;
       size++;
    }
 
    // Adiciona v ao final da lista
    public void addLast(T v) {
       Node<T> newNode = new Node<T>(v, null); 
       if (isEmpty()) {
          first = newNode;
       } else {
          Node<T> cur = first;
          while (cur.getNext() != null)
             cur = cur.getNext();
          cur.setNext(newNode);         
       }
       size++;
    }
 
    // Retorna o primeiro valor da lista (ou null se a lista for vazia)
    public T getFirst() {
       if (isEmpty()) return null;
       return first.getValue();
    }
 
    // Retorna o ultimo valor da lista (ou null se a lista for vazia)
    public T getLast() {
       if (isEmpty()) return null;
       Node<T> cur = first;
       while (cur.getNext() != null)
          cur = cur.getNext();
       return cur.getValue();      
    }
 
    // Remove o primeiro elemento da lista (se for vazia nao faz nada)
    public void removeFirst() {
       if (isEmpty()) return;
       first = first.getNext();
       size--;
    }
 
    // Remove o ultimo elemento da lista (se for vazia nao faz nada)
    public void removeLast() {
       if (isEmpty()) return;
       if (size == 1) {
          first = null;
       } else {
          // Ciclo com for e uso de de size para mostrar alternativa ao while
          Node<T> cur = first;
          for (int i=0; i<size-2; i++)
             cur = cur.getNext();
          cur.setNext(cur.getNext().getNext());
       }
       size--;
    }
    
    // Converte a lista para uma String
    public String toString() {
       String str = "{";      
       Node<T> cur = first;
       while (cur != null) {
          str += cur.getValue();
          cur = cur.getNext();
          if (cur != null) str += ",";                     
       }      
       str += "}";
       return str;
    }

    public SinglyLinkedList<T> reverse(){
        SinglyLinkedList<T> res = new SinglyLinkedList<T>();
        for (int i = size-1;i>=0;i--){
            Node<T> curr = first;
            for (int k = 0;k<i;k++){
                curr = curr.getNext();
            }
            res.addLast(curr.getValue());
        }
        return res;
    }

    public int[] occurrences(T elem){
        int n = 0;
        Node<T> curr = first;
        for (int i = 0;i<size;i++){
            if (curr.getValue().equals(elem)){n++;}
            curr = curr.getNext();
        }
        if (n==0){return null;}
        int[] res = new int[n];
        int u =0;
        curr = first;
        for (int i = 0;i<size;i++){
            if (curr.getValue().equals(elem)){res[u] = i;u++;}
            curr = curr.getNext();
        }
        return res;
    }

    public boolean isin(String s, String[]pro,int size){
        for(int i = 0;i<size;i++){
            if (s.equals(pro[i])){return true;}
        }
        return false;
    }

    public void remove(SinglyLinkedList<T> toRemove){
        int n = toRemove.size();
        String[] pro = new String[n];
        for(int i = 0;i<n;i++){
            pro[i] = toRemove.getFirst().toString();
            toRemove.removeFirst();
        }
        while (isin(first.getValue().toString(),pro,n)){
            removeFirst();
            if (isEmpty()){break;}
        }
        if (size>1){
        Node<T> ant = first;
        Node<T> curr = ant.getNext();
        int si = size;
        for (int k = 1;k<si;k++){
            if (isin(curr.getValue().toString(),pro,n)){ant.setNext(curr.getNext());size--;}
            else{ant=curr;}
            curr = ant.getNext();
            }
        }
        }
    

    public SinglyLinkedList<T> cut(int a, int b){
        Node<T> curr = first;
        for (int i = 0; i<a;i++){
            curr = curr.getNext();
        }
        SinglyLinkedList<T> res = new SinglyLinkedList<T>();
        for (int i = a; i<=b;i++){
            res.addLast(curr.getValue());
            curr = curr.getNext();
        }
        return res;
    }

    public void shift(int n){
        n %=size;
        if (!isEmpty() && n>0){
                Node<T> ant = first;
                Node<T> curr = ant.getNext();
                for (int k = 0; k<size-n-1;k++){
                    ant = curr;
                    curr = curr.getNext();
                }
                ant.setNext(null);
                Node<T> temp = first;
                first = curr;
                for(int k = 0;k<n-1;k++){
                    curr = curr.getNext();
                }
                curr.setNext(temp);
            }
        return;
    }


    public void duplicate(int pos){
        Node <T> curr = first;
        for (int i = 0;i<pos;i++){
            curr = curr.getNext();
        }
        Node <T> c = new Node<T>(curr.getValue(),curr.getNext());
        curr.setNext(c);
        size++;
    }

    public SinglyLinkedList<T> remove(int[] pos){
        SinglyLinkedList<T> res = new SinglyLinkedList<>();
        int p = 0;
        int i = 0;
        Node<T> curr = first;
        if (pos.length==0){
            if (size==0){return res;}
            res.first = new Node<T>(first.getValue(),null);
            res.size++;
            Node<T> cur1 = res.first;
            curr = curr.getNext();
            while (curr!=null){
                cur1.setNext(new Node<T>(curr.getValue(),null));
                curr = curr.getNext();
                cur1 = cur1.getNext();
                res.size++;
            }
            return res;
        }
        while(p==pos[i]){    
            curr = curr.getNext();
            p++;
            i++;
            if (p>=size){return res;}
            if (i>=pos.length){break;}
        }
        res.addFirst(curr.getValue());
        p++;
        curr=curr.getNext();
        Node<T> cur1 = res.first;
        while (p<size){
            if (i<pos.length){if (p==pos[i]){i++;}else{cur1.setNext(new Node<T>(curr.getValue(),null));cur1=cur1.getNext();res.size++;}}
            else{cur1.setNext(new Node<T>(curr.getValue(),null));cur1=cur1.getNext();res.size++;}
            curr = curr.getNext();
            p++;
        }
        return res;
    }


    public SinglyLinkedList<T> remove1(int[] pos){
        SinglyLinkedList<T> res = new SinglyLinkedList<>();
        int p = 0;
        int i = 0;
        Node<T> curr = first;
        Node<T> last = new Node<T>(null,null);
        while(curr!=null){
            if(i>=pos.length){
                while(curr!= null){
                    if (res.isEmpty()){res.first = new Node<T>(curr.getValue(),null);last = res.first;}
                    else{
                        last.setNext(new Node<T>(curr.getValue(),null));
                        last = last.getNext();}
                    res.size++;
                    p++;
                    curr = curr.getNext();
                }
                break;
            }
            if (p!=pos[i]){if (res.isEmpty()){res.first = new Node<T>(curr.getValue(),null);last = res.first;}
            else{
                last.setNext(new Node<T>(curr.getValue(),null));
                last = last.getNext();}
            res.size++;
            }
            else{i++;}
            p++;
            curr = curr.getNext();
            }
        return res;
    }
    
    
 }
