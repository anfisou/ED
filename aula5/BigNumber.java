public class BigNumber{
    int digits[];
    int size;


    BigNumber(String n){
        digits = new int[1000];
        size = n.length();
        for (int i = 0; i<size;i++){
            digits[i] = Character.getNumericValue(n.charAt(size-i-1));
        }
    }

    public boolean equals(BigNumber n){
        if (size != n.size){return false;}
        for (int i = 0; i<size;i++){
            if (digits[i] != n.digits[i]) {return false;}
        }
        return true;
    }

    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i<size; i++){
            s += digits[size-i-1];
        }
        return s;
    }

    public int max(int a, int b){
        if (a>=b){return a;}
        return b;
    }

    public BigNumber add(BigNumber n){
        int add_in = 0;
        BigNumber r = new BigNumber(toString());
        r.size = max(size,n.size)+1;
        for (int i = 0;i< r.size; i++){
            int p = digits[i] + n.digits[i] + add_in;
            add_in = 0;
            if (p>9){
                add_in = (p - (p%10))/10;
                p = p%10; 
            }
            r.digits[i] = p;
        }
        if (r.digits[r.size-1] == 0){r.size--;}
        return r;
    }


    public BigNumber multiply(BigNumber n){
        BigNumber total = new BigNumber("0");
        BigNumber r;
        total.size = size + n.size -1;
        for (int j = 0; j<n.size;j++){
        r = new BigNumber("0");
        r.size = size +1+j;
        int add_in = 0;
        for (int i = 0; i< size+1;i++){
            int p = (digits[i] * n.digits[j]) + add_in;
            add_in = 0;
            if (p>9){
                add_in = (p - (p%10))/10;
                p = p%10; 
            }
            r.digits[i+j] = p;
        }
        if (r.digits[r.size-1] == 0){r.size--;}
        total = total.add(r);
    }
    if (total.digits[total.size-1] == 0){total.size--;}
    return total;
}
}