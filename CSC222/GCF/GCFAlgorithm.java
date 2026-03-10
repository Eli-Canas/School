
 /**
* @author YINGJIN CUI
* @version 1.0
* since   2020-02
*
* GCFAlgorithm.java
*/

public class GCFAlgorithm{

   public static int gcf1(int a, int b){
      if(Math.abs(a)==Math.abs(b)) return Math.abs(a);
      if(a*b==0) return Math.abs(a+b);
      return gcf1(a %b, b%a);
   }
   public static int gcf2(int a, int b){
      a=Math.abs(a);
      b=Math.abs(b);
      int tmp=a;
      if(a==b) return a;
      if(a * b==0) return a+b;
      while(a*b !=0){
         tmp=a;
         a =a %b;
         b = b % tmp;
      }
      return a+b;
   }
   public static int gcf3(int a, int b){
      a=Math.abs(a);
      b=Math.abs(b);
      int tmp=a;
      if(a==b) return a;
      if(a * b==0) return a+b;
      while(a*b !=0){
         if(a>b) a=a-b;
         else b=b-a;
      }
      return a+b;
   }
}
