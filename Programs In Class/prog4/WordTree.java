// Program by Kenyon Geetings for COSC:130 - Data Structures

/* 
   Write a program using a specialized binary search tree to report the number of times each word appears in any text file.  
   Begin with the attached code and fill in the missing pieces.  I've provided code to read a file and extract the words from it.
   Your Node class should store a count of the number of times the word has been seen in the node in addition to its normal left & right references.  
   Provide a method to increase that count by 1 and write a toString() method for Node that includes the word and its count.  
   Because we only add and traverse, your Node class does not need to track parents.
 */

package prog4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordTree {
   private Node root;

   private static class Node {
      private String word;
      private int count;
      private Node left, right;
      private Node(String word, int count) {
         this.word = word;
         this.count = 1;
      }
      public String toString() {
         return word + "(" + count + ")";
      }
      public void increment() {
         count++;
      }
   }

   private void addNode(String word, Node n) {
      if (word.compareTo(n.word) < 0) {
         if (n.left == null) {
            n.left = new Node(word, 0);
         } else {
            addNode(word, n.left);
         }
      } else if (word.compareTo(n.word) > 0) {
         if (n.right == null) {
            n.right = new Node(word, 0);
         } else {
            addNode(word, n.right);
         }
      } else {
         n.increment();
      }
   }
   
   public void add(String word) {
      if (root == null) {
         root = new Node(word, 0);
      } else {
         addNode(word, root);
      }
   }
   
   @Override
   public String toString() {
      return inorder(root);
   }
   
   private String inorder(Node n) {
      String s = "";
      if (n != null) {
         s += inorder(n.left);
         s += n.toString() + "\n";
         s += inorder(n.right);
      }
      return s;
   }

   public static String readFile(String filename) {
      try {
         return Files.readString(Paths.get(filename));
      } catch (IOException e) {
         e.printStackTrace();
         return "";
      }
   }
   
   public static void main(String[] args) {
      WordTree t = new WordTree();
      String contents = readFile("Programs In Class/prog4/hamlet.txt");
      for (String word: contents.split("[\\p{Punct}\\s]+")) {
         t.add(word.toLowerCase());
      }
      System.out.println(t);
   }
}