/** 
* 
* Student name:  Eli Canas
* Completion date: 04/12/26
*
* LineList.txt: the template file of LineList.java
* Student tasks: implement tasks as specified in this file
*
* LineList class is a linked-base list that represents the contents of a document
*
*/ 
import java.io.*;
import java.util.*;

public class LineList {

   private Node head;

   public LineList(){
      head = null;
   }

   public void empty(){
      head = null;
   }

   public void load(String fileName, boolean append){
      try{
         if(!append){
            head = null;
         }

         BufferedReader br = new BufferedReader(new FileReader(fileName));
         String line;

         while((line = br.readLine()) != null){
            addLine(line);
         }

         br.close();
      }catch(Exception e){
         throw new RuntimeException(e);
      }
   }

   public void save(String fileName){
      try{
         PrintWriter pw = new PrintWriter(new FileWriter(fileName));
         Node curr = head;

         while(curr != null){
            pw.println(curr.getLine());
            curr = curr.getNext();
         }

         pw.close();
      }catch(Exception e){
         throw new RuntimeException(e);
      }
   }

   public void addLine(String line){
      Node newNode = new Node(line);

      if(head == null){
         head = newNode;
         return;
      }

      Node curr = head;
      while(curr.getNext() != null){
         curr = curr.getNext();
      }

      curr.setNext(newNode);
   }

   public void addLine(String line, int n){
      Node newNode = new Node(line);

      if(head == null || n <= 1){
         newNode.setNext(head);
         head = newNode;
         return;
      }

      Node curr = head;
      int count = 1;

      while(curr.getNext() != null && count < n-1){
         curr = curr.getNext();
         count++;
      }

      newNode.setNext(curr.getNext());
      curr.setNext(newNode);
   }

   public int words(){
      int count = 0;
      Node curr = head;

      while(curr != null){
         String[] tokens = curr.getLine().split("[\\s\\t,.;?!*@:\"'-]+");

         for(String t : tokens){
            if(!t.equals("")){
               count++;
            }
         }

         curr = curr.getNext();
      }

      return count;
   }

   public int lines(){
      int count = 0;
      Node curr = head;

      while(curr != null){
         count++;
         curr = curr.getNext();
      }

      return count;
   }

   public void delete(int n){
      if(head == null){
         return;
      }

      if(n == 1){
         head = head.getNext();
         return;
      }

      Node curr = head;
      int count = 1;

      while(curr.getNext() != null && count < n-1){
         curr = curr.getNext();
         count++;
      }

      if(curr.getNext() != null){
         curr.setNext(curr.getNext().getNext());
      }
   }

   public String toString(){
      StringBuilder sb = new StringBuilder();
      Node curr = head;

      while(curr != null){
         sb.append(curr.getLine());
         if(curr.getNext() != null){
            sb.append("\n");
         }
         curr = curr.getNext();
      }

      return sb.toString();
   }

   public void print(){
      Node curr = head;
      int num = 1;

      while(curr != null){
         System.out.println(num + ". " + curr.getLine());
         curr = curr.getNext();
         num++;
      }
   }

   public void replace(String s1, String s2){
      Node curr = head;

      while(curr != null){
         curr.replace(s1, s2);
         curr = curr.getNext();
      }
   }

   public void line(int n){
      Node curr = head;
      int count = 1;

      while(curr != null){
         if(count == n){
            System.out.println(curr.getLine());
            return;
         }
         curr = curr.getNext();
         count++;
      }

      System.out.println("Line " + n + " does not exist.");
   }
}