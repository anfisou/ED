public class BooleanArrayIntSet implements IntSet {
    private int size;// Numero de elementos do conjunto
    private boolean elem[]; // Array que contem os elementos em si 
    private int maxsize;

    BooleanArrayIntSet(int maxSize) {
        elem = new boolean[maxSize+1];
        size = 0;
        this.maxsize = maxSize;
    }
     
    public boolean add(int x) {
       if (!(elem[x])) {
            elem[x] = true;
            size++;
            return true;
        }
        return false;
    }
     
    public boolean remove(int x) {
        if (elem[x]) {
            elem[x] = false;
            size--;
            return true;  
       }
        return false;
    }
        
        
    public boolean contains(int x) {
        return elem[x];
    }
        
    public void clear() {
        elem = new boolean[maxsize];
        size = 0;
    }
        
    public int size() {
       return size;
    }
     
    @Override 
    public String toString() {
       String res = "{";
       int j = 0;
       for (int i=0; i<size; j++) {
            if (elem[j]){
                res += j;
                i++;
                if (i<size) res += ",";
            }
       }
       res += "}";
       return res;
    }
    
    public boolean equals(IntSet s){
        if (size != s.size()){return false;}
        int j = 0;
        for (int i = 0; i<size;j++){
            if (elem[j]){i++;}
            if (elem[j] != s.contains(j)){return false;}
        }
        return true;
    }
    
    public IntSet intersection(IntSet s){
        IntSet r = new BooleanArrayIntSet(maxsize); 
        int j=0;
        for (int i = 0; i<size;j++){
            if (elem[j]){i++;}
            if (elem[j] && s.contains(j)){
                r.add(j);              
            }
        }
        return r;
    }
     
}
