public class BTree<T> {   
    private BTNode<T> root; // raiz da arvore
 
    // Construtor
    BTree() {
       root = null;
    }
 
    // Getter e Setter para a raiz
    public BTNode<T> getRoot() {return root;}
    public void setRoot(BTNode<T> r) {root = r;}
 
    // Verificar se arvore esta vazia
    public boolean isEmpty() {
       return root == null;
    }
 
    // --------------------------------------------------------
 
    // Numero de nos da arvore   
    public int numberNodes() {
       return numberNodes(root);
    }
 
    private int numberNodes(BTNode<T> n) {
       if (n == null) return 0;
       return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }
 
    // --------------------------------------------------------
 
    // Altura da arvore
    public int depth() {
       return depth(root);
    }
 
    private int depth(BTNode<T> n) {
       if (n == null) return -1;
       return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }
 
    // --------------------------------------------------------
    
    // O elemento value esta contido na arvore?
    public boolean contains(T value) {
       return contains(root, value);
    }
 
    private boolean contains(BTNode<T> n, T value) {
       if (n==null) return false;
       if (n.getValue().equals(value)) return true;
       return contains(n.getLeft(), value) || contains(n.getRight(), value);
    }
 
    // --------------------------------------------------------
 
    // Imprimir arvore em PreOrder
    public void printPreOrder() {
       System.out.print("PreOrder:");
       printPreOrder(root);
       System.out.println();
    }
 
    private void printPreOrder(BTNode<T> n) {
       if (n==null) return;
       System.out.print(" " + n.getValue() );
       printPreOrder(n.getLeft());
       printPreOrder(n.getRight());
    }
 
    // --------------------------------------------------------
    
    // Imprimir arvore em InOrder
    public void printInOrder() {
       System.out.print("InOrder:");
       printInOrder(root);
       System.out.println();
    }
 
    private void printInOrder(BTNode<T> n) {
       if (n==null) return;
       printInOrder(n.getLeft());
       System.out.print(" " + n.getValue());
       printInOrder(n.getRight());
    }
 
    // --------------------------------------------------------
 
    // Imprimir arvore em PostOrder
    public void printPostOrder() {
       System.out.print("PostOrder:");
       printPostOrder(root);
       System.out.println();
    }
 
    private void printPostOrder(BTNode<T> n) {
       if (n==null) return;
       printPostOrder(n.getLeft());
       printPostOrder(n.getRight());
       System.out.print(" " + n.getValue());
    }
 
    // --------------------------------------------------------
 
    // Imprimir arvore numa visita em largura (usando TAD Fila)
    public void printBFS() {
       System.out.print("BFS:");
       
       MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
       q.enqueue(root);
       while (!q.isEmpty()) {
          BTNode<T> cur = q.dequeue();
          if (cur != null) {
             System.out.print(" " + cur.getValue());
             q.enqueue(cur.getLeft());
             q.enqueue(cur.getRight());
          }
       }
       System.out.println();
    }
 
    // --------------------------------------------------------
    
    // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
    public void printDFS() {
       System.out.print("DFS:");
       
       MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
       q.push(root);
       while (!q.isEmpty()) {
          BTNode<T> cur = q.pop();
          if (cur != null) {
             System.out.print(" " + cur.getValue());
             q.push(cur.getLeft());
             q.push(cur.getRight());
          }
       }
       System.out.println();
    }


    public int numberLeafs(){
        return nLeafs(root);
    }

    public int nLeafs(BTNode<T> n){
        if (n==null){return 0;}
        if(!(n==null)){if (n.getLeft()==null && n.getRight()==null){return 1;}}
        return nLeafs(n.getLeft())+nLeafs(n.getRight());
    }

    public boolean strict(){
        return isStrict(root);
    }

    public boolean isStrict(BTNode<T> n){
        if (n==null){return true;}
        if ((n.getLeft()==null && n.getRight()!=null)||(n.getLeft()!=null && n.getRight()==null)){return false;}
        return isStrict(n.getLeft()) && isStrict(n.getRight());
    }
 
    public T path(String s){
        if (s.equals("R")){return root.getValue();}
        BTNode<T>curr = root;
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i)=='E'){curr=curr.getLeft();}
            if (s.charAt(i)=='D'){curr=curr.getRight();}
        }
        return curr.getValue();
    }

    public int nodesLevel(int k){
        return nodesdepth(root,k);
    }

    public int nodesdepth(BTNode<T> n,int k){
        if (n==null){return 0;}
        if (k==0){return 1;}
        return nodesdepth(n.getLeft(), k-1)+nodesdepth(n.getRight(), k-1);
   }

   public int internal(){
      return internal(root);
   }

   public int internal(BTNode<T> n){
      if (n == null){return 0;}
      if (n.getLeft()==null && n.getRight()==null){return 0;}
      return 1 + internal(n.getLeft()) + internal(n.getRight());
   }

   public void cut(int d){
      if (d<=0){root = null;}
      else{cut(root,d,0);}
      return;
   }

   public void cut(BTNode<T> n, int d, int depth){
      if (n==null){return;}
      if (depth==d-1){
         n.setLeft(null);
         n.setRight(null);
      }
      cut(n.getLeft(),d,depth+1);
      cut(n.getRight(),d,depth+1);
      return;
   }

   public int[] maxLevel(){
      int depth = depth();
      int[] r = new int[depth+1];
      preenche(root,0,r);
      int[] res = new int[2];
      for(int i = 0;i<depth+1;i++){
         if (r[i] > res[0]){res[0]=r[i];res[1]=1;}
         else if (r[i] == res[0]){res[1]++;}
      }
      return res;
   }

   public void preenche(BTNode<T> n, int depth,int[] r){
      if(n==null){return;}
      preenche(n.getLeft(),depth+1,r);
      preenche(n.getRight(),depth+1,r);
      r[depth]=r[depth]+1;
      return;
   }

   public int count(){
      return count(root);
   }

   public int count(BTNode<T> n){
      if (n==null){return 0;}
      if ((n.getLeft()==null && n.getRight()!=null)||(n.getLeft()!=null && n.getRight()==null)){
         return 1+count(n.getLeft())+count(n.getRight());
      }
      return count(n.getLeft())+count(n.getRight());
   }

   public int level(T v){
      int n =  level(v, root,0);
      if (n>depth()){return -1;}
      return n;
   }

   public int level(T v, BTNode<T> n, int depth){
      if (n==null){return depth()+1;}
      if (n.getValue().equals(v)){return depth;}
      return Math.min(level(v,n.getLeft(),depth+1),level(v,n.getRight(),depth+1));
   }
 }
