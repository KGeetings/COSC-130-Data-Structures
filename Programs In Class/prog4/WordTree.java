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
   
   public void add(String word) {
      // write this
   }
   
   private void addNode(String word, Node n) {
      // write this
   }
   
   @Override
   public String toString() {
      // write this
      return "";
   }
   
   private String inorder(Node n) {
      // write this
      return "";
   }
   
   public static String readFile(String filename) {
      try {
         return Files.readString(Paths.get(filename));
      } catch (IOException e) {
         e.printStackTrace();
         return "";
      }
   }

   private static class Node {
      // write this
   }
   
   public static void main(String[] args) {
      WordTree t = new WordTree();
      String contents = readFile("hamlet.txt");
      for (String word: contents.split("[\\p{Punct}\\s]+")) {
         t.add(word.toLowerCase());
      }
      System.out.println(t);
   }
}