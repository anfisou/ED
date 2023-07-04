import java.util.Scanner;
import java.lang.Math;

public class DesafioRegrasFin {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int numP = stdin.nextInt();
         // aqui ele guarda as p linhas: os k's na line; os a's na low; os b's na high
         // para alem disso guarda em maxline o maior dos k's, ou seja, a maior linha q vai ter de construir
        int[] line = new int[numP];
        long[] low = new long[numP];
        long[] high = new long[numP];

        for(int i = 0;i<numP;i++){
            line[i]=stdin.nextInt();
            low[i]=stdin.nextLong() - 1;
            high[i]=stdin.nextLong();
        }
        
        int maxline = 0;
        for(int i:line){
            if(i>maxline){
                maxline=i;
            }
        }
        //aqui ele guarda o tamnho da linha n em tamanhos[n] com aquela forma de recursao ate ao maxline, pq n precisa mais do q isso
        long[] tamanhos = new long[maxline];
        tamanhos[0]=1;
        for(int i=1;i<maxline;i++){
            tamanhos[i] = 2*tamanhos[i-1] + (long)Math.pow(2, (i-1));
        }
        
        // agora a ideia é calcular o numero de quadrados pintados desde o inicio da linha até b ( high[i]) 
        //e subtrair o numero de quadrados pintados a desde o inicio ate a -1 (low[i]-1)
        // assim obtem o numero de quadrados pintados entre a e b

        // a forma de como ele faz isto e confusa; eu vou mandar-te o meu codigo q acho q fica mais claro, mas vou tentar explicar a mesma
        //para encontrar o numero de quadrados pintados desde o inicio ate n, vamos a maior linha contida em [0,n], por exemplo (0 = branco; 1 = pintado):
        //101001; q e um segmento da linha 3, q seria a 2 por causa da notacao tamanhos[2]; podemos retirar a linha 2 (tamanhos[1]) e contar o numero de quadrados pintados, ou seja, ficamos com 001 e
        // o numero de quadrados pintados fica 2^(linha, no caso 1) isto pq o numero de quadrados pintados numa linha é 2^(nº da linha -1); para alem disso 
        // vamos tirar aqueles espacos brancos do meio, que sao tambem 2^(linha, no caso 1) e ficariamos com 1, voltamos a fazer o mesmo processo até chegarmos até aqui,
        // ate o tamanho for 0 ou inferior
        

        for(int i=0; i< high.length;i++){
            int currentLine = 0;
            long numOnes = 0;
            long oneZero=0;

            while(low[i]>=tamanhos[currentLine+1]){
                currentLine++;
            }
            int currentLineh = currentLine;

            while(low[i]>0){
                while(low[i]>=tamanhos[currentLine+1]){
                    currentLine++;
                }
                oneZero = (long)Math.pow(2, currentLine);
                numOnes-=oneZero;
                low[i] -= tamanhos[currentLine]+oneZero;
                currentLine = 0;
            }

            while(high[i]>0){
                while(high[i]>tamanhos[currentLineh+1]){
                    currentLineh++;
                }
                oneZero = (long)Math.pow(2, currentLineh);
                numOnes+=oneZero;
                high[i] -= tamanhos[currentLineh]+oneZero;
                currentLineh = 0;
            }

            System.out.println(numOnes);
        }
    }
}