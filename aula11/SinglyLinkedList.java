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



    //188
    public T get(int x){
        if (x<0 || x>=size){return null;}
        Node<T> cur = first;
        for (int i = 0; i<x;i++){cur = cur.getNext();}
        return cur.getValue();   
    }

    //189
    public T remove(int x){
        if (x<0 || x>=size){return null;}
        size--;
        Node<T> cur = first;
        if (x==0){first=first.getNext();return cur.getValue();}
        for (int i = 0; i<x-1;i++){cur = cur.getNext();}
        Node<T> removed = cur.getNext();
        cur.setNext(cur.getNext().getNext());
        return removed.getValue();
    }

    //190
    public SinglyLinkedList<T> copy(){
        SinglyLinkedList<T> copy = new SinglyLinkedList<>();
        Node<T> cur = first;
        for(int i = 0;i<size;i++){
            copy.addLast(cur.getValue());
            cur = cur.getNext();
        }
        return copy;
    }

    //191
    public void duplicate(){
        if(isEmpty()){return;}
        Node<T> cur = first;
        Node<T> next = cur.getNext();
        for(int i = 0;i<size-1;i++){
        Node<T> copy = new Node<T>(cur.getValue(), next);
        cur.setNext(copy);
        cur = copy.getNext();
        next = cur.getNext();
        }
        addLast(getLast());
        size--;
        size*=2;
        return;
    }

    //192
    public int count(T value){
        Node<T> cur = first;
        int count = 0;
        for(int i = 0;i<size;i++){
            if (cur.getValue().equals(value)){count++;}
            cur = cur.getNext();
        }
        return count;
    }

    //193
    public void removeAll(T value){
        Node<T> cur = first;
        for(int i = 0;i<size;i++){
            if (cur.getValue().equals(value)){remove(i);i--;}
            cur = cur.getNext();
        }
        return;
    }
 }