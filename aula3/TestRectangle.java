//import java.util.Scanner;

class Point {
   int x, y;

   Point() {
      x = y = 0;
   }
   
   Point(int x0, int y0) {
      x = x0;
      y = y0;
   }

   public String toString() {
      return "(" + x + "," + y + ")";
   }
}

class Rectangle{
   Point a,b;

   Rectangle(int x0, int y0, int w0, int z0){
      a  = new Point (x0,y0);
      b  = new Point (w0,z0);
   }

   Rectangle(Point a1, Point b1){
   a = a1;
   b = b1;
}

   public int area(){
      int area = (b.x - a.x)*(b.y - a.y);
      return area; 
   }

   public int perimeter(){
      int perimeter = 2*(b.x-a.x)+ 2*(b.y - a.y);
      return perimeter;
   }

   public boolean pointInside(Point p){
      if ((p.x >= a.x) && (p.x <= b.x) && (p.y >= a.y) && (p.y <= b.y)){
         return true;
      }
      return false;
   }

   public boolean rectangleInside(Rectangle r){
      if ((r.a.x >= a.x) && (r.a.y >= a.y) && (r.b.x <= b.x) && (r.b.y <= b.y)){
         return true;
      }
      return false;
   }


}



class TestRectangle {
   public static void main(String[] args) {
      Point a = new Point(1,1);
      Point b = new Point(2,2);
      Point c = new Point(3,4);
      Point d = new Point(8,2);
      
      Rectangle amarelo  = new Rectangle(a, c);
      Rectangle laranja  = new Rectangle(2, 3, 9, 6);
      Rectangle verde    = new Rectangle(3, 4, 4, 5);
      Rectangle azul     = new Rectangle(5, 1, 6, 5);
      Rectangle vermelho = new Rectangle(7, 3, 9, 5);
      
      System.out.println("Perimetro do retangulo amarelo = " + amarelo.perimeter()); // 10
      System.out.println("Perimetro do retangulo laranja = " + laranja.perimeter()); // 20
      
      System.out.println("Area do retangulo amarelo = " + amarelo.area()); // 6
      System.out.println("Area do retangulo laranja = " + laranja.area()); // 21                   
      
      System.out.println("Ponto B dentro rectangulo amarelo? " + amarelo.pointInside(b)); // true
      System.out.println("Ponto D dentro rectangulo amarelo? " + amarelo.pointInside(d)); // false
      
      System.out.println("Retangulo verde dentro do laranja? " + laranja.rectangleInside(verde));       // true
      System.out.println("Retangulo azul dentro do laranja? " + laranja.rectangleInside(azul));         // false
      System.out.println("Retangulo vermelho dentro do laranja? " + laranja.rectangleInside(vermelho)); // true
   }
}