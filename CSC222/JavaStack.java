import java.util.Scanner;
import java.util.Stack;

public class JavaStack {


   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      System.out.println("Please enter a mathematical expression:");
      String expression = scnr.nextLine();

      Stack<Character> stack = new Stack<Character>();
      Stack<Integer> indexes = new Stack<Integer>();

      int mismatchIndex = -1;

      for (int i = 0; i < expression.length(); i++) {
         char ch = expression.charAt(i);

         if (ch == '(' || ch == '[' || ch == '{') {
            stack.push(ch);
            indexes.push(i);
         }
         else if (ch == ')' || ch == ']' || ch == '}') {
            if (stack.isEmpty()) {
               mismatchIndex = i;
               break;
            }

            char open = stack.pop();
            indexes.pop();

            if (!matches(open, ch)) {
               mismatchIndex = i;
               break;
            }
         }
      }

      if (mismatchIndex == -1 && !stack.isEmpty()) {
         mismatchIndex = indexes.pop();
      }

      if (mismatchIndex == -1) {
         System.out.println("The input expression is balanced!");
      } else {
         System.out.println("The input expression is not balanced! The first mismatch is found at position " + mismatchIndex + "!");
      }
   }

   public static boolean matches(char open, char close) {
      return (open == '(' && close == ')') ||
             (open == '[' && close == ']') ||
             (open == '{' && close == '}');
   }
}
